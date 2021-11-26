package Objects;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Wasserfahrzeug {

    /**
     * Funktion die aus einem passenden! ResultSet eine ArrayList bildet.
     * @param resultSet
     * @return ArrayList<Wasserfahrzeug>
     */
    public static ArrayList<Wasserfahrzeug> fromResultSet(ResultSet resultSet) {

        ArrayList<Wasserfahrzeug> list = new ArrayList<>();
        try{
            while(resultSet.next()){
                list.add(new Wasserfahrzeug(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getInt(3),
                        resultSet.getInt(4),
                        resultSet.getInt(5),
                        resultSet.getInt(6)
                ));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    /**
     * Füllt ein übliches PreparedStatement zum hinzufügen eines Wasserfahrezeugs mit den Attributen.
     * @param preparedStatement
     * @param wasserfahrzeug
     * @return
     */
    public static PreparedStatement fillPreparedStatementForAdd(PreparedStatement preparedStatement, Wasserfahrzeug wasserfahrzeug) {
        try{
            preparedStatement.setInt(1, wasserfahrzeug.getId());
            preparedStatement.setString(2, wasserfahrzeug.getName());
            preparedStatement.setInt(3, wasserfahrzeug.getKategorieId());
            preparedStatement.setInt(4, wasserfahrzeug.getLiegeplatzId());
            preparedStatement.setInt(5, wasserfahrzeug.getFrachtId());
            preparedStatement.setInt(6, wasserfahrzeug.getRouteId());
        }catch(SQLException e){
            e.printStackTrace();
        }
        return preparedStatement;
    }

    /**
     * Füllt ein übliches PreparedStatement zum bearbeiten eines Wasserfahrzeugs mit den Attributen.
     * @param preparedStatement
     * @param wasserfahrzeug
     * @return
     */
    public static PreparedStatement fillPreparedStatementForChange(PreparedStatement preparedStatement, Wasserfahrzeug wasserfahrzeug) {
        try{
            preparedStatement.setString(1, wasserfahrzeug.getName());
            preparedStatement.setInt(2, wasserfahrzeug.getKategorieId());
            preparedStatement.setInt(3, wasserfahrzeug.getLiegeplatzId());
            preparedStatement.setInt(4, wasserfahrzeug.getFrachtId());
            preparedStatement.setInt(5, wasserfahrzeug.getRouteId());
        }catch(SQLException e){
            e.printStackTrace();
        }
        return preparedStatement;
    }

    private int id;
    private String name;
    private int kategorieId;
    private int liegeplatzId;
    private int frachtId;
    private int routeId;

    public Wasserfahrzeug(int id, String name, int kategorieId, int liegeplatzId, int frachtId, int routeId) {
        this.id = id;
        this.name = name;
        this.kategorieId = kategorieId;
        this.liegeplatzId = liegeplatzId;
        this.frachtId = frachtId;
        this.routeId = routeId;
    }

    public int getKategorieId() {
        return kategorieId;
    }

    public void setKategorieId(int kategorieId) {
        this.kategorieId = kategorieId;
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
                ", kategorieId=" + kategorieId +
                ", liegeplatzId=" + liegeplatzId +
                ", frachtId=" + frachtId +
                ", routeId=" + routeId +
                '}';
    }
}
