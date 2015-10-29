
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
    
    /**
     * gemPDF er en static metode som bliver brugt til at kommunikere imellem GUI/main og PdfGenerator.
     * Den modtager data fra GUI, tjekker igennem om det lever op til kravene, hvorefter den sender 
     * det videre til PdfGenerator. retunerer false hvis der er nogle parametre der ikke lever op til 
     * kravene, eller generatePDF returner false. Den henter faktura nummer fra en "fakNum.txt" og tilføjer et par nuller til
     * alt efter hvilket nummer den er nået til. Hvis generatePDF() retunerer true, tæller den tallet i "fakNum.txt" 
     * @param name
     * @param streetName
     * @param streetNum
     * @param cityName
     * @param postalCode
     * @param email
     * @param tlf
     * @param cardNumber
     * @param cardType
     * @param cardMonth
     * @param cardYear
     * @param cardCCV
     * @param items
     * @param sizes
     * @param total
     * @return
     * @throws IOException
     * @throws COSVisitorException
     * @throws FileNotFoundException
     * @throws UnsupportedEncodingException
     */
    public static boolean gemPdf(String name, String streetName, String streetNum, String cityName, String postalCode, String email, String tlf, String cardNumber, String cardType, String cardMonth, String cardYear, String cardCCV, ArrayList<Product> items, ArrayList sizes, String total) throws IOException, COSVisitorException, FileNotFoundException, UnsupportedEncodingException{
        Float total1 = Float.parseFloat(total.replace(",", "."));
        Float moms = Float.parseFloat(String.format("%.2f", total1*0.2f).replace(",", "."));
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
        if (cardNumber.length() == 16 && isNumber(cardNumber)){
            correctCount++;
        }
        if (cardCCV.length() == 3 && isNumber(cardCCV)){
            correctCount++;
        }
        if (correctCount == 9){
            for (int i = 0; i < items.size(); i++) {
                pdf.setYdelseNavn(items.get(i).getName()+", "+sizes.get(i), i);
                pdf.setYdelsePris(items.get(i).getPrice()+"", i);
            }
            fakNumZeroes = "";
            for (int i = 0; i < (5-((fakturaNummer+"").length())); i++) {
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
            pdf.setTotal(total1);
            pdf.setMoms(moms);
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
    
    /**
     * Tjekker om den string den får er et nummer. returnerer true hvis den kan få en double ud af den.
     * @param str
     * @return
     */
    public static boolean isNumber(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
