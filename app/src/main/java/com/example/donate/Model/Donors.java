package com.example.donate.Model;

public class Donors {
    private String eevent;
    private String aaditional;
    private String Eemail;
    private String Addresses;
    public Donors(String eevent, String aaditional, String Eemail, String Addresses) {
        this.eevent = eevent;
        this.aaditional = aaditional;
        this.Eemail = Eemail;
        this.Addresses = Addresses;
    }

    public String getEevent() {
        return eevent;
    }

    public void setEevent(String eevent) {
        this.eevent = eevent;
    }

    public String getAaditional() {
        return aaditional;
    }

    public void setAaditional(String aaditional) {
        this.aaditional = aaditional;
    }

    public String getEemail() {
        return Eemail;
    }

    public void setEemail(String eemail) {
        Eemail = eemail;
    }

    public String getAddresses() {
        return Addresses;
    }

    public void setAddresses(String addresses) {
        Addresses = addresses;
    }
}
