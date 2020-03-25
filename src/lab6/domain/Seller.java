package lab6.domain;

public class Seller {

    String name;
    String numberPhone;
    int experience;

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

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Seller(String name, String numberPhone, int experience) {
        this.name = name;
        this.numberPhone = numberPhone;
        this.experience = experience;
    }
}
