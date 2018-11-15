package com.example.android.quakereport;

public class Earthquake {

    // Define member variables
    private double magnitude;
    private String location;
    private long time;

    // Define constructor
    public Earthquake(double magnitude, String location, long time) {
        this.magnitude = magnitude;
        this.location = location;
        this.time = time;
    }

    // Define methods
    public double getMagnitude() { return magnitude; }
    public String getLocation() { return location; }
    public long getTime() { return time; }
}
