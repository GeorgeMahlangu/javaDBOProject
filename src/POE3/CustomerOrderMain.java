package POE3;

import java.sql.SQLException;
import java.util.Scanner;

public class CustomerOrderMain {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        int customerNumber;

        System.out.print("Enter the customer number to find customer: ");
        customerNumber = scanner.nextInt();
        try{
            CustomerDBO.SelectCustomer(customerNumber);
        }
        catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

        //Creating a new customer order instance;
        CustomerOrder customerOrder = new CustomerOrder();

        //Prompt values from the users and set Object
        System.out.println("Please enter customer number");
        customerOrder.customerNumber = scanner.nextInt();

        System.out.println("Please enter Quotation number");
        customerOrder.quotationNumber = scanner.nextInt();

        System.out.println("Please enter customer category");
        customerOrder.customerCategory = scanner.nextInt();


        System.out.println("Please enter product code");
        customerOrder.productCode = scanner.nextInt();

        System.out.println("Please enter product price");
        customerOrder.productPrice = scanner.nextDouble();

        double totalAmountDue = customerOrder.calculateTotalAmountDue(customerOrder.customerCategory, customerOrder.productQuantity, customerOrder.productPrice);

        System.out.println("The total amount due for customer is: R"  + totalAmountDue);

        CustomerOrderDBO.insertPayRecord(customerOrder.customerNumber, customerOrder.quotationNumber,
                customerOrder.customerCategory,customerOrder.productCode,customerOrder.productQuantity
                ,customerOrder.productPrice,customerOrder.subTotalAmount,customerOrder.vatAmount,
                customerOrder.orderDiscountAmount,customerOrder.totalAmountDue);


    }



}
