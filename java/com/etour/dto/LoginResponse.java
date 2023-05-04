package com.etour.dto;

import com.etour.entities.Customer_Master;

public class LoginResponse {
    private boolean success;
    private Customer_Master customer;

    public LoginResponse(boolean success, Customer_Master customer) {
        this.success = success;
        this.customer = customer;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Customer_Master getCustomer() {
        return customer;
    }

    public void setCustomer(Customer_Master customer) {
        this.customer = customer;
    }
}