import java.util.Vector;

public class Catalog {
    private Vector<Category> categories = new Vector<>();

    public Catalog() { }

    public void viewCatalog() {
        for (int i = 0; i < categories.size(); i++) {
            categories.get(i).ViewItems();
        }
    }
}
