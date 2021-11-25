import Objects.Hafen;

import java.sql.*;

public class DatabaseService {

    private Connection con;

    public DatabaseService(){
        connect();
    }

    private ResultSet databaseInteraction(PreparedStatement preparedStatement){
        try {
            return preparedStatement.executeQuery();
        }
        catch (SQLException se){
            se.printStackTrace();
            return null;
        }
    }

    private void connect(){
        try{
            this.con = DriverManager.getConnection(PrivateInformation.DbURL, PrivateInformation.username, PrivateInformation.password);
            Class.forName("oracle.jdbc.driver.OracleDriver");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private PreparedStatement getPreparedStatement(String sqlStatement){
        try{
            return con.prepareStatement(sqlStatement);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public void listAllHafen(){
        String sqlString = "select ";//TODO Mit Tim benennung absprechen
        ResultSet resultSet = databaseInteraction(getPreparedStatement(sqlString));
        Hafen.fromResultSet(resultSet).forEach(hafen -> {
            System.out.println(hafen.toString());
        });
    }

    public void addHafen(Hafen hafen){
        String sqlString = "insert into hafen values (?, ?, ?, ?)";
        PreparedStatement preparedStatement = getPreparedStatement(sqlString);
        preparedStatement = Hafen.fillPreparedStatementForAdd(preparedStatement, hafen);
        databaseInteraction(preparedStatement);
    }

    public void changeHafen(Hafen hafen){
        String sqlString = "update hafen set name=?, anzahlLiegeplaetze=?, freierPlatz=? where id=" + hafen.getId();//TODO auch benennung beachten
        PreparedStatement preparedStatement = getPreparedStatement(sqlString);
        preparedStatement = Hafen.fillPreparedStatementForChange(preparedStatement, hafen);
        databaseInteraction(preparedStatement);
    }

    public void deleteHafen(Hafen hafen){
        String sqlString = "delete from hafen where id=" + hafen.getId();
    }

}
