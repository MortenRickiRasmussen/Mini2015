package Model;

import java.util.ArrayList;
import static oracle.jrockit.jfr.events.Bits.floatValue;

/**
 *
 * @author Morten Ricki Rasmussen
 */
public class Basket {

    private String name;
    private ArrayList<Product> items;
    private ArrayList<String> selectedSize;

    public Basket() {
        this.name = "Basket";
        items = new ArrayList();
        selectedSize = new ArrayList();
    }

    //--------------------------------------------------------------------------
    // Tilføjer et produkt til kurven
    //--------------------------------------------------------------------------
    public void addItem(Product item, String size) {
        items.add(item);
        selectedSize.add("Størrlese " + size);
    }

    //--------------------------------------------------------------------------
    // Udregner den samlee pris
    //--------------------------------------------------------------------------
    public String calculateTotalAmount() {
        float totalAmount = 0;

        if (items.isEmpty()) {
            totalAmount = 0;
        } else {
            for (int i = 0; i < items.size(); i++) {
                totalAmount = totalAmount + items.get(i).getPrice();
            }
        }
  
        String amount = String.format("%.2f", totalAmount);
        
        return amount;
    }
    
    public ArrayList returnBasket() {
        return items;
    }
    public ArrayList returnSelectedSize(){
        return selectedSize;
    }

}
