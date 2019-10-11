package lab1;

import java.util.List;

public class Client {

    String name;
    String numberPhone;
    int age;
    List<Deal> dealList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", numberPhone='" + numberPhone + '\'' +
                ", age=" + age +
                '}';
    }

    public Client(String name, String numberPhone, int age) {
        this.name = name;
        this.numberPhone = numberPhone;
        this.age = age;
    }

    public List<Deal> getDealList(){
        return dealList;
    }

    public void buyProduct (Deal deal){
        if (dealList.contains(deal)){
            dealList.add(deal);
        }
    }

    public void deleteDeal (Deal deal){
        dealList.remove(deal);
    }

}
