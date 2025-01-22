package com.springbootacademy.batch12.pos.dto.request;

public class CustomerUpdateDTO {

    private int customerId;
    private  String customerName;
    private String customerAddress;
    private double customerBalance;

    public CustomerUpdateDTO() {
    }

    public CustomerUpdateDTO(int customerId, String customerAddress, double customerBalance) {
        this.customerId = customerId;
        this.customerAddress = customerAddress;
        this.customerBalance = customerBalance;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public double getCustomerBalance() {
        return customerBalance;
    }

    public void setCustomerBalance(double customerBalance) {
        this.customerBalance = customerBalance;
    }

    @Override
    public String toString() {
        return "CustomerUpdateDTO{" +
                "customerId='" + customerId + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", customerBalance=" + customerBalance +
                '}';
    }
}
