package com.dogukandemirel.workshopapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {
    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0: return new WorkshopFragment();
            case 1: return new SocialFragment();
            case 2: return new ProfileFragment();
            default:return  new WorkshopFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
