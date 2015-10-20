package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Morten Ricki Rasmussen
 */
public class FileReader {

    private static Scanner textScan;

    public static void readFile(String fileName) {
        try {
            File file = new File(fileName);
            textScan = new Scanner(file);
            while (textScan.hasNext()) {
                System.out.println(textScan.nextLine());
            }
            textScan.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File Not Found: " + ex.getMessage());
        }
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
