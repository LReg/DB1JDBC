package Objects;

public class Wasserfahrzeugkathegorie {

    private int id;
    private Wasserfahrzeugkathegorie oberkathegorie;
    private String title;

    public Wasserfahrzeugkathegorie(int id, Wasserfahrzeugkathegorie oberkathegorie, String title) {
        this.id = id;
        this.oberkathegorie = oberkathegorie;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Wasserfahrzeugkathegorie getOberkathegorie() {
        return oberkathegorie;
    }

    public void setOberkathegorie(Wasserfahrzeugkathegorie oberkathegorie) {
        this.oberkathegorie = oberkathegorie;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
