package com.example.android.quakereport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class EarthquakeAdapter extends ArrayAdapter {

    // Define constructor
    public EarthquakeAdapter(Context context, ArrayList<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

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
        magnitudeTextView.setText(String.valueOf((currentEarthquake.getMagnitude())));

        // Set location
        TextView locationTextView = earthquakeItemView.findViewById(R.id.location_text_view);
        locationTextView.setText(currentEarthquake.getLocation());

        // Set date and time
        long earthquakeTimeInMilliseconds = currentEarthquake.getTime();
        Date earthquakeDateObject = new Date(earthquakeTimeInMilliseconds);

        // Set date
        SimpleDateFormat earthquakeDateFormatter = new SimpleDateFormat("MMM DD, yyyy");
        String earthquakeDateToDisplay = earthquakeDateFormatter.format(earthquakeDateObject);

        TextView dateTextView = earthquakeItemView.findViewById(R.id.date_text_view);
        dateTextView.setText(earthquakeDateToDisplay);

        // Set time
        SimpleDateFormat earthquakeTimeFormatter = new SimpleDateFormat("h:mm a");
        String earthquakeTimeToDisplay = earthquakeTimeFormatter.format(earthquakeDateObject);

        TextView timeTextView = earthquakeItemView.findViewById(R.id.time_text_view);
        timeTextView.setText(earthquakeTimeToDisplay);

        return earthquakeItemView;
    }
}
