public class Item {
    private String name;
    private String description;
    private String brand;
    private String category;
    private float price;
    private float discountPercentage;
    private int quantityInStock;
    private boolean loose;

    //constructor
    public Item() { }

    //setters
    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setDiscountPercentage(float discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public void setLoose(boolean loose) {
        this.loose = loose;
    }

    //getters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getBrand() {
        return brand;
    }

    public String getCategory() {
        return category;
    }

    public float getPrice() {
        return price;
    }

    public float getDiscountPercentage() {
        return discountPercentage;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public boolean getLoose() {
        return loose;
    }

    public void print() {
        System.out.println("Name: " + name);
        System.out.println("Description: " + description);
        System.out.println("Brand: " + brand);
        System.out.println("Category: " + category);
        System.out.println("Price: " + price);
        System.out.println("Discount Percentage: " + discountPercentage);
        System.out.println("Quantity In Stock: " + quantityInStock);
        System.out.println("Loose: " + loose);
    }
}
