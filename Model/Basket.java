package Model;

import java.util.ArrayList;

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
    }

    //--------------------------------------------------------------------------
    // Tilføjer et produkt til kurven
    //--------------------------------------------------------------------------
    public void addItem(Product item, String size) {
        items.add(item);
        selectedSize.add("Størrelse " + size);
    }

    //--------------------------------------------------------------------------
    // Udregner den samlee pris
    //--------------------------------------------------------------------------
    public float calculateTotalAmount() {
        float totalAmount = 0;

        if (items.isEmpty()) {
            totalAmount = 0;
        } else {
            for (int i = 0; i < items.size(); i++) {
                totalAmount = totalAmount + items.get(i).getPrice();
            }
        }

        return totalAmount;
    }
    
    public ArrayList returnBasket() {
        return items;
    }

}
