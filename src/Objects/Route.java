package Objects;

public class Route {

    private int id;
    private int startLiegeplatzId;
    private int zielLiegeplatzId;
    private int laeenge;

    public Route(int id, int startLiegeplatzId, int zielLiegeplatzId, int laeenge) {
        this.id = id;
        this.startLiegeplatzId = startLiegeplatzId;
        this.zielLiegeplatzId = zielLiegeplatzId;
        this.laeenge = laeenge;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStartLiegeplatzId() {
        return startLiegeplatzId;
    }

    public void setStartLiegeplatzId(int startLiegeplatzId) {
        this.startLiegeplatzId = startLiegeplatzId;
    }

    public int getZielLiegeplatzId() {
        return zielLiegeplatzId;
    }

    public void setZielLiegeplatzId(int zielLiegeplatzId) {
        this.zielLiegeplatzId = zielLiegeplatzId;
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
                ", startLiegeplatzId=" + startLiegeplatzId +
                ", zielLiegeplatzId=" + zielLiegeplatzId +
                ", laeenge=" + laeenge +
                '}';
    }
}
