package application;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Enter client data: ");
        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.next();

        System.out.print("Birth date (DD/MM/YYYY): ");
        LocalDate birthDate = LocalDate.parse(scanner.next(), formatter);

        Client client = new Client(name, email, birthDate);

        System.out.println("Enter order data: ");
        System.out.print("Status: ");
        OrderStatus orderStatus = OrderStatus.valueOf(scanner
            .next()
            .toUpperCase()
            .replace(" ", "_"));

        System.out.print("How many items to this order? ");
        int itemsQuantity = scanner.nextInt();
        scanner.nextLine();

        Order order = new Order(client, orderStatus);

        for (int i = 0; i < itemsQuantity; i++) {
            System.out.println("Enter " + (i + 1) + "# item data");
            System.out.print("Product name: ");
            String productName = scanner.nextLine();

            System.out.print("Product price: ");
            Double productPrice = scanner.nextDouble();

            System.out.print("Quantity: ");
            Integer quantity = scanner.nextInt();
            scanner.nextLine();

            Product product = new Product(productName, productPrice);
            OrderItem orderItem = new OrderItem(quantity, product);
            order.addItem(orderItem);

        }

        System.out.println(order);
        scanner.close();
    }
}
