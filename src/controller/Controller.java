package controller;

import model.Charakter;
import model.Produkt;
import service.Service;
import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

public class Controller {
    private final Service service;

    public Controller(Service service) {
        this.service = service;
    }

    public void createProdukt() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Produkt name: ");
        String name = scanner.nextLine();
        System.out.println("Enter Produkt price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Enter Produkt Herkunftsregion: ");
        String herkunftsregion = scanner.nextLine();


        Produkt produkt = new Produkt(name, price, herkunftsregion );
        service.addProdukt(produkt);
    }


    public void createCharakter() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Charakter id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter Charakter name: ");
        String name = scanner.nextLine();
        System.out.println("Enter Charakter Herkunftsort: ");
        String herkunftsort = scanner.nextLine();
        List<Produkt> produkts = new ArrayList<>();
        for (int i = 0; i < service.getProdukts().size(); i++) {
            System.out.println(i + "." +  service.getProdukts().get(i));
        }
        while (true){
            System.out.println("Enter the product number: ");
            int productNumber = scanner.nextInt();
            scanner.nextLine();
            if (productNumber < 0 || productNumber > service.getProdukts().size()){
                break;
            }
            System.out.println("Enter the product quantity: ");
            int quantity = scanner.nextInt();
            scanner.nextLine();

            for (int i = 1; i <= quantity; i++) {
                produkts.add(service.getProdukts().get(productNumber));
            }
        }

        Charakter customer = new Charakter(id, name, herkunftsort, produkts);
        service.addCharakter(customer);
    }


    public void getAllProdukts() {
        for (Produkt produkt : service.getProdukts()){
            System.out.println(produkt);
        }
    }


    public void getAllCharakters() {
        for (Charakter customer : service.getCharakters()){
            System.out.println(customer);
        }
    }


    public void deleteCharakter(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Charakter id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        for (Charakter charakter : service.getCharakters()){
            if (charakter.getId() == id){
                service.deleteCharakter(charakter);
                break;
            }
        }
    }


    public void deleteProdukt(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Produkt Name: ");
        String name = scanner.nextLine();
        for (Produkt produkt : service.getProdukts()){
            if (produkt.getName().equals(name)){
                service.deleteProdukt(produkt);
                break;
            }
        }
    }


    public void updateCharakter(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Charakter id to be updated: ");
        int id = scanner.nextInt();
        if (service.getCharakter(id) != null) {
            System.out.println("Enter new Charakter name: ");
            String name = scanner.nextLine();
            System.out.println("Enter new Charakter Herkunftsregion: ");
            String address = scanner.nextLine();
            List<Produkt> produkts = new ArrayList<>();
            for (int i = 0; i < service.getProdukts().size(); i++) {
                System.out.println(i + "." + service.getProdukts().get(i));
            }
            while (true) {
                System.out.println("Enter the product number: ");
                int productNumber = scanner.nextInt();
                scanner.nextLine();
                if (productNumber < 0 || productNumber > service.getProdukts().size()) {
                    break;
                }
                System.out.println("Enter the product quantity: ");
                int quantity = scanner.nextInt();
                scanner.nextLine();

                for (int i = 1; i <= quantity; i++) {
                    produkts.add(service.getProdukts().get(productNumber));
                }
            }
            Charakter charakter = new Charakter(id, name, address, produkts);

            service.updateCharakter(service.getCharakter(id),charakter);
        }
    }


    public void updateProdukt() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Produkt name to be updated: ");
        String name = scanner.nextLine();
        if (service.getProdukt(name) != null) {
            System.out.println("Enter new product name: ");
            String newName = scanner.nextLine();
            System.out.println("Enter new product price: ");
            double newPrice = scanner.nextDouble();
            scanner.nextLine();
            System.out.println("Enter new product herkunftsregion: ");
            String herkunftsregion = scanner.nextLine();


            Produkt produkt = new Produkt(newName, newPrice, herkunftsregion);
            service.updateProdukt(service.getProdukt(name),produkt);
        }
    }


    public List<Charakter> getCharaktersByProductHerkunft(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Charakter Herkunftsregion: ");
        String herkunftsregion = scanner.nextLine();
        List<Charakter> charakters = new ArrayList<>();
        for (Charakter charakter : service.getCharakters()){
            for (Produkt produkt : charakter.getProdukts()){
                if (produkt.getHerkunftsregion().equals(herkunftsregion)){
                    charakters.add(charakter);
                }
            }
        }
        return charakters;
    }

    public void sortProduktsByPriceAufsteigend(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Charakter Id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        for (Charakter charakter : service.getCharakters()){
            if (charakter.getId() == id){
                for (int i = 0; i < charakter.getProdukts().size() - 1; i++) {
                    for (int j = i + 1; j < charakter.getProdukts().size(); j++) {
                        if (charakter.getProdukts().get(i).getPrice() > charakter.getProdukts().get(j).getPrice()) {
                            Produkt temp = charakter.getProdukts().get(i);
                            charakter.getProdukts().set(i, charakter.getProdukts().get(j));
                            charakter.getProdukts().set(j, temp);
                        }
                    }
                }
            }
        }
    }


    public void sortProduktsByPriceAbsteigend(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Charakter Id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        for (Charakter charakter : service.getCharakters()){
            if (charakter.getId() == id){
                for (int i = 0; i < charakter.getProdukts().size() - 1; i++) {
                    for (int j = i + 1; j < charakter.getProdukts().size(); j++) {
                        if (charakter.getProdukts().get(i).getPrice() < charakter.getProdukts().get(j).getPrice()) {
                            Produkt temp = charakter.getProdukts().get(i);
                            charakter.getProdukts().set(i, charakter.getProdukts().get(j));
                            charakter.getProdukts().set(j, temp);
                        }
                    }
                }
            }
        }
    }

}
