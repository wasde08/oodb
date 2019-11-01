package lab4;

public class Product {

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

    public Product(int id, String description, int price, int size) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.size = size;
    }
}
