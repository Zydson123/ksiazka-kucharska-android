package com.example.ksiazka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RecipieActivity extends AppCompatActivity {

    TextView recipieName;
    TextView ingredients;
    ImageView image;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipie);
        recipieName = findViewById(R.id.recipie_name);
        ingredients = findViewById(R.id.ingredients);
        image = findViewById(R.id.imageView);
        btn = findViewById(R.id.share);
        int WhichRecipie = getIntent().getExtras().getInt(RecipieListActivity.WHICH_RECIPIE,0);
        int Category = getIntent().getExtras().getInt(RecipieListActivity.EXTRA_CATEOGRY,0);
        Recipie recipie = RecipieList.chooseRecipie(Category).get(WhichRecipie);
        recipieName.setText(recipie.getName());
        ingredients.setText(recipie.getIngredients());
        image.setImageResource(recipie.getImageId());
        btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        /*(w manifeście dodać:
                        <action android:name="android.intent.action.SEND"/>
                        <category android:name="android.intent.category.DEFAULT"/>
                        <data android:mimeType="text/plain"/>
                        czyli filtr do wysyłania sms
                         */
                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_SEND);
                        intent.putExtra(Intent.EXTRA_TEXT,recipie.getName()+" "+ recipie.getIngredients()+" Smacznego!");
                        intent.setType("text/plain");
                        Intent shareIntent = Intent.createChooser(intent,"pies");
                        startActivity(shareIntent);
                    }
                }
        );
    }
}