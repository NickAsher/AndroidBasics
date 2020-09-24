package in.rafique.androidbasics.widget.w1;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import in.rafique.androidbasics.widget.MainActivity;
import in.rafique.androidbasics.widget.R;

public class MyWidget1 extends AppWidgetProvider {


    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // for every single instance of our widget
        for(int appwidgetId : appWidgetIds){
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget1) ;

            String day = new SimpleDateFormat("EEEE").format(Calendar.getInstance().getTime()) ;
            String date = new SimpleDateFormat("MMMM dd").format(Calendar.getInstance().getTime()) ;

            Log.d("MyWidget => ", "Time is " + day + "  date is " + date) ;

            views.setTextViewText(R.id.widgetFinal_TextView_Day, day);
            views.setTextViewText(R.id.widgetFinal_TextView_Date, date);

            Intent intent = new Intent(context, MainActivity.class) ;
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT) ;
            views.setOnClickPendingIntent(R.id.widgetFinal_TextView_Day, pendingIntent);

            appWidgetManager.updateAppWidget(appwidgetId, views);
        }





    }




}
