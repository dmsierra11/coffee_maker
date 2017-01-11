package com.dmsierraf.coffeeapp;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;

import com.bumptech.glide.Glide;
import com.dmsierraf.coffeeapp.API.RestClientPublic;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    @BindView(R.id.btn_start)
    ImageButton btn_start;
    private String signal;
    private boolean coffee_on;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Glide.with(this).load(R.drawable.coffee_on).override(300, 300).into(btn_start);
        btn_start.setContentDescription(getString(R.string.turn_on));
    }

    @OnClick(R.id.btn_start)
    public void sendSignal(){
        if (!coffee_on){
            signal = "COFFEE_ON";
            coffee_on = true;
            Glide.with(this).load(R.drawable.coffee_off).override(300, 300).into(btn_start);
            btn_start.setContentDescription(getString(R.string.turn_off));
        } else {
            signal = "COFFEE_OFF";
            coffee_on = false;
            Glide.with(this).load(R.drawable.coffee_on).override(300, 300).into(btn_start);
            btn_start.setContentDescription(getString(R.string.turn_on));
        }
        RestClientPublic.getClient().getApiService().sendSignal("GAZGW3OVZ7X0VNT6", signal)
                .enqueue(new Callback<String>() {

                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        Log.d(TAG, "Response");
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Log.d(TAG, "Failed");
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
