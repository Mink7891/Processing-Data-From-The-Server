package ru.mirea.logunov.nasa;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Asteroid {
    @JsonProperty("designation")
    private String designation;

    @JsonProperty("discovery_date")
    private String discoveryDate;

    @JsonProperty("h_mag")
    private Double hMag;

    @JsonProperty("moid_au")
    private Double moidAu;

    @JsonProperty("q_au_1")
    private Double qAu1;

    @JsonProperty("q_au_2")
    private Double qAu2;

    @JsonProperty("period_yr")
    private Double periodYr;

    @JsonProperty("i_deg")
    private Double iDeg;

    @JsonProperty("pha")
    private String pha;

    @JsonProperty("orbit_class")
    private String orbitClass;

    // Getters and setters
    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDiscoveryDate() {
        return discoveryDate;
    }

    public void setDiscoveryDate(String discoveryDate) {
        this.discoveryDate = discoveryDate;
    }

    public Double gethMag() {
        return hMag;
    }

    public void sethMag(Double hMag) {
        this.hMag = hMag;
    }

    public Double getMoidAu() {
        return moidAu;
    }

    public void setMoidAu(Double moidAu) {
        this.moidAu = moidAu;
    }

    public Double getqAu1() {
        return qAu1;
    }

    public void setqAu1(Double qAu1) {
        this.qAu1 = qAu1;
    }

    public Double getqAu2() {
        return qAu2;
    }

    public void setqAu2(Double qAu2) {
        this.qAu2 = qAu2;
    }

    public Double getPeriodYr() {
        return periodYr;
    }

    public void setPeriodYr(Double periodYr) {
        this.periodYr = periodYr;
    }

    public Double getiDeg() {
        return iDeg;
    }

    public void setiDeg(Double iDeg) {
        this.iDeg = iDeg;
    }

    public String getPha() {
        return pha;
    }

    public void setPha(String pha) {
        this.pha = pha;
    }

    public String getOrbitClass() {
        return orbitClass;
    }

    public void setOrbitClass(String orbitClass) {
        this.orbitClass = orbitClass;
    }
}
