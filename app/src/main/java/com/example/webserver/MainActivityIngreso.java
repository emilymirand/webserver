package com.example.webserver;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import WebServer.Asynchtask;
import WebServer.WebService;

public class MainActivityIngreso extends AppCompatActivity implements Asynchtask {
    private TextView txtInformacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ingreso);
        txtInformacion = findViewById(R.id.txtMostrar);
        Bundle bundle = this.getIntent().getExtras();
        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService(" https://jsonplaceholder.typicode.com/users"
                ,datos, MainActivityIngreso.this, MainActivityIngreso.this);
        ws.execute("GET");

    }

    @Override
    public void processFinish(String result) throws JSONException {
        String lstUsuario = "";
        JSONArray JSONlista = new JSONArray(result);
        for (int i = 0; i < JSONlista.length(); i++) {
            JSONObject user = JSONlista.getJSONObject(i);
            String nombre = user.getString("name");
            String Usuario = user.getString("username");
            String Correo = user.getString("email");
            String telefono = user.getString("phone");
            String website = user.getString("website");

            lstUsuario = lstUsuario + " (" + i +") "+ "\nNombre: " + nombre +", Usuario:"+Usuario+ "\nCorreo: " +Correo+"\nTelefono: "+telefono+", WebSite: "+website+"\n";
            String LSTUser = lstUsuario;
            new android.os.Handler().postDelayed(new Runnable() {
                public void run() {
                    txtInformacion.setText(LSTUser);
                }
            }
            , (i + 1)*200);
        }
    }
}