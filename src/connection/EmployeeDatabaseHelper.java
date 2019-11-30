package connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeDatabaseHelper {
    public ResultSet allEmployeeDetails(Connection connection) {
        String querry = "SELECT * FROM EMPLOYEE";
        ResultSet resultset = null;
        try {
            Statement statement = connection.createStatement();
            resultset = statement.executeQuery(querry);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultset;
    }

}
