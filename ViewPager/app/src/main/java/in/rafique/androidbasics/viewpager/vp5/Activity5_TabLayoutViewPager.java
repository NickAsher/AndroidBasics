package in.rafique.androidbasics.viewpager.vp5;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import in.rafique.androidbasics.viewpager.R;

import static androidx.fragment.app.FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT;

public class Activity5_TabLayoutViewPager extends AppCompatActivity {
    Context context ;
    ViewPager viewPager ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity5_tabs);
        context = this ;

        setupViewPager() ;
        setupTabLayout() ;
    }

    private void setupViewPager() {
        viewPager = findViewById(R.id.viewPager);
        VPAdapter5_TabLayout vpAdapter = new VPAdapter5_TabLayout(getSupportFragmentManager(), BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(vpAdapter);


    }
    private void setupTabLayout(){
        TabLayout tabLayout = findViewById(R.id.tabLayout) ;
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.pizza_white) ; // can also set tab icons programatically
        tabLayout.getTabAt(1).setIcon(R.drawable.hamburger_white) ; // can also set tab icons programatically
        tabLayout.getTabAt(2).setIcon(R.drawable.coffee_white) ; // can also set tab icons programatically
        tabLayout.getTabAt(3).setIcon(R.drawable.cupcake_white) ; // can also set tab icons programatically
        tabLayout.getTabAt(4).setIcon(R.drawable.donut_white) ; // can also set tab icons programatically
        tabLayout.getTabAt(5).setIcon(R.drawable.drink_white) ; // can also set tab icons programatically

        tabLayout.getTabAt(1).select();
        tabLayout.getTabAt(0).select();



        tabLayout.addOnTabSelectedListener(
                new TabLayout.ViewPagerOnTabSelectedListener(viewPager) {

                    @Override
                    public void onTabSelected(TabLayout.Tab tab) {
                        super.onTabSelected(tab);
//                        int tabIconColor = ContextCompat.getColor(context, R.color.white);
//                        tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
                    }

                    @Override
                    public void onTabUnselected(TabLayout.Tab tab) {
                        super.onTabUnselected(tab);
//                        int tabIconColor = ContextCompat.getColor(context, R.color.grey);
//                        tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
                    }

                    @Override
                    public void onTabReselected(TabLayout.Tab tab) {
                        super.onTabReselected(tab);
                    }
                }
        );
    }


}