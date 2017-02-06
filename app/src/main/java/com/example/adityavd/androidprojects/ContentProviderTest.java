package com.example.adityavd.androidprojects;

import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ContentProviderTest extends AppCompatActivity {
Cursor c;
    ListView l;
    List<String>list=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_provider_test);

        l = (ListView) findViewById(R.id.listView2);
        c = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, null, null, null, ContactsContract.PhoneLookup.DISPLAY_NAME);
        while (c.moveToNext()) {
            int i = c.getColumnIndex(ContactsContract.PhoneLookup.DISPLAY_NAME);

            list.add(c.getString(i));

        int j=c.getColumnIndex(ContactsContract.PhoneLookup.TIMES_CONTACTED);
            list.add(c.getString(j));
        }

        ArrayAdapter<String>adapter=new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,list);
        l.setAdapter(adapter);
        }

    }

