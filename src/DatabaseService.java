import Objects.*;

import java.sql.*;

public class DatabaseService {

    private Connection con;

    public DatabaseService(){
        connect();
        printHowManyLowerKategrien(new Wasserfahrzeugkategorie(2, 2, "Motorboote"));
    }

    /**
     * @author Nils & Tim
     * Diese Methode repräsentiert den Punkt an dem ein "preparedStatement" an die Datenbank gesendet wird und ein "resultSet" zurück gegeben wird.
     * @param preparedStatement mit ausgefüllten Lücken
     * @return resultSet was bei Datenbankanfragen die angeforderten Informationen enthält
     * @see #getPreparedStatement(String sqlString)
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
     * @author Nils & Tim
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
     * @author Nils & Tim
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
     * @author Nils & Tim
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
     * @author Nils & Tim
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
     * @author Nils & Tim
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
     * @author Nils & Tim
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
     * @author Nils & Tim
     * Funktion, um eine Fracht zu ändern.
     * @param fracht
     */
    public void changeFracht(Fracht fracht){
        String sqlString = "update fracht set bezeichnung=?, gewicht=? where fracht_id=" + fracht.getId();
        PreparedStatement preparedStatement = getPreparedStatement(sqlString);
        preparedStatement = Fracht.fillPreparedStatementForChange(preparedStatement, fracht);
        databaseInteraction(preparedStatement);
    }

    /**
     * @author Nils & Tim
     * Funktion um eine Fracht zu löschen
     * @param fracht
     */
    public void deleteFracht(Fracht fracht){
        String sqlString = "delete from fracht where fracht_id=" + fracht.getId();
        PreparedStatement preparedStatement = getPreparedStatement(sqlString);
        databaseInteraction(preparedStatement);
    }

    /**
     * @author Nils & Tim
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
     * @author Nils & Tim
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
     * @author Nils & Tim
     * Funktion, um eine Wasserfahrzeugkategorie zu ändern.
     * @param wasserfahrzeugkathegorie
     */
    public void changeKategorie(Wasserfahrzeugkategorie wasserfahrzeugkathegorie){
        String sqlString = "update wasserfahrzeugkategorie set oberkategorie=?, titel=? where kategorie_id=" + wasserfahrzeugkathegorie.getId();
        PreparedStatement preparedStatement = getPreparedStatement(sqlString);
        preparedStatement = Wasserfahrzeugkategorie.fillPreparedStatementForChange(preparedStatement, wasserfahrzeugkathegorie);
        databaseInteraction(preparedStatement);
    }

    /**
     * @author Nils & Tim
     * Funktion um eine Wasserfahrzeugkategorie zu löschen
     * @param wasserfahrzeugkategorie
     */
    public void deleteKategorie(Wasserfahrzeugkategorie wasserfahrzeugkategorie){
        String sqlString = "delete from wasserfahrzeugkategorie where kategorie_id=" + wasserfahrzeugkategorie.getId();
        System.out.println(5);
        databaseInteraction(getPreparedStatement(sqlString));
        System.out.println(5);
    }

    /**
     * @author Nils & Tim
     * Funktion um die Anzahl der Kategorien auszugeben, die Unterkategorien von der übergebenen Kategorie sind.
     * @param wasserfahrzeugkathegorie
     */
    public void printHowManyLowerKategrien(Wasserfahrzeugkategorie wasserfahrzeugkathegorie){
        String sqlString = "SELECT oberkategorie, COUNT(*)FROM wasserfahrzeugkategorie WHERE oberkategorie=" + wasserfahrzeugkathegorie.getId() + " GROUP BY oberkategorie";
        PreparedStatement preparedStatement = getPreparedStatement(sqlString);
        ResultSet resultSet = databaseInteraction(preparedStatement);
        try{
            if(resultSet.next()) {
                int anzahl = resultSet.getInt(2);
                System.out.println(anzahl);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * @author Nils & Tim
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
     * @author Nils & Tim
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
     * @author Nils & Tim
     * Funktion, um einen Wasserfahrzeug zu ändern.
     * @param wasserfahrzeug
     */
    public void changeWasserfahrzeug(Wasserfahrzeug wasserfahrzeug){
        String sqlString = "update wasserfahrzeuge set name=?, kategorie=?, liegeplatz=?, fracht=?, route=? where schiff_id=" + wasserfahrzeug.getId();
        PreparedStatement preparedStatement = getPreparedStatement(sqlString);
        preparedStatement = Wasserfahrzeug.fillPreparedStatementForChange(preparedStatement, wasserfahrzeug);
        databaseInteraction(preparedStatement);
    }

    /**
     * @author Nils & Tim
     * Funktion um ein Wasserfahrzeug zu enternen
     * @param wasserfahrzeug
     */
    public void deleteWasserfahrzeug(Wasserfahrzeug wasserfahrzeug){
        String sqlString = "delete from wasserfahrzeuge where schiff_id=" + wasserfahrzeug.getId();
        databaseInteraction(getPreparedStatement(sqlString));
    }

    /**
     * @author Nils & Tim
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
     * @author Nils & Tim
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
     * @author Nils & Tim
     * Funktion, um einen Liegeplatz zu ändern.
     * @param liegeplatz
     */
    public void changeLiegeplatz(Liegeplatz liegeplatz){
        String sqlString = "update liegeplätze set hafen=?, passende_kategorie=? where lageplatz_id=" + liegeplatz.getId();
        PreparedStatement preparedStatement = getPreparedStatement(sqlString);
        preparedStatement = Liegeplatz.fillPreparedStatementForChange(preparedStatement, liegeplatz);
        databaseInteraction(preparedStatement);
    }

    /**
     * @author Nils & Tim
     * Funktion um einen Liegeplatz zu löschen.
     * @param liegeplatz
     */
    public void deleteLiegeplatz(Liegeplatz liegeplatz){
        String sqlString = "delete from liegeplätze where lageplatz_id=" + liegeplatz.getId();
        databaseInteraction(getPreparedStatement(sqlString));
    }

    /**
     * @author Nils & Tim
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
     * @author Nils & Tim
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
     * @author Nils & Tim
     * Funktion, um eine Route zu ändern.
     * @param route
     */
    public void changeRoute(Route route){
        String sqlString = "update route set startplatz=?, zielplatz=?, länge=? where routen_id=" + route.getId();
        PreparedStatement preparedStatement = getPreparedStatement(sqlString);
        preparedStatement = Route.fillPreparedStatementForChange(preparedStatement, route);
        databaseInteraction(preparedStatement);
    }

    /**
     * @author Nils & Tim
     * Funktion um eine Route zu löschen.
     * @param route
     */
    public void deleteRoute(Route route){
        String sqlString = "delete from route where routen_id=" + route.getId();
        databaseInteraction(getPreparedStatement(sqlString));
    }


}
