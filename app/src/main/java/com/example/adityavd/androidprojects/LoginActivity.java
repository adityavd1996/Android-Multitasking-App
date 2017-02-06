package com.example.adityavd.androidprojects;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText username, password;
    TextView tv;
    Button login;
    AlertDialog.Builder adb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = (EditText) findViewById(R.id.name);
        password = (EditText) findViewById(R.id.pass);
        login = (Button) findViewById(R.id.button);
        tv = (TextView) findViewById(R.id.res);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                adb = new AlertDialog.Builder(LoginActivity.this);
                adb.setMessage("ARE YOU SURE ?");
                adb.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        String uname = username.getText().toString();
                        String pass = password.getText().toString();
                        if (uname.isEmpty() | pass.isEmpty()) {
                            tv.setText("No field must be empty");
                            tv.setTextColor(Color.RED);
                        } else if (uname.equalsIgnoreCase(pass)) {
                            Intent intent=new Intent(LoginActivity.this,WelcomeActivity.class);
                            intent.putExtra("un",uname);
                            startActivity(intent);
                            tv.setText("LOGIN Successful");
                            tv.setTextColor(Color.GREEN);
                        } else {
                            tv.setText("PASSWORD is incorrect");
                            tv.setTextColor(Color.RED);
                        }


                    }
                });

                adb.setNegativeButton("NO",new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which){
                        Toast.makeText(LoginActivity.this," ",Toast.LENGTH_SHORT);

                    }
                });

                AlertDialog a=adb.create();
                a.show();
            }
        });
    }
}
