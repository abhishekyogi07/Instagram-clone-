package com.example.instagram.utils.homeActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.instagram.R;
import com.example.instagram.utils.login.login_activity;
import com.example.instagram.utils.navigationact;
import com.example.instagram.utils.shareAct.SectionsPagerAdapter;
import com.example.instagram.utils.universalImageLoader;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.nostra13.universalimageloader.core.ImageLoader;

public class MainActivity extends AppCompatActivity {
    private static final String tag = "home activity";
    private static final int act_no = 0;
    private Context mcontext = MainActivity.this;
//firebase
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthlistener;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        setupFirebaseAuth ();
        initimageloader ( );
        setupbottomnavigationView ( );
        setupViewPager ( );




    }
    private void initimageloader() {
        universalImageLoader uil = new universalImageLoader (mcontext);
        ImageLoader.getInstance ().init (uil.getConfig ( ));
    }

    private void setupViewPager() {
        SectionsPagerAdapter adapter = new SectionsPagerAdapter (getSupportFragmentManager ( ));
        adapter.addFragmnets (new cameraFragment());
        adapter.addFragmnets (new messageFragment());
        adapter.addFragmnets (new HomeFragment());
        ViewPager viewPager = (ViewPager) findViewById (R.id.container);
        viewPager.setAdapter (adapter);
        TabLayout tabLayout = findViewById (R.id.tabs);
        tabLayout.setupWithViewPager (viewPager);
    }

    private void setupbottomnavigationView() {
        Log.d (tag, "setting up bottom nav view");
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById (R.id.bottom);
        navigationact.setupbottomnavigationView (bottomNavigationViewEx);
        navigationact.enableNavigation ((MainActivity)mcontext, bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu ( );
        MenuItem menuItem = menu.getItem (act_no);
        menuItem.setChecked (true);


    }
    /*
     <-------------------------FIREBASE-------------------------------->
    */
    private void checkcurrentuser(FirebaseUser user){
        Log.d (tag,"check curent user:check wheather the current user is logged in");
        if(user==null){
            Intent intent=new Intent(mcontext, login_activity.class);
            startActivity (intent);
        }
    }

private void setupFirebaseAuth(){
    Log.d (tag,"setting up firebase");
        mAuth=FirebaseAuth.getInstance ();
        mAuthlistener=new FirebaseAuth.AuthStateListener ( ) {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user=firebaseAuth.getCurrentUser ();
                checkcurrentuser (user);
                if(user!=null){
                    Log.d (tag,"Oncreate:signedin"+user.getUid ());
                }
                else{
                    Log.d (tag,"oncreate:Activity end");
                }
            }
        };
}
    @Override
    public void onStart() {
        super.onStart();
       mAuth.addAuthStateListener (mAuthlistener);
       checkcurrentuser (mAuth.getCurrentUser ());
         }

    @Override
    protected void onStop() {
        super.onStop ( );
        if(mAuthlistener!=null){
            mAuth.removeAuthStateListener (mAuthlistener );
        }
    }


}

