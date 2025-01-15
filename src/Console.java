import java.util.Scanner;
import controller.Controller;

public class Console {
    private final Controller controller;

    public Console(Controller controller){
        this.controller = controller;
    }

    public int takeChoice(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the number you would like to take: ");
        return scanner.nextInt();
    }

    public void run() {
        System.out.println("Welcome to the app");
        System.out.println("""
                1. Add a new product
                2. Remove a product
                3. Show all products
                4. Update a product
                5. Add a new charakter
                6. Remove a charakter
                7. Show all charakters
                8. Update a charakter
                """);

        int choice = takeChoice();
        switch(choice){
            case 1:
                controller.createProdukt();
                break;

            case 2:
                controller.deleteProdukt();
                break;

            case 3:
                controller.getAllProdukts();
                break;

            case 4:
                controller.updateProdukt();
                break;
            case 5:
                controller.createCharakter();
                break;

            case 6:
                controller.deleteCharakter();
                break;

            case 7:
                controller.getAllCharakters();
                break;

            case 8:
                controller.updateCharakter();
                break;

            default:
                System.out.println("Invalid choice");
                break;
        }
    }
}
