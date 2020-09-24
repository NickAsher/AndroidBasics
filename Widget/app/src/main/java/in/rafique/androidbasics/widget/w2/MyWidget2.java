package in.rafique.androidbasics.widget.w2;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.util.Log;
import android.widget.RemoteViews;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import in.rafique.androidbasics.widget.R;

public class MyWidget2 extends AppWidgetProvider {
    //This is a simple widget that shows the date
    // IT


    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {

        for(int appwidgetId : appWidgetIds){
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget2) ;

            // To get the data here, connect to either sharedPrefs or some database
            // or use some kind of worker to update your widgets

            String time = new SimpleDateFormat("hh:mm").format(Calendar.getInstance().getTime()) ;
            views.setTextViewText(R.id.widget2_TextView_LastUpdated, "Last update on "+time);

            appWidgetManager.updateAppWidget(appwidgetId, views);
        }





    }




}
