package Lab1;

import java.util.List;

public class Main {
    public void main(String[] args){}
}

class Client {

    String name;
    String numberPhone;
    int age;
    List<Deal> dealList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Client(String name, String numberPhone, int age) {
        this.name = name;
        this.numberPhone = numberPhone;
        this.age = age;
    }
    public List<Deal> getDealList(){
        return dealList;
    }
    public void buyProduct (Deal deal){
        if (dealList.contains(deal)){
            dealList.add(deal);
        }
    }
    public void deleteDeal (Deal deal){
        dealList.remove(deal);
    }

}

class Seller {

    String name;
    String numberPhone;
    int experience;
    List<Product> productList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Seller(String name, String numberPhone, int experience) {
        this.name = name;
        this.numberPhone = numberPhone;
        this.experience = experience;
    }

    public void addProduct(Product product){
        if (productList.contains(product)){
            productList.add(product);
        }
    }

    public void editProductSize (Product product, int size){
        if (productList.equals(product))
            product.setSize(size);
    }

    public void editProductDescriptoin (Product product, String description){
        if (productList.equals(product))
            product.setDescription(description);
    }

    public void editProductPrice (Product product, int price){
        if (productList.equals(product))
            product.setPrice(price);
    }

    public List<Product> getProduct(){
        return productList;
    }

    public void deleteProduct(Product product){
            productList.remove(product);
    }
}

class Product {

    int id;
    String description;
    int price;
    int size;

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

    public Product(int id,String description, int price, int size) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.size = size;
    }
}

class Deal {

    int id;
    Client client;
    Seller seller;
    Product product;

    public Deal(int id, Client client, Seller seller, Product product) {
        this.id = id;
        this.client = client;
        this.seller = seller;
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

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

}
