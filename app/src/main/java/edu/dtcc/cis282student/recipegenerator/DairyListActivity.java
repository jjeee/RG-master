package edu.dtcc.cis282student.recipegenerator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DairyListActivity extends AppCompatActivity implements View.OnClickListener {
    private Button[] buttons;
    private int[] buttons_id = {
            R.id.btn_dairy_1, R.id.btn_dairy_2, R.id.btn_dairy_3,
            R.id.btn_dairy_4, R.id.btn_dairy_5, R.id.btn_dairy_6,
            R.id.btn_dairy_7, R.id.btn_dairy_8, R.id.btn_dairy_9,
            R.id.btn_all_back, R.id.btn_all_clear
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dairy);

        buttons = new Button[buttons_id.length];
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = (Button) findViewById(buttons_id[i]);
            buttons[i].setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_dairy_1:
                if (CategoryListActivity.ingredientsList[27] == null) {
                    CategoryListActivity.ingredientsList[27] = "egg";
                    view.setSelected(true);
                } else {
                    CategoryListActivity.ingredientsList[27] = null;
                    view.setSelected(false);
                } break;

            case R.id.btn_dairy_2:
                if (CategoryListActivity.ingredientsList[28] == null) {
                    CategoryListActivity.ingredientsList[28] = "milk";
                    view.setSelected(true);
                } else {
                    CategoryListActivity.ingredientsList[28] = null;
                    view.setSelected(false);
                } break;

            case R.id.btn_dairy_3:
                if (CategoryListActivity.ingredientsList[29] == null) {
                    CategoryListActivity.ingredientsList[29] = "heavy cream";
                    view.setSelected(true);
                } else {
                    CategoryListActivity.ingredientsList[29] = null;
                    view.setSelected(false);
                } break;

            case R.id.btn_dairy_4:
                if (CategoryListActivity.ingredientsList[30] == null) {
                    CategoryListActivity.ingredientsList[30] = "butter";
                    view.setSelected(true);
                } else {
                    CategoryListActivity.ingredientsList[30] = null;
                    view.setSelected(false);
                } break;

            case R.id.btn_dairy_5:
                if (CategoryListActivity.ingredientsList[31] == null) {
                    CategoryListActivity.ingredientsList[31] = "sour cream";
                    view.setSelected(true);
                } else {
                    CategoryListActivity.ingredientsList[31] = null;
                    view.setSelected(false);
                } break;

            case R.id.btn_dairy_6:
                if (CategoryListActivity.ingredientsList[32] == null) {
                    CategoryListActivity.ingredientsList[32] = "cheddar";
                    view.setSelected(true);
                } else {
                    CategoryListActivity.ingredientsList[32] = null;
                    view.setSelected(false);
                } break;

            case R.id.btn_dairy_7:
                if (CategoryListActivity.ingredientsList[33] == null) {
                    CategoryListActivity.ingredientsList[33] = "cream cheese";
                    view.setSelected(true);
                } else {
                    CategoryListActivity.ingredientsList[33] = null;
                    view.setSelected(false);
                } break;

            case R.id.btn_dairy_8:
                if (CategoryListActivity.ingredientsList[34] == null) {
                    CategoryListActivity.ingredientsList[34] = "yogurt";
                    view.setSelected(true);
                } else {
                    CategoryListActivity.ingredientsList[34] = null;
                    view.setSelected(false);
                } break;

            case R.id.btn_dairy_9:
                if (CategoryListActivity.ingredientsList[35] == null) {
                    CategoryListActivity.ingredientsList[35] = "cream";
                    view.setSelected(true);
                } else {
                    CategoryListActivity.ingredientsList[35] = null;
                    view.setSelected(false);
                } break;

            case R.id.btn_all_back:
                Intent bIntent = new Intent(this, CategoryListActivity.class);
                startActivity(bIntent);
                break;

            case R.id.btn_all_clear:
                for (int i = 27; i < 36; i++){
                    CategoryListActivity.ingredientsList[i] = null;
                }
                for (Button btn : buttons) {
                    btn.setSelected(false);
                }
                Toast.makeText(getApplicationContext(), "Dairy ingredients deselected",
                        Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
