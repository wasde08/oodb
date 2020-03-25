package lab6.domain;

import lab6.annotation.Column;
import lab6.annotation.Entity;

@Entity
public class Client  {

    @Column
    String name;

    @Column
    String numberPhone;

    @Column
    int age;

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

}
