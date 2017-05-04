package edu.dtcc.cis282student.recipegenerator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class OilListActivity extends AppCompatActivity implements View.OnClickListener{
    boolean[] bolArray = new boolean[9];
    private List<Button> buttons = new ArrayList<>(BUTTON_IDS.length);
    private static final int[] BUTTON_IDS = {
            R.id.btn_oil_1, R.id.btn_oil_2, R.id.btn_oil_3,
            R.id.btn_oil_4, R.id.btn_oil_5, R.id.btn_oil_6,
            R.id.btn_oil_7, R.id.btn_oil_8, R.id.btn_oil_9,
            R.id.btn_all_back, R.id.btn_all_clear
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oil);

        for(int id : BUTTON_IDS) {
            Button button = (Button) findViewById(id);
            button.setOnClickListener(this);
            buttons.add(button);
        }
        for (int b=72;b<81;b++){
            if (CategoryListActivity.ingredientsList[b]!=null)
                buttons.get(b).setSelected(true);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_oil_1:
                if (CategoryListActivity.ingredientsList[72] == null) {
                    CategoryListActivity.ingredientsList[72] = "olive oil";
                    bolArray[0] = true;
                    view.setSelected(true);
                } else {
                    CategoryListActivity.ingredientsList[72] = null;
                    bolArray[0] = false;
                    view.setSelected(false);
                } break;

            case R.id.btn_oil_2:
                if (CategoryListActivity.ingredientsList[73] == null) {
                    CategoryListActivity.ingredientsList[73] = "canola oil";
                    bolArray[1] = true;
                    view.setSelected(true);
                } else {
                    CategoryListActivity.ingredientsList[73] = null;
                    bolArray[1] = false;
                    view.setSelected(false);
                } break;

            case R.id.btn_oil_3:
                if (CategoryListActivity.ingredientsList[74] == null) {
                    CategoryListActivity.ingredientsList[74] = "vegetable oil";
                    bolArray[2] = true;
                    view.setSelected(true);
                } else {
                    CategoryListActivity.ingredientsList[74] = null;
                    bolArray[2] = false;
                    view.setSelected(false);
                } break;

            case R.id.btn_oil_4:
                if (CategoryListActivity.ingredientsList[75] == null) {
                    CategoryListActivity.ingredientsList[75] = "peanut oil";
                    bolArray[3] = true;
                    view.setSelected(true);
                } else {
                    CategoryListActivity.ingredientsList[75] = null;
                    bolArray[3] = false;
                    view.setSelected(false);
                } break;

            case R.id.btn_oil_5:
                if (CategoryListActivity.ingredientsList[76] == null) {
                    CategoryListActivity.ingredientsList[76] = "cooking spray";
                    bolArray[4] = true;
                    view.setSelected(true);
                } else {
                    CategoryListActivity.ingredientsList[76] = null;
                    bolArray[4] = false;
                    view.setSelected(false);
                } break;

            case R.id.btn_oil_6:
                if (CategoryListActivity.ingredientsList[77] == null) {
                    CategoryListActivity.ingredientsList[77] = "shortening";
                    bolArray[5] = true;
                    view.setSelected(true);
                } else {
                    CategoryListActivity.ingredientsList[77] = null;
                    bolArray[5] = false;
                    view.setSelected(false);
                } break;

            case R.id.btn_oil_7:
                if (CategoryListActivity.ingredientsList[78] == null) {
                    CategoryListActivity.ingredientsList[78] = "red pepper sauce";
                    bolArray[6] = true;
                    view.setSelected(true);
                } else {
                    CategoryListActivity.ingredientsList[78] = null;
                    bolArray[6] = false;
                    view.setSelected(false);
                } break;

            case R.id.btn_oil_8:
                if (CategoryListActivity.ingredientsList[79] == null) {
                    CategoryListActivity.ingredientsList[79] = "tomato paste";
                    bolArray[7] = true;
                    view.setSelected(true);
                } else {
                    CategoryListActivity.ingredientsList[79] = null;
                    bolArray[7] = false;
                    view.setSelected(false);
                } break;

            case R.id.btn_oil_9:
                if (CategoryListActivity.ingredientsList[80] == null) {
                    CategoryListActivity.ingredientsList[80] = "tomato sauce";
                    bolArray[8] = true;
                    view.setSelected(true);
                } else {
                    CategoryListActivity.ingredientsList[80] = null;
                    bolArray[8] = false;
                    view.setSelected(false);
                } break;

            case R.id.btn_all_back:
                Intent bIntent = new Intent(this, CategoryListActivity.class);
                startActivity(bIntent);
                break;

            case R.id.btn_all_clear:
                for (int i = 72; i < 81; i++){
                    CategoryListActivity.ingredientsList[i] = null;
                }
                for (int i = 0; i < bolArray.length; i++) {
                    bolArray[i] = false;
                }
                for (Button btn : buttons) {
                    btn.setSelected(false);
                }
                Toast.makeText(getApplicationContext(), "Oil ingredients deselected",
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
