package fr.wcs.blablawild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ViewSearchItineraryResultsListActivity extends AppCompatActivity {

    ListView mlistView;
    TripResultAdapter mResultAdapter;  //variable globale commence par "m"

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_search_itinerary_results_list);


        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        SearchRequestModel obj = intent.getParcelableExtra("Instance");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy-hh:mm");

        String departure = obj.getVilleDepart();
        String destination = obj.getVilleDest();

        Toast.makeText(getApplicationContext(), sdf.format(obj.getDateTrajet()), Toast.LENGTH_LONG).show();

        setTitle(departure + " >> " + destination);

        //Affichage de la liste
        mlistView = (ListView) findViewById(R.id.listView);

        ArrayList<TripResultModel> results = new ArrayList<>();//ArrayList = liste d'éléments



        try {
            results.add(new TripResultModel("Bruce", sdf.parse("21/02/2017-15:30"), 15));
            results.add(new TripResultModel("Clark", sdf.parse("21/02/2017-16:00"), 20));
            results.add(new TripResultModel("Bary", sdf.parse("21/02/2017-16:30"), 16));
            results.add(new TripResultModel("Lex", sdf.parse("21/02/2017-17:00"), 40));
        } catch (ParseException e) {
        }
        mResultAdapter = new TripResultAdapter(this, results);

        mlistView.setAdapter(mResultAdapter);


    }
}
