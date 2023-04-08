package com.leminhtriet.lab4_ex1;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity {

    private static Random rand = new Random();
    private static final int qua_item = rand.nextInt(100);;
    private ListView TV_item;
    private List<String> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TV_item = findViewById(R.id.TV_item);

        generateRandomItems();
        setListAdapter();
        addOnItemClickListener();
    }

    private void addOnItemClickListener() {
        TV_item.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String content = items.get(position);
                Toast.makeText(MainActivity.this, content, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setListAdapter() {
        ArrayAdapter<String> itemArrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, items);
        TV_item.setAdapter(itemArrayAdapter);
    }

    private void generateRandomItems() {
        for (int i = 0; i < qua_item; i++) {
            items.add("Item " + i);
        }
    }
}
