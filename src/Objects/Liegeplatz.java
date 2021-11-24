package Objects;

public class Liegeplatz {

    private int id;
    private Hafen hafen;
    private Wasserfahrzeug wasserfahrzeug;
    private Wasserfahrzeugkathegorie fuerKathegorie;

    public Liegeplatz(int id, Hafen hafen, Wasserfahrzeugkathegorie fuerKathegorie) {
        this.id = id;
        this.hafen = hafen;
        this.fuerKathegorie = fuerKathegorie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Hafen getHafen() {
        return hafen;
    }

    public void setHafen(Hafen hafen) {
        this.hafen = hafen;
    }

    public Wasserfahrzeugkathegorie getFuerKathegorie() {
        return fuerKathegorie;
    }

    public void setFuerKathegorie(Wasserfahrzeugkathegorie fuerKathegorie) {
        this.fuerKathegorie = fuerKathegorie;
    }
}
