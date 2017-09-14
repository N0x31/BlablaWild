package fr.wcs.blablawild;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SearchItineraryActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_itinerary);
        Intent intent = getIntent();

        final Button buttonSearch;
        buttonSearch = (Button) findViewById(R.id.buttonSearch);
        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                InputMethodManager inputManager = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);

                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);

                final EditText departure ;
                final EditText destination ;
                final EditText date;

                departure = (EditText) findViewById(R.id.editTextSearchDeparture);
                destination = (EditText) findViewById(R.id.editTextSearchDestination);
                date = (EditText) findViewById(R.id.editTextSearchDate);

                if (departure.getText().toString().isEmpty() || destination.getText().toString().isEmpty()) {
                    Context context = getApplicationContext();
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(context, R.string.toast, duration);
                    toast.show();
                }

                else {
                        Intent intent = new Intent(SearchItineraryActivity.this, ViewSearchItineraryResultsListActivity.class);
                        intent.putExtra("Départ", departure.getText().toString());
                        intent.putExtra("Destination", destination.getText().toString());
                        startActivity(intent);
                    }
            }
        });
    }
}
