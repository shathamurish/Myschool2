package com.shathamurish.myschool2.Help;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    List<Fragment>fragmentList1 =new ArrayList<>();
    List<String> title_list=new ArrayList<>();

    public ViewPagerAdapter(@NonNull @NotNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @NotNull
    @Override
    public Fragment getItem(int i) {
        return fragmentList1.get(i);
    }
public void addFragment(Fragment fragment,String title){
        fragmentList1.add(fragment);
        title_list.add(title);
}
    @Override
    public int getCount() {
        return fragmentList1.size();
    }
   public CharSequence getPageTitle(int i){
        return title_list.get(i);
   }
}
