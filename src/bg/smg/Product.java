package bg.smg;

public class Product {
    private String name;
    private String category;
    private double price;

    public Product() {
        this.name = "";
        this.category = "";
        this.price = 0;
    }

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " " + category + " " + price;
    }

    public int compareTo(Product o){
        return (int)(this.price-o.price);
    }
}
