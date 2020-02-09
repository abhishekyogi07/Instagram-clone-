package com.example.instagram.utils;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.instagram.R;
import com.example.instagram.utils.user.user;
import com.example.instagram.utils.user.user_act_settings;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class firebasemethods {
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthlistener;
    private String user_id;
    private Context mcontext;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference dref;



    public firebasemethods(Context context) {
    mAuth=FirebaseAuth.getInstance ();
    mcontext = context;
    firebaseDatabase=FirebaseDatabase.getInstance ();
    dref=firebaseDatabase.getReference ();
       if(mAuth.getCurrentUser ( )!=null){
           user_id=mAuth.getCurrentUser ().getUid ();
       }
    }
    public boolean checkusername (String username, DataSnapshot dataSnapshot) {
        user userr = new user ( );

        for (DataSnapshot ds : dataSnapshot.child (user_id).getChildren ( )) {
            userr.setUsername (ds.getValue (user.class).getUsername ( ));
            if (stringMani.expandusername (userr.getUsername ( )).equals (username)) {
                return true;
            }

        }
        return false;
    }
    public void registernewemail(final String me,String mp,final String mu){
        mAuth.createUserWithEmailAndPassword(me, mp)
                .addOnCompleteListener( new OnCompleteListener<AuthResult> () {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()) {
                            Toast.makeText (mcontext, R.string.authfailed, Toast.LENGTH_SHORT).show ( );

                        } else {
                            user_id=mAuth.getCurrentUser ().getUid ();

                        }

                        // ...
                    }
                });
    }

     public void addnewuser(String email,String username,String description,String profilephoto){
        user user1=new user(user_id,1 ,email,stringMani.condenseuser (username) );
        dref.child (mcontext.getString (R.string.dbname_users))
                .child (user_id)
                .setValue(user1);

         user_act_settings settings=new user_act_settings (description,username,0,0,0,profilephoto,username);
        dref.child (mcontext.getString(R.string.dbname_user_act_settings))
                .child (user_id)
                .setValue (settings);
         Toast.makeText (mcontext, "signup succesfull!! sending mail", Toast.LENGTH_SHORT).show ( );

     }


    }


