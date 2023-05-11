import java.util.Vector;
import java.io.IOException;

public class Catalog {
    private Vector<Item> items = new Vector<>();

    public Catalog() { 
        items.add(new Item("Chocolate", "Galaxy", 20));
        items.add(new Item("Chocolate", "Cadbury Dairy Milk", 15.5));
        items.add(new Item("Cake", "Todo", 5));
        items.add(new Item("Chocolate Cake", "Hohos", 5));
        items.add(new Item("Toffe", "Bebeto", 10));
        items.add(new Item("Icecream", "Friday", 7));
        items.add(new Item("Bonbon", "Halls", 10));
        items.add(new Item("Jelly", "Mimix", 1));
        items.add(new Item("Waffer", "Sham3edan", 5));
    }

    public void viewCatalog()throws IOException {
        for(int i = 0; i < items.size(); i++) {
            System.out.print("\n" + (i + 1) + ". ");
            items.get(i).print();
        }
    }

    public boolean validIndex(int index) {
        if(index < 0 || index >= items.size()) {
            System.out.println("The number you have entered is not valid");
            return false;
        }
        return true;
    }

    public Item getItem(int index) {
        return items.get(index-1);
    }
}
