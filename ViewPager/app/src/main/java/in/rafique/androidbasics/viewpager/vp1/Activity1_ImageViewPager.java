package in.rafique.androidbasics.viewpager.vp1;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

import in.rafique.androidbasics.viewpager.R;

public class Activity1_ImageViewPager extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1_image_pager);

        setupImageViewPager();
    }

    private void setupImageViewPager(){
        ArrayList<Integer> arrayList = new ArrayList<>() ;
        arrayList.add(R.drawable.p1);
        arrayList.add(R.drawable.p2);
        arrayList.add(R.drawable.p3);
        arrayList.add(R.drawable.p4);
        arrayList.add(R.drawable.p5);
        arrayList.add(R.drawable.p6);
        arrayList.add(R.drawable.p7);
        arrayList.add(R.drawable.p8);



        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(new ViewPager1_ImageOnlyAdapter(this, arrayList));
    }
}