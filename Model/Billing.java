package Model;

/**
 *
 * @author Morten Ricki Rasmussen 
 */
public class Billing {
    private long cardNumber;
    private byte month;
    private byte year;
    private String cardType;
    private short ccv;
    
    public Billing() {
        
    }
    
    public Billing(long cardNumber, byte month, byte year, String cardType, short ccv) {
        this.cardNumber = cardNumber;
        this.month = month;
        this.year = year;
        this.cardType = cardType;
        this.ccv = ccv;
    }
    //--------------------------------------------------------------------------
    // Accessors
    //--------------------------------------------------------------------------
    
    public long getCardNumber() {
        return cardNumber;
    }
    
    public byte getMonth() {
        return month;
    }
    
    public byte getYear() {
        return year;
    }
    
    public String getCardType() {
        return cardType;
    }
    
    public short getCCV() {
        return ccv;
    }
    
    //--------------------------------------------------------------------------
    // Mutators
    //--------------------------------------------------------------------------
    
    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }
    
    public void setMonth(byte month) {
        this.month = month;
    }
    
    public void setYear(byte year) {
        this.year = year;
    }
    
    public void setCardType(String cardType) {
        this.cardType = cardType;
    }
    
    public void setCCV(short ccv) {
        this.ccv = ccv;
    }
    
    //--------------------------------------------------------------------------
    // Metode til kun at vise de sidste fire cifre af kortnummeret
    //--------------------------------------------------------------------------
    public int lastFourDigits() {
        int lastDigits;
        
        lastDigits = (int) (cardNumber % 10000);
                
        return lastDigits;
    }
    
    //--------------------------------------------------------------------------
    //  betalingsoplysninger til brugeren
    //--------------------------------------------------------------------------
    
    public String getBillinInfoReciept() {
        String billingInfo;
        billingInfo = "Cardtype: " + cardType;
        billingInfo = billingInfo + "\nCardNumber: XXXX-XXXX-XXXX-" + lastFourDigits();
        
        return billingInfo;
    }
    
    //--------------------------------------------------------------------------
    // Tilføjer et produkt til Admin
    //--------------------------------------------------------------------------
    
    public String getBillingInfoBackEnd() {
        String billingInfo;
        billingInfo = "Cardtype: " + cardType;
        billingInfo = billingInfo + "\nCardNumber: " + cardNumber;
        billingInfo = billingInfo + "\nExpires: " + month + " " + year;
        billingInfo = billingInfo + "\nCCV: " + ccv;
        
        return billingInfo;
    }
    
}
