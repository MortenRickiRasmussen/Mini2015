package Model;

/**
 *
 * @author Morten Ricki Rasmussen 
 */
public class TShirt extends Product{
    private boolean sizeS;
    private boolean sizeM;
    private boolean sizeL;
    private boolean sizeXL;
    private boolean sizeXXL;
    
    public TShirt(String name, String color, double price, boolean sizeS, boolean sizeM, boolean sizeL, boolean sizeXL, boolean sizeXXL) {
        super.setName(name);
        super.setColor(color);
        super.setPrice(price);
        this.sizeS = sizeL;
        this.sizeM = sizeM;
        this.sizeL = sizeL;
        this.sizeXL = sizeXL;
        this.sizeXXL = sizeXXL;
        
    }
     
    
    
    
}
