package lab4;

import java.util.ArrayList;
import java.util.List;

public class MainLab4 {
    public static void main(String[] args){
        DbConnection dbConnection = new DbConnection();
        List<Product> list = new ArrayList<>();
        list.add(new Product(1,"2",3,4));
        dbConnection.saveInDbJSON(list);
       /* dbConnection.fromDBJson();
        dbConnection.fromDBJsonB();
        dbConnection.searchProduct(5);*/
    }
}
