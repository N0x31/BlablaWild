package fr.wcs.blablawild;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class SearchItineraryActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_itinerary);

        final EditText departure ;
        final EditText destination ;
        final EditText date;

        departure = (EditText) findViewById(R.id.editTextSearchDeparture);
        destination = (EditText) findViewById(R.id.editTextSearchDestination);
        date = (EditText) findViewById(R.id.editTextSearchDate);

        date.setFocusable(false);
        final Calendar myCalendar = Calendar.getInstance();
        final DatePickerDialog.OnDateSetListener datePicker = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

                date.setText(sdf.format(myCalendar.getTime()));
            }

        };

        date.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                new DatePickerDialog(SearchItineraryActivity.this, datePicker,
                        myCalendar.get(Calendar.YEAR),
                        myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

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


                if (departure.getText().toString().isEmpty() || destination.getText().toString().isEmpty()) {
                    Context context = getApplicationContext();
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(context, R.string.toast, duration);
                    toast.show();
                }

                else {
                    SearchRequestModel obj = new SearchRequestModel(departure.getText().toString(),destination.getText().toString(), new Date());
                    Intent intent = new Intent(SearchItineraryActivity.this, ViewSearchItineraryResultsListActivity.class);
                    intent.putExtra("Instance", obj);
                    startActivity(intent);
                }
            }
        });
    }
}
