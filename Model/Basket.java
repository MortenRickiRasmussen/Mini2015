package Model;

import java.util.ArrayList;

/**
 *
 * @author Morten Ricki Rasmussen
 */
public class Basket {
    private ArrayList<Product> items;
    private ArrayList<String> selectedSize;

    public Basket() {
        items = new ArrayList();
        selectedSize = new ArrayList();
    }

    //--------------------------------------------------------------------------
    // Tilføjer et produkt til kurven
    //--------------------------------------------------------------------------
    public void addItem(Product item, String size) {
        items.add(item);
        selectedSize.add("Størrelse " + size);
    }
    
    //--------------------------------------------------------------------------
    // Tilføjer et produkt til kurven fra BasketInventory, som allerede har "Størrelse " foran.
    //--------------------------------------------------------------------------
    public void addSameItem(Product item, String size) {
        items.add(item);
        selectedSize.add(size);
    }

    //--------------------------------------------------------------------------
    // Fjernet et produkt fra kurven
    //--------------------------------------------------------------------------
    public void removeItem(Product item, String size) {
        items.remove(item);
        selectedSize.remove(size);
    }

    //--------------------------------------------------------------------------
    // Udregner den samlede pris
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

    //--------------------------------------------------------------------------
    // Metoder til at retunere de to ArrayLister
    //--------------------------------------------------------------------------
    public ArrayList returnBasket() {
        return items;
    }

    public ArrayList returnSelectedSize() {
        return selectedSize;
    }

}
