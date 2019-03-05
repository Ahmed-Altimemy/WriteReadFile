package com.amd.writereadfile;

import android.content.Intent;
import android.icu.text.DecimalFormat;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.fathzer.soft.javaluator.DoubleEvaluator;

public class AgeActivity extends AppCompatActivity {
    private MenuItem menu_settings;
    private MenuItem menu_Weight;
    private MenuItem menu_about;
    private MenuItem menu_age;
    private MenuItem menu_BackToMain;
    private EditText txtAge;
    private Button btnExcute;
    private TextView lblmercury;
    private TextView lblvenus;
    private TextView lblearth;
    private TextView lblmars;
    private TextView lbljupiter;
    private TextView lblsaturn;
    private TextView lbluranus;
    private TextView lblneptune;
    private TextView lblpluto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        txtAge = (EditText)findViewById(R.id.txtAge);
        btnExcute = (Button)findViewById(R.id.btnExcute);
        lblmercury = (TextView)findViewById(R.id.lblmercury);
        lblvenus = (TextView)findViewById(R.id.lblvenus);
        lblearth = (TextView)findViewById(R.id.lblearth);
        lblmars = (TextView)findViewById(R.id.lblmars);
        lbljupiter = (TextView)findViewById(R.id.lbljupiter);
        lblsaturn = (TextView)findViewById(R.id.lblsaturn);
        lbluranus = (TextView)findViewById(R.id.lbluranus);
        lblneptune = (TextView)findViewById(R.id.lblneptune);
        lblpluto = (TextView)findViewById(R.id.lblpluto);

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
            Intent intent = new Intent(AgeActivity.this, MainActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void Excute(View v)
    {
        DecimalFormat d2 = new DecimalFormat(".##");

        //mercury
        StringBuilder exmercury = new StringBuilder();
        exmercury.append(txtAge.getText().toString());
        exmercury.append("/0.241");
        Double amercury = new DoubleEvaluator().evaluate(exmercury.toString());
        String samercury = d2.format(amercury);
        lblmercury.setText(samercury.toString());

        //venus
        StringBuilder exvenus = new StringBuilder();
        exvenus.append(txtAge.getText().toString());
        exvenus.append("/0.615");
        Double avenus = new DoubleEvaluator().evaluate(exvenus.toString());
        String savenus = d2.format(avenus);
        lblvenus.setText(savenus.toString());

        //earth
        StringBuilder exmoon = new StringBuilder();
        exmoon.append(txtAge.getText().toString());
        StringBuilder append = exmoon.append("/1");
        Double amoon = new DoubleEvaluator().evaluate(exmoon.toString());
        String samoon = d2.format(amoon);
        lblearth.setText(samoon.toString());


        //mars
        StringBuilder exmars = new StringBuilder();
        exmars.append(txtAge.getText().toString());
        exmars.append("/1.881");
        Double amars = new DoubleEvaluator().evaluate(exmars.toString());
        String samars = d2.format(amars);
        lblmars.setText(samars.toString());

        //jupiter
        StringBuilder exjupiter = new StringBuilder();
        exjupiter.append(txtAge.getText().toString());
        exjupiter.append("/11.86");
        Double ajupiter = new DoubleEvaluator().evaluate(exjupiter.toString());
        String sajupiter = d2.format(ajupiter);
        lbljupiter.setText(sajupiter.toString());

        //saturn
        StringBuilder exsaturn = new StringBuilder();
        exsaturn.append(txtAge.getText().toString());
        exsaturn.append("/29.46");
        Double asaturn = new DoubleEvaluator().evaluate(exsaturn.toString());
        String sasaturn = d2.format(asaturn);
        lblsaturn.setText(sasaturn.toString());

        //uranus
        StringBuilder exuranus = new StringBuilder();
        exuranus.append(txtAge.getText().toString());
        exuranus.append("/84.01");
        Double auranus = new DoubleEvaluator().evaluate(exuranus.toString());
        String sauranus = d2.format(auranus);
        lbluranus.setText(sauranus.toString());

        //neptune
        StringBuilder exneptune = new StringBuilder();
        exneptune.append(txtAge.getText().toString());
        exneptune.append("/164.8");
        Double aneptune = new DoubleEvaluator().evaluate(exneptune.toString());
        String saneptune = d2.format(aneptune);
        lblneptune.setText(saneptune.toString());

        //pluto
        StringBuilder expluto = new StringBuilder();
        expluto.append(txtAge.getText().toString());
        expluto.append("/248.6");
        Double apluto = new DoubleEvaluator().evaluate(expluto.toString());
        String sapluto = d2.format(apluto);
        lblpluto.setText(sapluto.toString());
    }
}
