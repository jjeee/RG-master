package edu.dtcc.cis282student.recipegenerator;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MeatListActivity extends AppCompatActivity implements View.OnClickListener {
    private Button[] buttons;
    private int[] buttons_id = {
            R.id.btn_meat_1, R.id.btn_meat_2, R.id.btn_meat_3,
            R.id.btn_meat_4, R.id.btn_meat_5, R.id.btn_meat_6,
            R.id.btn_meat_7, R.id.btn_meat_8, R.id.btn_meat_9,
            R.id.btn_all_back, R.id.btn_all_clear
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meat);

        buttons = new Button[buttons_id.length];
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = (Button) findViewById(buttons_id[i]);
            buttons[i].setOnClickListener(this);
        }

        for (int b=0;b<9;b++){
            if (CategoryListActivity.ingredientsList[b]!=null)
                buttons[b].setSelected(true);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_meat_1:
                if (CategoryListActivity.ingredientsList[0] == null) {
                    CategoryListActivity.ingredientsList[0] = "ground beef";
                    view.setSelected(true);
                } else {
                    CategoryListActivity.ingredientsList[0] = null;
                    view.setSelected(false);
                } break;


            case R.id.btn_meat_2:
                if (CategoryListActivity.ingredientsList[1] == null) {
                    CategoryListActivity.ingredientsList[1] = "chicken breast";
                    view.setSelected(true);
                } else {
                    CategoryListActivity.ingredientsList[1] = null;
                    view.setSelected(false);
                } break;

            case R.id.btn_meat_3:
                if (CategoryListActivity.ingredientsList[2] == null) {
                    CategoryListActivity.ingredientsList[2] = "pork chop";
                    view.setSelected(true);
                } else {
                    CategoryListActivity.ingredientsList[2] = null;
                    view.setSelected(false);
                } break;


            case R.id.btn_meat_4:
                if (CategoryListActivity.ingredientsList[3] == null) {
                    CategoryListActivity.ingredientsList[3] = "lamb";
                    view.setSelected(true);
                } else {
                    CategoryListActivity.ingredientsList[3] = null;
                    view.setSelected(false);
                } break;


            case R.id.btn_meat_5:
                if (CategoryListActivity.ingredientsList[4] == null) {
                    CategoryListActivity.ingredientsList[4] = "turkey";
                    view.setSelected(true);
                } else {
                    CategoryListActivity.ingredientsList[4] = null;
                    view.setSelected(false);
                } break;


            case R.id.btn_meat_6:
                if (CategoryListActivity.ingredientsList[5] == null) {
                    CategoryListActivity.ingredientsList[5] = "beef steak";
                    view.setSelected(true);
                } else {
                    CategoryListActivity.ingredientsList[5] = null;
                    view.setSelected(false);
                } break;


            case R.id.btn_meat_7:
                if (CategoryListActivity.ingredientsList[6] == null) {
                    CategoryListActivity.ingredientsList[6] = "sausage";
                    view.setSelected(true);
                } else {
                    CategoryListActivity.ingredientsList[6] = null;
                    view.setSelected(false);
                } break;


            case R.id.btn_meat_8:
                if (CategoryListActivity.ingredientsList[7] == null) {
                    CategoryListActivity.ingredientsList[7] = "bacon";
                    view.setSelected(true);
                } else {
                    CategoryListActivity.ingredientsList[7] = null;
                    view.setSelected(false);
                } break;


            case R.id.btn_meat_9:
                if (CategoryListActivity.ingredientsList[8] == null) {
                    CategoryListActivity.ingredientsList[8] = "veal";
                    view.setSelected(true);
                } else {
                    CategoryListActivity.ingredientsList[8] = null;
                    view.setSelected(false);
                } break;


            case R.id.btn_all_back:
                Intent bIntent = new Intent(this, CategoryListActivity.class);
                startActivity(bIntent);
                break;

            case R.id.btn_all_clear:
                for (int i = 0; i < 9; i++){
                    CategoryListActivity.ingredientsList[i] = null;
                }
                for (Button btn : buttons) {
                    btn.setSelected(false);
                }
                Toast.makeText(getApplicationContext(), "Meat ingredients deselected",
                        Toast.LENGTH_SHORT).show();
                break;
        }
    }

    /*public void SaveButtonState(String bState){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("focus_value", bState);
        edit.commit();
    }*/

    /*@Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putBooleanArray("counter_key", bolArray);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        bolArray = savedInstanceState.getBooleanArray("counter_key");
    }*/
}
