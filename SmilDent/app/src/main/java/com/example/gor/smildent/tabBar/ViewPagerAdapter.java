package com.example.grigor.fivefriendsmile.tabBar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.grigor.fivefriendsmile.forum.ForumFragment;
import com.example.grigor.fivefriendsmile.stomatologylist.StomatologyListFragment;


public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    CharSequence titles[];

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
        titles = new CharSequence[]{
                "stomatolagy","forum"
        };


    }

    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                StomatologyListFragment stomatologyListFragment = new StomatologyListFragment();
                return stomatologyListFragment;

            case 1:
                ForumFragment forumFragment = new ForumFragment();
                return forumFragment;
        }
        return null;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }


    @Override
    public int getCount() {
        return titles.length;
    }
}