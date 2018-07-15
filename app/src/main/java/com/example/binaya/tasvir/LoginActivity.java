package com.example.binaya.tasvir;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.binaya.tasvir.Models.UserData;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;


/**
 * Created by Binaya on 7/15/18.
 */

public class LoginActivity extends Activity {

    public static final String Base_URL = "http://192.168.123.2/api/";

    Button btn;
    EditText username;
    EditText password;

    private Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        btn = findViewById(R.id.login_btn);
        username = findViewById(R.id.edit_username);
        password = findViewById(R.id.password);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getUsername, getPassword;
                getUsername = username.getText().toString();
                getPassword = password.getText().toString();


                JsonObject json = new JsonObject();
                json.addProperty("email", getUsername);
                json.addProperty("password", getPassword);
                Ion.with(getApplicationContext())
                        .load("POST", Base_URL + "login")
                        .setJsonObjectBody(json)
                        .asJsonObject()
                        .setCallback(new FutureCallback < JsonObject > () {
                            @Override
                            public void onCompleted(Exception e, JsonObject result) {
                                if (e != null) {
                                    Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
                                } else {
                                    int status = result.get("status").getAsInt();
                                    if (status == 202) {
                                        Intent i = new Intent(getApplicationContext(), MainActivity.class);

                                        Gson gson = new Gson();
                                        UserData data = gson.fromJson(result, UserData.class);
                                        //                                        Log.d("User", "onCompleted: "+data.getUser().getName());
                                        i.putExtra("Data", data.getUser());
                                        startActivity(i);
                                    }
                                }
                            }
                        });
            }
        });




    }
}