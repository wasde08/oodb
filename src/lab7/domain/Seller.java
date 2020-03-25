package lab7.domain;

import lab7.annotation.Column;
import lab7.annotation.Entity;
import lab7.annotation.Id;


@Entity
public class Seller {
    @Id
    long id;

    @Column
    String name;

    @Column
    int experience;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Seller(String name, int experience) {
        this.name = name;
        this.experience = experience;
    }
}
