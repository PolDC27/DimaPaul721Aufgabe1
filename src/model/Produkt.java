package model;

import java.util.Date;

public class Produkt {
    String name;
    double price;
    String herkunftsregion;

    public Produkt(String name, double price, String herkunftsregion) {
        this.name = name;
        this.price = price;
        this.herkunftsregion = herkunftsregion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getHerkunftsregion() {
        return herkunftsregion;
    }

    public void setHerkunftsregion(String herkunftsregion) {
        this.herkunftsregion = herkunftsregion;
    }

    @Override
    public String toString() {
        return "model.Produkt{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", herkunftsregion=" + herkunftsregion +
                '}';
    }
}
