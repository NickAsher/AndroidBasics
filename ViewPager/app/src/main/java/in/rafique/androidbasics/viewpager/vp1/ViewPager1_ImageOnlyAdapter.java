package in.rafique.androidbasics.viewpager.vp1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

import in.rafique.androidbasics.viewpager.R;

public class ViewPager1_ImageOnlyAdapter extends PagerAdapter {
    //we extend the PagerAdapter class, which is the basic class for instantiating any type of pager
    // FragmentPagerAdapter & FragmentStatePagerAdapter are used when we are playing around with fragments

    Context context ;
    ArrayList<Integer> listOfImages;
    LayoutInflater layoutInflater;

    public ViewPager1_ImageOnlyAdapter(Context context, ArrayList<Integer> listOfImages) {
        this.context = context;
        this.listOfImages = listOfImages;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return listOfImages.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        // this is the layout used for instantiating every single item
        View itemView = layoutInflater.inflate(R.layout.pager_singlerow_imageadapter, container, false);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.imageview_main);
        imageView.setImageResource(listOfImages.get(position));

        container.addView(itemView);

        //listening to image click
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "you clicked image " + (position + 1), Toast.LENGTH_LONG).show();
            }
        });

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }


}
