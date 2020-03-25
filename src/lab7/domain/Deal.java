package lab7.domain;

import lab6.annotation.ManyToOne;
import lab7.annotation.Column;
import lab7.annotation.Entity;
import lab7.annotation.Id;

@Entity
public class Deal {

    @Id
    long id;

    @Column
    @ManyToOne
    Client client;

    @Column
    @ManyToOne
    Product product;

    String priceclient;

    public Deal(int id, Client client, Product product) {
        this.id = id;
        this.client = client;
        this.product = product;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
