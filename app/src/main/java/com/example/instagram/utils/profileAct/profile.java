package com.example.instagram.utils.profileAct;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.instagram.R;
import com.example.instagram.utils.gridviewadapter;
import com.example.instagram.utils.navigationact;
import com.example.instagram.utils.universalImageLoader;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.ArrayList;

public class profile extends AppCompatActivity {
    private static final String tag="profile activity";
    private static final int act_no=4;
    private Context mcontext= profile.this;
    private ProgressBar progressBar;
    private ImageView profilephoto;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView (R.layout.activity_profile);
        Log.d(tag,"oncreate:started");
      setupbottomnavigationView();
      progressBar=(ProgressBar)findViewById (R.id.pgb);
      progressBar.setVisibility (View.GONE);
        setupbottomnavigationView();
        setupbottomnavigationView ();
        setupToolbar ();
      setupwidget ();
      setprimage ();
      tempgridsetup ();
    }
    private void tempgridsetup(){
        ArrayList<String>imgurls=new ArrayList<> ();
        imgurls.add ("unsplash.com/photos/HYjJ1_AZnqw");
        imgurls.add ("unsplash.com/photos/AyH9hAmiX9Y");
        imgurls.add ("unsplash.com/photos/9LwCEYH1oW4");
        imgurls.add ("unsplash.com/photos/9LwCEYH1oW4");

        setupgv (imgurls);




    }
    private void setupgv(ArrayList<String> imgurls){
        GridView gridView=(GridView)findViewById (R.id.gview);
        gridviewadapter adapter=new gridviewadapter (mcontext,R.layout.layout_grid_image,"",imgurls);
        gridView.setAdapter (adapter);
        int gridwidth=getResources ().getDisplayMetrics ().widthPixels;
        int imgwidth=gridwidth/3;
         gridView.setColumnWidth (imgwidth);
    }

    private void setupwidget(){
        progressBar=findViewById (R.id.pgb);
        progressBar.setVisibility (View.GONE);
        profilephoto=findViewById (R.id.profilephoto);

    }
    private void setprimage(){
        String imageURL="unsplash.com/photos/4u2U8EO9OzY";
        universalImageLoader.setImage (imageURL,profilephoto,progressBar,"https://");

    }
    private void setupToolbar(){
        Toolbar toolbar=findViewById (R.id.profile_tool_bar);
        setSupportActionBar (toolbar);
        ImageView profilemenu=(ImageView)findViewById (R.id.cp);
        profilemenu.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mcontext,ActSetAct.class);
                startActivity (intent);
            }
        });
    }
    private  void setupbottomnavigationView() {
        Log.d(tag, "setting up bottom nav view");
        BottomNavigationViewEx bottomNavigationViewEx =(BottomNavigationViewEx) findViewById(R.id.bottom);
        navigationact.setupbottomnavigationView(bottomNavigationViewEx);
        navigationact.enableNavigation((profile) mcontext,bottomNavigationViewEx);
        Menu menu=bottomNavigationViewEx.getMenu();
        MenuItem menuItem=menu.getItem(act_no);
        menuItem.setChecked(true);
    }



}
