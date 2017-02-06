package com.example.adityavd.androidprojects;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, act);
        setListAdapter(adapter);
    }
    String act[] = {"ServiceTest","MyProject","BroadcastActivity","WifiTest","ContentProviderTest","DBTest","SensorTest2","Sensor1Test","SensorActivity","PreferenceTest","ContextMenuTest","MediaPlayerTest","OptionMenuTest","PopupMenuTest","RadioButtonTest","Temperature" ,"LoginActivity","SeekBarTest","CheckBoxTest","Counter","Calculator","Switch"};
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id)
    {
        super.onListItemClick(l, v, position, id);
        String s="com.example.adityavd.androidprojects."+act[position];
        try
        {
            Class c=Class.forName(s);
            Intent intent=new Intent(this,c);
            startActivity(intent);
        }catch (Exception e){e.printStackTrace();
        }
    }
}


