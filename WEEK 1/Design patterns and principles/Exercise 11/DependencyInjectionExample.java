import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

interface CustomerRepository {
    String findCustomerById(int id);
    void addCustomer(int id, String name);
}

class CustomerRepositoryImpl implements CustomerRepository {
    private Map<Integer, String> customerDatabase;

    public CustomerRepositoryImpl() {
        customerDatabase = new HashMap<>();
    }

    @Override
    public String findCustomerById(int id) {
        return customerDatabase.get(id);
    }

    @Override
    public void addCustomer(int id, String name) {
        customerDatabase.put(id, name);
    }
}

class CustomerService {
    private CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public String getCustomerName(int id) {
        return repository.findCustomerById(id);
    }

    public void addCustomer(int id, String name) {
        repository.addCustomer(id, name);
    }
}

public class DependencyInjectionExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CustomerRepository repository = new CustomerRepositoryImpl();

        CustomerService service = new CustomerService(repository);

        while (true) {
            System.out.println("Add a new customer:");
            System.out.print("Enter customer ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter customer name: ");
            String name = scanner.nextLine();
            service.addCustomer(id, name);

            System.out.print("Do you want to add another customer? (yes/no): ");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("no")) {
                break;
            }
        }

        while (true) {
            System.out.print("Enter customer ID to search (or -1 to exit): ");
            int searchId = scanner.nextInt();
            if (searchId == -1) {
                break;
            }

            String customerName = service.getCustomerName(searchId);

            if (customerName != null) {
                System.out.println("Customer Name: " + customerName);
            } else {
                System.out.println("Customer not found.");
            }
        }

        scanner.close();
    }
}
