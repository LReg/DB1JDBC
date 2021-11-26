import Objects.*;

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
        databaseInteraction(getPreparedStatement(sqlString));
    }

    public void listAllFracht(){
        String sqlString = "select";//TODO Benennung mit Tim
        ResultSet resultSet = databaseInteraction(getPreparedStatement(sqlString));
        Fracht.fromResultSet(resultSet).forEach(fracht -> {
            System.out.println(fracht.toString());
        });
    }

    public void addFracht(Fracht fracht){
        String sqlString = "insert into fracht values (?, ?, ?)";
        PreparedStatement preparedStatement = getPreparedStatement(sqlString);
        preparedStatement = Fracht.fillPreparedStatementForAdd(preparedStatement, fracht);
        databaseInteraction(preparedStatement);
    }

    public void changeFracht(Fracht fracht){
        String sqlString = "update fracht set bezeichnung=?, gewicht=? where id=" + fracht.getId();
        PreparedStatement preparedStatement = getPreparedStatement(sqlString);
        preparedStatement = Fracht.fillPreparedStatementForChange(preparedStatement, fracht);
        databaseInteraction(preparedStatement);
    }

    public void deleteFracht(Fracht fracht){
        String sqlString = "delte from fracht where id=" + fracht.getId();
        PreparedStatement preparedStatement = getPreparedStatement(sqlString);
        databaseInteraction(preparedStatement);
    }

    public void listAllKategorien(){
        String sqlString = "select...";//TODO Tim bennnung
        ResultSet resultSet = databaseInteraction(getPreparedStatement(sqlString));
        Wasserfahrzeugkathegorie.fromResultSet(resultSet).forEach(kat -> {
            System.out.println(kat.toString());
        });

    }

    public void addKategorie(Wasserfahrzeugkathegorie wasserfahrzeugkathegorie){
        String sqlString = "insert into wasserfahrzeugkathegorie values (?, ?, ?)";
        PreparedStatement preparedStatement = getPreparedStatement(sqlString);
        preparedStatement = Wasserfahrzeugkathegorie.fillPreparedStatementForAdd(preparedStatement, wasserfahrzeugkathegorie);
        databaseInteraction(preparedStatement);
    }

    public void changeKategorie(Wasserfahrzeugkathegorie wasserfahrzeugkathegorie){
        String sqlString = "update wasserfahrzeugkathegorie set oberkathegorieId=?, title=? where id=" + wasserfahrzeugkathegorie.getId();
        PreparedStatement preparedStatement = getPreparedStatement(sqlString);
        preparedStatement = Wasserfahrzeugkathegorie.fillPreparedStatementForChange(preparedStatement, wasserfahrzeugkathegorie);
        databaseInteraction(preparedStatement);
    }

    public void deleteKategorie(Wasserfahrzeugkathegorie wasserfahrzeugkathegorie){
        String sqlString = "delete from wasserfahrzeugkategorie where id=" + wasserfahrzeugkathegorie.getId();
        databaseInteraction(getPreparedStatement(sqlString));
    }

    public void printHowManyLowerKategrien(Wasserfahrzeugkathegorie wasserfahrzeugkathegorie){
        String sqlString = "select id, count(*) as anzahl groupBy id having oberkategorieId=" + wasserfahrzeugkathegorie.getId();
        PreparedStatement preparedStatement = getPreparedStatement(sqlString);
        ResultSet resultSet = databaseInteraction(preparedStatement);
        try{
            int anzahl = resultSet.getInt(2);
            System.out.println(anzahl);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void listAllWasserfahrzeuge(){
        String sqlString = "select...";//TODO Tim bennnung
        ResultSet resultSet = databaseInteraction(getPreparedStatement(sqlString));
        Wasserfahrzeug.fromResultSet(resultSet).forEach(kat -> {
            System.out.println(kat.toString());
        });

    }

    public void addWasserfahrzeug(Wasserfahrzeug wasserfahrzeug){
        String sqlString = "insert into wasserfahrzeug values (?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = getPreparedStatement(sqlString);
        preparedStatement = Wasserfahrzeug.fillPreparedStatementForAdd(preparedStatement, wasserfahrzeug);
        databaseInteraction(preparedStatement);
    }

    public void changeWasserfahrzeug(Wasserfahrzeug wasserfahrzeug){
        String sqlString = "update wasserfahrzeug set name=?, liegeplatzId=?, frachtId=?, routeId=? where id=" + wasserfahrzeug.getId();
        PreparedStatement preparedStatement = getPreparedStatement(sqlString);
        preparedStatement = Wasserfahrzeug.fillPreparedStatementForChange(preparedStatement, wasserfahrzeug);
        databaseInteraction(preparedStatement);
    }

    public void deleteWasserfahrzeug(Wasserfahrzeug wasserfahrzeug){
        String sqlString = "delete from wasserfahrzeug where id=" + wasserfahrzeug.getId();
        databaseInteraction(getPreparedStatement(sqlString));
    }

    public void listAllLiegeplaetze(){
        String sqlString = "select...";//TODO Tim bennnung
        ResultSet resultSet = databaseInteraction(getPreparedStatement(sqlString));
        Liegeplatz.fromResultSet(resultSet).forEach(kat -> {
            System.out.println(kat.toString());
        });

    }

    public void addLiegeplatz(Liegeplatz liegeplatz){
        String sqlString = "insert into liegeplatz values (?, ?, ?, ?)";
        PreparedStatement preparedStatement = getPreparedStatement(sqlString);
        preparedStatement = Liegeplatz.fillPreparedStatementForAdd(preparedStatement, liegeplatz);
        databaseInteraction(preparedStatement);
    }

    public void changeLiegeplatz(Liegeplatz liegeplatz){
        String sqlString = "update liegeplatz set hafenId=?, wasserfahrzeugId=?, fuerKategrieId=? where id=" + liegeplatz.getId();
        PreparedStatement preparedStatement = getPreparedStatement(sqlString);
        preparedStatement = Liegeplatz.fillPreparedStatementForChange(preparedStatement, liegeplatz);
        databaseInteraction(preparedStatement);
    }

    public void deleteLiegeplatz(Liegeplatz liegeplatz){
        String sqlString = "delete from liegeplatz where id=" + liegeplatz.getId();
        databaseInteraction(getPreparedStatement(sqlString));
    }


}
