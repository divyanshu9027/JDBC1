package connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class EmployeeDatabaseConnector {
    private static final String URL="jdbc:mysql://localhost:3306/test";
    private static final String USERNAME="root";
    private static final  String PASSWORD="";
    private static Connection connection=null;

    public static Connection getConnection() {
        return connection;
    }

    public boolean attemptConnection(){
        boolean isConnected=false;
        try{
            connection=DriverManager.getConnection(URL,USERNAME,PASSWORD);
            isConnected=true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isConnected;
    }
    public boolean closeConnection(){
        boolean isClosed=false;
        try{
            getConnection().close();
            isClosed=true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isClosed;
    }
}
