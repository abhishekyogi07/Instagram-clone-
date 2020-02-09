package com.example.instagram.utils.profileAct;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.instagram.R;
import com.example.instagram.utils.universalImageLoader;

public class EditprofileActivityFragment extends Fragment {
    private ImageView mprofilev;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate (R.layout.fragment_editprofile,container,false);
        mprofilev=(ImageView)view.findViewById (R.id.pp);

       setprofileimage ();
        ImageView ba=(ImageView)view.findViewById (R.id.backarrow);
        ba.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                Log.d ("message","navigating to the profile activity" );
                getActivity ().finish ();
            }
        });
        return view;
    }
    String imageurl="https://unsplash.com/photos/_fvUcz1H6EY";

    private void setprofileimage(){
        universalImageLoader.setImage (imageurl,mprofilev,null,"https://");
    }
}
