package com.example.android.quakereport;

import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * Settings menu activity.
 */
public class SettingsActivity extends AppCompatActivity {

    /**
     * Set activity content when activity is created.
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);
    }

    /**
     * Settings preference fragment for encapsulating various settings.
     */
    public static class EarthquakePreferenceFragment extends PreferenceFragment implements Preference.OnPreferenceChangeListener {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.settings_main);

            // Bind preference summary to preference values
            Preference minMagnitude = findPreference(getString(R.string.settings_min_magnitude_key));
            bindPreferenceSummaryToValue(minMagnitude);
        }

        /**
         * Method called when user changes a preference to update the UI.
         *
         * @param preference Preference changed.
         * @param newValue New preference value.
         * @return whether to update or not the state of the preference with the new value.
         */
        @Override
        public boolean onPreferenceChange(Preference preference, Object newValue) {
            // The code in this method takes care of updating the displayed preference summary after it has been changed
            String stringValue = newValue.toString();
            preference.setSummary(stringValue);
            return true; // To update the state of the preference with the new value
        }

        /**
         * Helper method to bind preference summary to preference value via listener.
         *
         * @param preference Selected preference.
         */
        private void bindPreferenceSummaryToValue(Preference preference) {
            // Set the current EarthquakePreferenceFragment instance to listen for changes
            preference.setOnPreferenceChangeListener(this);
            // Get current preference value
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(preference.getContext());
            String preferenceString = preferences.getString(preference.getKey(), "");
            // Display it in the preference summary -- that is, in the UI
            onPreferenceChange(preference, preferenceString);
        }
    }
}
