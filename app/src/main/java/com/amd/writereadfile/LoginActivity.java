package com.amd.writereadfile;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText txtUserName,txtPassword;
    private Button btnLogin;
    private MenuItem menu_settings;
    private MenuItem menu_Weight;
    private MenuItem menu_age;
    private MenuItem menu_about;
    private MenuItem menu_BackToMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        txtUserName=(EditText) findViewById(R.id.txtUserName);
        txtPassword=(EditText) findViewById(R.id.txtPassword);
        btnLogin=(Button)findViewById(R.id.btnLogin);


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
        menu_BackToMain.setVisible(false);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.menu_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void Login(View v)
    {
        if (!txtUserName.getText().toString().equals("") && !txtPassword.getText().toString().equals("")) {
            if (txtUserName.getText().toString().equals("ahmed") && txtPassword.getText().toString().equals("1010")) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(getApplicationContext(), "User Name And/Or Password Incorrect", Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(getApplicationContext(), "Please Fill User Name And Password Fields", Toast.LENGTH_SHORT).show();
        }
    }
}
