package com.intelliskye.www.earnd;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private float accomplishments = 0;
    private float rewards = 1;
    private float ratio = accomplishments / rewards;
    private String ratioString = "1";

    public float getAccomplishments(){
        return accomplishments;
    }

    public void upAccomplishments(){
        accomplishments++;
    }

    public void setAccomplishments(float num){
        accomplishments = num;
    }

    public float getRewards(){
        return rewards;
    }

    public void upRewards(){
        rewards++;
    }

    public void setRewards(float num){
        rewards = num;
    }

    public void updateRatio(float acc, float rew){
        ratio = (acc/(acc+rew))*100;
       // return ratio;
    }

    public String getRatioString(){
        return ratioString;
    }

    public void setRatioString(){
        ratioString = String.format("%.2f", ratio);
       // ratioString = String.valueOf(ratio);

    }
    public void greenButtonClicked(View v){
        upAccomplishments();
        updateRatio(getAccomplishments(), getRewards());
        setRatioString();
        TextView t = (TextView)findViewById(R.id.ratioText);
        t.setText(ratioString+"%");
        TextView p = (TextView)findViewById(R.id.greenText);
        p.setText(getAccomplishments()+"");
    }

    public void redButtonClicked(View v){
        upRewards();
        updateRatio(getAccomplishments(), getRewards());
        setRatioString();
        TextView t = (TextView)findViewById(R.id.ratioText);
        t.setText(ratioString+"%");
        TextView q = (TextView)findViewById(R.id.redText);
        q.setText(getRewards()+"");
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
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
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
