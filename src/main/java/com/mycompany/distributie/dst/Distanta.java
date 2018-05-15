package com.mycompany.distributie.dst;

public class Distanta {

    private final Integer idProducator;
    private final Integer idDistribuitor;
    private final Integer idClient;
    private final Integer ditantaPD;
    private final Integer ditantaDC;

    public Distanta(Integer idProducator, Integer idDistribuitor, Integer idClient, Integer ditantaPD, Integer ditantaDC) {
        this.idProducator = idProducator;
        this.idDistribuitor = idDistribuitor;
        this.idClient = idClient;
        this.ditantaPD = ditantaPD;
        this.ditantaDC = ditantaDC;
    }

    public Integer getIdProducator() {
        return idProducator;
    }

    public Integer getIdDistribuitor() {
        return idDistribuitor;
    }

    public Integer getIdClient() {
        return idClient;
    }

    public Integer getDitantaPD() {
        return ditantaPD;
    }

    public Integer getDitantaDC() {
        return ditantaDC;
    }
    
}
