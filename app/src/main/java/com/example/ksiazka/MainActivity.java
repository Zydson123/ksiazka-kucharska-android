package com.example.ksiazka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String Extra_category = "idCategory";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ListView Categories;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Categories = findViewById(R.id.list);
        Categories.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        StartnewActivity(i);
                        /*String category = adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(MainActivity.this,
                                category+" at index: "+i,
                                Toast.LENGTH_SHORT).show();*/
                    }
                }
        );
}

    private void StartnewActivity(int category){
        Intent intent = new Intent(this,RecipieListActivity.class);
        intent.putExtra(Extra_category, category);
        startActivity(intent);
    }
}