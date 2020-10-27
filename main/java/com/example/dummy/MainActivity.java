package com.example.dummy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText textview;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textview = (EditText) findViewById(R.id.text);
        button = (Button) findViewById(R.id.button);

        SharedPreferences sharedpref = getPreferences(Context.MODE_PRIVATE);
        String OldItem = sharedpref.getString("OldItem","nothing created yet...");

        textview.setText(OldItem);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedpref.edit();
                editor.putString("OldItem", textview.getText().toString());
                editor.commit();

                Animation ani = new AlphaAnimation(1.0f, 0.0f);
                ani.setDuration(1000);
                button.startAnimation(ani);

                Log.d("DEBUG","button clicked");
            }
        });
    }
}