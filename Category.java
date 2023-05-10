import java.util.Vector;

public class Category {
    private String name;
    private Vector<Item> items = new Vector<Item>();


    public Category() {
        Item item = new Item();
        item.setBrand("a7a");
        item.setPrice(1000000);
        items.add(item);

        Item item2 = new Item();
        item2.setBrand("a8a");
        item2.setPrice(1000000);
        items.add(item2);
    }

    public void ViewItems() {
        for (int i = 0; i < items.size(); i++) {
            items.get(i).print();
        }
    }
}
