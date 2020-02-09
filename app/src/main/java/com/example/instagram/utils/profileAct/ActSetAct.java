package com.example.instagram.utils.profileAct;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.instagram.R;
import com.example.instagram.utils.navigationact;
import com.example.instagram.utils.shareAct.SectionStatePagerAdapter;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.ArrayList;

import static com.example.instagram.utils.navigationact.tag;


public class ActSetAct extends AppCompatActivity {
    private Context mcontext;
    private static final int act_no=0;
    private SectionStatePagerAdapter pagerAdapter;
    private ViewPager viewPager;
    private RelativeLayout relativeLayout;

    private static final String TAG = "Actsettigns activity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.act_settings);
        Log.d (tag,"account setting started" );
        mcontext=ActSetAct.this;
        viewPager=findViewById (R.id.container);
        relativeLayout=findViewById (R.id.relact1);
        setupSettingList ();
        setupbottomnavigationView ();
        setupFragments ();
        //
        ImageView imageView=findViewById (R.id.backarrow);
        imageView.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                finish ();
            }
        });

    }
    private void setupFragments(){
        pagerAdapter=new SectionStatePagerAdapter (getSupportFragmentManager ());
        pagerAdapter.addFragment (new EditprofileActivityFragment (),getString (R.string.Edit_profile));
        pagerAdapter.addFragment (new signoutFragment (),getString (R.string.sign_out));

        }

        private void setViewPager(int fragmentnumber){
        relativeLayout.setVisibility (View.GONE);
        viewPager.setAdapter (pagerAdapter);
        viewPager.setCurrentItem (fragmentnumber);
    }


    private void setupSettingList(){

       ListView listView=findViewById (R.id.lvas);
        ArrayList<String>options=new ArrayList<> ();
        options.add (getString (R.string.Edit_profile));
        options.add (getString (R.string.sign_out));
        ArrayAdapter arrayAdapter=new ArrayAdapter (mcontext,android.R.layout.simple_list_item_1,options);
        listView.setAdapter (arrayAdapter);
        listView.setOnItemClickListener ( new  AdapterView.OnItemClickListener ( ) {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                setViewPager (position);
            }
        });

    }
    private  void setupbottomnavigationView(){
        Log.d(tag,"setting up bottom nav view" );
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottom);
        navigationact.setupbottomnavigationView (bottomNavigationViewEx);
        navigationact.enableNavigation( mcontext,bottomNavigationViewEx);
        Menu menu=bottomNavigationViewEx.getMenu();
        MenuItem menuItem=menu.getItem(act_no);
        menuItem.setChecked(true);


    }
}
