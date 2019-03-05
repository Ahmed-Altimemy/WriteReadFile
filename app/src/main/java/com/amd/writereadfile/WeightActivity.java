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

public class WeightActivity extends AppCompatActivity {
    private MenuItem menu_settings;
    private MenuItem menu_Weight;
    private MenuItem menu_about;
    private MenuItem menu_age;
    private MenuItem menu_BackToMain;
    private EditText txtWeight;
    private Button btnExcute;
    private TextView lblmercury;
    private TextView lblvenus;
    private TextView lblmoon;
    private TextView lblmars;
    private TextView lbljupiter;
    private TextView lblsaturn;
    private TextView lbluranus;
    private TextView lblneptune;
    private TextView lblpluto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        txtWeight = (EditText)findViewById(R.id.txtWeight);
        btnExcute = (Button)findViewById(R.id.btnExcute);
        lblmercury = (TextView)findViewById(R.id.lblmercury);
        lblvenus = (TextView)findViewById(R.id.lblvenus);
        lblmoon = (TextView)findViewById(R.id.lblmoon);
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
            Intent intent = new Intent(WeightActivity.this, MainActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void Excute(View v)
    {
        DecimalFormat d2 = new DecimalFormat(".##");
        //double g = txtWeight.getText().toString() / 9.8;
        StringBuilder expression = new StringBuilder();
        expression.append(txtWeight.getText().toString());
        expression.append("/9.8");
        Double g = new DoubleEvaluator().evaluate(expression.toString());

        //mercury
        StringBuilder exmercury = new StringBuilder();
        exmercury.append(g.toString());
        exmercury.append("*3.7");
        Double wmercury = new DoubleEvaluator().evaluate(exmercury.toString());
        String swmercury = d2.format(wmercury);
        lblmercury.setText(swmercury.toString());

        //venus
        StringBuilder exvenus = new StringBuilder();
        exvenus.append(g.toString());
        exvenus.append("*8.87");
        Double wvenus = new DoubleEvaluator().evaluate(exvenus.toString());
        String swvenus = d2.format(wvenus);
        lblvenus.setText(swvenus.toString());

        //moon
        StringBuilder exmoon = new StringBuilder();
        exmoon.append(g.toString());
        exmoon.append("*1.62");
        Double wmoon = new DoubleEvaluator().evaluate(exmoon.toString());
        String swmoon = d2.format(wmoon);
        lblmoon.setText(swmoon.toString());

        //mars
        StringBuilder exmars = new StringBuilder();
        exmars.append(g.toString());
        exmars.append("*3.71");
        Double wmars = new DoubleEvaluator().evaluate(exmars.toString());
        String swmars = d2.format(wmars);
        lblmars.setText(swmars.toString());

        //jupiter
        StringBuilder exjupiter = new StringBuilder();
        exjupiter.append(g.toString());
        exjupiter.append("*24.79");
        Double wjupiter = new DoubleEvaluator().evaluate(exjupiter.toString());
        String swjupiter = d2.format(wjupiter);
        lbljupiter.setText(swjupiter.toString());

        //saturn
        StringBuilder exsaturn = new StringBuilder();
        exsaturn.append(g.toString());
        exsaturn.append("*10.44");
        Double wsaturn = new DoubleEvaluator().evaluate(exsaturn.toString());
        String swsaturn = d2.format(wsaturn);
        lblsaturn.setText(swsaturn.toString());

        //uranus
        StringBuilder exuranus = new StringBuilder();
        exuranus.append(g.toString());
        exuranus.append("*8.87");
        Double wuranus = new DoubleEvaluator().evaluate(exuranus.toString());
        String swuranus = d2.format(wuranus);
        lbluranus.setText(swuranus.toString());

        //neptune
        StringBuilder exneptune = new StringBuilder();
        exneptune.append(g.toString());
        exneptune.append("*11.15");
        Double wneptune = new DoubleEvaluator().evaluate(exneptune.toString());
        String swneptune = d2.format(wneptune);
        lblneptune.setText(swneptune.toString());

        //pluto
        StringBuilder expluto = new StringBuilder();
        expluto.append(g.toString());
        expluto.append("*0.62");
        Double wpluto = new DoubleEvaluator().evaluate(expluto.toString());
        String swpluto = d2.format(wpluto);
        lblpluto.setText(swpluto.toString());
    }
}
