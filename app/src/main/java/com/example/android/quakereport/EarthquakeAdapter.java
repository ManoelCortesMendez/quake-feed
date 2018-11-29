package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.util.Log;
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
        final Earthquake currentEarthquake = (Earthquake) getItem(position);

        // Set magnitude
        TextView magnitudeTextView = earthquakeItemView.findViewById(R.id.magnitude_text_view);
        magnitudeTextView.setText(formatMagnitude(currentEarthquake.getMagnitude()));

        // Set magnitude color
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeTextView.getBackground();
        magnitudeCircle.setColor(getMagnitudeColor(currentEarthquake.getMagnitude()));

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
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM dd, yyyy");
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

    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeColorFloor = (int) Math.floor(magnitude);

        switch (magnitudeColorFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }

        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }
}
