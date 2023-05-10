import java.time.LocalDate;

public class Order {
    private static int nextOrderId = 1;
    private int orderId;
    private LocalDate orderDate;
    private String address;
    private OrderStatus status;
    private ShoppingCart cart;

    public Order(String address,ShoppingCart cart) {
        this.cart = cart;
        this.orderId = nextOrderId;
        this.orderDate = LocalDate.now();
        this.address = address;
        this.status = OrderStatus.CREATED;
        nextOrderId++;
    }

    // setters
    public void setAddress(String address) {
        this.address = address;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    // getters
    public int getOrderId() {
        return orderId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public String getAddress() {
        return address;
    }

    public OrderStatus getOrderStatus() {
        return status;
    }

    public ShoppingCart getCart() {
        return cart;
    }
}
