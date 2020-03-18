package com.example.mart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    DatabaseHelper MyDBhelper;
    EditText editFirstname, editLastname, editEmail, editPassword, editPhone;
    Button buttonlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        MyDBhelper = new DatabaseHelper(this);

        editFirstname = findViewById(R.id.first_name);
        editLastname = findViewById(R.id.last_name);
        editEmail = findViewById(R.id.email);
        editPassword = findViewById(R.id.pswd);
        editPhone = findViewById(R.id.phone);
        buttonlogin = findViewById(R.id.login2);
    }

    public void signUp(View view){

        MyDBhelper.insertData(editFirstname.getText().toString(),editLastname.getText().toString(),editEmail.getText().toString(),editPassword.getText().toString(),editPhone.getText().toString());
        Toast.makeText(getApplicationContext(), "Registered successfully",Toast.LENGTH_LONG).show();
        if (editFirstname.getText().toString().isEmpty()){
            Toast.makeText(this, "enter your details", Toast.LENGTH_SHORT).show();
        }

        else if (editLastname.getText().toString().isEmpty()){
            Toast.makeText(this, "enter your details", Toast.LENGTH_SHORT).show();
        }

        else if (editEmail.getText().toString().isEmpty()){
            Toast.makeText(this, "enter your details", Toast.LENGTH_SHORT).show();
        }

        else if (editPassword.getText().toString().isEmpty()){
            Toast.makeText(this, "enter your details", Toast.LENGTH_SHORT).show();
        }

        else if (editPhone.getText().toString().isEmpty()){
            Toast.makeText(this, "enter your details", Toast.LENGTH_SHORT).show();
        }

        buttonlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }
}
