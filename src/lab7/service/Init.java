package lab7.service;

import lab7.annotation.*;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Init {
    private static final String PATH_TO_SCAN = "lab7.domain";


    public static boolean isDBEqual() {
        DbScan dbScanner = new DbScan();
        ScanLab7 pathScanner = new ScanLab7();

        HashMap<String, HashSet<String>> tables = new HashMap<>();
        dbScanner.getTables().forEach(table -> {
            HashSet<String> fields = new HashSet<>(dbScanner.getField(table));
            tables.put(table, fields);
        });

        HashMap<String, HashSet<String>> classes = new HashMap<>();
        pathScanner.findEntity(PATH_TO_SCAN).stream().filter(c -> c.getAnnotation(Entity.class) != null).forEach(c -> {
            HashSet<String> fieldNames = new HashSet<>();
            getClassFields(classes, c, fieldNames, c.getDeclaredFields());

            if (!c.getSuperclass().equals(Object.class)) {
                getClassFields(classes, c, fieldNames, c.getSuperclass().getDeclaredFields());
            }

            classes.put(c.getSimpleName().toLowerCase(), fieldNames);
        });

        boolean isEquals = true;
        for (Map.Entry<String, HashSet<String>> entry : classes.entrySet()) {
            String className = entry.getKey();
            HashSet<String> classFields = entry.getValue();

            isEquals = tables.containsKey(className);
            HashSet<String> tableFields = classes.get(className);
            for (String fieldName : classFields) {
                isEquals = tableFields.contains(fieldName);
            }
        }

        return isEquals;
    }

    private static void getClassFields(HashMap<String, HashSet<String>> classes, Class<?> c, HashSet<String> fieldNames, Field[] fields) {
        for (Field field : fields) {
            if (field.getAnnotation(Column.class) != null) {
                if (field.getAnnotation(ManyToOne.class) != null || field.getAnnotation(OneToOne.class) != null) {
                    fieldNames.add(field.getName().toLowerCase().concat("_id"));
                } else if (field.getAnnotation(OneToMany.class) != null || field.getAnnotation(ManyToMany.class) != null) {
                    String relationTypeName = field.getGenericType().getTypeName();
                    String relationClassName = relationTypeName.substring(relationTypeName.indexOf("<") + 1, relationTypeName.indexOf(">"));
                    String className = relationClassName.substring(relationClassName.lastIndexOf('.') + 1);

                    String interTableName = c.getSimpleName().toLowerCase() + "_" + className.toLowerCase();
                    HashSet<String> interFields = new HashSet<>();
                    interFields.add(c.getSimpleName().toLowerCase() + "_id");
                    interFields.add(field.getName().toLowerCase() + "_id");
                    classes.put(interTableName, interFields);
                } else {
                    fieldNames.add(field.getName().toLowerCase());
                }
            }
        }
    }

}
