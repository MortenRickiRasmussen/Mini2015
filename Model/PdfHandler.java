
package Model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import org.apache.pdfbox.exceptions.COSVisitorException;

/**
 *
 * @author Jakob
 */
public class PdfHandler {
    private static int correctCount;
    private static PdfGenerator pdf;
    private static ReadFile fakNum;
    private static int fakturaNummer;
    private static String fakNumZeroes;
    
    public static boolean gemPdf(String name, String streetName, String streetNum, String cityName, String postalCode, String email, String tlf, String cardNumber, String cardType, String cardMonth, String cardYear, String cardCCV, ArrayList<Product> items, ArrayList sizes, float total) throws IOException, COSVisitorException, FileNotFoundException, UnsupportedEncodingException{
        correctCount = 0;
        pdf = new PdfGenerator();
        pdf.PdfGenerator();
        fakNum = new ReadFile("fakNum.txt");
        fakturaNummer = Integer.parseInt(fakNum.openFile()[0]);
        if (name.contains(" ") && name.length() > 2){
            correctCount++;
        }
        if (!streetName.isEmpty()){
            correctCount++;
        }
        if (Integer.parseInt(streetNum) > 0){
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
                pdf.setYdelseNavn(items.get(i).getName()+", "+sizes.get(i), i);
                pdf.setYdelsePris(items.get(i).getPrice()+"", i);
            }
            fakNumZeroes = "";
            for (int i = 0; i < (4-((fakturaNummer+"").length())); i++) {
            fakNumZeroes = fakNumZeroes.concat("0");            
            }
            pdf.setBy(cityName);
            pdf.setEmail(email);
            pdf.setFakNummer(fakNumZeroes+fakturaNummer);
            pdf.setKundeNavn(name);
            pdf.setPostNummer(postalCode);
            pdf.setTelefonNr(tlf);
            pdf.setVejNavn(streetName);
            pdf.setVejNr(Integer.parseInt(streetNum));
            pdf.setTotal(total);
            pdf.setMoms(total*0.2f);
            if (pdf.generatePDF()){
                fakturaNummer++;
                PrintWriter writer = null;
                writer = new PrintWriter("fakNum.txt", "UTF-8");
                writer.println(fakturaNummer+"");
                writer.close();
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
}
