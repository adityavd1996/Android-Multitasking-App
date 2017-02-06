package com.example.adityavd.androidprojects;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.util.Scanner;

public class FileTest extends AppCompatActivity {
TextView tv6,tv7;
    EditText ed2,ed3;
    Button add,search,delete,create;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_test);
    tv6=(TextView)findViewById(R.id.textView6);
        tv7=(TextView)findViewById(R.id.textView7);
        ed2=(EditText)findViewById(R.id.editText2);
        ed3=(EditText)findViewById(R.id.editText3);
        add=(Button)findViewById(R.id.add);
        create=(Button)findViewById(R.id.create);
        search=(Button)findViewById(R.id.search);
        delete=(Button)findViewById(R.id.delete);

    add.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Scanner sc=new Scanner(System.in);
            String fname=sc.nextLine();
            File f=new File(fname);

        }
    });
    }


}
