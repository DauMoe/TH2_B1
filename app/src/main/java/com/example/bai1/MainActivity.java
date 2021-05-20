package com.example.bai1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private MenuItem profile, exit;
    private ActionBar topbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        profile = findViewById(R.id.profile);
        exit = findViewById(R.id.exit);
        topbar = getSupportActionBar();
        BottomNavigationView navigation = findViewById(R.id.navigation);
        BottomNavigationView.OnNavigationItemSelectedListener handling = new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.cf1:
                        topbar.setTitle("Cafe1");
                        LoadFrameLayout(new CafeOneFragment());
                        return true;
                    case R.id.cf2:
                        topbar.setTitle("Cafe2");
                        LoadFrameLayout(new CafeTwoFragment());
                        return true;
                    case R.id.cf3:
                        topbar.setTitle("Cafe3");
                        LoadFrameLayout(new CafeThreeFragment());
                        return true;
                    default:
                        return true;
                }
            }
        };
        navigation.setOnNavigationItemSelectedListener(handling);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.profile:
                Intent profile = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(profile);
                break;
            case R.id.exit:
                System.exit(0);
                break;
            default:
                break;
        }
        return true;
    }

    private void LoadFrameLayout(Fragment f) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame, f);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}