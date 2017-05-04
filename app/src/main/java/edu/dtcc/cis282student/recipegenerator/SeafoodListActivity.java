package edu.dtcc.cis282student.recipegenerator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SeafoodListActivity extends AppCompatActivity implements View.OnClickListener {
    boolean[] bolArray = new boolean[9];
    private List<Button> buttons = new ArrayList<>(BUTTON_IDS.length);
    private static final int[] BUTTON_IDS = {
            R.id.btn_sea_1, R.id.btn_sea_2, R.id.btn_sea_3,
            R.id.btn_sea_4, R.id.btn_sea_5, R.id.btn_sea_6,
            R.id.btn_sea_7, R.id.btn_sea_8, R.id.btn_sea_9,
            R.id.btn_all_back, R.id.btn_all_clear
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seafood);

        for(int id : BUTTON_IDS) {
            Button button = (Button) findViewById(id);
            button.setOnClickListener(this);
            buttons.add(button);
        }
        for (int b=54;b<63;b++){
            if (CategoryListActivity.ingredientsList[b]!=null)
                buttons.get(b).setSelected(true);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_sea_1:
                if (CategoryListActivity.ingredientsList[54] == null) {
                    CategoryListActivity.ingredientsList[54] = "salmon";
                    bolArray[0] = true;
                    view.setSelected(true);
                } else {
                    CategoryListActivity.ingredientsList[54] = null;
                    bolArray[0] = false;
                    view.setSelected(false);
                } break;

            case R.id.btn_sea_2:
                if (CategoryListActivity.ingredientsList[55] == null) {
                    CategoryListActivity.ingredientsList[55] = "trout";
                    bolArray[1] = true;
                    view.setSelected(true);
                } else {
                    CategoryListActivity.ingredientsList[55] = null;
                    bolArray[1] = false;
                    view.setSelected(false);
                } break;

            case R.id.btn_sea_3:
                if (CategoryListActivity.ingredientsList[56] == null) {
                    CategoryListActivity.ingredientsList[56] = "sea bass";
                    bolArray[2] = true;
                    view.setSelected(true);
                } else {
                    CategoryListActivity.ingredientsList[56] = null;
                    bolArray[2] = false;
                    view.setSelected(false);
                } break;

            case R.id.btn_sea_4:
                if (CategoryListActivity.ingredientsList[57] == null) {
                    CategoryListActivity.ingredientsList[57] = "shrimp";
                    bolArray[3] = true;
                    view.setSelected(true);
                } else {
                    CategoryListActivity.ingredientsList[57] = null;
                    bolArray[3] = false;
                    view.setSelected(false);
                } break;

            case R.id.btn_sea_5:
                if (CategoryListActivity.ingredientsList[58] == null) {
                    CategoryListActivity.ingredientsList[58] = "tuna";
                    bolArray[4] = true;
                    view.setSelected(true);
                } else {
                    CategoryListActivity.ingredientsList[58] = null;
                    bolArray[4] = false;
                    view.setSelected(false);
                } break;

            case R.id.btn_sea_6:
                if (CategoryListActivity.ingredientsList[59] == null) {
                    CategoryListActivity.ingredientsList[59] = "tilapia";
                    bolArray[5] = true;
                    view.setSelected(true);
                } else {
                    CategoryListActivity.ingredientsList[59] = null;
                    bolArray[5] = false;
                    view.setSelected(false);
                } break;

            case R.id.btn_sea_7:
                if (CategoryListActivity.ingredientsList[60] == null) {
                    CategoryListActivity.ingredientsList[60] = "halibut";
                    bolArray[6] = true;
                    view.setSelected(true);
                } else {
                    CategoryListActivity.ingredientsList[60] = null;
                    bolArray[6] = false;
                    view.setSelected(false);
                } break;

            case R.id.btn_sea_8:
                if (CategoryListActivity.ingredientsList[61] == null) {
                    CategoryListActivity.ingredientsList[61] = "mackerel";
                    bolArray[7] = true;
                    view.setSelected(true);
                } else {
                    CategoryListActivity.ingredientsList[61] = null;
                    bolArray[7] = false;
                    view.setSelected(false);
                } break;

            case R.id.btn_sea_9:
                if (CategoryListActivity.ingredientsList[62] == null) {
                    CategoryListActivity.ingredientsList[62] = "anchovy";
                    bolArray[8] = true;
                    view.setSelected(true);
                } else {
                    CategoryListActivity.ingredientsList[62] = null;
                    bolArray[8] = false;
                    view.setSelected(false);
                } break;

            case R.id.btn_all_back:
                Intent bIntent = new Intent(this, CategoryListActivity.class);
                startActivity(bIntent);
                break;

            case R.id.btn_all_clear:
                for (int i = 54; i < 63; i++){
                    CategoryListActivity.ingredientsList[i] = null;
                }
                for (int i = 0; i < bolArray.length; i++) {
                    bolArray[i] = false;
                }
                for (Button btn : buttons) {
                    btn.setSelected(false);
                }
                Toast.makeText(getApplicationContext(), "Seafood ingredients deselected",
                        Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putBooleanArray("counter_key", bolArray);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        bolArray = savedInstanceState.getBooleanArray("counter_key");
    }
}
