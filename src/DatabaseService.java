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

}
