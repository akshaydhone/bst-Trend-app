package com.mind.bst;

public class Deal {
    private String client;
    private String date;

    public Deal() {
    }

    public Deal(String client, String date) {
        this.client = client;
        this.date = date;
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

