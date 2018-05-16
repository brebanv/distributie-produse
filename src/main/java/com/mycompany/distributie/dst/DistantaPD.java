package com.mycompany.distributie.dst;

public class DistantaPD {

    Integer idProducator;
    Integer idDistribuitor;
    Long distance;

    public DistantaPD(Integer idProducator, Integer idDistribuitor, Long distance) {
        this.idProducator = idProducator;
        this.idDistribuitor = idDistribuitor;
        this.distance = distance;
    }

    public Integer getIdProducator() {
        return idProducator;
    }

    public Integer getIdDistribuitor() {
        return idDistribuitor;
    }

    public Long getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return "idProducator=" + idProducator + ", idDistribuitor=" + idDistribuitor + ", distance=" + distance;
    }

}
