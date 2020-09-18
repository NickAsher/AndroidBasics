package in.rafique.androidbasics.viewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import static androidx.fragment.app.FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT;

public class Activity1_NormalViewPager extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1_normal_view_pager);

        setupViewPager() ;
    }

    private void setupViewPager(){
        ViewPager viewpager = (ViewPager) findViewById(R.id.activity1_ViewPager) ;
        VPAdapter1_NormalFragments adapter = new VPAdapter1_NormalFragments(getSupportFragmentManager(), BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) ;
        viewpager.setAdapter(adapter);
    }
}