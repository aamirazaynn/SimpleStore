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
        int i = 1;
        for (Map.Entry<Item, Integer> entry : items.entrySet()) {
            Item item = entry.getKey();
            int quantity = entry.getValue();
            System.out.print(i + ". ");
            item.print();
            System.out.print(", Quantity: " + quantity);
            System.out.println(", Price: " + item.getPrice() * quantity + " EGP");
            i++;
        }
        System.out.println("Total Price: " + totalPrice);
    }

    public boolean validIndex(int index) {
        if (index > 0 && index <= items.size()) {
            return true;
        }
        return false;
    }

    /**
     *  this method changes the quantity of an item
     * @param item
     * @param quantity
     */
    public void changeQuantity(int index, int quantity) {
        Item item;
        int i = 1;
        for (Map.Entry<Item, Integer> entry : items.entrySet()) {
            item = entry.getKey();
            if (i == index) {
                items.put(item, quantity);
                calcTotalPrice();
                break;
            }
        }
    }

    /**
     *  this method removes an item
     * @param item
     */
    public void removeItem(int index) {
        Item item;
        int i = 1;
        for (Map.Entry<Item, Integer> entry : items.entrySet()) {
            item = entry.getKey();
            if (i == index) {
                items.remove(item);
                calcTotalPrice();
                break;
            }
        }
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
