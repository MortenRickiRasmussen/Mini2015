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
        items = new ArrayList();
    }

    public void addItem(Product item) {
        items.add(item);
    }

    public double calculateTotalAmount() {
        double totalAmount = 0;

        if (items.isEmpty()) {
            totalAmount = 0;
        } else {
            for (int i = 0; i < items.size(); i++) {
                totalAmount = totalAmount + items.get(i).getPrice();
            }
        }

        return totalAmount;
    }

}
