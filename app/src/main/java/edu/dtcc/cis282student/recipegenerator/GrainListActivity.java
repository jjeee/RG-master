package edu.dtcc.cis282student.recipegenerator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class GrainListActivity extends AppCompatActivity implements View.OnClickListener {
    boolean[] bolArray = new boolean[9];
    private List<Button> buttons = new ArrayList<>(BUTTON_IDS.length);
    private static final int[] BUTTON_IDS = {
            R.id.btn_grain_1, R.id.btn_grain_2, R.id.btn_grain_3,
            R.id.btn_grain_4, R.id.btn_grain_5, R.id.btn_grain_6,
            R.id.btn_grain_7, R.id.btn_grain_8, R.id.btn_grain_9,
            R.id.btn_all_back, R.id.btn_all_clear
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grain);

        for(int id : BUTTON_IDS) {
            Button button = (Button) findViewById(id);
            button.setOnClickListener(this);
            buttons.add(button);
        }
        for (int b=45;b<54;b++){
            if (CategoryListActivity.ingredientsList[b]!=null)
                buttons.get(b).setSelected(true);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_grain_1:
                if (CategoryListActivity.ingredientsList[45] == null) {
                    CategoryListActivity.ingredientsList[45] = "flour";
                    bolArray[0] = true;
                    view.setSelected(true);
                } else {
                    CategoryListActivity.ingredientsList[45] = null;
                    bolArray[0] = false;
                    view.setSelected(false);
                } break;

            case R.id.btn_grain_2:
                if (CategoryListActivity.ingredientsList[46] == null) {
                    CategoryListActivity.ingredientsList[46] = "rice";
                    bolArray[1] = true;
                    view.setSelected(true);
                } else {
                    CategoryListActivity.ingredientsList[46] = null;
                    bolArray[1] = false;
                    view.setSelected(false);
                } break;

            case R.id.btn_grain_3:
                if (CategoryListActivity.ingredientsList[47] == null) {
                    CategoryListActivity.ingredientsList[47] = "corn tortilla";
                    bolArray[2] = true;
                    view.setSelected(true);
                } else {
                    CategoryListActivity.ingredientsList[47] = null;
                    bolArray[2] = false;
                    view.setSelected(false);
                } break;

            case R.id.btn_grain_4:
                if (CategoryListActivity.ingredientsList[48] == null) {
                    CategoryListActivity.ingredientsList[48] = "bread";
                    bolArray[3] = true;
                    view.setSelected(true);
                } else {
                    CategoryListActivity.ingredientsList[48] = null;
                    bolArray[3] = false;
                    view.setSelected(false);
                } break;

            case R.id.btn_grain_5:
                if (CategoryListActivity.ingredientsList[49] == null) {
                    CategoryListActivity.ingredientsList[49] = "pasta";
                    bolArray[4] = true;
                    view.setSelected(true);
                } else {
                    CategoryListActivity.ingredientsList[49] = null;
                    bolArray[4] = false;
                    view.setSelected(false);
                } break;

            case R.id.btn_grain_6:
                if (CategoryListActivity.ingredientsList[50] == null) {
                    CategoryListActivity.ingredientsList[50] = "semolina";
                    bolArray[5] = true;
                    view.setSelected(true);
                } else {
                    CategoryListActivity.ingredientsList[50] = null;
                    bolArray[5] = false;
                    view.setSelected(false);
                } break;

            case R.id.btn_grain_7:
                if (CategoryListActivity.ingredientsList[51] == null) {
                    CategoryListActivity.ingredientsList[51] = "cereal";
                    bolArray[6] = true;
                    view.setSelected(true);
                } else {
                    CategoryListActivity.ingredientsList[51] = null;
                    bolArray[6] = false;
                    view.setSelected(false);
                } break;

            case R.id.btn_grain_8:
                if (CategoryListActivity.ingredientsList[52] == null) {
                    CategoryListActivity.ingredientsList[52] = "bagel";
                    bolArray[7] = true;
                    view.setSelected(true);
                } else {
                    CategoryListActivity.ingredientsList[52] = null;
                    bolArray[7] = false;
                    view.setSelected(false);
                } break;

            case R.id.btn_grain_9:
                if (CategoryListActivity.ingredientsList[53] == null) {
                    CategoryListActivity.ingredientsList[53] = "pita";
                    bolArray[8] = true;
                    view.setSelected(true);
                } else {
                    CategoryListActivity.ingredientsList[53] = null;
                    bolArray[8] = false;
                    view.setSelected(false);
                } break;

            case R.id.btn_all_back:
                Intent bIntent = new Intent(this, CategoryListActivity.class);
                startActivity(bIntent);
                break;

            case R.id.btn_all_clear:
                for (int i = 45; i < 54; i++){
                    CategoryListActivity.ingredientsList[i] = null;
                }
                for (int i = 0; i < bolArray.length; i++) {
                    bolArray[i] = false;
                }
                for (Button btn : buttons) {
                    btn.setSelected(false);
                }
                Toast.makeText(getApplicationContext(), "Grain ingredients deselected",
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
