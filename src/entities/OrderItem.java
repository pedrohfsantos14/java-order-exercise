package entities;

public class OrderItem {

    private Integer quantity;
    private Double price;

    private Product product;

    public OrderItem(Integer quantity, Product product) {
        this.quantity = quantity;
        this.price = product.getPrice();
        this.product = product;
    }

    public Double subTotal() {
        return quantity * price;
    }

    @Override
    public String toString() {
        return product.getName()
            + ", $"
            + String.format("%.2f" ,price)
            + ", Quantity: "
            + quantity
            + ", Subtotal: $"
            + subTotal();
    }
}
