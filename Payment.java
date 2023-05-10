public class Payment {
    private double shippingFees = 20;
    private double totalCost = 0;

    public Payment() { }

    public double getShippingFees() {
        return shippingFees;
    }

    public double getTotalCost(ShoppingCart cart) {
        totalCost = shippingFees + cart.getTotalPrice();
        return totalCost;
    }

    public void checkOut(Order order) {
        order.getOrderStatus();
        order.setStatus(OrderStatus.DELIVERED);
    }
}