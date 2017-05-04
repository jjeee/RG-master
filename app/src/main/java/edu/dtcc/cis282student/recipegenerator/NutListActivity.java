package edu.dtcc.cis282student.recipegenerator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class NutListActivity extends AppCompatActivity implements View.OnClickListener{
    boolean[] bolArray = new boolean[9];
    private List<Button> buttons = new ArrayList<>(BUTTON_IDS.length);
    private static final int[] BUTTON_IDS = {
            R.id.btn_nut_1, R.id.btn_nut_2, R.id.btn_nut_3,
            R.id.btn_nut_4, R.id.btn_nut_5, R.id.btn_nut_6,
            R.id.btn_nut_7, R.id.btn_nut_8, R.id.btn_nut_9,
            R.id.btn_all_back, R.id.btn_all_clear
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nut);

        for(int id : BUTTON_IDS) {
            Button button = (Button) findViewById(id);
            button.setOnClickListener(this);
            buttons.add(button);
        }
        for (int b=36;b<45;b++){
            if (CategoryListActivity.ingredientsList[b]!=null)
                buttons.get(b).setSelected(true);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_nut_1:
                if (CategoryListActivity.ingredientsList[36] == null) {
                    CategoryListActivity.ingredientsList[36] = "peanut";
                    bolArray[0] = true;
                    view.setSelected(true);
                } else {
                    CategoryListActivity.ingredientsList[36] = null;
                    bolArray[0] = false;
                    view.setSelected(false);
                } break;

            case R.id.btn_nut_2:
                if (CategoryListActivity.ingredientsList[37] == null) {
                    CategoryListActivity.ingredientsList[37] = "cashew";
                    bolArray[1] = true;
                    view.setSelected(true);
                } else {
                    CategoryListActivity.ingredientsList[37] = null;
                    bolArray[1] = false;
                    view.setSelected(false);
                } break;

            case R.id.btn_nut_3:
                if (CategoryListActivity.ingredientsList[38] == null) {
                    CategoryListActivity.ingredientsList[38] = "walnut";
                    bolArray[2] = true;
                    view.setSelected(true);
                } else {
                    CategoryListActivity.ingredientsList[38] = null;
                    bolArray[2] = false;
                    view.setSelected(false);
                } break;

            case R.id.btn_nut_4:
                if (CategoryListActivity.ingredientsList[39] == null) {
                    CategoryListActivity.ingredientsList[39] = "pistachio";
                    bolArray[3] = true;
                    view.setSelected(true);
                } else {
                    CategoryListActivity.ingredientsList[39] = null;
                    bolArray[3] = false;
                    view.setSelected(false);
                } break;

            case R.id.btn_nut_5:
                if (CategoryListActivity.ingredientsList[40] == null) {
                    CategoryListActivity.ingredientsList[40] = "almond";
                    bolArray[4] = true;
                    view.setSelected(true);
                } else {
                    CategoryListActivity.ingredientsList[40] = null;
                    bolArray[4] = false;
                    view.setSelected(false);
                } break;

            case R.id.btn_nut_6:
                if (CategoryListActivity.ingredientsList[41] == null) {
                    CategoryListActivity.ingredientsList[41] = "peanut butter";
                    bolArray[5] = true;
                    view.setSelected(true);
                } else {
                    CategoryListActivity.ingredientsList[41] = null;
                    bolArray[5] = false;
                    view.setSelected(false);
                } break;

            case R.id.btn_nut_7:
                if (CategoryListActivity.ingredientsList[42] == null) {
                    CategoryListActivity.ingredientsList[42] = "hazelnut";
                    bolArray[6] = true;
                    view.setSelected(true);
                } else {
                    CategoryListActivity.ingredientsList[42] = null;
                    bolArray[6] = false;
                    view.setSelected(false);
                } break;

            case R.id.btn_nut_8:
                if (CategoryListActivity.ingredientsList[43] == null) {
                    CategoryListActivity.ingredientsList[43] = "macadamia";
                    bolArray[7] = true;
                    view.setSelected(true);
                } else {
                    CategoryListActivity.ingredientsList[43] = null;
                    bolArray[7] = false;
                    view.setSelected(false);
                } break;

            case R.id.btn_nut_9:
                if (CategoryListActivity.ingredientsList[44] == null) {
                    CategoryListActivity.ingredientsList[44] = "pecan";
                    bolArray[8] = true;
                    view.setSelected(true);
                } else {
                    CategoryListActivity.ingredientsList[44] = null;
                    bolArray[8] = false;
                    view.setSelected(false);
                } break;

            case R.id.btn_all_back:
                Intent bIntent = new Intent(this, CategoryListActivity.class);
                startActivity(bIntent);
                break;

            case R.id.btn_all_clear:
                for (int i = 36; i < 45; i++){
                    CategoryListActivity.ingredientsList[i] = null;
                }
                for (int i = 0; i < bolArray.length; i++) {
                    bolArray[i] = false;
                }
                for (Button btn : buttons) {
                    btn.setSelected(false);
                }
                Toast.makeText(getApplicationContext(), "Nut ingredients deselected",
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
