package com.mycompany.distributie.dst;

public class DistantaDC {

    Integer idDistribuitor;
    Integer idClient;
    Long distance;

    public DistantaDC(Integer idDistribuitor, Integer idClient, Long distance) {
        this.idDistribuitor = idDistribuitor;
        this.idClient = idClient;
        this.distance = distance;
    }

    public Integer getIdDistribuitor() {
        return idDistribuitor;
    }

    public Integer getIdClient() {
        return idClient;
    }

    public Long getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return "idClient=" + idClient + ",     idDistribuitor=" + idDistribuitor + ", distance=" + distance;
    }

}
