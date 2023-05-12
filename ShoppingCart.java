import java.util.HashMap;
import java.util.Map;

/**
 * this class represents a shopping cart
 */
public class ShoppingCart {
    private Map<Item, Integer> items = new HashMap<>();
    private double totalPrice = 0;

    /**
     * this is the constructor
     */
    public ShoppingCart() {
    }

    /**
     * this method adds an item to the cart
     * @param item
     * @param quantity
     */
    public void addItem(Item item, int quantity) {
        items.put(item, quantity);
        calcTotalPrice();
    }

    /**
     *  this method views the cart
     */
    public void viewCart() {
        for (Map.Entry<Item, Integer> entry : items.entrySet()) {
            Item item = entry.getKey();
            int quantity = entry.getValue();
            item.print();
            System.out.print(", Quantity: " + quantity);
            System.out.println(", Price: " + item.getPrice() * quantity + " EGP\n");
        }
        System.out.println("Total Price: " + totalPrice);
    }

    /**
     *  this method changes the quantity of an item
     * @param item
     * @param quantity
     */
    public void changeQuantity(Item item, int quantity) {
        items.put(item, quantity);
        calcTotalPrice();
    }

    /**
     *  this method removes an item
     * @param item
     */
    public void removeItem(Item item) {
        items.remove(item);
        calcTotalPrice();
    }

    /**
     *  this method calculates the total price
     */
    public void calcTotalPrice() {
        totalPrice = 0;
        for (Map.Entry<Item, Integer> entry : items.entrySet()) {
            Item item = entry.getKey();
            int quantity = entry.getValue();
            this.totalPrice += item.getPrice() * quantity;
        }
    }

    /**
     *  this method returns the total price
     * @return the total price
     */
    public double getTotalPrice() {
        return totalPrice;
    }
}
