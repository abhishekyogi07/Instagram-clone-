package com.example.instagram.utils.login;

import android.content.Context;
import android.content.Intent;
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
import com.example.instagram.utils.homeActivity.MainActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static com.example.instagram.utils.navigationact.tag;

public class login_activity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthlistener;
    Context mcontext;
    private ProgressBar mprogressbar;
    private EditText email;
    private EditText pwd;
    private TextView mpleasewait;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_login);
        mprogressbar=(ProgressBar)findViewById (R.id.lapgb);
        email=findViewById (R.id.email);
        pwd=findViewById (R.id.password);
        mpleasewait=findViewById (R.id.pw);
        mcontext=login_activity.this;
        mprogressbar.setVisibility (View.GONE);
        mpleasewait.setVisibility (View.GONE);
        setupFirebaseAuth ();
        init ();

    }
 /*
 <-------------------------------------------------firebase-------------------------------------->
  */
 private boolean isnull(String string) {
     if (string.equals ("")) {
         return true;
     } else {
         return false;
     }
 }

 private void init() {
     Button bt = findViewById (R.id.lg);
     bt.setOnClickListener (new View.OnClickListener ( ) {
         @Override
         public void onClick(View v) {
             String Email = email.getText ( ).toString ( );
             String Password = pwd.getText ( ).toString ( );
             if (isnull (Email) && isnull (Password)) {
                 Toast.makeText (login_activity.this, "you must fill all the contents over here!", Toast.LENGTH_SHORT).show ( );
             } else {
                 mprogressbar.setVisibility (View.VISIBLE);
                 mpleasewait.setVisibility (View.VISIBLE);
                 mAuth.signInWithEmailAndPassword (Email, Password)
                          .addOnCompleteListener (login_activity.this, new OnCompleteListener<AuthResult> ( ) {
                             @Override
                             public void onComplete(@NonNull Task<AuthResult> task) {
                                 if (!task.isSuccessful ( )) {
                                    Log.w (tag, "signin with email is failed", task.getException ( ));
                                     Toast.makeText (login_activity.this, getString (R.string.authfailed),
                                             Toast.LENGTH_SHORT).show ( );
                                    mprogressbar.setVisibility (View.GONE);
                                     mpleasewait.setVisibility (View.GONE);

                                 }
                                 else {
                                     Log.d (tag,"sign in with email:successfull");
                                     Toast.makeText (login_activity.this,getString (R.string.authsuccess),
                                             Toast.LENGTH_SHORT).show ( );
                                     mprogressbar.setVisibility (View.GONE);
                                     mpleasewait.setVisibility (View.GONE);

                                 }
                             }
                         });
             }
         }

     });
     TextView link=findViewById (R.id.linkk);
     link.setOnClickListener (new View.OnClickListener ( ) {
         @Override
         public void onClick(View v) {
             Intent int2=new Intent (mcontext,register_activity.class);
             startActivity (int2);

         }
     });


     if(mAuth.getCurrentUser ( )!=null){
         Intent intent=new Intent (login_activity.this, MainActivity.class);
        startActivity (intent);
         finish ();
     }
 }


    private void setupFirebaseAuth(){
        Log.d (tag,"setting up firebase");
        mAuth=FirebaseAuth.getInstance ();
        mAuthlistener=new FirebaseAuth.AuthStateListener ( ) {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user=firebaseAuth.getCurrentUser ();

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

    }

    @Override
    protected void onStop() {
        super.onStop ( );
        if(mAuthlistener!=null){
            mAuth.removeAuthStateListener (mAuthlistener );
        }
    }

}
