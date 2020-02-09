package com.example.instagram.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.instagram.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
//import com.nostra13.universalimageloader.core.imageaware.ImageAware;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import java.util.ArrayList;

public class gridviewadapter extends ArrayAdapter<String> {
    private Context mcontext;
    private LayoutInflater minflator;
    private int layoutResource;
    private String mappend;
    private ArrayList<String>iu;

    public gridviewadapter(Context mcontext, int layoutResource, String mappend, ArrayList<String> iu) {
        super(mcontext,layoutResource,iu);
        this.mcontext = mcontext;
        minflator= (LayoutInflater) mcontext.getSystemService (mcontext.LAYOUT_INFLATER_SERVICE);
        this.minflator = minflator;
        this.layoutResource = layoutResource;
        this.mappend = mappend;
        this.iu = iu;
    }
    private static class Viewholder{
        sqaureimageview profileimage;
        ProgressBar mprogress;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final Viewholder viewholder;
        if(convertView == null){
           convertView=minflator.inflate (layoutResource , parent ,false);
           viewholder=new Viewholder ();
           viewholder.mprogress=(ProgressBar) convertView.findViewById (R.id.progbar);
           viewholder.profileimage=(sqaureimageview) convertView.findViewById (R.id.gridimagviewg);
           convertView.setTag (viewholder);
        }
        else{
            viewholder=(Viewholder)convertView.getTag ();

        }
        String imgurl=getItem (position);
        ImageLoader imageLoader=ImageLoader.getInstance ();
        imageLoader.displayImage (mappend + imgurl,  viewholder.profileimage, new ImageLoadingListener ( ) {
            @Override
            public void onLoadingStarted(String imageUri, View view) {
                if(viewholder.mprogress!=null){
                    viewholder.mprogress.setVisibility (View.VISIBLE);
                }
            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                if(viewholder.mprogress!=null){
                    viewholder.mprogress.setVisibility (View.VISIBLE);
                }
            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                if(viewholder.mprogress!=null){
                    viewholder.mprogress.setVisibility (View.VISIBLE);
                }
            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {
                if(viewholder.mprogress!=null){
                    viewholder.mprogress.setVisibility (View.VISIBLE);
                }
            }
        });

        return convertView;
    }
}
