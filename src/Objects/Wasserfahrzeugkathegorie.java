package Objects;

import oracle.jdbc.internal.OracleStatement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Wasserfahrzeugkathegorie {

    public static ArrayList<Wasserfahrzeugkathegorie> fromResultSet(ResultSet resultSet){
        ArrayList<Wasserfahrzeugkathegorie> list = new ArrayList<>();
        try{
            while(resultSet.next()) {
                list.add(new Wasserfahrzeugkathegorie(
                        resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getString(3)
                ));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    public static PreparedStatement fillPreparedStatementForAdd(PreparedStatement preparedStatement, Wasserfahrzeugkathegorie wasserfahrzeugkathegorie){
        try{
            preparedStatement.setInt(1, wasserfahrzeugkathegorie.getId());
            preparedStatement.setInt(2, wasserfahrzeugkathegorie.getOberkathegorieId());
            preparedStatement.setString(3, wasserfahrzeugkathegorie.getTitle());
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return preparedStatement;
    }

    public static PreparedStatement fillPreparedStatementForChange(PreparedStatement preparedStatement, Wasserfahrzeugkathegorie wasserfahrzeugkathegorie){
        try{
            preparedStatement.setInt(1, wasserfahrzeugkathegorie.getOberkathegorieId());
            preparedStatement.setString(2, wasserfahrzeugkathegorie.getTitle());
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return preparedStatement;
    }

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
