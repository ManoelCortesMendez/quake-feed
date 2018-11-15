package com.example.android.quakereport;

public class Earthquake {

    // Define member variables
    private double magnitude;
    private String location;
    private long time;
    private String url;

    // Define constructor
    public Earthquake(double magnitude, String location, long time, String url) {
        this.magnitude = magnitude;
        this.location = location;
        this.time = time;
        this.url = url;
    }

    // Define methods
    public double getMagnitude() { return magnitude; }
    public String getLocation() { return location; }
    public long getTime() { return time; }
    public String getURL() { return url; }
}
