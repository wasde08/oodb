package lab4;

import com.google.gson.Gson;

import java.sql.*;
import java.util.List;

public class DbConnection {
    public Connection getDBconnection(){
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            String dbURL = "jdbc:postgresql://localhost:5432/postgres";
            connection =
                    DriverManager.getConnection( dbURL, "postgres", "1234");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void saveInDbJSON(List<Product> products){
        for (int i = 0; i <products.size() ; i++) {
            Connection connection = getDBconnection();
            PreparedStatement statement = null;
            Gson gson = new Gson();
            String json = gson.toJson(products.get(i));
            //System.out.println(json);
            try {
                statement = connection.
                        prepareStatement("insert into product (id,datajsonb) " +
                                "values (?,cast( ? as json) );");
                statement.setInt(1, products.get(i).getId());
                statement.setObject(2, json);

                long start = System.currentTimeMillis();
                statement.executeUpdate();
                long finish = System.currentTimeMillis();
                long timeConsumedMillis = finish - start;
                System.out.println(timeConsumedMillis+ " - time json");

                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            int j = 3;
            try {
                statement = connection.
                        prepareStatement("insert into product (id,datajson) " +
                                "values (?,cast( ? as json) );");
                statement.setInt(1, j);
                statement.setObject(2, json);

                long start = System.currentTimeMillis();
                statement.executeUpdate();
                long finish = System.currentTimeMillis();
                long timeConsumedMillis = finish - start;
                System.out.println(timeConsumedMillis+ " - time jsonb");

                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

 /*   public void saveInDb(List<Product> products){
        for (int i = 0; i <products.size() ; i++) {
            Connection connection = getDBconnection();
            PreparedStatement statement = null;
            Gson gson = new Gson();
            String json = gson.toJson(products.get(i));
            System.out.println(json);
            try {
                statement = connection.
                        prepareStatement("insert into product (id,datajson,datajsonb) " +
                                "values (?,cast( ? as json),cast( ? as json) );");
                statement.setInt(1, products.get(i).getId());
                statement.setObject(2, json);
                statement.setObject(3, json);
                statement.executeUpdate();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    */
    public void fromDBJson(){

        String str;
        PreparedStatement statement =
                null;
        try {
            statement = getDBconnection().prepareStatement("select datajson from product;");

            long start = System.currentTimeMillis();
            ResultSet resultSet = statement.executeQuery();
            long finish = System.currentTimeMillis();
            long timeConsumedMillis = finish - start;
            System.out.println(timeConsumedMillis+ " - time json");

            while (resultSet.next()) {
                str = resultSet.getString("datajson");
               // System.out.println(str);
            }

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    public void fromDBJsonB(){
        String str;
        PreparedStatement statement =
                null;
        try {
            statement = getDBconnection().prepareStatement("select datajsonb from product;");

            long start = System.currentTimeMillis();
            ResultSet resultSet = statement.executeQuery();
            long finish = System.currentTimeMillis();
            long timeConsumedMillis = finish - start;
            System.out.println(timeConsumedMillis+ " - time jsonb");

            while (resultSet.next()) {
                str = resultSet.getString("datajsonb");
                //System.out.println(str);
            }

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void searchProduct(int criterion){
        String str;

        try {
            PreparedStatement statement = getDBconnection().prepareStatement("select datajson from product;");

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                str = resultSet.getString("datajson");
                Gson gson = new Gson();
                Product product = gson.fromJson(str,Product.class);
                if (product.getPrice()==criterion){
                    System.out.println(str);
                }
            }

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
