package lab5.entity;

import lab5.entity.Product;

import java.util.List;

class Seller{

    String name;
    List<Product> productList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Seller(String name) {
        this.name = name;
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
