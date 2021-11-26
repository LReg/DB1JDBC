package Objects;

import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Fracht {

    /**
     * @author Nils & Tim
     * Funktion die aus einem passenden! ResultSet eine ArrayList bildet.
     * @param resultSet
     * @return ArrayList<Fracht>
     */
    public static ArrayList<Fracht> fromResultSet(ResultSet resultSet){
        ArrayList<Fracht> list = new ArrayList<>();
        try{
            while(resultSet.next()){
                Fracht fracht = new Fracht(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getInt(3)
                );
                list.add(fracht);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    /**
     * @author Nils & Tim
     * Füllt ein übliches PreparedStatement zum hinzufügen einer Fracht mit den Attributen.
     * @param preparedStatement
     * @param fracht
     * @return PreparedStatement
     */
    public static PreparedStatement fillPreparedStatementForAdd(PreparedStatement preparedStatement, Fracht fracht){
        try{
            preparedStatement.setInt(1, fracht.getId());
            preparedStatement.setString(2, fracht.getBezeichnug());
            preparedStatement.setInt(3, fracht.getGewicht());
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return preparedStatement;
    }

    /**
     * @author Nils & Tim
     * Füllt ein übliches PreparedStatement zum bearbeiten einer Fracht mit den Attributen.
     * @param preparedStatement
     * @param fracht
     * @return
     */
    public static PreparedStatement fillPreparedStatementForChange(PreparedStatement preparedStatement, Fracht fracht){
        try{
            preparedStatement.setString(1, fracht.getBezeichnug());
            preparedStatement.setInt(2, fracht.getGewicht());
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return preparedStatement;
    }

    private int id;
    private String bezeichnug;
    private int gewicht;

    public Fracht(int id, String bezeichnug, int gewicht) {
        this.id = id;
        this.bezeichnug = bezeichnug;
        this.gewicht = gewicht;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBezeichnug() {
        return bezeichnug;
    }

    public void setBezeichnug(String bezeichnug) {
        this.bezeichnug = bezeichnug;
    }

    public int getGewicht() {
        return gewicht;
    }

    public void setGewicht(int gewicht) {
        this.gewicht = gewicht;
    }

    @Override
    public String toString() {
        return "Fracht{" +
                "id=" + id +
                ", bezeichnug='" + bezeichnug + '\'' +
                ", gewicht=" + gewicht +
                '}';
    }
}
