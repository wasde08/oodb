package lab9.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Client {
    @Id
    long id;

    @Column
    String name;

    @Column
    String numberPhone;

    public Client() {
    }


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
