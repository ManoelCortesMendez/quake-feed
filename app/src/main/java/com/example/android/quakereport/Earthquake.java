package com.example.android.quakereport;

public class Earthquake {

    // Define member variables
    private double magnitude;
    private String location;
    private String date;

    // Define constructor
    public Earthquake(double magnitude, String location, String date) {
        this.magnitude = magnitude;
        this.location = location;
        this.date = date;
    }

    // Define methods
    public double getMagnitude() { return magnitude; }
    public String getLocation() { return location; }
    public String getDate() { return date; }
}
