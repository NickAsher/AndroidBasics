package com.example.contentprovider1_implementation;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Activity_Contacts extends AppCompatActivity {
    ContentResolver contentResolver ;
    TextView resultTextView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        getReferences();

        contentResolver = getContentResolver() ;
    }

    private void getReferences(){
        resultTextView = findViewById(R.id.activityContentProvider_TextView_Result) ;

    }

    public void showAllContacts(View v){
        Uri tableUri = ContactsContract.Contacts.CONTENT_URI ; // => Uri.parse("content://user_dictionary/words") ;
        String[] arrayOfColumnNames = {
                ContactsContract.Contacts._ID,
                ContactsContract.Contacts.DISPLAY_NAME,
//                ContactsContract.CommonDataKinds.Phone.NUMBER,

        } ;

        String sortOrder = ContactsContract.Contacts.DISPLAY_NAME + " DESC" ;

        Cursor cursor = contentResolver.query(tableUri, arrayOfColumnNames, null, null, sortOrder) ;
        Toast.makeText(this, "Count is " + cursor.getCount(), Toast.LENGTH_SHORT).show() ;
        while(cursor.moveToNext()){
            String a0 = cursor.getString(0) ;
            String a1 = cursor.getString(1) ;
            String a2 = "" ; // cursor.getString(2) ;


            resultTextView.append(a0 + " - " + a1 + " - " + a2  + "\n");
        }
        cursor.close();
    }






}