package com.example.binaya.tasvir;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.binaya.tasvir.Models.User;
import com.mikhaellopez.circularimageview.CircularImageView;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    private final String imgUrl ="http://192.168.123.2/uploads/avatars/";
    TextView name, username, email;
    CircularImageView avatarImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_layout);

        name = findViewById(R.id.text_name);
        username = findViewById(R.id.text_username);
        email=findViewById(R.id.text_email);
        avatarImg = findViewById(R.id.image);


        Intent intent = getIntent();
        User user = (User) intent.getSerializableExtra("Data");

        name.setText("Name: "+user.getName());
        username.setText("Username: "+user.getUsername());
        email.setText("Email: "+user.getEmail());
        Picasso.get().load(imgUrl+user.getAvatar()).into(avatarImg);

        Log.d("akldsjfalksdfj", "onCreate: "+imgUrl+user.getAvatar());

    }


    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }
}
