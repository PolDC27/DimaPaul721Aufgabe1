import model.Charakter;
import model.Produkt;
import repository.Repository;
import service.Service;
import controller.Controller;

public class Main {
    public static void main(String[] args) {
        Repository<Charakter> customerRepository = new Repository<>();
        Repository<Produkt> productRepository = new Repository<>();
        Service service = new Service(customerRepository, productRepository);
        Controller controller = new Controller(service);
        Console console = new Console(controller);

        while (true) {
            console.run();
        }
        }
}