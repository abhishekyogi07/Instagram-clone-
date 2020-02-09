package com.example.instagram.utils;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;

import com.example.instagram.R;
import com.example.instagram.utils.homeActivity.MainActivity;
import com.example.instagram.utils.likesActivity.likes;
import com.example.instagram.utils.profileAct.profile;
import com.example.instagram.utils.searchAct.search;
import com.example.instagram.utils.shareAct.shareactivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class navigationact {
    public static final String tag = "bottom_helper";

    public static void setupbottomnavigationView(BottomNavigationViewEx bottomNavigationViewEx) {
        Log.d (tag, "setupbottomnavigation:setting up");
        bottomNavigationViewEx.enableAnimation(false);
        bottomNavigationViewEx.enableItemShiftingMode(false);
        bottomNavigationViewEx.enableShiftingMode(false);
        bottomNavigationViewEx.setTextVisibility(false);

    }
    public static void enableNavigation(final Context context, BottomNavigationViewEx view){
        view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {
                    case R.id.house:
                        Intent i1 = new Intent(context, MainActivity.class);
                        context.startActivity(i1);
                        break;

                    case R.id.search:
                        Intent i2 = new Intent(context, search.class);
                        context.startActivity(i2);
                        break;
                    case R.id.circle:
                        Intent i3 = new Intent(context, shareactivity.class);
                        context.startActivity(i3);
                        break;
                    case R.id.alert:
                        Intent i4 = new Intent(context, likes.class);
                        context.startActivity(i4);
                        break;
                    case R.id.android:
                        Intent i5 = new Intent(context, profile.class);
                        context.startActivity(i5);
                        break;
                }


                return false;
            }

        });
    }
}
