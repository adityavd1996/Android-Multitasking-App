package com.example.adityavd.androidprojects;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class PreferenceTest extends AppCompatActivity {
EditText editText;
   SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference_test);
    editText=(EditText)findViewById(R.id.editText);
        sp=getSharedPreferences("MYPREF",MODE_PRIVATE);
        editText.setText(sp.getString("my"," "));
    }

    @Override
    protected void onStop() {
        super.onStop();
    String data=editText.getText().toString();
        SharedPreferences.Editor se=sp.edit();
        se.putString("my",data);
        se.commit();

    }
}


