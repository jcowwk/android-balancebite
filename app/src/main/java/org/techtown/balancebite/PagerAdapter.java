package org.techtown.balancebite;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

public class PagerAdapter extends FragmentStateAdapter {
    ArrayList<Fragment> items = new ArrayList<Fragment>();
    public PagerAdapter(FragmentActivity fragmentActivity){
        super(fragmentActivity);
    }
    public void addItem(Fragment fragment){
        items.add(fragment);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return items.get(position);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}