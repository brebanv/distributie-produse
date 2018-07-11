package distante;

public class Distanta {

    private Integer idProducator;
    private Integer idDistribuitor;
    private Integer idClient;
    private Integer ditantaPD;
    private Integer ditantaDC;

    public Distanta(Integer idProducator, Integer idDistribuitor, Integer idClient, Integer ditantaPD, Integer ditantaDC) {
        this.idProducator = idProducator;
        this.idDistribuitor = idDistribuitor;
        this.idClient = idClient;
        this.ditantaPD = ditantaPD;
        this.ditantaDC = ditantaDC;
    }

    public Distanta(Integer idProducator, Integer idDistribuitor, Integer idClient) {
        this.idProducator = idProducator;
        this.idDistribuitor = idDistribuitor;
        this.idClient = idClient;
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

    public void setIdProducator(Integer idProducator) {
        this.idProducator = idProducator;
    }

    public void setIdDistribuitor(Integer idDistribuitor) {
        this.idDistribuitor = idDistribuitor;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public void setDitantaPD(Integer ditantaPD) {
        this.ditantaPD = ditantaPD;
    }

    public void setDitantaDC(Integer ditantaDC) {
        this.ditantaDC = ditantaDC;
    }

    @Override
    public String toString() {
        return "idProducator=" + idProducator + ", idDistribuitor=" + idDistribuitor + ", idClient=" + idClient + ", ditantaPD=" + ditantaPD + ", ditantaDC=" + ditantaDC;
    }
    
}
