package in.rafique.androidbasics.recyclerviews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import in.rafique.androidbasics.recyclerviews.ui.normal.Normal_1_RecyclerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void openNormalRecyclerView(View v){
        Intent intent = new Intent(this, Normal_1_RecyclerView.class) ;
        startActivity(intent);
    }

    public void openAutoScrollingRecyclerView(View v){
        Intent intent = new Intent(this, Normal_1_RecyclerView.class) ;
        startActivity(intent);
    }
}