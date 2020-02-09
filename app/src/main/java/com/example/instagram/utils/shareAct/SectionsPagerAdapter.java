package com.example.instagram.utils.shareAct;



import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class SectionsPagerAdapter extends FragmentPagerAdapter {
    private static final String tag ="section pager adapter";
    private final List<Fragment> mfragmentlist=new ArrayList<Fragment> ();



    public SectionsPagerAdapter(FragmentManager fm) {
        super (fm);
    }

    @Override
    public Fragment getItem(int i) {
        return mfragmentlist.get (i);
    }

    @Override
    public int getCount() {
        return mfragmentlist.size ();
    }
    public void addFragmnets(Fragment fragment){
        mfragmentlist.add (fragment);
    }
}
