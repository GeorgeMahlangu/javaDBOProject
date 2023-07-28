package POE3;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDBO {

    public static void SelectCustomer(int customerNumber) throws SQLException, ClassNotFoundException {
        //Declare a SELECT statement
        String selectStmt = "SELECT * FROM CUSTOMER WHERE Customer_Number =" + customerNumber;

        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rs = DatabaseUtility.dbExecuteQuery(selectStmt);

            //use the ResultSet to store the specific variables that pertain to the model class.
            while(rs.next()) {
                int cusNumber  = rs.getInt("Customer_Number");
                String cusName = rs.getString("Customer_Name");
                int cusCategory = rs.getInt("Customer_Category");
                String cusTelno = rs.getString("Customer_Telno");
                String cusDelAdd = rs.getString("Customer_DeliveryAddress");

                //Print results
                System.out.println("Customer Information");
                System.out.println("================================================================");
                System.out.println(" ");
                System.out.println("Customer Number : " + cusNumber + "\n"
                        + "Customer Name: " + cusName + "\n"
                        + "Customer Category : " + cusCategory + "\n"
                        + "Customer Telephone Number : " + cusTelno + "\n"
                        + "Customer Delivery Address : " + cusDelAdd + "\n" );
                System.out.println(" ");
                System.out.println("===============================================================");

            }
            //close database connection
            DatabaseUtility.dbDisconnect();
        }catch(Exception e){ System.out.println(e.getMessage());}
    }
}
