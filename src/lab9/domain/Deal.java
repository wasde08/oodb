package lab9.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Deal {

    @Id
    long id;


    @ManyToOne
    Client client;


    @ManyToOne
    Product product;

    String priceclient;

    public Deal(int id, Client client, Product product) {
        this.id = id;
        this.client = client;
        this.product = product;
    }

    public Deal() {
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
