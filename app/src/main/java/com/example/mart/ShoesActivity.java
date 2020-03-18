package com.example.mart;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class ShoesActivity extends AppCompatActivity {

    Button button;
    ListView listView;
    String[] names = {"Brand Name: Bata", "Brand Name: Ndure", "Brand Name: Bata", "Brand Name: Ndure", "Brand Name: Bata"};
    String[] description = {"Suede loafers with tassel trim", "Rich leather and soft suede", "Lace-up hybrid sneakers", "Mixed leather sneakers", "sneakers in italian suede"};
    String[] price = {"3000", "3500", "2500", "3500", "4000"};
    int[] images = {R.drawable.bata, R.drawable.ndure, R.drawable.batathree, R.drawable.ndurebbb, R.drawable.batatwo};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoes);

        ListView listView = (ListView) findViewById(R.id.listview);

        MyAdapter adapter = new MyAdapter(this, names, description, price, images);
        listView.setAdapter(adapter);



    }

    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String names[];
        String description[];
        String price[];
        int images[];

        MyAdapter(Context c, String names[], String description[], String price[], int images[]){
            super(c, R.layout.customlayoutshoes, R.id.textView1, names);

            this.context = c;
            this.names = names;
            this.description = description;
            this.price = price;
            this.images = images;

        }

        @NonNull
        @Override
        public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = layoutInflater.inflate(R.layout.customlayoutwatch, parent, false);
            final ImageView imageView = view.findViewById(R.id.imageView);
            TextView textView1 = view.findViewById(R.id.textView1);
            TextView textView2 = view.findViewById(R.id.textView2);
            TextView textView3 = view.findViewById(R.id.textView3);
            button = view.findViewById(R.id.button);
            textView1.setText(names[position]);
            textView2.setText(description[position]);
            textView3.setText(price[position]);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(ShoesActivity.this, "Added to cart! Click on the item", Toast.LENGTH_SHORT).show();
                }
            });

            imageView.setImageResource(images[position]);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(ShoesActivity.this, description[position], Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ShoesActivity.this, CartActivity.class);
                    intent.putExtra("tooba",names[position]);
                    intent.putExtra("dua",description[position]);
                    intent.putExtra("affan",price[position]);
                    intent.putExtra("maham",images[position]);
                    startActivity(intent);
                }
            });

            return view;
        }
    }
}
