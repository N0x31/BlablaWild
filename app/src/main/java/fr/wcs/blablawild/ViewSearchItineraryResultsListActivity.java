package fr.wcs.blablawild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ViewSearchItineraryResultsListActivity extends AppCompatActivity {

    ListView listView;
    TripResultAdapter mResultAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_search_itinerary_results_list);


        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String departure = intent.getStringExtra("Départ");
        String destination = intent.getStringExtra("Destination");

        setTitle(departure + " >> " + destination);

        //Affichage de la liste


        listView = (ListView) findViewById(R.id.listView);

        ArrayList<TripResultModel> results = new ArrayList<>();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy-hh:mm");

        try {
            results.add(new TripResultModel("Bruce", sdf.parse("21/02/2017-15:30"), 15));
            results.add(new TripResultModel("Clark", sdf.parse("21/02/2017-16:00"), 20));
            results.add(new TripResultModel("Bary", sdf.parse("21/02/2017-16:30"), 16));
            results.add(new TripResultModel("Lex", sdf.parse("21/02/2017-17:00"), 40));
        } catch (ParseException e) {
        }
        mResultAdapter = new TripResultAdapter(this, results);

        listView.setAdapter(mResultAdapter);


    }
}
