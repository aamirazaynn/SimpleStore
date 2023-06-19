/**
 *  this class is used to define the item
 */
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

    /**
     *  this method is used to set the name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *  this method is used to set the brand
     * @param brand
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     *  this method is used to set the price
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    //getters

    /**
     *  this method is used to get the name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     *  this method is used to get the brand
     * @return brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     *  this method is used to get the price
     * @return price
     */
    public double getPrice() {
        return price;
    }

    /**
     *  this method is used to print the item information
     */
    public void print() {
        System.out.print("Name: " + name + ", ");
        System.out.print("Brand: " + brand + ", ");
        System.out.print("Price per item (in EGP): " + price);
    }
}
