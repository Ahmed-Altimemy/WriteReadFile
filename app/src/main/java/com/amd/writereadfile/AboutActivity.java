package com.amd.writereadfile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.security.PrivateKey;

public class AboutActivity extends AppCompatActivity {
    private MenuItem menu_settings;
    private MenuItem menu_Weight;
    private MenuItem menu_about;
    private MenuItem menu_age;
    private MenuItem menu_BackToMain;
    private EditText txtComment;
    private Button btnSaveRetrive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        txtComment = (EditText)findViewById(R.id.txtComment);
        btnSaveRetrive = (Button)findViewById(R.id.btnSaveRetrive);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        menu_settings = menu.findItem(R.id.menu_settings);
        menu_Weight = menu.findItem(R.id.menu_Weight);
        menu_age = menu.findItem(R.id.menu_age);
        menu_about = menu.findItem(R.id.menu_about);
        menu_BackToMain = menu.findItem(R.id.menu_BackToMain);
        menu_settings.setVisible(false);
        menu_Weight.setVisible(false);
        menu_age.setVisible(false);
        menu_about.setVisible(false);
        menu_BackToMain.setVisible(true);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.menu_BackToMain) {
            Intent intent = new Intent(AboutActivity.this, MainActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    private void writeToFile(String data, Context context) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("comment.txt", Context.MODE_PRIVATE));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
            Toast.makeText(getBaseContext(), "Save", Toast.LENGTH_SHORT).show();
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }
    private void readFromFile(Context context) {

        String retFileContent = "";
        try {
            InputStream inputStream = context.openFileInput("comment.txt");

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    stringBuilder.append(receiveString);
                    stringBuilder.append("\n");
                }
                inputStream.close();
                retFileContent = stringBuilder.toString();
            }
            Toast.makeText(getBaseContext(), "Retrive", Toast.LENGTH_SHORT).show();
        }
        catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        }
        txtComment.setText(retFileContent);
    }

    public void SaveRetrive(View v)
    {
        Toast.makeText(getBaseContext(), txtComment.getText().toString(), Toast.LENGTH_SHORT).show();
        if (txtComment.getText().toString().trim().length() > 0) {
            writeToFile(txtComment.getText().toString(),this);
        }
        else{
            readFromFile(this);
        }
    }
}
