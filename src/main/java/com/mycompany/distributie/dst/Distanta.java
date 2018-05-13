
package com.mycompany.distributie.dst;

public class Distanta {
    private final Integer idProducator;
    private final Integer idDistribuitor;
    private final Integer idClient;
    private final Integer ditanta;

    public Distanta(Integer idProducator, Integer idDistribuitor, Integer idClient, Integer ditanta) {
        this.idProducator = idProducator;
        this.idDistribuitor = idDistribuitor;
        this.idClient = idClient;
        this.ditanta = ditanta;
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

    public Integer getDitanta() {
        return ditanta;
    }
    
}
