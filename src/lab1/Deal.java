package lab1;

import java.util.List;

public class Deal {

    int id;
    Client client;
    Product product;

    public Deal(int id, Client client, Product product) {
        this.id = id;
        this.client = client;
        this.product = product;
    }
    public int getId() {
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

    /*public List<Product> updateList(int id, Client client){
        List<Product> productList = (List<Product>) client.getDealList().remove(id);
        return productList;
    }*/
}
