package lab3.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlRootElement
public class Seller {

    String name;
    String numberPhone;
    int experience;

    @Override
    public String toString() {
        return "Seller{" +
                "name='" + name + '\'' +
                ", numberPhone='" + numberPhone + '\'' +
                ", experience=" + experience +
                ", productList=" + productList +
                '}';
    }

    public Seller(){
    }
    @XmlElementWrapper(name = "products")
    @XmlElement(name = "product")
    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

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
