package com.mind.bst;

public class Deal {
    private String client;
    private String date;
    private String client_image_url;

    public Deal() {
    }

    public Deal(String client, String date,String client_image_url) {
        this.client = client;
        this.date = date;
        this.client_image_url=client_image_url;
    }

    public String getClient_image_url() {
        return client_image_url;
    }

    public void setClient_image_url(String client_image_url)
    { this.client_image_url = client_image_url;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

