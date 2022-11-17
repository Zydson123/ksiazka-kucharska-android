package com.example.ksiazka;

import static com.example.ksiazka.MainActivity.Extra_category;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class RecipieListActivity extends AppCompatActivity {

    public static final String WHICH_RECIPIE = "WhichRecipie";
    public static final String EXTRA_CATEOGRY = "CategoryId";
    ArrayAdapter<Recipie> RecipiesAdapter;
    ListView recipies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipie_list);
        int category = (int) getIntent().getExtras().get(Extra_category);
        // Toast.makeText(RecipieListActivity.this, Integer.toString(category), Toast.LENGTH_SHORT).show();
        ArrayList<Recipie> chosenRecipie = RecipieList.chooseRecipie(category);
        RecipiesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,chosenRecipie);
        recipies = findViewById(R.id.recipie_list);
        recipies.setAdapter(RecipiesAdapter);

        recipies.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(RecipieListActivity.this, RecipieActivity.class);
                intent.putExtra(WHICH_RECIPIE,i);
                intent.putExtra(EXTRA_CATEOGRY,category);
                startActivity(intent);
            }
        });
    }
}


