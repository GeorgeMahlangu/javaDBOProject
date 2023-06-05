package POE3;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDBO {

    //Use ResultSet from DB as parameter and set Customer Object's attributes and return customer object.
    public static Customer getCustomer(ResultSet rs) throws SQLException{
        Customer customer = new Customer();
        if(rs.next())
        {
            customer.setCustomerNumber(rs.getInt("Customer_Number"));
            customer.setCustomerName(rs.getString("Customer_Name"));
            customer.setCustomerCategory(rs.getInt("Customer_Category"));
            customer.setCustomerTelNo(rs.getInt("Customer_TelNo"));
            customer.setCustomerDeliveryAddress(rs.getString("Customer_DeliveryAddress"));
        }

        return customer;
    }
    public static void selectCustomer(int customerNumber)
    {
        String selectStatement = "SELECT * FROM CUSTOMER WHERE Customer_Number="+ customerNumber;

        try
        {
         ResultSet rsCustomer = DatabaseUtility.dbExecuteQuery(selectStatement);

         Customer customer = getCustomer(rsCustomer);


         System.out.println("Customer Information");
         System.out.println("================================================================");
         System.out.println(" ");
         System.out.println("Customer Number: " + customer.getCustomerNumber());
         System.out.println("Customer Name: " + customer.getCustomerName());
         System.out.println("Customer Category: " + customer.getCustomerCategory());
         System.out.println("Customer Telphone number: " + customer.getCustomerTelNo());
         System.out.println("Customer Delivery Address: " + customer.getCustomerDeliveryAddress());
         System.out.println(" ");
         System.out.println("===============================================================");


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
