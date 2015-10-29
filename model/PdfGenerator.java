package model;

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

/**
 *
 * @author Jakob Ferdinandsen
 */
public class PdfGenerator {
    private String kundeNavn;
    private String vejNavn;
    private String vejNr;
    private String postNummer;
    private String by;
    private String emailAdresse;
    private String telefonNr;
    private String[] ydelseNavn;
    private String[] ydelsePris;
    private String fakNummer;
    private float moms;
    private float total;

    public void PdfGenerator() {
        kundeNavn = "";
        vejNavn = "";
        by = "";
        emailAdresse = "";
        telefonNr = "";
        postNummer = "";
        ydelseNavn = new String[17];
        ydelsePris = new String[17];
    }

    /**
     * Denne metode bygger en pdf op fra variablerne i denne klasse, hvorefter den ligger den oven på en template kaldet "fakForm.pdf".
     * Den gemmer den nye pdf som faktura, med fakturanummer + kundeNavn som titel.
     * Bruger Apache PDFBox library.
     * @return
     * @throws IOException
     * @throws COSVisitorException
     */
    public boolean generatePDF() throws IOException, COSVisitorException {
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
        if (!vejNavn.isEmpty()) {
            if (vejNr.isEmpty()) {
                contentStream.moveTextPositionByAmount(0, -12);
                contentStream.drawString(vejNavn);
            } else {
                contentStream.moveTextPositionByAmount(0, -12);
                contentStream.drawString(vejNavn + " " + vejNr);
            }
        }
        if (!by.isEmpty() || !postNummer.isEmpty()) {
            if (postNummer.isEmpty()) {
                contentStream.moveTextPositionByAmount(0, -12);
                contentStream.drawString(by);
            } else {
                contentStream.moveTextPositionByAmount(0, -12);
                contentStream.drawString(postNummer + " " + by);
            }
        }
        if (!telefonNr.isEmpty()) {
            contentStream.moveTextPositionByAmount(0, -12);
            contentStream.drawString(telefonNr + "");
        }
        contentStream.moveTextPositionByAmount(0, -12);
        contentStream.drawString(emailAdresse);
        contentStream.endText();

        contentStream.beginText();
        contentStream.setFont(font, 10);
        contentStream.moveTextPositionByAmount(547, 588);
        float textwidth = (font.getStringWidth(date.format(new Date())) / 1000.0f) * 10;
        contentStream.moveTextPositionByAmount(-textwidth, 0);
        contentStream.drawString(date.format(new Date()));
        contentStream.moveTextPositionByAmount(textwidth, 0);
        contentStream.moveTextPositionByAmount(0, -12);
        String fakNumString = fakNummer + "";
        textwidth = (font.getStringWidth(fakNumString) / 1000.0f) * 10;
        contentStream.moveTextPositionByAmount(-textwidth, 0);
        contentStream.drawString(fakNummer + "");
        contentStream.moveTextPositionByAmount(textwidth, 0);
        contentStream.endText();

        contentStream.beginText();
        contentStream.setFont(font, 10);
        contentStream.moveTextPositionByAmount(47, 532);
        for (int i = 0; i < ydelseNavn.length; i++) {
            if (ydelseNavn[i] != null) {
                contentStream.moveTextPositionByAmount(0, -18);
                contentStream.drawString(ydelseNavn[i]);
            }

        }
        contentStream.endText();

        contentStream.beginText();
        contentStream.setFont(font, 10);
        contentStream.moveTextPositionByAmount(547, 532);
        for (int i = 0; i < ydelsePris.length; i++) {
            if (ydelsePris[i] != null) {
                contentStream.moveTextPositionByAmount(0, -18);
                float text_width6 = (font.getStringWidth(ydelsePris[i].substring(0, 3) + "," + ydelsePris[i].substring(4, 6) + "kr.") / 1000.0f) * 10;
                contentStream.moveTextPositionByAmount(-text_width6, 0);
                contentStream.drawString(ydelsePris[i].substring(0, 3) + "," + ydelsePris[i].substring(4, 6) + "kr.");
                contentStream.moveTextPositionByAmount(text_width6, 0);
            }
        }
        contentStream.endText();

        if (moms != 0.0) {
            String moms1 = moms + "";
            if (moms >= 1000 && moms1.length() == 6) {
                moms1 = moms1 + "0";
            }
            if (moms >= 100 && moms1.length() == 5) {
                moms1 = moms1 + "0";
            }
            if (moms >= 10 && moms1.length() == 4) {
                moms1 = moms1 + "0";
            }
            contentStream.beginText();
            contentStream.setFont(font, 10);
            contentStream.moveTextPositionByAmount(547, 205);
            switch (moms1.length()) {
                case 5:
                    float text_width5 = (font.getStringWidth(moms1.substring(0, 2) + "," + moms1.substring(3, 5) + "kr.") / 1000.0f) * 10;
                    contentStream.moveTextPositionByAmount(-text_width5, 0);
                    contentStream.drawString(moms1.substring(0, 2) + "," + moms1.substring(3, 5) + "kr.");
                    contentStream.moveTextPositionByAmount(text_width5, 0);
                    break;
                case 6:
                    float text_width6 = (font.getStringWidth(moms1.substring(0, 3) + "," + moms1.substring(4, 6) + "kr.") / 1000.0f) * 10;
                    contentStream.moveTextPositionByAmount(-text_width6, 0);
                    contentStream.drawString(moms1.substring(0, 3) + "," + moms1.substring(4, 6) + "kr.");
                    contentStream.moveTextPositionByAmount(text_width6, 0);
                    break;
                case 7:
                    float text_width7 = (font.getStringWidth(moms1.substring(0, 1) + "." + moms1.substring(1, 4) + "," + moms1.substring(5, 7) + "kr.") / 1000.0f) * 10;
                    contentStream.moveTextPositionByAmount(-text_width7, 0);
                    contentStream.drawString(moms1.substring(0, 1) + "." + moms1.substring(1, 4) + "," + moms1.substring(5, 7) + "kr.");
                    contentStream.moveTextPositionByAmount(text_width7, 0);
                    break;
                case 8:
                    float text_width8 = (font.getStringWidth(moms1.substring(0, 2) + "." + moms1.substring(2, 5) + "," + moms1.substring(6, 8) + "kr.") / 1000.0f) * 10;
                    contentStream.moveTextPositionByAmount(-text_width8, 0);
                    contentStream.drawString(moms1.substring(0, 2) + "." + moms1.substring(2, 5) + "," + moms1.substring(6, 8) + "kr.");
                    contentStream.moveTextPositionByAmount(text_width8, 0);
                    break;
            }
            contentStream.endText();
        }
        if (total != 0.0) {
            String total1 = total + "";
            if (total >= 10000 && total1.length() == 7) {
                total1 = total1 + "0";
            }
            if (total >= 1000 && total1.length() == 6) {
                total1 = total1 + "0";
            }
            if (total >= 100 && total1.length() == 5) {
                total1 = total1 + "0";
            }
            if (total >= 10 && total1.length() == 4) {
                total1 = total1 + "0";
            }
            contentStream.beginText();
            contentStream.setFont(font, 10);
            contentStream.moveTextPositionByAmount(547, 185);
            switch (total1.length()) {
                case 6:
                    float text_width6 = (font.getStringWidth(total1.substring(0, 3) + "," + total1.substring(4, 6) + "kr.") / 1000.0f) * 10;
                    contentStream.moveTextPositionByAmount(-text_width6, 0);
                    contentStream.drawString(total1.substring(0, 3) + "," + total1.substring(4, 6) + "kr.");
                    contentStream.moveTextPositionByAmount(text_width6, 0);
                    break;
                case 7:
                    float text_width7 = (font.getStringWidth(total1.substring(0, 1) + "." + total1.substring(1, 4) + "," + total1.substring(5, 7) + "kr.") / 1000.0f) * 10;
                    contentStream.moveTextPositionByAmount(-text_width7, 0);
                    contentStream.drawString(total1.substring(0, 1) + "." + total1.substring(1, 4) + "," + total1.substring(5, 7) + "kr.");
                    contentStream.moveTextPositionByAmount(text_width7, 0);
                    break;
                case 8:
                    float text_width8 = (font.getStringWidth(total1.substring(0, 2) + "." + total1.substring(2, 5) + "," + total1.substring(6, 8) + "kr.") / 1000.0f) * 10;
                    contentStream.moveTextPositionByAmount(-text_width8, 0);
                    contentStream.drawString(total1.substring(0, 2) + "." + total1.substring(2, 5) + "," + total1.substring(6, 8) + "kr.");
                    contentStream.moveTextPositionByAmount(text_width8, 0);
                    break;
                case 9:
                    float text_width9 = (font.getStringWidth(total1.substring(0, 3) + "." + total1.substring(3, 6) + "," + total1.substring(7, 9) + "kr.") / 1000.0f) * 10;
                    contentStream.moveTextPositionByAmount(-text_width9, 0);
                    contentStream.drawString(total1.substring(0, 3) + "." + total1.substring(3, 6) + "," + total1.substring(7, 9) + "kr.");
                    contentStream.moveTextPositionByAmount(text_width9, 0);
                    break;
            }
            contentStream.endText();
        }

        contentStream.beginText();
        contentStream.setFont(font, 10);
        contentStream.moveTextPositionByAmount(45, 157);
        contentStream.drawString("");
        contentStream.moveTextPositionByAmount(0, -96);
        contentStream.drawString("");
        contentStream.endText();

        contentStream.close();
        PDDocument fakForm;
        fakForm = PDDocument.load("fakForm.pdf");
        Overlay overlay = new Overlay();
        overlay.overlay(fakForm, faktura);
        faktura.save("Faktura " + fakNummer + " " + kundeNavn + ".pdf");
        fakForm.close();
        faktura.close();
        return true;
    }
//------------------------------------------------------------------------------    
//    Mutators
//------------------------------------------------------------------------------
    public void setKundeNavn(String kundeNavn) {
        this.kundeNavn = kundeNavn;
    }

    public void setVejNavn(String vejNavn) {
        this.vejNavn = vejNavn;
    }

    public void setVejNr(String vejNr) {
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
}
