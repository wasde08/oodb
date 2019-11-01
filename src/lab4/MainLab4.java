package lab4;

public class MainLab4 {
    public static void main(String[] args){
        DbConnection dbConnection = new DbConnection();
       /* List<Product> list = new ArrayList<>();
        list.add(new Product(1,"2",3,4));
        list.add(new Product(2,"4",5,6));
        dbConnection.saveInDb(list);*/
        dbConnection.fromDBJson();
        dbConnection.fromDBJsonB();
        dbConnection.searchProduct(5);
    }
}
