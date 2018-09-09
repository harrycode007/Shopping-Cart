package com.example.hariharank.shoppingcart;

public class Buy {

    private String model;
    private String username;
    private int quantity;
    private String invoiceNumber;

    public Buy(String model, String username, int quantity, String invoiceNumber) {
        this.model = model;
        this.username = username;
        this.quantity = quantity;
        this.invoiceNumber = invoiceNumber;
    }

    public String getModel() {
        return model;
    }

    public String getUsername() {
        return username;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }
}