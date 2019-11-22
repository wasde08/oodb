package lab5;

import lab5.entity.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Service {

    public List<Product> fromDB(){
        List<Product> list = new ArrayList<>();
        DbConnection dbConnection = new DbConnection();
        String str;
        PreparedStatement statement = null;
        try {
            statement = dbConnection.getDBconnection().prepareStatement("select (prod) from sellers;");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String string = resultSet.getString("prod").split("\\(")[1].split("\\)")[0];
                list.add(new Product(
                        Integer.valueOf( string.split(",")[0]),
                        string.split(",")[2],
                        Integer.valueOf(string.split(",")[3]),
                        Integer.valueOf( string.split(",")[1])));
            }

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;

    }
    public void saveDB(Product product){
        DbConnection dbConnection = new DbConnection();
        String str;
        Statement statement = null;
        try {
            String sql = "insert into sellers values (ROW('" + product.id + "','"
                    + product.size+ "','" +product.description
                    + "','" +product.price +"'));";
            Connection c =dbConnection.getDBconnection();
            Statement stmt = c.createStatement();
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    public void updateDB(Product product){
        DbConnection dbConnection = new DbConnection();
        try {
            String sql = "UPDATE sellers SET prod.id = " + product.id+",prod.size = "+ product.size+
                    ",prod.description = '" + product.description +"',prod.price =" +product.price+
                    " where (prod).id = " + product.id+";";
            Connection c =dbConnection.getDBconnection();
            Statement stmt = c.createStatement();
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
