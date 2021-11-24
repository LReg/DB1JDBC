package Objects;

public class Hafen {


    public static final int FREI = 1;
    public static final int BELEGT = 2;
    public static final int UNBEKANNT = 4;

    private int id;
    private String name;
    private int anzahlLiegeplaetze;
    private int status;

    public Hafen(int id, String name, int anzahlLiegeplaetze, int status) {
        this.id = id;
        this.name = name;
        this.anzahlLiegeplaetze = anzahlLiegeplaetze;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAnzahlLiegeplaetze() {
        return anzahlLiegeplaetze;
    }

    public void setAnzahlLiegeplaetze(int anzahlLiegeplaetze) {
        this.anzahlLiegeplaetze = anzahlLiegeplaetze;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
