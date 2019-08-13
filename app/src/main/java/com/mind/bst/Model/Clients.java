package com.mind.bst.Model;

public class Clients {


    private  String PartyName,EmailID,Address,City,Country;




    public Clients() {
    }

    public Clients(String partyName,String emailID,String address,String city,String country) {
        PartyName = partyName;
        EmailID=emailID;
        Address=address;
        City=city;
        Country=country;


    }


    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPartyName() {
        return PartyName;
    }

    public void setPartyName(String partyName) {
        PartyName = partyName;
    }

    public String getEmailID() {
        return EmailID;
    }

    public void setEmailID(String emailID) {
        EmailID = emailID;
    }
}
