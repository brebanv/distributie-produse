package limba;

public class Limba {

    String jLabelProDucator;
    String jLabelDistribuitor;
    String jLabelClient;
    String jLabelDistanta;
    String jLabelDurata;
    String jTabbedPaneHarta;
    String jTabbedPaneAdaugaProducator;
    String jTabbedPaneAdaugaDistribuitor;
    String jTabbedPaneAdaugaClient;
    String jLabelLoading;
    String jButtonAdauga;
    String jButtonTraseu;
    String jButtonTraseuOptim;
    String jLabelAdaugaNume;
    String jLabelAdaugaAdresa;
    String jButtonStergeFirme;

    public Limba() {
        this.jLabelProDucator = "Producator:";
        this.jLabelDistribuitor = "Distribuitor:";
        this.jLabelClient = "Client:";
        this.jLabelDistanta = "Distanta";
        this.jLabelDurata = "Durata";
        this.jTabbedPaneHarta = "Harta";
        this.jTabbedPaneAdaugaProducator = "Adauga Producator";
        this.jTabbedPaneAdaugaDistribuitor = "Adauga Distribuitor";
        this.jTabbedPaneAdaugaClient = "Adauga Client";
        this.jLabelLoading = "Se încarcă...";
        this.jButtonAdauga = "Adauga";
        this.jButtonTraseu = "Traseu";
        this.jButtonTraseuOptim = "Traseu Optim";
        this.jLabelAdaugaNume = "Nume";
        this.jLabelAdaugaAdresa = "Adresa";
        this.jButtonStergeFirme = "Șterge firme";
    }

    public Limba(String language) {
        this.jLabelProDucator = "Producers:";
        this.jLabelDistribuitor = "Distributors:";
        this.jLabelClient = "Clients:";
        this.jLabelDistanta = "Distance";
        this.jLabelDurata = "Duration";
        this.jTabbedPaneHarta = "Map";
        this.jTabbedPaneAdaugaProducator = "Add Producer";
        this.jTabbedPaneAdaugaDistribuitor = "Add Distributor";
        this.jTabbedPaneAdaugaClient = "Add Client";
        this.jLabelLoading = "Loading...";
        this.jButtonAdauga = "Add";
        this.jButtonTraseu = "Route";
        this.jButtonTraseuOptim = "Optimum Route";
        this.jLabelAdaugaNume = "Name";
        this.jLabelAdaugaAdresa = "Address";
        this.jButtonStergeFirme = "Delete companies";
    }

    public String getjLabelProDucator() {
        return jLabelProDucator;
    }

    public String getjLabelDistribuitor() {
        return jLabelDistribuitor;
    }

    public String getjLabelClient() {
        return jLabelClient;
    }

    public String getjLabelDistanta() {
        return jLabelDistanta;
    }

    public String getjLabelDurata() {
        return jLabelDurata;
    }

    public String getjTabbedPaneHarta() {
        return jTabbedPaneHarta;
    }

    public String getjTabbedPaneAdaugaProducator() {
        return jTabbedPaneAdaugaProducator;
    }

    public String getjTabbedPaneAdaugaDistribuitor() {
        return jTabbedPaneAdaugaDistribuitor;
    }

    public String getjTabbedPaneAdaugaClient() {
        return jTabbedPaneAdaugaClient;
    }

    public String getjLabelLoading() {
        return jLabelLoading;
    }

    public String getjButtonAdauga() {
        return jButtonAdauga;
    }

    public String getjButtonTraseu() {
        return jButtonTraseu;
    }

    public String getjButtonTraseuOptim() {
        return jButtonTraseuOptim;
    }

    public String getjLabelAdaugaNume() {
        return jLabelAdaugaNume;
    }

    public String getjLabelAdaugaAdresa() {
        return jLabelAdaugaAdresa;
    }

    public String getjButtonStergeFirme() {
        return jButtonStergeFirme;
    }
}
