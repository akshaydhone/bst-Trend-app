package com.mind.bst;

public class Total {





    //String data;
    //String city;
    //String name;
    String city;
    String engineer;
    String client;
    String client_add;
   // String client_cont;
    //String client_email;
    String date;
    String time;
    String product_serial_no;
    String nature_of_complaint;
    String details_of_complaint;
    String engineer_observation;
    String client_remark;
    String product_name;
    String status_of_complaint;
    String payment_via;
 String client_image_url;
 String cust_name;
 String cust_cont;
 String cust_email;

 //private String Image;

 //ImageView client_image;


    // String email;




    public Total (){

    }

   /*public String getData() {
        return data;
    }*/

    public String getCity() {
        return city;
    }

    public String getCust_name() {
        return cust_name;
    }

    public void setCust_name(String cust_name) {
        this.cust_name = cust_name;
    }

    public String getCust_cont() {
        return cust_cont;
    }

    public void setCust_cont(String cust_cont) {
        this.cust_cont = cust_cont;
    }

    public String getCust_email() {
        return cust_email;
    }

    public void setCust_email(String cust_email) {
        this.cust_email = cust_email;
    }

    public String getEngineer() {
        return engineer;
    }
//public  ImageView getClient_image(){return client_image;}



    public String getClient() {
        return client;
    }


    public String getClient_add() {
        return client_add;
    }




    public String getDate() {
        return date;
    }


    public String getTime() {
        return time;
    }


    public String getProduct_serial_no() {
        return product_serial_no;
    }

    public String getNature_of_complaint() {
        return nature_of_complaint;
    }

    public String getDetails_of_complaint() {
        return details_of_complaint;
    }

    public String getEngineer_observation() {
        return engineer_observation;
    }

    public String getClient_remark() {
        return client_remark;
    }

    public String getProduct_name() {
        return product_name;
    }
    public String getStatus_of_complaint() {
        return status_of_complaint;
    }
    public String getPayment_via() {
        return payment_via;
    }

    public  String getClient_image_url() {
        return client_image_url;
    }




    public Total(String data, String city,String engineer,String client,String client_add,String date,String time,String product_serial_no,String nature_of_complaint,String details_of_complaint,String engineer_observation,String client_remark,String product_name,String status_of_complaint,String payment_via,String client_image_url,String cust_name,String cust_cont,String cust_email) {
        //this.data = data;

        this.city = city;
        this.engineer=engineer;
        this.client = client;
        this.client_add=client_add;

        this.date=date;
        this.time=time;
        this.product_serial_no=product_serial_no;
        this.nature_of_complaint=nature_of_complaint;
        this.details_of_complaint=details_of_complaint;
        this.engineer_observation=engineer_observation;
        this.client_remark=client_remark;
       this.product_name=product_name;
       this.status_of_complaint=status_of_complaint;
       this.payment_via=payment_via;
       this.client_image_url=client_image_url;
       this.cust_name=cust_name;
       this.cust_cont=cust_cont;
       this.cust_email=cust_email;
   // Image=Iamge;
   // this.client_image=client_image;

    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setEngineer(String engineer) {
        this.engineer = engineer;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public void setClient_add(String client_add) {
        this.client_add = client_add;
    }


    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setProduct_serial_no(String product_serial_no) {
        this.product_serial_no = product_serial_no;
    }

    public void setNature_of_complaint(String nature_of_complaint) {
        this.nature_of_complaint = nature_of_complaint;
    }

    public void setDetails_of_complaint(String details_of_complaint) {
        this.details_of_complaint = details_of_complaint;
    }

    public void setEngineer_observation(String engineer_observation) {
        this.engineer_observation = engineer_observation;
    }

    public void setClient_remark(String client_remark) {
        this.client_remark = client_remark;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public void setStatus_of_complaint(String status_of_complaint) {
        this.status_of_complaint = status_of_complaint;
    }

    public void setPayment_via(String payment_via) {
        this.payment_via = payment_via;
    }

    public void setClient_image_url(String client_image_url) {
        this.client_image_url = client_image_url;
    }
/* public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }*/
}
