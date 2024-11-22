package ru.mirea.logunov.nasa;

import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface AsteroidService {
    @GET("/resource/2vr3-k9wn.json")
    Call<List<Asteroid>> getAsteroids();
}