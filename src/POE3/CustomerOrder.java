package POE3;

public class CustomerOrder {

    private int customerNumber;

    private int quotationNumber;

    private int customerCategory;

    private int productCode;

    private int productQuantity;

    private double productPrice;

    //Setting default values not to include them in constructor;
    private double subTotalAmount = 0.0;

    private double vatAmount = 0.0;

    private double orderDiscountAmount = 0.0;

    private double totalAmountDue = 0.0;

    public CustomerOrder() {

        this.customerNumber = 0;

        this.quotationNumber = 0;

        this.customerCategory = 0;

        this.productCode = 0;

        this.productQuantity = 0;

        this.productPrice = 0;

        this.subTotalAmount = 0.0;

        this.vatAmount = 0.0;

        this.orderDiscountAmount = 0.0;

        this.totalAmountDue = 0.0;
    }

    public CustomerOrder(int customerNumber, int quotationNumber, int customerCategory, int productCode, int productQuantity, double productPrice) {
        this.customerNumber = customerNumber;
        this.quotationNumber = quotationNumber;
        this.customerCategory = customerCategory;
        this.productCode = productCode;
        this.productQuantity = productQuantity;
        this.productPrice = productPrice;
    }

    public void calculateTotalAmountDue(int customerCategory, int productQuantity, double productPrice)
    {
        //initialize amounts
        double subTotalAmount = 0.0;
        double vatAmount = 0.0;
        double orderDiscountAmount = 0.0;
        double totalAmountDue = 0.0;

        //Process calculations
        subTotalAmount = (productPrice * productQuantity);
        vatAmount = subTotalAmount * 0.15;

        orderDiscountAmount = switch (customerCategory) {
            case 1 -> ((subTotalAmount + vatAmount) * 0.10) + ((subTotalAmount + vatAmount) * 0.1);
            case 2 -> ((subTotalAmount + vatAmount) * 0.15) + ((subTotalAmount + vatAmount) * 0.1);
            case 3 -> ((subTotalAmount + vatAmount) * 0.20) + ((subTotalAmount + vatAmount) * 0.1);
            default -> 0;
        };


        //Calculate total Amount Due
        totalAmountDue = ((subTotalAmount+vatAmount)-(orderDiscountAmount));


        //Display calculated values
        System.out.println("Sub total Amount: " +  subTotalAmount);
        System.out.println("Order Vat Amount: " +  vatAmount);
        System.out.println("Order Discount Amount: " +  orderDiscountAmount);
        System.out.println("Total Amount Due: " +  totalAmountDue);

        //Return calculated values to Object
        this.subTotalAmount = subTotalAmount;
        this.vatAmount = vatAmount;
        this.orderDiscountAmount = orderDiscountAmount;
        this.totalAmountDue = orderDiscountAmount;

    }

    public double getSubTotalAmount() {
        return subTotalAmount;
    }

    public double getVatAmount() {
        return vatAmount;
    }

    public double getOrderDiscountAmount() {
        return orderDiscountAmount;
    }

    public double getTotalAmountDue() {
        return totalAmountDue;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public int getQuotationNumber() {
        return quotationNumber;
    }

    public void setQuotationNumber(int quotationNumber) {
        this.quotationNumber = quotationNumber;
    }

    public int getCustomerCategory() {
        return customerCategory;
    }

    public void setCustomerCategory(int customerCategory) {
        this.customerCategory = customerCategory;
    }

    public int getProductCode() {
        return productCode;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public void setSubTotalAmount(double subTotalAmount) {
        this.subTotalAmount = subTotalAmount;
    }

    public void setVatAmount(double vatAmount) {
        this.vatAmount = vatAmount;
    }

    public void setOrderDiscountAmount(double orderDiscountAmount) {
        this.orderDiscountAmount = orderDiscountAmount;
    }

    public void setTotalAmountDue(double totalAmountDue) {
        this.totalAmountDue = totalAmountDue;
    }

}

class CustomerAccountOrder extends CustomerOrder{
    public CustomerAccountOrder(int customerNumber, int quotationNumber, int customerCategory, int productCode, int productQuantity, double productPrice) {
        super(customerNumber, quotationNumber, customerCategory, productCode, productQuantity, productPrice);
    }

    public void calculateTotalAmountDue(int customerCategory, int productQuantity, double productPrice)
    {
        //initialize amounts
        double subTotalAmount;
        double vatAmount;
        double orderDiscountAmount;
        double totalAmountDue;

        //Process calculations
        subTotalAmount = (productPrice * productQuantity);
        vatAmount = subTotalAmount * 0.15;

        orderDiscountAmount = switch (customerCategory) {
            case 1 -> ((subTotalAmount + vatAmount) * 0.10) + ((subTotalAmount + vatAmount) * 0.03);
            case 2 -> ((subTotalAmount + vatAmount) * 0.15) + ((subTotalAmount + vatAmount) * 0.03);
            case 3 -> ((subTotalAmount + vatAmount) * 0.20) + ((subTotalAmount + vatAmount) * 0.03);
            default -> 0;
        };


        //Calculate total Amount Due
        totalAmountDue = ((subTotalAmount+vatAmount)-(orderDiscountAmount));


        //Display calculated values
        System.out.println("Sub total Amount: " +  subTotalAmount);
        System.out.println("Order Vat Amount: " +  vatAmount);
        System.out.println("Order Discount Amount: " +  orderDiscountAmount);
        System.out.println("Total Amount Due: " +  totalAmountDue);

        //Return calculated values to Object
        this.setSubTotalAmount(subTotalAmount);
        this.setVatAmount(vatAmount);
        this.setOrderDiscountAmount(orderDiscountAmount);
        this.setOrderDiscountAmount(orderDiscountAmount);

    }

}

