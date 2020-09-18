package in.rafique.androidbasics.viewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import static androidx.fragment.app.FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT;

public class Activity2_NormalViewPager extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2_normal_view_pager);

        setupViewPager() ;
    }

    private void setupViewPager(){
        ViewPager viewpager = (ViewPager) findViewById(R.id.viewPager) ;
        VPAdapter2_NormalFragments adapter = new VPAdapter2_NormalFragments(getSupportFragmentManager(), BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) ;
        viewpager.setPageMargin(25); // add spacing between pages on scrolling, (not like credit cards)
        viewpager.setAdapter(adapter);

        viewpager.setCurrentItem(3); // setCurrentItem should be called after calling the setAdapter

    }
}