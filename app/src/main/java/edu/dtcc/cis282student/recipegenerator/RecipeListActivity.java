package edu.dtcc.cis282student.recipegenerator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;

import java.net.HttpURLConnection;
import java.net.URL;

public class RecipeListActivity extends AppCompatActivity implements View.OnClickListener {
    RecipeListObjects recipeListObjects=new RecipeListObjects();
    CategoryListActivity categoryListActivity=new CategoryListActivity();
    String count="",surname="",age="",username="",password="";
    String type="testing";
    static String testString="";
    String[] Directions;
    int directionNum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);

        String match=recipeListObjects.compareList(categoryListActivity.ingredientsList);
        String[] matchList=match.split("\t");


        for (int i=0;i<matchList.length;i++){
            if (matchList[i].equals("Chili"))
                count=matchList[i];
            else if (matchList[i].equals("Baked salmon"))
                surname=matchList[i];
            else if (matchList[i].equals("Spaghetti sauce with ground beef"))
                age=matchList[i];
            else if (matchList[i].equals("Lemon pepper chicken"))
                username=matchList[i];
            else if (matchList[i].equals("Kofta"))
                password=matchList[i];
        }
        String what="";
        password="sf";
        BackgroundWorker backgroundWorker=new BackgroundWorker(this);
        backgroundWorker.execute(type,count,surname,age,username,password);


        // Buttons
        Button btnRec1 = (Button) findViewById(R.id.btn_output_1);
        Button btnRec2 = (Button) findViewById(R.id.btn_output_2);
        Button btnRec3 = (Button) findViewById(R.id.btn_output_3);
        Button btnRec4 = (Button) findViewById(R.id.btn_output_4);
        Button btnRec5 = (Button) findViewById(R.id.btn_output_5);
        Button btnRec6 = (Button) findViewById(R.id.btn_output_6);
        Button btnRec7 = (Button) findViewById(R.id.btn_output_7);
        Button btnRec8 = (Button) findViewById(R.id.btn_output_8);
        Button btnRec9 = (Button) findViewById(R.id.btn_output_9);
        Button btnBack = (Button) findViewById(R.id.btn_all_back);

        // Button listeners
        btnRec1.setOnClickListener(this);
        btnRec2.setOnClickListener(this);
        btnRec3.setOnClickListener(this);
        btnRec4.setOnClickListener(this);
        btnRec5.setOnClickListener(this);
        btnRec6.setOnClickListener(this);
        btnRec7.setOnClickListener(this);
        btnRec8.setOnClickListener(this);
        btnRec9.setOnClickListener(this);
        btnBack.setOnClickListener(this);
    }

    public void split(){
        if (!testString.equals("")) {
            Directions = testString.split(":");
            directionNum=Directions.length;
        }
    }




    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_output_1:
                split();
                TextView textView=(TextView) findViewById(R.id.textView2);
                if (Directions.length>0){
                    textView.setText(Directions[0]);
                }
                //Intent aIntent = new Intent(this, PopupActivity.class);
                //startActivity(aIntent);
                break;

            case R.id.btn_output_2:
                Intent bIntent = new Intent(this, PopupActivity.class);
                startActivity(bIntent);
                break;

            case R.id.btn_output_3:
                Intent cIntent = new Intent(this, PopupActivity.class);
                startActivity(cIntent);
                break;

            case R.id.btn_output_4:
                Intent dIntent = new Intent(this, PopupActivity.class);
                startActivity(dIntent);
                break;

            case R.id.btn_output_5:
                Intent eIntent = new Intent(this, PopupActivity.class);
                startActivity(eIntent);
                break;

            case R.id.btn_output_6:
                Intent fIntent = new Intent(this, PopupActivity.class);
                startActivity(fIntent);
                break;

            case R.id.btn_output_7:
                Intent gIntent = new Intent(this, PopupActivity.class);
                startActivity(gIntent);
                break;

            case R.id.btn_output_8:
                Intent hIntent = new Intent(this, PopupActivity.class);
                startActivity(hIntent);
                break;

            case R.id.btn_output_9:
                Intent iIntent = new Intent(this, PopupActivity.class);
                startActivity(iIntent);
                break;

            case R.id.btn_all_back:

                break;
        }
    }
}
