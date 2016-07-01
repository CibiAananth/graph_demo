package com.sathees.demo;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sathees on 12-06-2016.
 */
public class HomeActivity extends AppCompatActivity  {

    private Button logOut;
    private TextView textbox;
    String[] SPINNERLIST = {"Januray", "February", "March", "April","May", "June", "July", "August", "September", "October", "November", "December"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        final Spinner materialDesignSpinner = (Spinner)
                findViewById(R.id.spinner);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, SPINNERLIST);
        materialDesignSpinner.setAdapter(arrayAdapter);

        final DatabaseHandler db2 = new DatabaseHandler(this);
        final SQLiteDatabase sq  = new DatabaseHandler(this).getWritableDatabase();

        logOut = (Button)findViewById(R.id.logout);
        final BarChart barChart = (BarChart) findViewById(R.id.chart);
        textbox = (TextView) findViewById(R.id.textView);
        Intent intent = getIntent();
        String str = intent.getStringExtra("username");
        textbox.setText(str);
        final DatabaseHandler db = new DatabaseHandler(this);
        List<User> users = db.getAllUsers();
        ArrayList<BarEntry> entries = new ArrayList<>();
        ArrayList<String> labels = new ArrayList<String>();
        int i=0;
        for (User u : users) {
            entries.add(new BarEntry(u.retSalary(),i));
            labels.add(u.getName());
            i++;
        }
        BarDataSet dataset = new BarDataSet(entries, "Monthly Salary");
        dataset.setColors(ColorTemplate.COLORFUL_COLORS);
        BarData data = new BarData(labels, dataset);
        barChart.setData(data);
        barChart.setDescription("Salary Details");
        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        materialDesignSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
             //   Toast.makeText(getBaseContext(), "Selected: " + item, Toast.LENGTH_SHORT).show();
                if(item.equals("January")){
                    Toast.makeText(getBaseContext(), "Selected month is " + item, Toast.LENGTH_SHORT).show();
                }
                else if(item.equals("February")){
                    Toast.makeText(getBaseContext(), "Selected month is " + item, Toast.LENGTH_SHORT).show();
                    db2.onUpgrade(sq,1,1);
                    Log.d("Insert: ", "Inserting ..");
                    db2.addUser(new User("Sathees", "5000"));
                    db2.addUser(new User("Kumar", "7500"));
                    db2.addUser(new User("Tommy", "2500"));
                    db2.addUser(new User("Karthik", "7050"));

                    List<User> users = db2.getAllUsers();
                    ArrayList<BarEntry> entries = new ArrayList<>();
                    ArrayList<String> labels = new ArrayList<String>();
                    int i=0;
                    for (User u : users) {
                        entries.add(new BarEntry(u.retSalary(),i));
                        labels.add(u.getName());
                        i++;
                    }
                    BarDataSet dataset = new BarDataSet(entries, "Monthly Salary");
                    dataset.setColors(ColorTemplate.COLORFUL_COLORS);
                    BarData data = new BarData(labels, dataset);
                    barChart.setData(data);
                    barChart.setDescription("Salary Details");
                }
                else if(item.equals("March")){
                    Toast.makeText(getBaseContext(), "Selected month is " + item, Toast.LENGTH_SHORT).show();
                }
                else if(item.equals("April")){
                    Toast.makeText(getBaseContext(), "Selected month is " + item, Toast.LENGTH_SHORT).show();
                }
                else if(item.equals("May")){
                    Toast.makeText(getBaseContext(), "Selected month is " + item, Toast.LENGTH_SHORT).show();
                }
                else if(item.equals("June")){
                    Toast.makeText(getBaseContext(), "Selected month is " + item, Toast.LENGTH_SHORT).show();
                }
                else if(item.equals("July")){
                    Toast.makeText(getBaseContext(), "Selected month is " + item, Toast.LENGTH_SHORT).show();
                }
                else if(item.equals("August")){
                    Toast.makeText(getBaseContext(), "Selected month is " + item, Toast.LENGTH_SHORT).show();
                }
                else if(item.equals("September")){
                    Toast.makeText(getBaseContext(), "Selected month is " + item, Toast.LENGTH_SHORT).show();
                }
                else if(item.equals("October")){
                    Toast.makeText(getBaseContext(), "Selected month is " + item, Toast.LENGTH_SHORT).show();
                }
                else if(item.equals("November")){
                    Toast.makeText(getBaseContext(), "Selected month is " + item, Toast.LENGTH_SHORT).show();
                }
                else if(item.equals("December")){
                    Toast.makeText(getBaseContext(), "Selected month is " + item, Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }


}
