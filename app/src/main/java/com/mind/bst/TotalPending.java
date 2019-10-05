package com.mind.bst;

public class TotalPending {

    //String data;
    //String city;
    //String name;
    String name_of_service_engineer;
    String region_of_service_engineer;
    String customer_rep_name;
    String customer_Email_Id;
    // String client_cont;
    //String client_email;
    String call_log_date;

    String city_of_service;
    // String time;
    String product_serial_no;
    //String gstin;
    String product_category;
    String engineer_observation;
    String client_remark;
    // String product_name;
    //String status_of_complaint;
    //String payment_via;
    String nature_of_comp;
    String details_of_comp;
    String cust_cont;
    String customer_name;
    String customer_address;

    String customer_city;

    String customer_state;

    String customer_country;
    String product_description;


    String call_assigned_to;

    //String call_visiting_date;

    String product_name;

    String engineer_in_time;

    String call_attending_date;


    String call_assigned_by;

    String call_rescheduled_date;

    String invoice_no;

    String status_of_complaint;




    //private String Image;

    //ImageView client_image;


    // String email;




    public TotalPending (){

    }



    public String getStatus_of_complaint() {
        return status_of_complaint;
    }

    public void setStatus_of_complaint(String status_of_complaint) {
        this.status_of_complaint = status_of_complaint;
    }

    public String getCall_attending_date() {
        return call_attending_date;
    }

    public String getInvoice_no() {
        return invoice_no;
    }

    public void setInvoice_no(String invoice_no) {
        this.invoice_no = invoice_no;
    }

    public String getCall_rescheduled_date() {
        return call_rescheduled_date;
    }

    public void setCall_rescheduled_date(String call_rescheduled_date) {
        this.call_rescheduled_date = call_rescheduled_date;
    }

    public String getCall_assigned_by() {
        return call_assigned_by;
    }

    public void setCall_assigned_by(String call_assigned_by) {
        this.call_assigned_by = call_assigned_by;
    }

    public void setCall_attending_date(String call_attending_date) {
        this.call_attending_date = call_attending_date;
    }

    public String getEngineer_in_time() {
        return engineer_in_time;
    }

    public void setEngineer_in_time(String engineer_in_time) {
        this.engineer_in_time = engineer_in_time;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }


    public String getCall_assigned_to() {
        return call_assigned_to;
    }

    public void setCall_assigned_to(String call_assigned_to) {
        this.call_assigned_to = call_assigned_to;
    }

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    public String getCustomer_state() {
        return customer_state;
    }

    public void setCustomer_state(String customer_state) {
        this.customer_state = customer_state;
    }

    public String getCustomer_country() {
        return customer_country;
    }

    public void setCustomer_country(String customer_country) {
        this.customer_country = customer_country;
    }

    public String getCustomer_city() {
        return customer_city;
    }

    public void setCustomer_city(String customer_city) {
        this.customer_city = customer_city;
    }
/*public String getData() {
        return data;
    }*/

    public String getCity_of_service() {
        return city_of_service;
    }

    public void setCity_of_service(String city_of_service) {
        this.city_of_service = city_of_service;
    }



    public String getProduct_category() {
        return product_category;
    }

    public void setProduct_category(String product_category) {
        this.product_category = product_category;
    }

    public String getCustomer_address() {
        return customer_address;
    }

    public void setCustomer_address(String customer_address) {
        this.customer_address = customer_address;
    }

    public String getName_of_service_engineer() {
        return name_of_service_engineer;
    }

    public String getDetails_of_comp() {
        return details_of_comp;
    }

    public void setDetails_of_comp(String details_of_comp) {
        this.details_of_comp = details_of_comp;
    }

    public String getCust_cont() {
        return cust_cont;
    }

    public void setCust_cont(String cust_cont) {
        this.cust_cont = cust_cont;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getRegion_of_service_engineer() {
        return region_of_service_engineer;
    }
//public  ImageView getClient_image(){return client_image;}



    public String getCustomer_rep_name() {
        return customer_rep_name;
    }


    public String getCustomer_Email_Id() {
        return customer_Email_Id;
    }




    public String getCall_log_date() {
        return call_log_date;
    }





    public String getProduct_serial_no() {
        return product_serial_no;
    }



    public String getEngineer_observation() {
        return engineer_observation;
    }

    public String getClient_remark() {
        return client_remark;
    }





    public  String getNature_of_comp() {
        return nature_of_comp;
    }




    public TotalPending(String data, String name_of_service_engineer,String region_of_service_engineer,String customer_rep_name,String customer_Email_Id,String call_log_date,String product_serial_no,String engineer_observation,String client_remark,String nature_of_comp,String details_of_comp,String cust_cont,String customer_name,String customer_address,String product_category,String city_of_service,String customer_city,String customer_state,String customer_country,String product_description,String call_assigned_to,String product_name,String engineer_in_time,String call_attending_date,String call_assigned_by,String call_rescheduled_date,String invoice_no,String status_of_complaint ) {
        //this.data = data;

        this.name_of_service_engineer = name_of_service_engineer;
        this.region_of_service_engineer=region_of_service_engineer;
        this.customer_rep_name = customer_rep_name;
        this.customer_Email_Id=customer_Email_Id;

        this.call_log_date=call_log_date;

        this.product_serial_no=product_serial_no;

        this.engineer_observation=engineer_observation;
        this.client_remark=client_remark;
        //this.product_name=product_name;

        //this.payment_via=payment_via;
        this.nature_of_comp=nature_of_comp;
        this.details_of_comp=details_of_comp;
        this.cust_cont=cust_cont;
        this.customer_name=customer_name;
        this.customer_address=customer_address;

        this.product_category=product_category;
        this.city_of_service=city_of_service;
        this.customer_city=customer_city;
        this.customer_state=customer_state;
        this.customer_country=customer_country;
        this.product_description=product_description;
        this.call_assigned_to=call_assigned_to;


        this.product_name=product_name;
        this.engineer_in_time=engineer_in_time;
        this.call_attending_date=call_attending_date;
        this.call_assigned_by=call_assigned_by;
        this.call_rescheduled_date=call_rescheduled_date;
        this.invoice_no=invoice_no;
        this.status_of_complaint=status_of_complaint;

        // Image=Iamge;
        // this.client_image=client_image;

    }

    public void setName_of_service_engineer(String name_of_service_engineer) {
        this.name_of_service_engineer = name_of_service_engineer;
    }

    public void setRegion_of_service_engineer(String region_of_service_engineer) {
        this.region_of_service_engineer = region_of_service_engineer;
    }

    public void setCustomer_rep_name(String customer_rep_name) {
        this.customer_rep_name = customer_rep_name;
    }

    public void setCustomer_Email_Id(String customer_Email_Id) {
        this.customer_Email_Id = customer_Email_Id;
    }


    public void setCall_log_date(String call_log_date) {
        this.call_log_date = call_log_date;
    }



    public void setProduct_serial_no(String product_serial_no) {
        this.product_serial_no = product_serial_no;
    }


    public void setEngineer_observation(String engineer_observation) {
        this.engineer_observation = engineer_observation;
    }

    public void setClient_remark(String client_remark) {
        this.client_remark = client_remark;
    }







    public void setNature_of_comp(String nature_of_comp) {
        this.nature_of_comp = nature_of_comp;
    }
/* public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }*/
}
