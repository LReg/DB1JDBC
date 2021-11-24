package Objects;

public class Wasserfahrzeug {

    private int id;
    private String name;
    private Liegeplatz liegeplatz;
    private Fracht fracht;
    private Route route;

    public Wasserfahrzeug(int id, String name, Liegeplatz liegeplatz, Fracht fracht, Route route) {
        this.id = id;
        this.name = name;
        this.liegeplatz = liegeplatz;
        this.fracht = fracht;
        this.route = route;
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

    public Liegeplatz getLiegeplatz() {
        return liegeplatz;
    }

    public void setLiegeplatz(Liegeplatz liegeplatz) {
        this.liegeplatz = liegeplatz;
    }

    public Fracht getFracht() {
        return fracht;
    }

    public void setFracht(Fracht fracht) {
        this.fracht = fracht;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }
}
