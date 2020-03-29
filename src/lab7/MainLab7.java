package lab7;

//import lab5.DbConnection;
import lab7.annotation.Entity;
import lab7.service.DbScan;
import lab7.service.Init;
import lab7.service.ScanLab7;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainLab7 {
    public static void main(String[] args){
        ScanLab7 scanLab7 = new ScanLab7();
        String scanPath = "lab7.domain";
        List<Class<?>> classes = scanLab7.findEntity(scanPath);
        classes.forEach(c -> {
            if (c.getAnnotation(Entity.class) != null) {
                System.out.println(c.getSimpleName());
                List<Field> fields = new ArrayList<>(Arrays.asList(c.getDeclaredFields()));
                if (!c.getSuperclass().equals(Object.class)) {
                    fields.addAll(Arrays.asList(c.getSuperclass().getDeclaredFields()));
                }
                for (Field field : fields) {
                    System.out.println("\t" + field.getType());
                }
            }
        });
        System.out.println("Result = " + Init.isDBEqual());
    }
}
