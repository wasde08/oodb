package lab1;

import java.util.List;

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
