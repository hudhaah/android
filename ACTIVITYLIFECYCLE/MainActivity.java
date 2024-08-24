package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button btn;
        btn = (Button) findViewById(R.id.button4);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnOnclick();
            }
        });
        Log.i("My tag", "oncreate");
        Toast.makeText(this, "oncreate", Toast.LENGTH_SHORT).show();
    }
    private void btnOnclick()
    {
        Intent intent=new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
    @Override
    protected void onRestart()
    {
        super.onRestart();
        Log.i("My tag", "onrestart");
        Toast.makeText(this, "onrestart", Toast.LENGTH_SHORT).show();

    }
    @Override
    protected void onPause()
    {
        super.onPause();
        Log.i("My tag", "onpause");
        Toast.makeText(this, "onpause", Toast.LENGTH_SHORT).show();

    }
    @Override
    protected void onStart()
    {
        super.onStart();
        Log.i("My tag", "onstart");
        Toast.makeText(this, "onstart", Toast.LENGTH_SHORT).show();

    }
    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Log.i("My tag", "ondestroy");
        Toast.makeText(this, "ondestroy", Toast.LENGTH_SHORT).show();

    }
    @Override
    protected void onStop()
    {
        super.onStop();
        Log.i("My tag", "onstop");
        Toast.makeText(this, "onstop", Toast.LENGTH_SHORT).show();

    }
    @Override
    protected void onResume()
    {
        super.onResume();
        Log.i("My tag", "onresume");
        Toast.makeText(this, "onresume", Toast.LENGTH_SHORT).show();
    }

    }

