import java.util.Vector;

public class Category {
    private String name;
    private Vector<Item> items = new Vector<>();


    public Category() {
//        Item item = new Item();
//        item.setBrand("a7a");
//        item.setPrice(1000000);
//        items.add(item);
    }

    public void ViewItems() {
        for (int i = 0; i < items.size(); i++) {
            items.get(i).print();
        }
    }
}
