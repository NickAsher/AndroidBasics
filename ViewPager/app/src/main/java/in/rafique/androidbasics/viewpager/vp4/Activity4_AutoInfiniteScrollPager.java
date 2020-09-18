package in.rafique.androidbasics.viewpager.vp4;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import in.rafique.androidbasics.viewpager.R;
import in.rafique.androidbasics.viewpager.VPAdapter3_InfiniteScroll;

import static androidx.fragment.app.FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT;

public class Activity4_AutoInfiniteScrollPager extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity4_auto_scroll);

        setupViewPager() ;
    }

    private void setupViewPager(){
        AutoScrollViewPager pager = (AutoScrollViewPager)findViewById(R.id.autoScrollViewPager) ;
        VPAdapter4_AutoInfiniteScroll adapter = new VPAdapter4_AutoInfiniteScroll(getSupportFragmentManager(), BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) ;

        pager.setAdapter(adapter) ;
        pager.setInterval(2000);
        pager.startAutoScroll();
        pager.setCurrentItem(500);
        pager.setStopScrollWhenTouch(false);
        pager.setAutoScrollDurationFactor(8);
        pager.setPageTransformer(true, new DepthParallaxPageTransformer());



    }
}