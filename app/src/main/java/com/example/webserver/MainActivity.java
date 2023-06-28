package com.example.webserver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import WebServer.Asynchtask;
import WebServer.WebService;

public class MainActivity extends AppCompatActivity

{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void btIngresar(View view)
    {

        Intent intent=new Intent(MainActivity.this, MainActivityIngreso.class);
        startActivity(intent);


    }
}
