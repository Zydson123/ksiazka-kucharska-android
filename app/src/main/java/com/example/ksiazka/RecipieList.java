package com.example.ksiazka;

import java.util.ArrayList;

public class RecipieList {
    public static final Recipie[] recipies = {
            new Recipie("Lipton Ice Tea Lemon","Lipton",R.drawable.liptonek,0), //0
            new Recipie("Bacon with eggs", "Bacon, Eggs", R.drawable.bacon, 1), //1
            new Recipie("Scrambled Eggs", "Eggs, idk", R.drawable.scrambled_eggs,1),//2
            new Recipie("Steak","Steak,Butter,Pepper,Salt",R.drawable.steak,2),//3
            new Recipie("Toasts","Toast bread,ham,cheese",R.drawable.tosty,3),//4
    };
    public static ArrayList<Recipie> chooseRecipie(int category){
      ArrayList<Recipie> chosen = new ArrayList<>();
      for(Recipie recipie:recipies){
          if(recipie.getCategory()==category){
              chosen.add(recipie);
          }
      }
      return chosen;
    };
}
