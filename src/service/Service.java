package service;

import model.Produkt;
import repository.Repository;
import model.Charakter;

import java.util.List;

public class Service {
    private final Repository<Charakter> charakterRepo;
    private final Repository<Produkt>produktRepo;

    public Service(Repository<Charakter> charakterRepo, Repository<Produkt> produktRepo) {
        this.charakterRepo = charakterRepo;
        this.produktRepo = produktRepo;
    }

    public void addCharakter(Charakter charakter) {
        charakterRepo.create(charakter);
    }


    public void addProdukt(Produkt produkt) {
        produktRepo.create(produkt);
    }


    public void deleteCharakter(Charakter charakter) {
        charakterRepo.delete(charakter);
    }


    public void deleteProdukt(Produkt produkt) {
        produktRepo.delete(produkt);
    }


    public List<Charakter> getCharakter() {
        return charakterRepo.getAll();
    }


    public List<Produkt> getProdukts() {
        return produktRepo.getAll();
    }


    public void updateCharakter(Charakter firstCharakter, Charakter charakter) {
        charakterRepo.update(firstCharakter, charakter);
    }


    public void updateProdukt(Produkt firstProdukt,Produkt produkt) {
        produktRepo.update(firstProdukt,produkt);
    }

    public Produkt getProdukt(String name) {
        for (Produkt produkt : produktRepo.getAll()) {
            if (produkt.getName().equals(name)) {
                return produkt;
            }
        }
        return null;
    }

    public Charakter getCharakter(int id) {
        for (Charakter customer : charakterRepo.getAll()) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }


}


