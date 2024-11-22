package ru.mirea.logunov.nasa;

import com.fasterxml.jackson.databind.json.JsonMapper;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class AsteroidClient {
    public static void main(String[] args) {
        try {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://data.nasa.gov")
                    .addConverterFactory(JacksonConverterFactory.create(new JsonMapper()))
                    .build();

            AsteroidService asteroidService = retrofit.create(AsteroidService.class);

            Call<List<Asteroid>> call = asteroidService.getAsteroids();
            Response<List<Asteroid>> response = call.execute();

            if (response.isSuccessful() && response.body() != null) {
                List<Asteroid> asteroids = response.body();

                Optional<Asteroid> lastDiscovered = asteroids.stream()
                        .filter(new java.util.function.Predicate<Asteroid>() {
                            @Override
                            public boolean test(Asteroid a) {
                                return a.getDiscoveryDate() != null;
                            }
                        })
                        .max(new Comparator<Asteroid>() {
                            @Override
                            public int compare(Asteroid a1, Asteroid a2) {
                                LocalDateTime date1 = LocalDateTime.parse(a1.getDiscoveryDate(), DateTimeFormatter.ISO_DATE_TIME);
                                LocalDateTime date2 = LocalDateTime.parse(a2.getDiscoveryDate(), DateTimeFormatter.ISO_DATE_TIME);
                                return date1.compareTo(date2);
                            }
                        });

                if (lastDiscovered.isPresent()) {
                    Asteroid asteroid = lastDiscovered.get();
                    System.out.println("Последний обнаруженный астероид: " + asteroid.getDesignation() +
                            ", Дата обнаружения: " + asteroid.getDiscoveryDate());
                } else {
                    System.out.println("Не удалось найти астероид.");
                }
            } else {
                System.out.println("Ошибка при получении данных.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
