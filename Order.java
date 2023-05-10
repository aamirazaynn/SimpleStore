import java.util.Vector;
import java.time.LocalDate;

public class Order {
    private static int nextOrderId = 1;
    private int orderId;
    private LocalDate orderDate;
    private String address;
    private OrderStatus status;
    private Vector<Item> items = new Vector<Item>();

    public Order(String address,Vector<Item> i) {
        this.items = i;
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
}
