package model;

/**
 *
 * @author Morten Ricki Rasmussen
 */
public abstract class Product {

    private String name;
    private String color;
    private float price;

    //--------------------------------------------------------------------------
    // Accessors
    //--------------------------------------------------------------------------
    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public float getPrice() {
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

    public void setPrice(float price) {
        this.price = price;
    }

    //--------------------------------------------------------------------------
    // toString
    //--------------------------------------------------------------------------  
    @Override
    public String toString() {
        return name;
    }

}
