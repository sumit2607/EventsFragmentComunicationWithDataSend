package com.example.eventsinFraments;

import java.io.Serializable;

public class Model implements Serializable {

    private String tittle, description, startdate, enddate, starttime, endtime,Currency,Price;

    public Model(String tittle, String description, String startdate, String enddate, String starttime, String endtime, String currency, String price) {
        this.tittle = tittle;
        this.description = description;
        this.startdate = startdate;
        this.enddate = enddate;
        this.starttime = starttime;
        this.endtime = endtime;
        Currency = currency;
        Price = price;
    }

    public String getTittle() {
        return tittle;
    }

    public String getDescription() {
        return description;
    }

    public String getStartdate() {
        return startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public String getStarttime() {
        return starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public String getCurrency() {
        return Currency;
    }

    public String getPrice() {
        return Price;
    }
}
