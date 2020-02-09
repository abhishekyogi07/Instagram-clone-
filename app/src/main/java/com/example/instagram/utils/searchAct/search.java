package com.example.instagram.utils.searchAct;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.instagram.R;
import com.example.instagram.utils.navigationact;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class search extends AppCompatActivity {
    private static final String tag="search activity";
    private static final int act_no=1;
    private Context mcontext= search.this;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView (R.layout.activity_main);
        Log.d(tag,"oncreate:started");
        setupbottomnavigationView ( );
    }

    private  void setupbottomnavigationView() {
        Log.d(tag, "setting up bottom nav view");
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottom);
        navigationact.setupbottomnavigationView(bottomNavigationViewEx);
        navigationact.enableNavigation((search) mcontext, bottomNavigationViewEx);
        Menu menu=bottomNavigationViewEx.getMenu();
        MenuItem menuItem=menu.getItem(act_no);
        menuItem.setChecked(true);
    }
}
