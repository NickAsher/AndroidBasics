package in.rafique.androidbasics.viewpager.vp3;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import in.rafique.androidbasics.viewpager.R;

import static androidx.fragment.app.FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT;

public class Activity3_InfiniteScrollViewPager extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3_infinite_scroll);

        setupViewPager() ;
    }

    private void setupViewPager(){
        ViewPager viewpager = (ViewPager) findViewById(R.id.viewPager) ;
        VPAdapter3_InfiniteScroll adapter = new VPAdapter3_InfiniteScroll(getSupportFragmentManager(), BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) ;
        viewpager.setPageMargin(25); // add spacing between pages on scrolling, (not like credit cards)
        viewpager.setAdapter(adapter);

        viewpager.setCurrentItem(Integer.MAX_VALUE/2); // setCurrentItem should be called after calling the setAdapter

    }
}