package lab7.domain;

import lab7.annotation.ManyToOne;
import lab7.annotation.Column;
import lab7.annotation.Entity;
import lab7.annotation.Id;

@Entity
public class Product {
    @Id
    long id;

    @Column
    int size;

    @Column
    String description;

    @Column
    int price;

    @Column
    @ManyToOne
    Seller seller;

    public long getId() {
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

    public Product(long id, int id1, String description, int price, int size, Seller seller) {
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
