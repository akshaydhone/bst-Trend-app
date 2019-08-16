package com.mind.bst.Model;

public class Clients {


    private  String PartyName,EmailID,Address,City,Country,GSTINNo,PersonName,State;




    public Clients() {
    }

    public Clients(String partyName,String emailID,String address,String city,String country,String gstinno,String personName,String state) {
        PartyName = partyName;
        EmailID=emailID;
        Address=address;
        City=city;
        Country=country;
        GSTINNo=gstinno;
        PersonName=personName;
        State=state;


    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getPersonName() {
        return PersonName;
    }

    public void setPersonName(String personName) {
        PersonName = personName;
    }

    public String getGSTINNo() {
        return GSTINNo;
    }

    public void setGSTINNo(String GSTINNo) {
        this.GSTINNo = GSTINNo;
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
