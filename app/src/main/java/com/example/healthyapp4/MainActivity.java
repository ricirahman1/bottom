package com.example.healthyapp4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomappbar.BottomAppBar;

public class MainActivity extends AppCompatActivity {
    BottomAppBar bottomAppBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomAppBar=findViewById(R.id.bar);
        setSupportActionBar(bottomAppBar);

        HomeFragment homeFragment=new HomeFragment();
        LoveFragment loveFragment=new LoveFragment();
        CallFragment callFragment=new CallFragment();


        setFragment(homeFragment);
        bottomAppBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.call_id:
                        setFragment(callFragment);
                        break;
                    case R.id.love_id:
                        setFragment(loveFragment);
                        break;

                }
                return true;
            }
        });
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_id,fragment);
        fragmentTransaction.commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.nav_items,menu);
        return true;
    }

    public void fabclick(View view) {
        HomeFragment homeFragment=new HomeFragment();
        setFragment(homeFragment);

    }
}