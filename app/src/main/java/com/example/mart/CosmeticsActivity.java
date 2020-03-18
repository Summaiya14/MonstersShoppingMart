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

public class CosmeticsActivity extends AppCompatActivity {

    Button button;
    ListView listView;
    String[] names = {"Brand Name: Huda Beauty", "Brand Name: Loreal", "Brand Name: Huda Beauty", "Brand Name: Maybelline", "Brand Name: Huda Beauty"};
    String[] description = {"Huda beauty makeup kit", "Metallic highlighter illuminateur", "Mate lipstics in 12 colors", "Beauty products", "Eye shadows"};
    String[] price = {"10000", "3500", "5500", "4500","3500"};
    int[] images = {R.drawable.hudakit, R.drawable.loreal, R.drawable.hudalipstic, R.drawable.maybelling, R.drawable.hudashadow};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cosmetics);

        listView = findViewById(R.id.listview);

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
            super(c, R.layout.customlayoutperfume, R.id.textView1, names);

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
                    Toast.makeText(CosmeticsActivity.this, "Added to cart! Click on the item", Toast.LENGTH_SHORT).show();
                }
            });

            imageView.setImageResource(images[position]);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(CosmeticsActivity.this, description[position], Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(CosmeticsActivity.this, CartActivity.class);
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
