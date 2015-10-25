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
    
    public TShirt() {
        
    }
    
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

    public void setSizeS(boolean sizeS) {
        this.sizeS = sizeS;
    }

    public void setSizeM(boolean sizeM) {
        this.sizeM = sizeM;
    }

    public void setSizeL(boolean sizeL) {
        this.sizeL = sizeL;
    }

    public void setSizeXL(boolean sizeXL) {
        this.sizeXL = sizeXL;
    }

    public void setSizeXXL(boolean sizeXXL) {
        this.sizeXXL = sizeXXL;
    }
    
    
    @Override
    public String toString() {
        return super.getName();
    }
    
    
    
}
