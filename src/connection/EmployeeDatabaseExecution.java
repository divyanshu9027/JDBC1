package connection;

import java.sql.SQLException;
import java.sql.ResultSet;

public class EmployeeDatabaseExecution {
    public static void main(String[] args) {
        EmployeeDatabaseConnector employeeDatabaseConnector=new EmployeeDatabaseConnector();
        if (employeeDatabaseConnector.attemptConnection()==true){
            System.out.println("Connection Established");
        }
        else{
            System.out.println("Connection Failed");
        }
        EmployeeDatabaseHelper employeeDatabaseHelper=new EmployeeDatabaseHelper();
        ResultSet alldata=employeeDatabaseHelper.allEmployeeDetails(employeeDatabaseConnector.getConnection());
        while(true){
            try{
                if(!alldata.next()){
                    break;
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
            try{
                System.out.println("Employee Details: empID: "+alldata.getString("empID")
                +" Employee Name: "+alldata.getString("empName"));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (employeeDatabaseConnector.closeConnection()==true){
            System.out.println("Connection Closed");
        }
        else{
            System.out.println("Connection is not Closed");
        }
    }
}
