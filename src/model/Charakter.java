package model;

import java.util.List;

public class Charakter {
    private int id;
    private String name;
    private String Herkunftsort;
    private List<Produkt> produkts;

    public Charakter(int id, String name, String Herkunftsort, List<Produkt> produkts) {
        this.id = id;
        this.name = name;
        this.Herkunftsort = Herkunftsort;
        this.produkts = produkts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHerkunftsort() {
        return Herkunftsort;
    }

    public void setHerkunftsort(String herkunftsort) {
        this.Herkunftsort = herkunftsort;
    }

    public List<Produkt> getProdukts() {
        return produkts;
    }

    public void setProdukts(List<Produkt> produkts) {
        this.produkts = produkts;
    }

    @Override
    public String toString() {
        return "model.Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + Herkunftsort + '\'' +
                ", produkts=" + produkts +
                '}';
    }
}
