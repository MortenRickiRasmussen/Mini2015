package Model;

import java.util.ArrayList;

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
    private ArrayList sizes;
    
    public TShirt(String name, String color, float price, boolean sizeS, boolean sizeM, boolean sizeL, boolean sizeXL, boolean sizeXXL) {
        super.setName(name);
        super.setColor(color);
        super.setPrice(price);
        this.sizeS = sizeL;
        this.sizeM = sizeM;
        this.sizeL = sizeL;
        this.sizeXL = sizeXL;
        this.sizeXXL = sizeXXL;
        sizes = new ArrayList();       
        if (sizeS == true) {
            sizes.add("S");
        }
        if (sizeM == true) {
            sizes.add("M");
        }
        if (sizeL == true) {
            sizes.add("L");
        }
        if (sizeXL == true) {
            sizes.add("XL");
        }
        if (sizeXXL == true) {
            sizes.add("L");
        }
    }
     
    public int getSizesSize() {
        return sizes.size();
    }
    
    public String getSizes(int i) {
        return (String) sizes.get(i).toString();
    }
    
}
