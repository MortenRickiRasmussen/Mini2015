package GUI;

import Model.Pants;

/**
 *
 * @author Morten Ricki Rasmussen 
 */
public class Main {

    public static void main(String[] args) {
        Pants p1 = new Pants("Long pants","blue",50,true,true,true,true,true,true,true,true,true);
        
        System.out.println(p1.getName());
    }

}
