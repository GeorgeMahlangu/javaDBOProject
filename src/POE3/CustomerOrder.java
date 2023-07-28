package POE3;

public class CustomerOrder {

    public int customerNumber;

    public int quotationNumber;

    public int customerCategory;

    public int productCode;

    public int productQuantity;

    public double productPrice;

    //Setting default values not to include them in constructor;
    public double subTotalAmount = 0.0;

    public double vatAmount = 0.0;

    public double orderDiscountAmount = 0.0;

    public double totalAmountDue = 0.0;

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

    public double calculateTotalAmountDue(int customerCategory, int productQuantity, double productPrice)
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

        return totalAmountDue;

    }


class CustomerAccountOrder extends CustomerOrder{
    public CustomerAccountOrder(int customerNumber, int quotationNumber, int customerCategory, int productCode, int productQuantity, double productPrice) {
        super(customerNumber, quotationNumber, customerCategory, productCode, productQuantity, productPrice);
    }

    public double calculateTotalAmountDue(int customerCategory, int productQuantity, double productPrice)
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

        return totalAmountDue;

    }

}}

