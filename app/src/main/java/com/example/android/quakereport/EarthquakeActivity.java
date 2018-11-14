/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.quakereport;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class EarthquakeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);

        // Create array list of earthquake objects
        ArrayList<Earthquake> earthquakes = new ArrayList<>();
        earthquakes.add(new Earthquake(4.0, "San Francisco", "Today"));
        earthquakes.add(new Earthquake(4.0, "London", "Today"));
        earthquakes.add(new Earthquake(4.0, "Tokyo", "Today"));
        earthquakes.add(new Earthquake(4.0, "Mexico City", "Today"));
        earthquakes.add(new Earthquake(4.0, "Moscow", "Today"));
        earthquakes.add(new Earthquake(4.0, "Rio de Janeiro", "Today"));
        earthquakes.add(new Earthquake(4.0, "Paris", "Today"));

        // Set up earthquake adapter
        EarthquakeAdapter earthquakeAdapter = new EarthquakeAdapter(this, earthquakes);
        ListView earthquakeListView = findViewById(R.id.earthquake_list_view);
        earthquakeListView.setAdapter(earthquakeAdapter);

    }
}