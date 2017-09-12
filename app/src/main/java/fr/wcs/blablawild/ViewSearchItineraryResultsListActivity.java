package fr.wcs.blablawild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ViewSearchItineraryResultsListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_search_itinerary_results_list);


        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String departure = intent.getStringExtra("Départ");
        String destination = intent.getStringExtra("Destination");

        setTitle(departure + " >> " + destination);

    }
}
