package edu.dtcc.cis282student.recipegenerator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SpiceListActivity extends AppCompatActivity implements View.OnClickListener {
    boolean[] bolArray = new boolean[9];
    private List<Button> buttons = new ArrayList<>(BUTTON_IDS.length);
    private static final int[] BUTTON_IDS = {
            R.id.btn_spice_1, R.id.btn_spice_2, R.id.btn_spice_3,
            R.id.btn_spice_4, R.id.btn_spice_5, R.id.btn_spice_6,
            R.id.btn_spice_7, R.id.btn_spice_8, R.id.btn_spice_9,
            R.id.btn_all_back, R.id.btn_all_clear
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spice);

        for(int id : BUTTON_IDS) {
            Button button = (Button) findViewById(id);
            button.setOnClickListener(this);
            buttons.add(button);
        }
        for (int b=63;b<72;b++){
            if (CategoryListActivity.ingredientsList[b]!=null)
                buttons.get(b).setSelected(true);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_spice_1:
                if (CategoryListActivity.ingredientsList[63] == null) {
                    CategoryListActivity.ingredientsList[63] = "salt";
                    bolArray[0] = true;
                    view.setSelected(true);
                } else {
                    CategoryListActivity.ingredientsList[63] = null;
                    bolArray[0] = false;
                    view.setSelected(false);
                } break;

            case R.id.btn_spice_2:
                if (CategoryListActivity.ingredientsList[64] == null) {
                    CategoryListActivity.ingredientsList[64]  = "black pepper";
                    bolArray[1] = true;
                    view.setSelected(true);
                } else {
                    CategoryListActivity.ingredientsList[64] = null;
                    bolArray[1] = false;
                    view.setSelected(false);
                } break;

            case R.id.btn_spice_3:
                if (CategoryListActivity.ingredientsList[65] == null) {
                    CategoryListActivity.ingredientsList[65] = "basil";
                    bolArray[2] = true;
                    view.setSelected(true);
                } else {
                    CategoryListActivity.ingredientsList[65] = null;
                    bolArray[2] = false;
                    view.setSelected(false);
                } break;

            case R.id.btn_spice_4:
                if (CategoryListActivity.ingredientsList[66] == null) {
                    CategoryListActivity.ingredientsList[66] = "parsley";
                    bolArray[3] = true;
                    view.setSelected(true);
                } else {
                    CategoryListActivity.ingredientsList[66] = null;
                    bolArray[3] = false;
                    view.setSelected(false);
                } break;

            case R.id.btn_spice_5:
                if (CategoryListActivity.ingredientsList[67] == null) {
                    CategoryListActivity.ingredientsList[67] = "oregano";
                    bolArray[4] = true;
                    view.setSelected(true);
                } else {
                    CategoryListActivity.ingredientsList[67] = null;
                    bolArray[4] = false;
                    view.setSelected(false);
                } break;

            case R.id.btn_spice_6:
                if (CategoryListActivity.ingredientsList[68] == null) {
                    CategoryListActivity.ingredientsList[68] = "ground cumin";
                    bolArray[5] = true;
                    view.setSelected(true);
                } else {
                    CategoryListActivity.ingredientsList[68] = null;
                    bolArray[5] = false;
                    view.setSelected(false);
                } break;

            case R.id.btn_spice_7:
                if (CategoryListActivity.ingredientsList[69] == null) {
                    CategoryListActivity.ingredientsList[69] = "chili powder";
                    bolArray[6] = true;
                    view.setSelected(true);
                } else {
                    CategoryListActivity.ingredientsList[69] = null;
                    bolArray[6] = false;
                    view.setSelected(false);
                } break;

            case R.id.btn_spice_8:
                if (CategoryListActivity.ingredientsList[70] == null) {
                    CategoryListActivity.ingredientsList[70] = "garlic powder";
                    bolArray[7] = true;
                    view.setSelected(true);
                } else {
                    CategoryListActivity.ingredientsList[70] = null;
                    bolArray[7] = false;
                    view.setSelected(false);
                } break;

            case R.id.btn_spice_9:
                if (CategoryListActivity.ingredientsList[71] == null) {
                    CategoryListActivity.ingredientsList[71] = "onion powder";
                    bolArray[8] = true;
                    view.setSelected(true);
                } else {
                    CategoryListActivity.ingredientsList[71] = null;
                    bolArray[8] = false;
                    view.setSelected(false);
                } break;

            case R.id.btn_all_back:
                Intent bIntent = new Intent(this, CategoryListActivity.class);
                startActivity(bIntent);
                break;

            case R.id.btn_all_clear:
                for (int i = 63; i < 72; i++){
                    CategoryListActivity.ingredientsList[i] = null;
                }
                for (int i = 0; i < bolArray.length; i++) {
                    bolArray[i] = false;
                }
                for (Button btn : buttons) {
                    btn.setSelected(false);
                }
                Toast.makeText(getApplicationContext(), "Spice ingredients deselected",
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
