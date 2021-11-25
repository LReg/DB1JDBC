package Objects;

public class Route {

    private int id;
    private Liegeplatz start;
    private Liegeplatz ziel;
    private int laeenge;

    public Route(int id, Liegeplatz start, Liegeplatz ziel, int laeenge) {
        this.id = id;
        this.start = start;
        this.ziel = ziel;
        this.laeenge = laeenge;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Liegeplatz getStart() {
        return start;
    }

    public void setStart(Liegeplatz start) {
        this.start = start;
    }

    public Liegeplatz getZiel() {
        return ziel;
    }

    public void setZiel(Liegeplatz ziel) {
        this.ziel = ziel;
    }

    public int getLaeenge() {
        return laeenge;
    }

    public void setLaeenge(int laeenge) {
        this.laeenge = laeenge;
    }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", start=" + start +
                ", ziel=" + ziel +
                ", laeenge=" + laeenge +
                '}';
    }
}
