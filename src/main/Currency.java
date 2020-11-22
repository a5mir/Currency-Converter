package main;

import java.util.ArrayList;

public class Currency {
    final String url = "https://www.ecb.europa.eu/stats/policy_and_exchange_rates/euro_reference_exchange_rates/html/index.en.html";
    private String name;
    private double spot;
    private String image;
    private ArrayList<Currency> list;

    public Currency() {
    }

    public Currency(String name, double spot, String image) {
        this.name = name;
        this.spot = spot;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSpot() {
        return spot;
    }

    public void setSpot(double spot) {
        this.spot = spot;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ArrayList<Currency> getList() {
        return list;
    }

    public void setList(ArrayList<Currency> list) {
        this.list = list;
    }
}
