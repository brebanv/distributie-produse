package com.mycompany.distributie.dst;

public class Producator {

    int id;
    String nume;
    String adresa;
    double latitude;
    double longitude;

    public Producator(int id, String nume, String adresa, double latitude, double longitude) {
        this.id = id;
        this.nume = nume;
        this.adresa = adresa;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getId() {
        return id;
    }

    public String getNume() {
        return nume;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    @Override
    public String toString() {
        return nume;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

}
