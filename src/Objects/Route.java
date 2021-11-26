package Objects;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Route {

    /**
     * @author Nils & Tim
     * Füllt ein übliches PreparedStatement zum bearbeiten einer Route mit den Attributen.
     * @param preparedStatement
     * @param route
     * @return
     */
    public static PreparedStatement fillPreparedStatementForChange(PreparedStatement preparedStatement, Route route) {
        try{
            preparedStatement.setInt(1, route.getStartLiegeplatzId());
            preparedStatement.setInt(2, route.getZielLiegeplatzId());
            preparedStatement.setInt(3, route.getLaeenge());
        }catch(SQLException e){
            e.printStackTrace();
        }
        return preparedStatement;
    }

    /**
     * @author Nils & Tim
     * Füllt ein übliches PreparedStatement zum hinzufügen einer Route mit den Attributen.
     * @param preparedStatement
     * @param route
     * @return
     */
    public static PreparedStatement fillPreparedStatementForAdd(PreparedStatement preparedStatement, Route route) {
        try{
            preparedStatement.setInt(1, route.getId());
            preparedStatement.setInt(2, route.getStartLiegeplatzId());
            preparedStatement.setInt(3, route.getZielLiegeplatzId());
            preparedStatement.setInt(4, route.getLaeenge());
        }catch(SQLException e){
            e.printStackTrace();
        }
        return preparedStatement;
    }

    /**
     * @author Nils & Tim
     * Funktion die aus einem passenden! ResultSet eine ArrayList bildet.
     * @param resultSet
     * @return ArrayList<Route>
     */
    public static Iterable<Route> fromResultSet(ResultSet resultSet) {
        ArrayList<Route> list = new ArrayList<>();
        try{
            while(resultSet.next()){
                list.add(new Route(
                    resultSet.getInt(1),
                    resultSet.getInt(2),
                    resultSet.getInt(3),
                    resultSet.getInt(4)
                ));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }

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
