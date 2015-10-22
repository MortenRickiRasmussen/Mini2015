package Model;

import java.util.ArrayList;

/**
 *
 * @author Morten Ricki Rasmussen 
 */
public class Basket {
    private String name;
    private ArrayList<Product> items;
    
    public Basket() {
        this.name = "Basket";
    }
    
    public void addItem(Product item) {
        items.add(item);
    }
    
    public int calculateTotalAmout() {
        int totalAmout = 0;
        
        for (int i = 0; i < items.size(); i++) {
            totalAmout = totalAmout + items.get(i).getPrice();
        }
        
        return totalAmout;
    }
    
}
