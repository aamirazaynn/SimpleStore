import java.time.LocalDate;

/**
 *  This class represents an order.
 */
public class Order {
    private static int nextOrderId = 1;
    private int orderId;
    private LocalDate orderDate;
    private String address;
    private OrderStatus status;
    private ShoppingCart cart;

    // constructor
    public Order(String address,ShoppingCart cart) {
        this.cart = cart;
        this.orderId = nextOrderId;
        this.orderDate = LocalDate.now();
        this.address = address;
        this.status = OrderStatus.CREATED;
        nextOrderId++;
    }

    // setters

    /**
     *  this method sets the order address
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     *  this method sets the order status
     * @param status
     */
    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    // getters

    /**
     *  this method returns the order id
     * @return orderId
     */
    public int getOrderId() {
        return orderId;
    }

    /**
     *  this method returns the order date
     * @return  orderDate
     */
    public LocalDate getOrderDate() {
        return orderDate;
    }

    /**
     *  this method returns the order address
     * @return  address
     */
    public String getAddress() {
        return address;
    }

    /**
     *  this method returns the order status
     * @return  status
     */
    public OrderStatus getOrderStatus() {
        return status;
    }

    /**
     *  this method returns the shopping cart
     * @return cart
     */
    public ShoppingCart getCart() {
        return cart;
    }
}
