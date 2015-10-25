package Model;

/**
 *
 * @author Morten Ricki Rasmussen 
 */
public abstract class Product {
    private String name;
    private String color;
    private double price;
    
    //--------------------------------------------------------------------------
    // Accessors
    //--------------------------------------------------------------------------

    public String getName() {
        return name;
    }
    
    public String getColor() {
        return color;
    }
    
    public double getPrice() {
        return price;
    }
    
    //--------------------------------------------------------------------------
    // Mutators
    //--------------------------------------------------------------------------

    public void setName(String name) {
        this.name = name;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
}
