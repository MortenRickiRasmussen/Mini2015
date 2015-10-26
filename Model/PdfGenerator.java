package Model;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.pdfbox.Overlay;
import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDTrueTypeFont;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jakob
 */
public class PdfGenerator {
    private static String kundeNavn;
    private static String vejNavn;
    private static int vejNr;
    private static String postNummer;
    private static String by;
    private static String emailAdresse;
    private static String telefonNr;
    private static String[] ydelseNavn;
    private static String[] ydelsePris;
    private static String fakNummer;
    private static float moms;
    private static float total;
    private static String localCopyPath;
    private static String serverCopyPath;
    
    public void PdfGenerator(){
        kundeNavn = "";
        vejNavn = "";
        by = "";
        emailAdresse = "";
        telefonNr = "";
        postNummer = "";
        ydelseNavn = new String[16];
        ydelsePris = new String[16];
        localCopyPath = "";
        serverCopyPath = "";
    }

    public static boolean generatePDF(String name, String email, String tlf,  ) throws IOException, COSVisitorException{
        kundeNavn = "";
        vejNavn = "";
        by = "";
        emailAdresse = "";
        telefonNr = "";
        postNummer = "";
        ydelseNavn = new String[16];
        ydelsePris = new String[16];
        localCopyPath = "";
        serverCopyPath = "";
        PDDocument faktura = new PDDocument();
        PDPage page = new PDPage(PDPage.PAGE_SIZE_A4);
        faktura.addPage(page);
        SimpleDateFormat date = new SimpleDateFormat("dd-M-yyyy");
        PDFont font = PDTrueTypeFont.loadTTF(faktura, "font/arial.ttf");
        PDFont fontBold = PDTrueTypeFont.loadTTF(faktura, "font/arialbd.ttf");
        PDPageContentStream contentStream = new PDPageContentStream(faktura, page);
        
        contentStream.beginText();
        contentStream.setFont(font, 10);
        contentStream.moveTextPositionByAmount(45, 712);
        contentStream.drawString("Femøvej 3, 4700 Næstved");
        contentStream.moveTextPositionByAmount(0, -12);
        contentStream.drawString("Tlf.: 50762640");
        contentStream.moveTextPositionByAmount(0, -12);
        contentStream.drawString("CVR-nr.: 31661471");
        contentStream.setFont(fontBold, 10);        
        contentStream.moveTextPositionByAmount(0, -48);
        contentStream.drawString("Faktureres til:");
        contentStream.setFont(font, 10);
        contentStream.moveTextPositionByAmount(0, -12);
        contentStream.drawString(kundeNavn);
        if (!vejNavn.isEmpty()){
            if (vejNr == 0){
                contentStream.moveTextPositionByAmount(0, -12);
                contentStream.drawString(vejNavn);
            }else{
                contentStream.moveTextPositionByAmount(0, -12);
                contentStream.drawString(vejNavn+" "+vejNr);            
            }
        }
        if (!by.isEmpty() || !postNummer.isEmpty()){
            if (postNummer.isEmpty()){
                contentStream.moveTextPositionByAmount(0, -12);
                contentStream.drawString(by);
            }else{
                contentStream.moveTextPositionByAmount(0, -12);
                contentStream.drawString(postNummer+" "+by);
            }
        }
        if (!telefonNr.isEmpty()){
            contentStream.moveTextPositionByAmount(0, -12);
            contentStream.drawString(telefonNr+"");
        }
        contentStream.moveTextPositionByAmount(0, -12);
        contentStream.drawString(emailAdresse);
        contentStream.endText();
        
        contentStream.beginText();
        contentStream.setFont(font, 10);
        contentStream.moveTextPositionByAmount(547, 588);
        float textwidth = (font.getStringWidth(date.format(new Date()))/1000.0f)*10;
        contentStream.moveTextPositionByAmount(-textwidth, 0);
        contentStream.drawString(date.format(new Date()));
        contentStream.moveTextPositionByAmount(textwidth, 0);
        contentStream.moveTextPositionByAmount(0, -12);
        String fakNumString = fakNummer+"";
        textwidth = (font.getStringWidth(fakNumString)/1000.0f)*10;
        contentStream.moveTextPositionByAmount(-textwidth, 0);
        contentStream.drawString(fakNummer+"");
        contentStream.moveTextPositionByAmount(textwidth, 0);
        contentStream.endText();
        
        contentStream.beginText();
        contentStream.setFont(font, 10);
        contentStream.moveTextPositionByAmount(47, 532);        
        if (!ydelseNavn[0].equals("null")){
            contentStream.moveTextPositionByAmount(0, -18);
            contentStream.drawString(ydelseNavn[0]);
        }
        if (!ydelseNavn[1].equals("null")){
            contentStream.moveTextPositionByAmount(0, -18);
            contentStream.drawString(ydelseNavn[1]);
        }
        if (!ydelseNavn[2].equals("null")){
            contentStream.moveTextPositionByAmount(0, -18);
            contentStream.drawString(ydelseNavn[2]);
        }
        if (!ydelseNavn[3].equals("null")){
            contentStream.moveTextPositionByAmount(0, -18);
            contentStream.drawString(ydelseNavn[3]);
        }
        if (!ydelseNavn[4].equals("null")){
            contentStream.moveTextPositionByAmount(0, -18);
            contentStream.drawString(ydelseNavn[4]);
        }
        if (!ydelseNavn[5].equals("null")){
            contentStream.moveTextPositionByAmount(0, -18);
            contentStream.drawString(ydelseNavn[5]);
        }
        if (!ydelseNavn[6].equals("null")){
            contentStream.moveTextPositionByAmount(0, -18);
            contentStream.drawString(ydelseNavn[6]);
        }
        if (!ydelseNavn[7].equals("null")){
            contentStream.moveTextPositionByAmount(0, -18);
            contentStream.drawString(ydelseNavn[7]);
        }
        if (!ydelseNavn[8].equals("null")){
            contentStream.moveTextPositionByAmount(0, -18);
            contentStream.drawString(ydelseNavn[8]);
        }
        if (!ydelseNavn[9].equals("null")){
            contentStream.moveTextPositionByAmount(0, -18);
            contentStream.drawString(ydelseNavn[9]);
        }
        if (!ydelseNavn[10].equals("null")){
            contentStream.moveTextPositionByAmount(0, -18);
            contentStream.drawString(ydelseNavn[10]);
        }
        if (!ydelseNavn[11].equals("null")){
            contentStream.moveTextPositionByAmount(0, -18);
            contentStream.drawString(ydelseNavn[11]);
        }
        if (!ydelseNavn[12].equals("null")){
            contentStream.moveTextPositionByAmount(0, -18);
            contentStream.drawString(ydelseNavn[12]);
        }
        if (!ydelseNavn[13].equals("null")){
            contentStream.moveTextPositionByAmount(0, -18);
            contentStream.drawString(ydelseNavn[13]);
        }
        if (!ydelseNavn[14].equals("null")){
            contentStream.moveTextPositionByAmount(0, -18);
            contentStream.drawString(ydelseNavn[14]);
        }
        if (!ydelseNavn[15].equals("null")){
            contentStream.moveTextPositionByAmount(0, -18);
            contentStream.drawString(ydelseNavn[15]);
        }
        contentStream.endText();
        
        contentStream.beginText();
        contentStream.setFont(font, 10);
        contentStream.moveTextPositionByAmount(547, 532);
        for (int i = 0; i < 16; i++) {
            if (!ydelsePris[i].equals("null")){
                contentStream.moveTextPositionByAmount(0, -18);
                if (ydelsePris[i].length() >= 4){
                    float text_width = (font.getStringWidth(ydelsePris[i].substring(0, 1)+"."+ydelsePris[i].substring(1)+",00kr.")/1000.0f)*10;
                    contentStream.moveTextPositionByAmount(-text_width, 0);
                    contentStream.drawString(ydelsePris[i].substring(0, 1)+"."+ydelsePris[i].substring(1)+",00kr.");
                    contentStream.moveTextPositionByAmount(text_width, 0);
                }else{
                    float text_width = (font.getStringWidth(ydelsePris[i]+",00kr.")/1000.0f)*10;
                    contentStream.moveTextPositionByAmount(-text_width, 0);
                    contentStream.drawString(ydelsePris[i]+",00kr.");
                    contentStream.moveTextPositionByAmount(text_width, 0);
                }
            }   
        }
        contentStream.endText();
        
        if (moms != 0.0){
            String moms1 = moms+"";
            contentStream.beginText();
            contentStream.setFont(font, 10);
            contentStream.moveTextPositionByAmount(547, 205);
            if (moms1.endsWith(".5")){
                moms1 = moms1.substring(0, (moms1.length()-2))+".50";
            }
            if (moms1.endsWith(".0")){
                moms1 = moms1.substring(0, (moms1.length()-2))+".00";
            }
            switch(moms1.length()){
                case 5:
                    float text_width5 = (font.getStringWidth(moms1.substring(0, 2)+","+moms1.substring(3, 5)+"kr.")/1000.0f)*10;
                    contentStream.moveTextPositionByAmount(-text_width5, 0);
                    contentStream.drawString(moms1.substring(0, 2)+","+moms1.substring(3, 5)+"kr.");
                    contentStream.moveTextPositionByAmount(text_width5, 0);
                    break;
                case 6:
                    float text_width6 = (font.getStringWidth(moms1.substring(0, 3)+","+moms1.substring(4, 6)+"kr.")/1000.0f)*10;
                    contentStream.moveTextPositionByAmount(-text_width6, 0);
                    contentStream.drawString(moms1.substring(0, 3)+","+moms1.substring(4, 6)+"kr.");
                    contentStream.moveTextPositionByAmount(text_width6, 0);
                    break;
                case 7:
                    float text_width7 = (font.getStringWidth(moms1.substring(0, 1)+"."+moms1.substring(1, 4)+","+moms1.substring(5, 7)+"kr.")/1000.0f)*10;
                    contentStream.moveTextPositionByAmount(-text_width7, 0);
                    contentStream.drawString(moms1.substring(0, 1)+"."+moms1.substring(1, 4)+","+moms1.substring(5, 7)+"kr.");
                    contentStream.moveTextPositionByAmount(text_width7, 0);
                    break;
                case 8:
                    float text_width8 = (font.getStringWidth(moms1.substring(0, 2)+"."+moms1.substring(2, 5)+","+moms1.substring(6, 8)+"kr.")/1000.0f)*10;
                    contentStream.moveTextPositionByAmount(-text_width8, 0);
                    contentStream.drawString(moms1.substring(0, 2)+"."+moms1.substring(2, 5)+","+moms1.substring(6, 8)+"kr.");
                    contentStream.moveTextPositionByAmount(text_width8, 0);
                    break;
            }
            contentStream.endText();
        }
        if (total != 0.0){
            String total1 = total+"";
            contentStream.beginText();
            contentStream.setFont(font, 10);
            contentStream.moveTextPositionByAmount(547, 185);
            if (total1.endsWith(".5")){
                total1 = total1.substring(0, (total1.length()-2))+".50";
            }
            if (total1.endsWith(".0")){
                total1 = total1.substring(0, (total1.length()-2))+".00";
            }
            switch(total1.length()){
                case 5:
                    float text_width5 = (font.getStringWidth(total1.substring(0, 2)+",00kr.")/1000.0f)*10;
                    contentStream.moveTextPositionByAmount(-text_width5, 0);
                    contentStream.drawString(total1.substring(0, 2)+",00kr.");
                    contentStream.moveTextPositionByAmount(text_width5, 0);
                    break;
                case 6:
                    float text_width6 = (font.getStringWidth(total1.substring(0, 3)+","+total1.substring(4, 6)+"kr.")/1000.0f)*10;
                    contentStream.moveTextPositionByAmount(-text_width6, 0);
                    contentStream.drawString(total1.substring(0, 3)+","+total1.substring(4, 6)+"kr.");
                    contentStream.moveTextPositionByAmount(text_width6, 0);
                    break;
                case 7:
                    float text_width7 = (font.getStringWidth(total1.substring(0, 1)+"."+total1.substring(1, 4)+","+total1.substring(5, 7)+"kr.")/1000.0f)*10;
                    contentStream.moveTextPositionByAmount(-text_width7, 0);
                    contentStream.drawString(total1.substring(0, 1)+"."+total1.substring(1, 4)+","+total1.substring(5, 7)+"kr.");
                    contentStream.moveTextPositionByAmount(text_width7, 0);
                    break;
                case 8:
                    float text_width8 = (font.getStringWidth(total1.substring(0, 2)+"."+total1.substring(2, 5)+","+total1.substring(6, 8)+"kr.")/1000.0f)*10;
                    contentStream.moveTextPositionByAmount(-text_width8, 0);
                    contentStream.drawString(total1.substring(0, 2)+"."+total1.substring(2, 5)+","+total1.substring(6, 8)+"kr.");
                    contentStream.moveTextPositionByAmount(text_width8, 0);
                    break;
                case 9:
                    float text_width9 = (font.getStringWidth(total1.substring(0, 3)+"."+total1.substring(3, 6)+","+total1.substring(7, 9)+"kr.")/1000.0f)*10;
                    contentStream.moveTextPositionByAmount(-text_width9, 0);
                    contentStream.drawString(total1.substring(0, 3)+"."+total1.substring(3, 6)+","+total1.substring(7, 9)+"kr.");
                    contentStream.moveTextPositionByAmount(text_width9, 0);
                    break;
            }
            contentStream.endText();
        }
        
        contentStream.beginText();
        contentStream.setFont(font, 10);
        contentStream.moveTextPositionByAmount(45, 157);
        contentStream.drawString("Beløbet overføres til konto nr. 9819-4579835082, med navn og faktura nummer.");
        contentStream.moveTextPositionByAmount(0, -96);
        contentStream.drawString("Hvis der er spørgsmål til denne faktura, bedes De venligst kontakte Lilly, 26110343, lilly@sunshineyoga.dk");
        contentStream.endText();
                
        contentStream.close();
        PDDocument fakForm;
        if (moms != 0.0){
            fakForm = PDDocument.load("Faktura formular.pdf");
        }else{
            fakForm = PDDocument.load("Faktura formularudenmoms.pdf");
        }
        Overlay overlay = new Overlay();
        overlay.overlay(fakForm, faktura);
        faktura.save(localCopyPath+"/Faktura "+fakNummer+" "+kundeNavn+".pdf");
        faktura.save(serverCopyPath+"/Faktura "+fakNummer+" "+kundeNavn+".pdf");
        fakForm.close();
        faktura.close();
        return true;
    }
    public void setKundeNavn(String kundeNavn) {
        this.kundeNavn = kundeNavn;
    }

    public void setVejNavn(String vejNavn) {
        this.vejNavn = vejNavn;
    }

    public void setVejNr(int vejNr) {
        this.vejNr = vejNr;
    }

    public void setPostNummer(String postNummer) {
        this.postNummer = postNummer;
    }

    public void setBy(String by) {
        this.by = by;
    }

    public void setEmail(String email) {
        this.emailAdresse = email;
    }

    public void setTelefonNr(String telefonNr) {
        this.telefonNr = telefonNr;
    }

    public void setYdelseNavn(String ydelse, int i) {
        ydelseNavn[i] = ydelse;
    }

    public void setYdelsePris(String ydelse, int i) {
        ydelsePris[i] = ydelse;
    }

    public void setFakNummer(String fakNummer) {
        this.fakNummer = fakNummer;
    }

    public void setMoms(float moms) {
        this.moms = moms;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public void setLocalCopyPath(String localCopyPath) {
        this.localCopyPath = localCopyPath;
    }

    public void setServerCopyPath(String serverCopyPath) {
        this.serverCopyPath = serverCopyPath;
    }    
}
