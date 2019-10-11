package lab2;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import lab1.Client;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JsonWork {
    public static void main(String[] args) throws IOException {
       fillIn();
       System.out.println(readWithJson());
       search("Almaz",readWithJson());
    }

    public static void fillIn() throws IOException {
        ArrayList<Client> clients = new ArrayList<>();
        clients.add(new Client("Almaz", "89872547875", 19));
        clients.add(new Client("Fail", "89872547876", 10));
        clients.add(new Client("Slava", "89872547877", 33));
        writeInJson(clients);
    }

    public static List<Client> readWithJson() throws IOException, JsonSyntaxException {
        String json = new String(Files.readAllBytes(new File("persons.json").toPath()));
        Gson gson = new Gson();
        Client[] personList = gson.fromJson(json, Client[].class);
        return Arrays.asList(personList);
    }

    public static void writeInJson(List<Client> clients) throws JsonSyntaxException {
        Gson gson = new Gson();
        String json = gson.toJson(clients);
        try {
            FileWriter writer = new FileWriter("persons.json");
            writer.write(json);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void search(String name, List<Client> list){
        list.stream().filter(client -> client.getName().equals(name)).forEach(System.out::println);
    }
}
