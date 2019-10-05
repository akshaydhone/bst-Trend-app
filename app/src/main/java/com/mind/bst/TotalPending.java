package com.mind.bst;

public class TotalPending {

    String name_of_service_engineer;
    String region_of_service_engineer;
    String customer_name;
    String customer_rep_name;
    String cust_email_id;
    String cust_address;
    String cust_city;
    String cust_state;
    String cust_country;





    public TotalPending() {

    }

    public String getName_of_service_engineer() {
        return name_of_service_engineer;
    }

    public void setName_of_service_engineer(String name_of_service_engineer) {
        this.name_of_service_engineer = name_of_service_engineer;
    }

    public String getRegion_of_service_engineer() {
        return region_of_service_engineer;
    }

    public void setRegion_of_service_engineer(String region_of_service_engineer) {
        this.region_of_service_engineer = region_of_service_engineer;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_rep_name() {
        return customer_rep_name;
    }

    public void setCustomer_rep_name(String customer_rep_name) {
        this.customer_rep_name = customer_rep_name;
    }

    public String getCust_email_id() {
        return cust_email_id;
    }

    public void setCust_email_id(String cust_email_id) {
        this.cust_email_id = cust_email_id;
    }

    public String getCust_address() {
        return cust_address;
    }

    public void setCust_address(String cust_address) {
        this.cust_address = cust_address;
    }

    public String getCust_city() {
        return cust_city;
    }

    public void setCust_city(String cust_city) {
        this.cust_city = cust_city;
    }

    public String getCust_state() {
        return cust_state;
    }

    public void setCust_state(String cust_state) {
        this.cust_state = cust_state;
    }

    public String getCust_country() {
        return cust_country;
    }

    public void setCust_country(String cust_country) {
        this.cust_country = cust_country;
    }


    public TotalPending(String data,String name_of_service_engineer, String region_of_service_engineer, String customer_name, String customer_rep_name, String cust_email_id, String cust_address, String cust_city, String cust_state, String cust_country) {
        this.name_of_service_engineer = name_of_service_engineer;
        this.region_of_service_engineer = region_of_service_engineer;
        this.customer_name = customer_name;
        this.customer_rep_name = customer_rep_name;
        this.cust_email_id = cust_email_id;
        this.cust_address = cust_address;
        this.cust_city = cust_city;
        this.cust_state = cust_state;
        this.cust_country = cust_country;
    }
}




