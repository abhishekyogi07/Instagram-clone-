package com.example.instagram.utils.shareAct;

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

public class shareactivity extends AppCompatActivity {
    private static final String tag="share activity";
    private static final int act_no=2;
    private Context mcontext= shareactivity.this;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView (R.layout.activity_main);
        setupbottomnavigationView();
    }

    private  void setupbottomnavigationView() {
        Log.d(tag, "setting up bottom nav view");
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottom);
        navigationact.setupbottomnavigationView(bottomNavigationViewEx);
        navigationact.enableNavigation((shareactivity) mcontext,bottomNavigationViewEx);
        Menu menu=bottomNavigationViewEx.getMenu();
        MenuItem menuItem=menu.getItem(act_no);
        menuItem.setChecked(true);
    }
}
