package com.example.adityavd.androidprojects;

import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ContextMenuTest extends AppCompatActivity {

String name[]={"AVD","AP","AJL","GHOUL"};
    ListView listView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_menu_test);

listView=(ListView)findViewById(R.id.listView);
        ArrayAdapter<String>adapter=new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,name);
        listView.setAdapter(adapter);
    registerForContextMenu(listView);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Select any option");
        menu.add(0,v.getId(),0,"CALL");
        menu.add(0,v.getId(),0,"SMS");

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Toast.makeText(ContextMenuTest.this,"You have selected "+item.getTitle().toString(),Toast.LENGTH_SHORT).show();
        return true;
    }

}
