package POE3;

import java.sql.SQLException;

public class CustomerOrderDBO {

    public static void insertPayRecord(int customerNumber, int quotationNumber, int customerCategory, int productCode, int productQuantity, double productPrice, double subTotalAmount, double vatAmount, double orderDiscountAmount, double totalAmountDue)
    {
        System.out.println("Inserting customer order");

        String insertStatement =
                "INSERT INTO CUSTOMER_ORDERS\n" +
                "(Quotation_Number, Customer_number, Customer_Category, Product_Code, Product_Quantity , " +
                "Product_Price, SubTotal_Amount, Order_VAT_Amount, Order_Discounted_Amount, Total_Amount_Due )\n" +
                "VALUES\n" +
                "('"+quotationNumber+"', '"+customerNumber+"', '"+customerCategory+"','"+productCode+"','"+productQuantity+ "'  ,'" +productPrice+"','" +subTotalAmount+"','"+vatAmount+"', '"+orderDiscountAmount+"',   '"+totalAmountDue+"')";
        try {
            DatabaseUtility.dbExecuteUpdate(insertStatement);
            System.out.println("Successfully inserted record to DB");
        } catch (SQLException e) {
            System.out.print("Error occurred while INSERT  Operation: " + e);

        } catch (ClassNotFoundException e) {

            System.out.println("Error inserting record to DB");
            throw new RuntimeException(e);
        }
    }

}
