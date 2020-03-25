package lab6.domain;

import lab6.annotation.Entity;


public class Product extends Deal {

    int id;
    String description;
    int price;
    int size;
    Seller seller;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Product(int id, Client client, Product product, int id1, String description, int price, int size, Seller seller) {
        super(id, client, product);
        this.id = id1;
        this.description = description;
        this.price = price;
        this.size = size;
        this.seller = seller;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }
}
