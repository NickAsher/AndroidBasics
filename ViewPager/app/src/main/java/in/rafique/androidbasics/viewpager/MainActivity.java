package in.rafique.androidbasics.viewpager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openImageOnlyViewPager(View v){
        Intent intent = new Intent(this, Activity0_ImageViewPager.class) ;
        startActivity(intent) ;
    }

    public void openNormalViewPager(View v){
        Intent intent = new Intent(this, Activity1_NormalViewPager.class) ;
        startActivity(intent) ;
    }

    public void openSpacedViewPager(View v){
        Intent intent = new Intent(this, Activity2_SpacedViewPager.class) ;
        startActivity(intent) ;
    }

    public void openTabLayoutViewPager(View v){
        Intent intent = new Intent(this, Activity3_TabLayoutViewPager.class) ;
        startActivity(intent) ;
    }

    public void openInfiniteRoundScrollViewPager(View v){
        Intent intent = new Intent(this, Activity4_InfiniteScrollViewPager.class) ;
        startActivity(intent) ;
    }

    public void openDynamicViewPager(View v){
        Intent intent = new Intent(this, Activity5_DynamicViewPager.class) ;
        startActivity(intent) ;
    }


}