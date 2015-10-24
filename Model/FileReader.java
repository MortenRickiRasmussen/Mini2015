package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Jakob Ferdinandsen
 * @author Morten Ricki Rasmussen
 */
public class FileReader {

    private static Scanner textScan;
        private static ArrayList<String> fil;
        private static ArrayList<String> tøj;
        
        
//  readFile() returnere en arrayliste med de forskellige stykker tøj i filen som strings ud fra formatet: category, name, color, price, true/false sizes according to class
//  tjek eventtuelt filen tøjdata.txt(ligger på drev)
    public static ArrayList<String> readFile(String fileName) {
        fil = new ArrayList<>();
        tøj = new ArrayList<>();
        
        try {
            File file = new File(fileName);
            textScan = new Scanner(file);
            while (textScan.hasNext()) {
                //System.out.println(textScan.nextLine());
                fil.add(textScan.nextLine());
            }
            textScan.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File Not Found: " + ex.getMessage());
        }
        for (int i = 0; i < fil.size(); i++) {
            if (!fil.get(i).isEmpty() && !fil.get(i).startsWith("#")){
                tøj.add(fil.get(i));
            }
        }
        return tøj;
    }
    
    public static void writeFile(String fileName, String writeText) {
        try {
            File file = new File(fileName);
            PrintWriter pw = new PrintWriter(file);
            pw.print(writeText);
            pw.close();
        } catch (IOException ex) {
            System.out.println("It wasen't possible to write to the file:  " + ex.getMessage());
        }
    }
    
}
