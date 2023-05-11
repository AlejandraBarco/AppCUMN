package com.example.proyect.Model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Data {

    private String date; // Para "date"

    private String hour; // Para "hour"

    @SerializedName("is-cheap")
    private boolean isCheap; // Para "is-cheap"
    @SerializedName("is-under-avg")
    private boolean isUnderAvg; // Para "is-under-avg"

    private String market; // Para "market"

    private double price; // Para "price"

    private String units; // Para "units"


    public String getDate() {
        return date;
    }

    public String getHour() {
        return hour;
    }

    public boolean isCheap() {
        return isCheap;
    }

    public boolean isUnderAvg() {
        return isUnderAvg;
    }

    public String getMarket() {
        return market;
    }

    public double getPrice() {
        return price;
    }

    public String getUnits() {
        return units;
    }
}
