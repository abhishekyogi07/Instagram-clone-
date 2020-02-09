package com.example.instagram.utils.login;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.instagram.R;
import com.example.instagram.utils.firebasemethods;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static com.example.instagram.utils.navigationact.tag;

public class register_activity extends AppCompatActivity {
    private firebasemethods firebasemethods;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthlistener;
    private ProgressBar mprogressbar;
    private EditText email;
    private EditText pwd;
    private EditText username;
    private Button rgbt;
    private String me,mu,mp;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference dref;
     private String append="";

    private TextView mpleasewait;
    Context mcontext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        mcontext=register_activity.this;
        setContentView (R.layout.registerpage);
        initWidgets ();
        setupFirebaseAuth ();
        init();

    }
    private void init(){
        rgbt.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                me=email.getText ().toString ();
                mu=username.getText ().toString ();
                mp=pwd.getText ().toString ();
            if( checkinputs (me,mu,mp)){
             mprogressbar.setVisibility (View.VISIBLE);
             mpleasewait.setVisibility (View.VISIBLE);
             firebasemethods.registernewemail(me,mp,mu);
                firebasemethods.addnewuser(me,mu,"","");
            }
            }
        });
    }
    private boolean checkinputs(String me,String mp,String mu){
        if(me.equals ("")||mp.equals ("")||mu.equals ("")){
            Toast.makeText (mcontext, "you need to fill the info.", Toast.LENGTH_SHORT).show ( );
             return false;
        }
        return true;
    }
    private void  initWidgets(){
        mprogressbar=(ProgressBar)findViewById (R.id.rapgb);
        email=findViewById (R.id.em);
        pwd=findViewById (R.id.pass);
        username=findViewById (R.id.fn);
        rgbt=findViewById (R.id.rg);
        mpleasewait=findViewById (R.id.please);
        mcontext=register_activity.this;
        mprogressbar.setVisibility(View.GONE);
        mpleasewait.setVisibility(View.GONE);
    }
    private boolean isnull(String string) {
        if (string.equals ("")) {
            return true;
        } else {
            return false;
        }
    }
/*
<-----------------------------------FIREBASE------------------------------------->
 */
    private void setupFirebaseAuth(){
        Log.d (tag,"setting up firebase");

        mAuth= FirebaseAuth.getInstance ();
        firebaseDatabase = FirebaseDatabase.getInstance();
         dref =firebaseDatabase.getReference();
        mAuthlistener=new FirebaseAuth.AuthStateListener ( ) {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                final FirebaseUser user=firebaseAuth.getCurrentUser ();

                if(user!=null){
                    Log.d (tag,"Oncreate:signedin"+user.getUid ());
                    dref.addListenerForSingleValueEvent (new ValueEventListener ( ) {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                       if(firebasemethods.checkusername (mu ,dataSnapshot)) {
                           append = dref.push ( ).getKey ( ).substring (3, 10);
                       }
                        mu =mu+append;


                        }
                       @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
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

    }

    @Override
    protected void onStop() {
        super.onStop ( );
        if(mAuthlistener!=null){
            mAuth.removeAuthStateListener (mAuthlistener );
        }
    }

}
