import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Vector;
import java.io.IOException;

public class Catalog {
    private Vector<Category> categories = new Vector<>();

    public Catalog() { }

    public void viewCatalog()throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("Catalog.txt"));
        String line;

        // read file content
        while((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }
}
