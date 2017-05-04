package edu.dtcc.cis282student.recipegenerator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FruitListActivity extends AppCompatActivity implements View.OnClickListener {
    private Button[] buttons;
    private int[] buttons_id = {
            R.id.btn_fruit_1, R.id.btn_fruit_2, R.id.btn_fruit_3,
            R.id.btn_fruit_4, R.id.btn_fruit_5, R.id.btn_fruit_6,
            R.id.btn_fruit_7, R.id.btn_fruit_8, R.id.btn_fruit_9,
            R.id.btn_all_back, R.id.btn_all_clear
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit);

        buttons = new Button[buttons_id.length];
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = (Button) findViewById(buttons_id[i]);
            buttons[i].setOnClickListener(this);
        }
        for (int b=18;b<27;b++){
            if (CategoryListActivity.ingredientsList[b]!=null)
                buttons[b].setSelected(true);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_fruit_1:
                if (CategoryListActivity.ingredientsList[18] == null) {
                    CategoryListActivity.ingredientsList[18] = "cherry";
                    view.setSelected(true);
                } else {
                    CategoryListActivity.ingredientsList[18] = null;
                    view.setSelected(false);
                } break;

            case R.id.btn_fruit_2:
                if (CategoryListActivity.ingredientsList[19] == null) {
                    CategoryListActivity.ingredientsList[19] = "watermelon";
                    view.setSelected(true);
                } else {
                    CategoryListActivity.ingredientsList[19] = null;
                    view.setSelected(false);
                } break;

            case R.id.btn_fruit_3:
                if (CategoryListActivity.ingredientsList[20] == null) {
                    CategoryListActivity.ingredientsList[20] = "cantaloupe";
                    view.setSelected(true);
                } else {
                    CategoryListActivity.ingredientsList[20] = null;
                    view.setSelected(false);
                } break;

            case R.id.btn_fruit_4:
                if (CategoryListActivity.ingredientsList[21] == null) {
                    CategoryListActivity.ingredientsList[21] = "grape";
                    view.setSelected(true);
                } else {
                    CategoryListActivity.ingredientsList[21] = null;
                    view.setSelected(false);
                } break;

            case R.id.btn_fruit_5:
                if (CategoryListActivity.ingredientsList[22] == null) {
                    CategoryListActivity.ingredientsList[22] = "orange";
                    view.setSelected(true);
                } else {
                    CategoryListActivity.ingredientsList[22] = null;
                    view.setSelected(false);
                } break;

            case R.id.btn_fruit_6:
                if (CategoryListActivity.ingredientsList[23] == null) {
                    CategoryListActivity.ingredientsList[23] = "lemon";
                    view.setSelected(true);
                } else {
                    CategoryListActivity.ingredientsList[23] = null;
                    view.setSelected(false);
                } break;

            case R.id.btn_fruit_7:
                if (CategoryListActivity.ingredientsList[24] == null) {
                    CategoryListActivity.ingredientsList[24] = "strawberry";
                    view.setSelected(true);
                } else {
                    CategoryListActivity.ingredientsList[24] = null;
                    view.setSelected(false);
                } break;

            case R.id.btn_fruit_8:
                if (CategoryListActivity.ingredientsList[25] == null) {
                    CategoryListActivity.ingredientsList[25] = "banana";
                    view.setSelected(true);
                } else {
                    CategoryListActivity.ingredientsList[25] = null;
                    view.setSelected(false);
                } break;

            case R.id.btn_fruit_9:
                if (CategoryListActivity.ingredientsList[26] == null) {
                    CategoryListActivity.ingredientsList[26] = "apple";
                    view.setSelected(true);
                } else {
                    CategoryListActivity.ingredientsList[26] = null;
                    view.setSelected(false);
                } break;

            case R.id.btn_all_back:
                Intent bIntent = new Intent(this, CategoryListActivity.class);
                startActivity(bIntent);
                break;

            case R.id.btn_all_clear:
                for (int i = 18; i < 27; i++){
                    CategoryListActivity.ingredientsList[i] = null;
                }
                for (Button btn : buttons) {
                    btn.setSelected(false);
                }
                Toast.makeText(getApplicationContext(), "Fruit ingredients deselected",
                        Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
