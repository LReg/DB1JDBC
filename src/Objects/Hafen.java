package Objects;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Hafen {

    public static ArrayList<Hafen> fromResultSet(ResultSet resultSet){
        ArrayList<Hafen> list = new ArrayList<>();
        try {
            while (resultSet.next()){
                Hafen hafen = new Hafen(
                        resultSet.getInt(1),
                        resultSet.getString(2).trim(),
                        resultSet.getInt(3),
                        resultSet.getInt(4)
                );
                list.add(hafen);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    public static PreparedStatement fillPreparedStatementForAdd(PreparedStatement preparedStatement, Hafen hafen){
        try{
            preparedStatement.setInt(1, hafen.getId());
            preparedStatement.setString(2, hafen.getName());
            preparedStatement.setInt(3, hafen.getAnzahlLiegeplaetze());
            preparedStatement.setInt(4, hafen.getStatus());
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return preparedStatement;
    }

    public static PreparedStatement fillPreparedStatementForChange(PreparedStatement preparedStatement, Hafen hafen){
        try{
            preparedStatement.setString(1, hafen.getName());
            preparedStatement.setInt(2, hafen.getAnzahlLiegeplaetze());
            preparedStatement.setInt(3, hafen.getStatus());
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return preparedStatement;
    }

    public static final int FREI = 1;
    public static final int BELEGT = 0;

    private int id;
    private String name;
    private int anzahlLiegeplaetze;
    private int status;

    public Hafen(int id, String name, int anzahlLiegeplaetze, int status) {
        this.id = id;
        this.name = name;
        this.anzahlLiegeplaetze = anzahlLiegeplaetze;
        this.status = status;
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

    public int getAnzahlLiegeplaetze() {
        return anzahlLiegeplaetze;
    }

    public void setAnzahlLiegeplaetze(int anzahlLiegeplaetze) {
        this.anzahlLiegeplaetze = anzahlLiegeplaetze;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Hafen{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", anzahlLiegeplaetze=" + anzahlLiegeplaetze +
                ", status=" + status +
                '}';
    }
}
