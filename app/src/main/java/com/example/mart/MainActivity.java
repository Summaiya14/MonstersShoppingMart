package com.example.mart;

import android.content.Intent;
import android.os.Bundle;


import com.example.mart.ui.home.HomeFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    ////private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ////frameLayout = findViewById(R.id.main_framelayout);
        ////setFragment(new HomeFragment());
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_tools, R.id.nav_share, R.id.nav_send)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    ///case R.id.nav_home:
                       /// Toast.makeText(MainActivity.this, "done", Toast.LENGTH_LONG).show();
                        ///return true;

                    case R.id.nav_slideshow:
                        Intent intent = new Intent(MainActivity.this, StartActivity.class);
                        startActivity(intent);
                        return true;

                    case R.id.nav_tools:
                        Intent intent1 = new Intent(MainActivity.this, MapsActivity.class);
                        startActivity(intent1);

                    default:
                        return false;
                }
            }
        });


    }

    ///private void setFragment(Fragment fragment){
       /// FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        ///fragmentTransaction.replace(frameLayout.getId(),fragment);
        ////fragmentTransaction.commit();
    ////}



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

//    @Override
//    public boolean onNavigationItemSelected(MenuItem item){
//
//    }









    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void clickPerfume(View view) {
        Intent intent = new Intent(MainActivity.this, PerfumeActivity.class);
        startActivity(intent);
    }

    public void clickWatch(View view) {
        Intent intent = new Intent(MainActivity.this, WatchActivity.class);
        startActivity(intent);

    }

    public void clickShoes(View view) {
        Intent intent = new Intent(MainActivity.this, ShoesActivity.class);
        startActivity(intent);
    }

    public void clickCloth(View view) {
        Intent intent = new Intent(MainActivity.this, ClothActivity.class);
        startActivity(intent);
    }

    public void clickCosmetics(View view) {
        Intent intent = new Intent(MainActivity.this, CosmeticsActivity.class);
        startActivity(intent);
    }

    public void clickPurse(View view) {
        Intent intent = new Intent(MainActivity.this, PurseActivity.class);
        startActivity(intent);
    }


    public void help(MenuItem item) {
        Intent intent = new Intent(MainActivity.this, NavActivitytwo.class);
        startActivity(intent);

    }
}
