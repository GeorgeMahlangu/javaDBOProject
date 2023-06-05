package POE3;

import java.util.Scanner;

public class CustomerOrderMain {

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int customerNumber;

//        System.out.print("Enter the customer number to find customer: ");
//        customerNumber = scanner.nextInt();
//        CustomerDBO.selectCustomer(customerNumber);

        //Creating a new customer order instance;
        CustomerOrder customerOrder = new CustomerOrder();

        //Prompt values from the users and set Object
        System.out.println("Please enter customer number");
        int customerNumber2 = scanner.nextInt();

        customerOrder.setCustomerNumber(customerNumber2);

        System.out.println("Please enter Quotation number");
        int quotationNumber = scanner.nextInt();

        customerOrder.setQuotationNumber(quotationNumber);

        System.out.println("Please enter customer category");
        int customerCategory = scanner.nextInt();

        customerOrder.setCustomerCategory(customerCategory);


        System.out.println("Please enter product code");
        int productCode = scanner.nextInt();

        customerOrder.setProductCode(productCode);

        System.out.println("Please enter product price");
        double productPrice = scanner.nextDouble();

        customerOrder.setProductPrice(productPrice);

        customerOrder.calculateTotalAmountDue(customerOrder.getCustomerCategory(), customerOrder.getProductQuantity(), customerOrder.getProductPrice());

        CustomerOrderDBO.insertPayRecord(customerOrder.getCustomerNumber(), customerOrder.getQuotationNumber(),
                customerOrder.getCustomerCategory(),customerOrder.getProductCode(),customerOrder.getProductQuantity()
                ,customerOrder.getProductPrice(),customerOrder.getSubTotalAmount(),customerOrder.getVatAmount(),
                customerOrder.getOrderDiscountAmount(),customerOrder.getTotalAmountDue());


    }



}
