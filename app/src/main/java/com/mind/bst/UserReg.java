package com.mind.bst;

public class UserReg {


    private  String Address,Contact,Email,Image_Url,Name,Region;

    public UserReg() {
    }

    public UserReg(String address, String contact, String email, String image_Url, String name, String region) {
        Address = address;
        Contact = contact;
        Email = email;
        Image_Url = image_Url;
        Name = name;
        Region = region;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getImage_Url() {
        return Image_Url;
    }

    public void setImage_Url(String image_Url) {
        Image_Url = image_Url;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String region) {
        Region = region;
    }
}
