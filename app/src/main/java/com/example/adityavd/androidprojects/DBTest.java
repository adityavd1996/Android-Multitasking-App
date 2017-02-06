package com.example.adityavd.androidprojects;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DBTest extends AppCompatActivity {
EditText ed1,ed2,ed3,ed4;
    SQLiteDatabase sd;
    Cursor c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dbtest);
    ed1=(EditText)findViewById(R.id.sid);
        ed2=(EditText)findViewById(R.id.sname);
        ed3=(EditText)findViewById(R.id.sbranch);
        ed4=(EditText)findViewById(R.id.sage);

        sd=openOrCreateDatabase("mydb",MODE_PRIVATE,null);
        sd.execSQL("create table if not exists student(sid int primary key,"+"sname varchar not null,sbranch varchar not null,sage int(2) not null");
        c=sd.rawQuery("select *from student",null);

    }
public void add(View v)
{
    try{
        int sid=Integer.parseInt(ed1.getText().toString());
        String sname=ed2.getText().toString();
        String sbranch=ed3.getText().toString();
        int sage=Integer.parseInt(ed4.getText().toString());
        sd.execSQL("insert into student vaues(" + sid + ",'" + sname + "','" + sbranch + "'," + sage );
        Toast.makeText(DBTest.this,"Data Added",Toast.LENGTH_SHORT).show();
    }catch(Exception e){
        Toast.makeText(DBTest.this,"Database Corruption Error",Toast.LENGTH_SHORT).show();
    }
c=sd.rawQuery("select from student",null);
}

public void search(View v){

        ed2.setText("");

    ed3.setText("");
    ed4.setText("");
    int sid=Integer.parseInt(ed1.getText().toString());
        Cursor c=sd.rawQuery("select * from student where sid="+sid+"",null);
        if(c.moveToNext())
        {
            ed1.setText(" "+c.getInt(0));
            ed2.setText(c.getInt(1));
            ed3.setText(c.getInt(2));
            ed4.setText(" "+c.getInt(3));

        }else
            Toast.makeText(DBTest.this,"NO Record Found",Toast.LENGTH_SHORT).show();
}




    public void next(View v)
{
     if (c.moveToNext()) {
         ed1.setText(" " + c.getInt(0));
         ed2.setText( c.getInt(1));
         ed3.setText( c.getInt(2));
         ed4.setText(" " + c.getInt(3));

     }

}
public  void first(View v){

    if(c.moveToFirst()){
        ed1.setText(" "+c.getInt(0));
        ed2.setText(c.getInt(1));
        ed3.setText(c.getInt(2));
        ed4.setText(" "+c.getInt(3));


    }
    }

    public void previous(View v) {
        if (c.moveToPrevious()) {
            ed1.setText(" " + c.getInt(0));
            ed2.setText(c.getInt(1));
            ed3.setText(c.getInt(2));
            ed4.setText(" " + c.getInt(3));


        }
    }

    public void last(View v){

        if(c.moveToLast()){
        ed1.setText(" "+c.getInt(0));
        ed2.setText(c.getInt(1));
        ed3.setText(c.getInt(2));
        ed4.setText(" "+c.getInt(3));


        }
    }
}

