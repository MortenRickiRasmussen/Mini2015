
package Model;

import java.util.ArrayList;

/**
 *
 * @author Jakob
 */
public class pdfHandler {
    private static int correctCount;
    private static PdfGenerator pdf;
    private static float moms;
    private static float total;
    
    public static boolean gemPdf(String name, String streetName, String streetNum, String cityName, String postalCode, String email, String tlf, String cardNumber, String cardType, String cardMonth, String cardYear, String cardCCV, ArrayList<Product> items, ArrayList sizes){
        correctCount = 0;
        pdf = new PdfGenerator();
        if (name.contains(" ") && name.length() > 2){
            correctCount++;
        }
        if (!streetName.isEmpty()){
            correctCount++;
        }
        if (!streetNum.isEmpty()){
            correctCount++;
        }
        if (!cityName.isEmpty()){
            correctCount++;
        }
        if (Integer.parseInt(postalCode) > 99 && Integer.parseInt(postalCode) < 10000){
            correctCount++;
        }
        if (email.contains("@") && email.length() > 5){
            correctCount++;
        }
        if (tlf.length() > 7){
            correctCount++;
        }
        if (cardNumber.length() > 15){
            correctCount++;
        }
        if (cardCCV.length() == 3){
            correctCount++;
        }
        if (correctCount == 9){
            for (int i = 0; i < items.size(); i++) {
                pdf.setYdelseNavn(items.get(i).toString()+", "+sizes.get(i), i);
                pdf.setYdelsePris(items.get(i).getPrice()+"", i);
            }
            
            pdf.setBy(cityName);
            pdf.setEmail(email);
            pdf.setFakNummer(fakNum);
            pdf.setKundeNavn(name);
            return true;
        }else{
            return false;
        }
    }
}
