package in.rafique.androidbasics.viewpager.vp5;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import in.rafique.androidbasics.viewpager.fragments.Fragment1;
import in.rafique.androidbasics.viewpager.fragments.Fragment2;
import in.rafique.androidbasics.viewpager.fragments.Fragment3;
import in.rafique.androidbasics.viewpager.fragments.Fragment4;
import in.rafique.androidbasics.viewpager.fragments.Fragment5;
import in.rafique.androidbasics.viewpager.fragments.Fragment6;

public class VPAdapter5_TabLayout extends FragmentPagerAdapter {
    private String tabTitles[] = new String[] {"Pizza", "Burger", "Coffee", "Cupcake", "Donut", "Soda"};

    public VPAdapter5_TabLayout(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0 : return new Fragment1() ;
            case 1 : return new Fragment2() ;
            case 2 : return new Fragment3() ;
            case 3 : return new Fragment4() ;
            case 4 : return new Fragment5() ;
            case 5 : return new Fragment6() ;
            default: return new Fragment1() ;
        }

    }

    @Override
    public int getCount() {
        return 6;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position] ;
    }
}
