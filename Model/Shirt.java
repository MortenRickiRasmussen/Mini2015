package Model;

/**
 *
 * @author Morten Ricki Rasmussen 
 */
public class Shirt extends Product{
    private boolean size38;
    private boolean size39;
    private boolean size40;
    private boolean size41;
    private boolean size42;
    private boolean size43;
    private boolean size44;
    private boolean size45;
    
    public Shirt(String name, String color, double price, boolean size38, boolean size39, boolean size40, boolean size41, boolean size42, boolean size43, boolean size44, boolean size45) {
        super.setName(name);
        super.setColor(color);
        super.setPrice(price);
        this.size38 = size38;
        this.size39 = size39;
        this.size40 = size40;
        this.size41 = size41;
        this.size42 = size42;
        this.size43 = size43;
        this.size44 = size44;
        this.size45 = size45;
    }
}
