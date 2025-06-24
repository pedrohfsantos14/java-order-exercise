package entities;

import entities.enums.OrderStatus;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    private Instant moment;
    private OrderStatus status;

    private List<OrderItem> items = new ArrayList<>();
    private Client client;

    public Order(Client client, OrderStatus orderStatus) {
        this.moment = Instant.now();
        this.status = orderStatus;
        this.client = client;
    }

    public void addItem(OrderItem orderItem) {
        this.items.add(orderItem);
    }

    public void removeItem(OrderItem orderItem) {
        this.items.remove(orderItem);
    }

    public Double total() {
        Double sum = 0.0;

        for (OrderItem item : items) {
            sum += item.subTotal();
        }
        return sum;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        ZonedDateTime zonedMoment = moment.atZone(ZoneId.systemDefault());

        stringBuilder.append("ORDER SUMMARY: \n");
        stringBuilder.append("Order moment: " + zonedMoment.format(DATE_TIME_FORMATTER));
        stringBuilder.append("\nOrder status: " + status);
        stringBuilder.append("\n" + client);
        stringBuilder.append("\nOrder items: ");
        for (OrderItem orderItem : items) {
            stringBuilder.append("\n" + orderItem);
        }
        stringBuilder.append(String.format("\nTotal price: $%.2f", total()));

        return stringBuilder.toString();
    }
}
