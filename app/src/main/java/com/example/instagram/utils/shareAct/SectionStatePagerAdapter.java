package com.example.instagram.utils.shareAct;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SectionStatePagerAdapter extends FragmentStatePagerAdapter {
    private final List<Fragment> mfragmentlist = new ArrayList<>();
    private final HashMap<Fragment, Integer> mfragment = new HashMap<>();
    private final HashMap<String, Integer> mfragmentno = new HashMap<>();
    private final HashMap<Integer, String> mfragmentname = new HashMap<>();

    public SectionStatePagerAdapter(FragmentManager fm) {
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



    public void addFragment(Fragment fragment, String fragmentname) {
        mfragmentlist.add (fragment);
        mfragment.put (fragment, mfragmentlist.size()- 1);
        mfragmentno.put (fragmentname, mfragmentlist.size()- 1);
        mfragmentname.put (mfragmentlist.size ()- 1, fragmentname);

    }
    public Integer getFragmentno(String fragmentname) {
        if (mfragmentno.containsKey (fragmentname)) {
            return mfragmentno.get (fragmentname);
        } else {
            return null;
        }

    }

    public Integer getFragmentno(Fragment fragment) {
        if (mfragmentno.containsKey (fragment)) {
            return mfragmentno.get (fragment);
        } else {
            return null;
        }
    }

    public Integer getFragmentname(Integer fragmentnoo) {
        if (mfragmentno.containsKey (fragmentnoo)) {
            return mfragmentno.get (fragmentnoo);
        } else {
            return null;
        }
    }
}

