import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<Item, Integer> items = new HashMap<>();
    private double totalPrice = 0;

    public ShoppingCart() {
    }

    public void addItem(Item item, int quantity) {
        items.put(item, quantity);
        calcTotalPrice();
    }

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

    public void changeQuantity(Item item, int quantity) {
        items.put(item, quantity);
        calcTotalPrice();
    }

    public void removeItem(Item item) {
        items.remove(item);
        calcTotalPrice();
    }

    public void calcTotalPrice() {
        totalPrice = 0;
        for (Map.Entry<Item, Integer> entry : items.entrySet()) {
            Item item = entry.getKey();
            int quantity = entry.getValue();
            this.totalPrice += item.getPrice() * quantity;
        }
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
