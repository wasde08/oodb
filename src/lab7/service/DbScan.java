package lab7.service;

import lab7.DAO.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DbScan {


    public List<String> getTables() {
        List<String> result = new ArrayList<>();

        try(Connection connection = DbConnection.getDBconnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "select table_name from information_schema.tables " +
                            "where table_type = 'BASE TABLE' and table_schema not in ('pg_catalog', 'information_schema')"
            );

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                String tableName = rs.getString("table_name");
                result.add(tableName);
            }

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<String> getField(String tableName) {
        List<String> result = new ArrayList<>();

        try (Connection connection = DbConnection.getDBconnection()){

            PreparedStatement statement = connection.prepareStatement(
                    "select a.attname from pg_catalog.pg_attribute a " +
                            "where a.attrelid = (select c.oid from pg_catalog.pg_class c left join pg_catalog.pg_namespace n on n.oid = c.relnamespace where pg_catalog.pg_table_is_visible(c.oid) and c.relname = ?) " +
                            "and a.attnum > 0 and not a.attisdropped"
            );
            statement.setString(1, tableName);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                String field = rs.getString("attname");
                result.add(field);
            }

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
