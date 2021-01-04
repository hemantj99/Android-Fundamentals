package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String[] cities={"Delhi","Jaipur","Mumbai","Delhi","Jaipur",
            "Delhi","Jaipur","Mumbai","Delhi","Jaipur"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.list);
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_dropdown_item_1line,cities);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(MainActivity.this, "Clicked "+cities[position], Toast.LENGTH_SHORT).show();
            }
        });
    }
}