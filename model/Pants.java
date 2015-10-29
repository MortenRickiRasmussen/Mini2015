package model;

import java.util.ArrayList;

/**
 *
 * @author Morten Ricki Rasmussen
 */
public class Pants extends Product {

    private boolean size28;
    private boolean size29;
    private boolean size30;
    private boolean size31;
    private boolean size32;
    private boolean size33;
    private boolean size34;
    private boolean size36;
    private boolean size38;
    private ArrayList sizes;

    //--------------------------------------------------------------------------
    // Constructor som laver et objekt og fylder størrelser i ArrayListen sizes
    //--------------------------------------------------------------------------
    public Pants(String name, String color, float price, boolean size28, boolean size29, boolean size30, boolean size31, boolean size32, boolean size33, boolean size34, boolean size36, boolean size38) {
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
        sizes = new ArrayList();
        if (size28 == true) {
            sizes.add("28");
        }
        if (size29 == true) {
            sizes.add("29");
        }
        if (size30 == true) {
            sizes.add("30");
        }
        if (size31 == true) {
            sizes.add("31");
        }
        if (size32 == true) {
            sizes.add("32");
        }
        if (size33 == true) {
            sizes.add("33");
        }
        if (size34 == true) {
            sizes.add("34");
        }
        if (size36 == true) {
            sizes.add("36");
        }
        if (size38 == true) {
            sizes.add("38");
        }
    }

    //--------------------------------------------------------------------------
    // metoder til at beregne ArrayList størrelser og return.
    //--------------------------------------------------------------------------

    public ArrayList getSizes() {
        return sizes;
    }

}
