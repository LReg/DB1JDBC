package Objects;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Liegeplatz {

    public static PreparedStatement fillPreparedStatementForChange(PreparedStatement preparedStatement, Liegeplatz liegeplatz) {
        try{
            preparedStatement.setInt(1, liegeplatz.getHafen());
            preparedStatement.setInt(2, liegeplatz.getFuerKathegorieId());
        }catch(SQLException e){
            e.printStackTrace();
        }
        return preparedStatement;
    }

    public static PreparedStatement fillPreparedStatementForAdd(PreparedStatement preparedStatement, Liegeplatz liegeplatz) {
        try{
            preparedStatement.setInt(1, liegeplatz.getId());
            preparedStatement.setInt(2, liegeplatz.getHafen());
            preparedStatement.setInt(3, liegeplatz.getFuerKathegorieId());
        }catch(SQLException e){
            e.printStackTrace();
        }
        return preparedStatement;
    }

    public static Iterable<Liegeplatz> fromResultSet(ResultSet resultSet) {
        ArrayList<Liegeplatz> list = new ArrayList<>();
        try{
            while(resultSet.next()){
                list.add(new Liegeplatz(
                        resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getInt(3)
                ));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    private int id;
    private int hafenId;
    private int fuerKathegorieId;

    public Liegeplatz(int id, int hafen, int fuerKathegorieId) {
        this.id = id;
        this.hafenId = hafen;
        this.fuerKathegorieId = fuerKathegorieId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHafen() {
        return hafenId;
    }

    public void setHafen(int hafen) {
        this.hafenId = hafen;
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
                ", hafen=" + hafenId +
                ", fuerKathegorieId=" + fuerKathegorieId +
                '}';
    }
}
