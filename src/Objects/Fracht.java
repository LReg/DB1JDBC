package Objects;

public class Fracht {

    private int id;
    private String bezeichnug;
    private int gewicht;

    public Fracht(int id, String bezeichnug, int gewicht) {
        this.id = id;
        this.bezeichnug = bezeichnug;
        this.gewicht = gewicht;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBezeichnug() {
        return bezeichnug;
    }

    public void setBezeichnug(String bezeichnug) {
        this.bezeichnug = bezeichnug;
    }

    public int getGewicht() {
        return gewicht;
    }

    public void setGewicht(int gewicht) {
        this.gewicht = gewicht;
    }
}
