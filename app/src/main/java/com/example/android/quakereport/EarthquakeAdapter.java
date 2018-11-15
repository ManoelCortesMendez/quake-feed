package com.example.android.quakereport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class EarthquakeAdapter extends ArrayAdapter {

    // Define member variables
    private String LOCATION_SEPARATOR = " of ";

    // Define constructor
    public EarthquakeAdapter(Context context, ArrayList<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    // Define methods
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Recycle or inflate view
        View earthquakeItemView = convertView;
        if (earthquakeItemView == null) {
            earthquakeItemView = LayoutInflater.from(getContext()).inflate(R.layout.earthquake_item, parent, false);
        }

        // Get current earthquake object
        Earthquake currentEarthquake = (Earthquake) getItem(position);

        // Set magnitude
        TextView magnitudeTextView = earthquakeItemView.findViewById(R.id.magnitude_text_view);
        magnitudeTextView.setText(formatMagnitude(currentEarthquake.getMagnitude()));

        // Set location offset and primary
        String[] locationParts = formatLocation(currentEarthquake.getLocation());

        // Set location offset
        TextView locationOffsetTextView = earthquakeItemView.findViewById(R.id.location_offset_text_view);
        locationOffsetTextView.setText(locationParts[0]);

        // Set location primary
        TextView locationPrimaryTextView = earthquakeItemView.findViewById(R.id.location_primary_text_view);
        locationPrimaryTextView.setText(locationParts[1]);

        // Set date and time
        long earthquakeTimeInMilliseconds = currentEarthquake.getTime();
        Date earthquakeDateObject = new Date(earthquakeTimeInMilliseconds);

        // Set date
        String earthquakeDateToDisplay = formatDate(earthquakeDateObject);
        TextView dateTextView = earthquakeItemView.findViewById(R.id.date_text_view);
        dateTextView.setText(earthquakeDateToDisplay);

        // Set time
        String earthquakeTimeToDisplay = formatTime(earthquakeDateObject);
        TextView timeTextView = earthquakeItemView.findViewById(R.id.time_text_view);
        timeTextView.setText(earthquakeTimeToDisplay);

        return earthquakeItemView;
    }

    // Define helper methods
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM DD, yyyy");
        return dateFormatter.format(dateObject);
    }

    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormatter = new SimpleDateFormat("h:mm a");
        return timeFormatter.format(dateObject);
    }

    private String[] formatLocation(String location) {
        String locationOffset;
        String locationPrimary;

        if (location.contains(LOCATION_SEPARATOR)) {
            String [] parts = location.split(LOCATION_SEPARATOR);
            locationOffset = parts[0] + LOCATION_SEPARATOR;
            locationPrimary = parts[1];
        } else {
            locationOffset = "Near";
            locationPrimary = location;
        }

        String [] locationDescription = {locationOffset, locationPrimary};

        return locationDescription;
    }

    private String formatMagnitude(double magnitude) {
        DecimalFormat magnitudeFormatter = new DecimalFormat("0.0");
        return magnitudeFormatter.format(magnitude);
    }
}
