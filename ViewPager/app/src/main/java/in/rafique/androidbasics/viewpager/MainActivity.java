package in.rafique.androidbasics.viewpager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import in.rafique.androidbasics.viewpager.vp1.Activity1_ImageViewPager;
import in.rafique.androidbasics.viewpager.vp2.Activity2_NormalViewPager;
import in.rafique.androidbasics.viewpager.vp3.Activity3_InfiniteScrollViewPager;
import in.rafique.androidbasics.viewpager.vp4.Activity4_AutoInfiniteScrollPager;
import in.rafique.androidbasics.viewpager.vp5.Activity5_TabLayoutViewPager;
import in.rafique.androidbasics.viewpager.vp6.Activity6_DynamicViewPager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openImageOnlyViewPager(View v){
        Intent intent = new Intent(this, Activity1_ImageViewPager.class) ;
        startActivity(intent) ;
    }

    public void openNormalViewPager(View v){
        Intent intent = new Intent(this, Activity2_NormalViewPager.class) ;
        startActivity(intent) ;
    }


    public void openInfiniteRoundScrollViewPager(View v){
        Intent intent = new Intent(this, Activity3_InfiniteScrollViewPager.class) ;
        startActivity(intent) ;
    }

    public void openAutoScrollingViewPager(View v){
        Intent intent = new Intent(this, Activity4_AutoInfiniteScrollPager.class) ;
        startActivity(intent) ;
    }

    public void openTabLayoutViewPager(View v){
        Intent intent = new Intent(this, Activity5_TabLayoutViewPager.class) ;
        startActivity(intent) ;
    }

    public void openDynamicViewPager(View v){
        Intent intent = new Intent(this, Activity6_DynamicViewPager.class) ;
        startActivity(intent) ;
    }


}