package Objects;

public class Liegeplatz {

    private int id;
    private Hafen hafen;
    private int wasserfahrzeugId;
    private int fuerKathegorieId;

    public Liegeplatz(int id, Hafen hafen, int wasserfahrzeugId, int fuerKathegorieId) {
        this.id = id;
        this.hafen = hafen;
        this.wasserfahrzeugId = wasserfahrzeugId;
        this.fuerKathegorieId = fuerKathegorieId;
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

    public int getWasserfahrzeugId() {
        return wasserfahrzeugId;
    }

    public void setWasserfahrzeugId(int wasserfahrzeugId) {
        this.wasserfahrzeugId = wasserfahrzeugId;
    }

    public int getFuerKathegorieId() {
        return fuerKathegorieId;
    }

    public void setFuerKathegorieId(int fuerKathegorieId) {
        this.fuerKathegorieId = fuerKathegorieId;
    }

    @Override
    public String toString() {
        return "Liegeplatz{" +
                "id=" + id +
                ", hafen=" + hafen +
                ", wasserfahrzeugId=" + wasserfahrzeugId +
                ", fuerKathegorieId=" + fuerKathegorieId +
                '}';
    }
}
