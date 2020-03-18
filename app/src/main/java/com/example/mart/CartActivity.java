package com.example.mart;

import android.content.Intent;
import android.graphics.Bitmap;
import android.location.Address;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CartActivity extends AppCompatActivity {

    TextView afnan;

    TextView textView;
    Button minus;
    Button plus;
    int counter;
    int price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        textView = findViewById(R.id.quantity);
        afnan = findViewById(R.id.afnan);

        minus = findViewById(R.id.minus);
        plus = findViewById(R.id.plus);
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                minusCounter();
               // int num = Integer.parseInt(p);
               // afnan.setText(String.valueOf(counter*num));

            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plusCounter();

            }
        });

        initCounter();

        //ListView list=findViewById(R.id.listview1);
        ArrayList<Integer> names=new ArrayList<>();
        ImageView imageView = (ImageView) findViewById(R.id.imageconfrm);
        Intent intent = getIntent();
        TextView textView = findViewById(R.id.text_name);
        TextView textView1 = findViewById(R.id.text_des);
        TextView textView2 = findViewById(R.id.text_price);
        //TextView textView3 = findViewById(R.id.afnan);



        Bundle bundle = getIntent().getExtras();
        if (bundle!=null){
            int summaiya = bundle.getInt("maham");
            String n=intent.getStringExtra("tooba");
            String d = intent.getStringExtra("dua");
            String p = intent.getStringExtra("affan");

            Toast.makeText(CartActivity.this, "added", Toast.LENGTH_SHORT).show();
            names.add(summaiya);

            imageView.setImageResource(summaiya);
            textView.setText(n);
            textView1.setText(d);
            textView2.setText(p);
            //textView3.setText(p);

             price = Integer.parseInt(p);

        }


    }





    private void initCounter() {
        counter = 0;
        textView.setText(counter + "");

    }

    public void plusCounter(){
        counter++;
        textView.setText(counter + "");
        int mm=price*counter;
        afnan.setText("Total Price: Rs "+String.valueOf(mm));



    }

    public void minusCounter(){
        counter --;
        textView.setText(counter + "");
        int mm=price*counter;
        afnan.setText(String.valueOf(mm));


    }






    public void confirm(View view) {
        Toast.makeText(this, "Your order has been confirmed", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(CartActivity.this, AddressActivity.class);
        startActivity(intent);

    }

}