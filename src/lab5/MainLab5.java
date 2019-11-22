package lab5;

import lab5.entity.Product;

public class MainLab5 {
    public static void main(String[] args){
        Service service = new Service();
        service.saveDB(new Product(1,"red pen",40,100));
        service.saveDB(new Product(2,"green pen",30,100));
        System.out.println(service.fromDB());
        System.out.println("----UPDATE----");
        service.updateDB(new Product(2,"green pen",20,100));
        System.out.println(service.fromDB());
    }
}
