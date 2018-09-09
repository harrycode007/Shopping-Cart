package com.example.hariharank.shoppingcart;

public class Phone {

    private String manufacturer;
    private String model;
    private int price;
    private String image;

    public Phone(String manufacturer, String model, int price, String image) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.price = price;
        this.image = image;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public int getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }
}
