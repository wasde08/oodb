package lab7.domain;

import lab7.annotation.Column;
import lab7.annotation.Entity;
import lab7.annotation.Id;

@Entity
public class Client {
    @Id
    long id;

    @Column
    String name;

    @Column
    String numberPhone;


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


    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", numberPhone='" + numberPhone + '\'' +
                '}';
    }

    public Client(String name, String numberPhone) {
        this.name = name;
        this.numberPhone = numberPhone;
    }

}
