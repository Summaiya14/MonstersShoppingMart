package com.example.mart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddressActivity extends AppCompatActivity {

    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;
    DatabaseHelper MyDBhelper;
    EditText editFname, editLname, editPhone, editAddress;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        openHelper = new DatabaseHelper(this);
        db = openHelper.getReadableDatabase();

        editFname = findViewById(R.id.firstname);
        editLname = findViewById(R.id.lastname);
        editPhone = findViewById(R.id.phone);

    }

    public void submit(View view) {



        String fname = editFname.getText().toString();
        String lname = editLname.getText().toString();
        String phone = editPhone.getText().toString();
        
        cursor = db.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_NAME + " WHERE " + DatabaseHelper.COL_2 + "=? AND " + DatabaseHelper.COL_3 + "=? AND " + DatabaseHelper.COL_6 + "=?", new String[]{fname, lname, phone});
        if(cursor!=null){
            if (cursor.getCount() > 0){
                cursor.moveToNext();
                Toast.makeText(this, "Thank You For Ordering! ", Toast.LENGTH_SHORT).show();


            } else {
                Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_SHORT).show();
            }
        }

    }
}
