package miniprojekt2015;

/**
 *
 * @author Morten Ricki Rasmussen 
 */
public class Customer {
    private String name;
    private String street;
    private String city;
    private String telephoneNum;
    private String eMail;
    private int zipCode;
    
    public Customer(String name, String street, String city, String telephoneNum, String eMail, int zipCode) {
        this.name = name;
        this.street = street;
        this.city = city;
        this.telephoneNum = telephoneNum;
        this.eMail = eMail;
        this.zipCode = zipCode;        
    }
    
    //--------------------------------------------------------------------------
    // Accessors
    //--------------------------------------------------------------------------
    
    public String getName() {
        return name;
    }
    
    public String getStreet() {
        return street;
    }
    
    public String getCity() {
        return city;
    }
    
    public String getTelephoneNum() {
        return telephoneNum;
    }
    
    public String getEMail() {
        return eMail;
    }
    
    public int getZipCode() {
        return zipCode;
    }

    //--------------------------------------------------------------------------
    // Mutators
    //--------------------------------------------------------------------------
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setStreet(String street) {
        this.street = street;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    public void setTelephoneNum(String telephoneNum) {
        this.telephoneNum = telephoneNum;
    }
    
    public void setEMail(String eMail) {
        this.eMail = eMail;
    }
    
    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }
    
    //--------------------------------------------------------------------------
    // toString
    //--------------------------------------------------------------------------
    
    @Override
    public String toString() {
        String customerInfo;
        
        customerInfo = "Name: " + name;
        customerInfo = customerInfo + "\nCity: " + city;
        customerInfo = customerInfo + "\nZipcode: " + zipCode;
        customerInfo = customerInfo + "\nStreet: " + street;
        customerInfo = customerInfo + "\nTelephone Number: " + telephoneNum;
        customerInfo = customerInfo + "\nE-Mail: " + eMail;
        
        return customerInfo;
    }
    
}
