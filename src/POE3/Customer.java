package POE3;

public class Customer {
    private int customerNumber;
    private String customerName;

    private int customerCategory;

    private int customerTelNo;

    private String customerDeliveryAddress;

    public Customer(int customerNumber, String customerName, int customerCategory, int customerTelNo, String customerDeliveryAddress) {
        this.customerNumber = customerNumber;
        this.customerName = customerName;
        this.customerCategory = customerCategory;
        this.customerTelNo = customerTelNo;
        this.customerDeliveryAddress = customerDeliveryAddress;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getCustomerCategory() {
        return customerCategory;
    }

    public void setCustomerCategory(int customerCategory) {
        this.customerCategory = customerCategory;
    }

    public int getCustomerTelNo() {
        return customerTelNo;
    }

    public void setCustomerTelNo(int customerTelNo) {
        this.customerTelNo = customerTelNo;
    }

    public String getCustomerDeliveryAddress() {
        return customerDeliveryAddress;
    }

    public void setCustomerDeliveryAddress(String customerDeliveryAddress) {
        this.customerDeliveryAddress = customerDeliveryAddress;
    }
}
