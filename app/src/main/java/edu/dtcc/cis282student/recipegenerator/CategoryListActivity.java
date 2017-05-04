package edu.dtcc.cis282student.recipegenerator;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class CategoryListActivity extends AppCompatActivity implements View.OnClickListener {
    static String[] ingredientsList = new String[81];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        // Buttons
        ImageButton btnMeat = (ImageButton) findViewById(R.id.btn_categories_meat);
        ImageButton btnVeg = (ImageButton) findViewById(R.id.btn_categories_veg);
        ImageButton btnFruit = (ImageButton) findViewById(R.id.btn_categories_fruit);
        ImageButton btnDairy = (ImageButton) findViewById(R.id.btn_categories_dairy);
        ImageButton btnNut = (ImageButton) findViewById(R.id.btn_categories_nut);
        ImageButton btnGrain = (ImageButton) findViewById(R.id.btn_categories_grain);
        ImageButton btnSea = (ImageButton) findViewById(R.id.btn_categories_sea);
        ImageButton btnSpice = (ImageButton) findViewById(R.id.btn_categories_spice);
        ImageButton btnOil = (ImageButton) findViewById(R.id.btn_categories_oil);
        Button btnBack = (Button) findViewById(R.id.btn_all_back);
        Button btnFind = (Button) findViewById(R.id.btn_categories_find);
        Button btnClear = (Button) findViewById(R.id.btn_all_clear);

        // Button listeners
        btnMeat.setOnClickListener(this);
        btnVeg.setOnClickListener(this);
        btnFruit.setOnClickListener(this);
        btnDairy.setOnClickListener(this);
        btnNut.setOnClickListener(this);
        btnGrain.setOnClickListener(this);
        btnSea.setOnClickListener(this);
        btnSpice.setOnClickListener(this);
        btnOil.setOnClickListener(this);
        btnBack.setOnClickListener(this);
        btnFind.setOnClickListener(this);
        btnClear.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_categories_meat:
                Intent meatIntent = new Intent(this, MeatListActivity.class);
                startActivity(meatIntent);
                break;

            case R.id.btn_categories_veg:
                Intent vegIntent = new Intent(this, VegetableListActivity.class);
                startActivity(vegIntent);
                break;

            case R.id.btn_categories_fruit:
                Intent fruitIntent = new Intent(this, FruitListActivity.class);
                startActivity(fruitIntent);
                break;

            case R.id.btn_categories_dairy:
                Intent dairyIntent = new Intent(this, DairyListActivity.class);
                startActivity(dairyIntent);
                break;

            case R.id.btn_categories_nut:
                Intent nutIntent = new Intent(this, NutListActivity.class);
                startActivity(nutIntent);
                break;

            case R.id.btn_categories_grain:
                Intent grainIntent = new Intent(this, GrainListActivity.class);
                startActivity(grainIntent);
                break;

            case R.id.btn_categories_sea:
                Intent seaIntent = new Intent(this, SeafoodListActivity.class);
                startActivity(seaIntent);
                break;

            case R.id.btn_categories_spice:
                Intent spiceIntent = new Intent(this, SpiceListActivity.class);
                startActivity(spiceIntent);
                break;

            case R.id.btn_categories_oil:
                Intent oilIntent = new Intent(this, OilListActivity.class);
                startActivity(oilIntent);
                break;

            case R.id.btn_all_back:
                Intent bIntent = new Intent(this, MenuActivity.class);
                startActivity(bIntent);
                break;

            case R.id.btn_categories_find:
                Intent rIntent = new Intent(this, RecipeListActivity.class);
                startActivity(rIntent);
                break;

            case R.id.btn_all_clear:
                for (int i = 0; i < ingredientsList.length; i++){
                    ingredientsList[i] = null;
                }
                Toast.makeText(getApplicationContext(), "All Ingredients Deselected",
                        Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
