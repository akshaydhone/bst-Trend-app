package com.mind.bst;

public class Data {





   //String data;
    String region;
    String name;
    String address;
    String contact;
    String email;

    public Data (){

    }

   /*public String getData() {
        return data;
    }*/

    public String getRegion() {
        return region;
    }



    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }

    public String getContact() {
        return contact;
    }

    public String getEmail() {
        return email;
    }


    public Data(String data, String region,String name,String address, String contact,String email) {
        //this.data = data;

        this.name = name;
        this.region = region;
        this.address = address;
        this.contact = contact;
        this.email = email;
    }
}
