package edu.dtcc.cis282student.recipegenerator;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;

/**
 * Created by Ben on 3/28/2017.
 */

public class BackgroundWorker extends AsyncTask<String,Void,String> {
    RecipeListActivity recipeListActivity=new RecipeListActivity();
    Context context;
    AlertDialog alertDialog;
    BackgroundWorker(Context ctx) {
        context = ctx;
    }
    @Override
    protected String doInBackground(String... params) {
        String type = "testing";

        if(type.equals("testing")){
            try {
                String name = params[1];
                String surname = params[2];
                String age = params[3];
                String username = params[4];
                String password = params[5];
                URL url = new URL("http://76.98.61.23/testing.php");
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);

                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(httpURLConnection.getOutputStream(), "UTF-8"));
                String post_data = URLEncoder.encode("name", "UTF-8")+"="+URLEncoder.encode(name,"UTF-8")+"&"
                        + URLEncoder.encode("surname", "UTF-8")+"="+URLEncoder.encode(surname,"UTF-8")+"&"
                        + URLEncoder.encode("age", "UTF-8")+"="+URLEncoder.encode(age,"UTF-8")+"&"
                        + URLEncoder.encode("username", "UTF-8")+"="+URLEncoder.encode(username,"UTF-8")+"&"
                        +URLEncoder.encode("password", "UTF-8")+"="+URLEncoder.encode(password,"UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";
                while((line = bufferedReader.readLine())!= null){
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("LoginStatus");
    }

    @Override
    protected void onPostExecute(String result) {
        recipeListActivity.testString+=result;
        alertDialog.setMessage("Recipes found!");
        alertDialog.show();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
