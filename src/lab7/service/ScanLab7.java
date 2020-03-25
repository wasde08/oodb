package lab7.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ScanLab7 {
    public static List<Class<?>> findEntity(String scannedPackage) {
        String replace = scannedPackage.replaceAll("\\.", "/");
        String scanned ="target/classes/" + replace;
        File scannedDir = new File(scanned);
        List<Class<?>> classes = new ArrayList<>();
        for (File file : scannedDir.listFiles()) {
            classes.addAll(find(file, scannedPackage));
        }
        return classes;
    }
    private static List<Class<?>> find(File file, String scannedPackage) {
        List<Class<?>> classes = new ArrayList<>();
        String resource = scannedPackage + "." + file.getName();
        if (file.isDirectory()) {
            for (File child : file.listFiles()) {
                classes.addAll(find(child, resource));
            }
        } else if (resource.endsWith(".class")) {
            String className = resource.substring(0, resource.length() - 6);
            try {
                classes.add(Class.forName(className));
            } catch (ClassNotFoundException ignore) {
            }
        }
        return classes;
    }
}
