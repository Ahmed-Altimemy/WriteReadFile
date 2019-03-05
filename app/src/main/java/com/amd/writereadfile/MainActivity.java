package com.amd.writereadfile;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private MenuItem menu_settings;
    private MenuItem menu_Weight;
    private MenuItem menu_age;
    private MenuItem menu_about;
    private MenuItem menu_BackToMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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
        menu_settings.setVisible(true);
        menu_Weight.setVisible(true);
        menu_age.setVisible(true);
        menu_about.setVisible(true);
        menu_BackToMain.setVisible(false);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        Intent intent;
        //noinspection SimplifiableIfStatement
        switch (id)
        {
            case R.id.menu_settings:
                Toast.makeText(getBaseContext(), "Settings", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_Weight:
                intent = new Intent(MainActivity.this, WeightActivity.class);
                startActivity(intent);
                break;
            case R.id.menu_age:
                intent = new Intent(MainActivity.this, AgeActivity.class);
                startActivity(intent);
                break;
            case R.id.menu_about:
                intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

}
