/** this class represents a payment */
public class Payment {
    private double shippingFees = 20;
    private double totalCost = 0;

    /**
     * this is the constructor
     */
    public Payment() { }

    /**
     *  this method returns the shipping fees
     * @return the shipping fees
     */
    public double getShippingFees() {
        return shippingFees;
    }

    /**
     * this method returns the total cost
     * @param cart
     * @return the total cost
     */
    public double getTotalCost(ShoppingCart cart) {
        totalCost = shippingFees + cart.getTotalPrice();
        return totalCost;
    }

    /** this method checks out the order
     * @param order
     */
    public void checkOut(Order order) {
        order.getOrderStatus();
        order.setStatus(OrderStatus.DELIVERED);
    }
}