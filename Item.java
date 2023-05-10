public class Item {
    private String name;
    private String brand;
    private double price;

    //constructor
    public Item(String n, String b, double p) {
        this.name = n;
        this.brand = b;
        this.price = p;
    }
       

    //setters
    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //getters
    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public void print() {
        System.out.print("Name: " + name + ", ");
        System.out.print("Brand: " + brand + ", ");
        System.out.print("Price per item (in EGP): " + price);
    }
}
