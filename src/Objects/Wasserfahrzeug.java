package Objects;

public class Wasserfahrzeug {

    private int id;
    private String name;
    private int liegeplatzId;
    private int frachtId;
    private int routeId;

    public Wasserfahrzeug(int id, String name, int liegeplatzId, int frachtId, int routeId) {
        this.id = id;
        this.name = name;
        this.liegeplatzId = liegeplatzId;
        this.frachtId = frachtId;
        this.routeId = routeId;
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

    public int getLiegeplatzId() {
        return liegeplatzId;
    }

    public void setLiegeplatzId(int liegeplatzId) {
        this.liegeplatzId = liegeplatzId;
    }

    public int getFrachtId() {
        return frachtId;
    }

    public void setFrachtId(int frachtId) {
        this.frachtId = frachtId;
    }

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    @Override
    public String toString() {
        return "Wasserfahrzeug{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", liegeplatzId=" + liegeplatzId +
                ", frachtId=" + frachtId +
                ", routeId=" + routeId +
                '}';
    }
}
