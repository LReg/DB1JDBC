import Objects.*;

import java.sql.*;

public class DatabaseService {

    private Connection con;

    public DatabaseService(){
        connect();
        addWasserfahrzeug(new Wasserfahrzeug(10, "MS Schiff",2 ,8, 10, 5));
        listAllFracht();
        listAllKategorien();
        listAllWasserfahrzeuge();
        listAllRouten();
        listAllLiegeplaetze();
    }

    /**
     * Diese Methode repräsentiert den Punkt an dem ein "preparedStatement" an die Datenbank gesendet wird und ein "resultSet" zurück gegeben wird.
     * @param preparedStatement mit ausgefüllten Lücken
     * @return resultSet was bei Datenbankanfragen die angeforderten Informationen enthält
     * @see #getPreparedStatement(String sqlString)  hiermit kann ein String in ein PreparedStatement umgewandelt werden
     */
    private ResultSet databaseInteraction(PreparedStatement preparedStatement){
        try {
            return preparedStatement.executeQuery();
        }
        catch (SQLException se){
            se.printStackTrace();
            return null;
        }
    }

    /**
     * Methode um sich mit der !Oracle Datenbank zu verbinden
     * @see PrivateInformation hier werden die Anmeldeinformationen bezogen
     */
    private void connect(){
        try{
            this.con = DriverManager.getConnection(PrivateInformation.DbURL, PrivateInformation.username, PrivateInformation.password);
            Class.forName("oracle.jdbc.driver.OracleDriver");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Mit dieser Methode kann man einen String in ein Prepared statement umwandeln. Es füllt jedoch noch keine "?" Lücken.
     * @param sqlStatement String mit OracleSql Synthax
     * @return PreparedStatement ohne gefüllten Lücken
     * @see #databaseInteraction(PreparedStatement)
     */
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

    /**
     * Funktion die alle nötigen Aktionen beinhaltet um alle in der Datenbank gespeicherten Objekte vom Typ Hafen in die Konsole zu schreiben.
     */
    public void listAllHafen(){
        String sqlString = "SELECT * FROM Hafen";
        ResultSet resultSet = databaseInteraction(getPreparedStatement(sqlString));
        Hafen.fromResultSet(resultSet).forEach(hafen -> {
            System.out.println(hafen.toString());
        });
    }

    /**
     * Funktion um der Datenbank einen neuen Hafen hinzuzufügen
     * @param hafen
     */
    public void addHafen(Hafen hafen){
        String sqlString = "insert into hafen values (?, ?, ?, ?)";
        PreparedStatement preparedStatement = getPreparedStatement(sqlString);
        preparedStatement = Hafen.fillPreparedStatementForAdd(preparedStatement, hafen);
        databaseInteraction(preparedStatement);
    }

    public void changeHafen(Hafen hafen){
        String sqlString = "update Hafen set Name=?, Anzahl_Lageplätze=?, Platz_verfügbar=? where Hafen_ID=" + hafen.getId();
        PreparedStatement preparedStatement = getPreparedStatement(sqlString);
        preparedStatement = Hafen.fillPreparedStatementForChange(preparedStatement, hafen);
        databaseInteraction(preparedStatement);
    }

    public void deleteHafen(Hafen hafen){
        String sqlString = "delete from hafen where Hafen_ID=" + hafen.getId();
        databaseInteraction(getPreparedStatement(sqlString));
    }

    /**
     * Funktion die alle nötigen Aktionen beinhaltet um alle in der Datenbank gespeicherten Objekte vom Typ Fracht in die Konsole zu schreiben.
     */
    public void listAllFracht(){
        String sqlString = "select * from Fracht";
        ResultSet resultSet = databaseInteraction(getPreparedStatement(sqlString));
        Fracht.fromResultSet(resultSet).forEach(fracht -> {
            System.out.println(fracht.toString());
        });
    }

    /**
     * Funktion um der Datenbank eine neue Fracht hinzuzufügen
     * @param fracht
     */
    public void addFracht(Fracht fracht){
        String sqlString = "insert into fracht values (?, ?, ?)";
        PreparedStatement preparedStatement = getPreparedStatement(sqlString);
        preparedStatement = Fracht.fillPreparedStatementForAdd(preparedStatement, fracht);
        databaseInteraction(preparedStatement);
    }

    /**
     * Funktion, um eine Fracht zu ändern.
     * @param fracht
     */
    public void changeFracht(Fracht fracht){
        String sqlString = "update fracht set bezeichnung=?, gewicht=? where id=" + fracht.getId();
        PreparedStatement preparedStatement = getPreparedStatement(sqlString);
        preparedStatement = Fracht.fillPreparedStatementForChange(preparedStatement, fracht);
        databaseInteraction(preparedStatement);
    }

    /**
     * Funktion um eine Fracht zu löschen
     * @param fracht
     */
    public void deleteFracht(Fracht fracht){
        String sqlString = "delte from fracht where id=" + fracht.getId();
        PreparedStatement preparedStatement = getPreparedStatement(sqlString);
        databaseInteraction(preparedStatement);
    }

    /**
     * Funktion die alle nötigen Aktionen beinhaltet um alle in der Datenbank gespeicherten Objekte vom Typ Wasserfahrzeugkategorien in die Konsole zu schreiben.
     */
    public void listAllKategorien(){
        String sqlString = "select * from Wasserfahrzeugkategorie";
        ResultSet resultSet = databaseInteraction(getPreparedStatement(sqlString));
        Wasserfahrzeugkategorie.fromResultSet(resultSet).forEach(kat -> {
            System.out.println(kat.toString());
        });

    }

    /**
     * Funktion um der Datenbank einen neue Kategorie hinzuzufügen
     * @param wasserfahrzeugkathegorie
     */
    public void addKategorie(Wasserfahrzeugkategorie wasserfahrzeugkathegorie){
        String sqlString = "insert into wasserfahrzeugkategorie values (?, ?, ?)";
        PreparedStatement preparedStatement = getPreparedStatement(sqlString);
        preparedStatement = Wasserfahrzeugkategorie.fillPreparedStatementForAdd(preparedStatement, wasserfahrzeugkathegorie);
        databaseInteraction(preparedStatement);
    }

    /**
     * Funktion, um eine Wasserfahrzeugkategorie zu ändern.
     * @param wasserfahrzeugkathegorie
     */
    public void changeKategorie(Wasserfahrzeugkategorie wasserfahrzeugkathegorie){
        String sqlString = "update wasserfahrzeugkathegorie set oberkathegorieId=?, title=? where id=" + wasserfahrzeugkathegorie.getId();
        PreparedStatement preparedStatement = getPreparedStatement(sqlString);
        preparedStatement = Wasserfahrzeugkategorie.fillPreparedStatementForChange(preparedStatement, wasserfahrzeugkathegorie);
        databaseInteraction(preparedStatement);
    }

    /**
     * Funktion um eine Wasserfahrzeugkategorie zu löschen
     * @param wasserfahrzeugkathegorie
     */
    public void deleteKategorie(Wasserfahrzeugkategorie wasserfahrzeugkathegorie){
        String sqlString = "delete from wasserfahrzeugkategorie where id=" + wasserfahrzeugkathegorie.getId();
        databaseInteraction(getPreparedStatement(sqlString));
    }

    /**
     * Funktion um die Anzahl der Kategorien auszugeben, die Unterkategorien von der übergebenen Kategorie sind.
     * @param wasserfahrzeugkathegorie
     */
    public void printHowManyLowerKategrien(Wasserfahrzeugkategorie wasserfahrzeugkathegorie){
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

    /**
     * Funktion die alle nötigen Aktionen beinhaltet um alle in der Datenbank gespeicherten Objekte vom Typ Wasserfahrzeug in die Konsole zu schreiben.
     */
    public void listAllWasserfahrzeuge(){
        String sqlString = "select * from Wasserfahrzeuge";
        ResultSet resultSet = databaseInteraction(getPreparedStatement(sqlString));
        Wasserfahrzeug.fromResultSet(resultSet).forEach(kat -> {
            System.out.println(kat.toString());
        });
    }

    /**
     * Funktion um der Datenbank ein neues Wasserfahrzeug hinzuzufügen
     * @param wasserfahrzeug
     */
    public void addWasserfahrzeug(Wasserfahrzeug wasserfahrzeug){
        String sqlString = "insert into wasserfahrzeuge values (?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = getPreparedStatement(sqlString);
        preparedStatement = Wasserfahrzeug.fillPreparedStatementForAdd(preparedStatement, wasserfahrzeug);
        databaseInteraction(preparedStatement);
    }

    /**
     * Funktion, um einen Wasserfahrzeug zu ändern.
     * @param wasserfahrzeug
     */
    public void changeWasserfahrzeug(Wasserfahrzeug wasserfahrzeug){
        String sqlString = "update wasserfahrzeug set name=?, kategorieId=?, liegeplatzId=?, frachtId=?, routeId=? where id=" + wasserfahrzeug.getId();
        PreparedStatement preparedStatement = getPreparedStatement(sqlString);
        preparedStatement = Wasserfahrzeug.fillPreparedStatementForChange(preparedStatement, wasserfahrzeug);
        databaseInteraction(preparedStatement);
    }

    /**
     * Funktion um ein Wasserfahrzeug zu enternen
     * @param wasserfahrzeug
     */
    public void deleteWasserfahrzeug(Wasserfahrzeug wasserfahrzeug){
        String sqlString = "delete from wasserfahrzeug where id=" + wasserfahrzeug.getId();
        databaseInteraction(getPreparedStatement(sqlString));
    }

    /**
     * Funktion die alle nötigen Aktionen beinhaltet um alle in der Datenbank gespeicherten Objekte vom Typ Liegeplätze in die Konsole zu schreiben.
     */
    public void listAllLiegeplaetze(){
        String sqlString = "select * from Liegeplätze";
        ResultSet resultSet = databaseInteraction(getPreparedStatement(sqlString));
        Liegeplatz.fromResultSet(resultSet).forEach(kat -> {
            System.out.println(kat.toString());
        });

    }

    /**
     * Funktion um der Datenbank einen neuen Liegeplatz hinzuzufügen
     * @param liegeplatz
     */
    public void addLiegeplatz(Liegeplatz liegeplatz){
        String sqlString = "insert into liegeplätze values (?, ?, ?)";
        PreparedStatement preparedStatement = getPreparedStatement(sqlString);
        preparedStatement = Liegeplatz.fillPreparedStatementForAdd(preparedStatement, liegeplatz);
        databaseInteraction(preparedStatement);
    }

    /**
     * Funktion, um einen Liegeplatz zu ändern.
     * @param liegeplatz
     */
    public void changeLiegeplatz(Liegeplatz liegeplatz){
        String sqlString = "update liegeplatz set hafenId=?, wasserfahrzeugId=?, fuerKategrieId=? where id=" + liegeplatz.getId();
        PreparedStatement preparedStatement = getPreparedStatement(sqlString);
        preparedStatement = Liegeplatz.fillPreparedStatementForChange(preparedStatement, liegeplatz);
        databaseInteraction(preparedStatement);
    }

    /**
     * Funktion um einen Liegeplatz zu löschen.
     * @param liegeplatz
     */
    public void deleteLiegeplatz(Liegeplatz liegeplatz){
        String sqlString = "delete from liegeplatz where id=" + liegeplatz.getId();
        databaseInteraction(getPreparedStatement(sqlString));
    }

    /**
     * Funktion die alle nötigen Aktionen beinhaltet um alle in der Datenbank gespeicherten Objekte vom Typ Routen in die Konsole zu schreiben.
     */
    public void listAllRouten(){
        String sqlString = "select * from Route";
        ResultSet resultSet = databaseInteraction(getPreparedStatement(sqlString));
        Route.fromResultSet(resultSet).forEach(kat -> {
            System.out.println(kat.toString());
        });

    }

    /**
     * Funktion um der Datenbank eine neue Route hinzuzufügen
     * @param route
     */
    public void addRoute(Route route){
        String sqlString = "insert into route values (?, ?, ?, ?)";
        PreparedStatement preparedStatement = getPreparedStatement(sqlString);
        preparedStatement = Route.fillPreparedStatementForAdd(preparedStatement, route);
        databaseInteraction(preparedStatement);
    }

    /**
     * Funktion, um eine Route zu ändern.
     * @param route
     */
    public void changeRoute(Route route){
        String sqlString = "update route set startLiegeplatzId=?, zielLiegeplatzId=?, laenge=? where id=" + route.getId();
        PreparedStatement preparedStatement = getPreparedStatement(sqlString);
        preparedStatement = Route.fillPreparedStatementForChange(preparedStatement, route);
        databaseInteraction(preparedStatement);
    }

    /**
     * Funktion um eine Route zu löschen.
     * @param route
     */
    public void deleteRoute(Route route){
        String sqlString = "delete from route where id=" + route.getId();
        databaseInteraction(getPreparedStatement(sqlString));
    }


}
