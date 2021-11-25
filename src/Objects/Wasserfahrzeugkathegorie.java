package Objects;

public class Wasserfahrzeugkathegorie {

    private int id;
    private int oberkathegorieId;
    private String title;

    public Wasserfahrzeugkathegorie(int id, int oberkathegorieId, String title) {
        this.id = id;
        this.oberkathegorieId = oberkathegorieId;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOberkathegorieId() {
        return oberkathegorieId;
    }

    public void setOberkathegorieId(int oberkathegorieId) {
        this.oberkathegorieId = oberkathegorieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Wasserfahrzeugkathegorie{" +
                "id=" + id +
                ", oberkathegorieId=" + oberkathegorieId +
                ", title='" + title + '\'' +
                '}';
    }
}
