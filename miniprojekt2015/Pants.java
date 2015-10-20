package miniprojekt2015;

/**
 *
 * @author Morten Ricki Rasmussen 
 */
public class Pants extends Product{
    private boolean size28;
    private boolean size29;
    private boolean size30;
    private boolean size31;
    private boolean size32;
    private boolean size33;
    private boolean size34;
    private boolean size36;
    private boolean size38;
    
    public Pants(String name, String color, int price, boolean size28, boolean size29, boolean size30, boolean size31, boolean size32, boolean size33, boolean size34, boolean size36, boolean size38) {
        super.setName(name);
        super.setColor(color);
        super.setPrice(price);
        this.size28 = size28;
        this.size29 = size29;
        this.size30 = size30;
        this.size31 = size31;
        this.size32 = size32;
        this.size33 = size33;
        this.size34 = size34;
        this.size36 = size36;
        this.size38 = size38;
    }
    
    //--------------------------------------------------------------------------
    // toString
    //--------------------------------------------------------------------------

    @Override
    public String toString() {
        String sizes;
        sizes = "Sizes: ";
        
        if (size28 == true) {
            sizes = "Size 28 ";
        }
        if (size29 == true) {
            sizes = sizes + "Size 29 ";
        }
        if (size30 == true) {
            sizes = sizes + "Size 30 ";
        }
        if (size31 == true) {
            sizes = sizes + "Size 31";
        }
        if (size32 == true) {
            sizes = sizes + "Size 31";
        }        
        if (size33 == true) {
            sizes = sizes + "Size 33";
        }
        if (size34 == true) {
            sizes = sizes + "Size 34";
        }
        if (size36 == true) {
            sizes = sizes + "Size 36";
        }
        if (size38 == true) {
            sizes = sizes + "Size 38";
        }
        
        return sizes;
    }
            
}
