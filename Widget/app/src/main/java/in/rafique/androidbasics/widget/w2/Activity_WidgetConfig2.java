package in.rafique.androidbasics.widget.w2;

import androidx.appcompat.app.AppCompatActivity;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RemoteViews;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import in.rafique.androidbasics.widget.R;
import in.rafique.androidbasics.widget.w1.MyWidget1;

public class Activity_WidgetConfig2 extends AppCompatActivity {
    Context context ;
    String LOG_TAG = "Activity_WidgetConfig2 => " ;

    AppWidgetManager appWidgetManager ;
    int widgetId ;
    EditText dataEditText ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setResult(RESULT_OK);
        setContentView(R.layout.activity_widget_config2);

        context = this.getApplicationContext() ;
        appWidgetManager = AppWidgetManager.getInstance(context);

        dataEditText = findViewById(R.id.activityWidgetConfig2_EditText_data) ;

        setWidgetId() ;

    }



    private void setWidgetId(){
        /* This activity will only be opened, when we are setting a new widget.
         * so, this activity is automatically opened by the system.
         * When the system opens this activity, it passes a widgetId, to this activity, in an intent.
         * So right now, we are going to get that widget id.

         * If for some reason, this widget id is not available to us, in this activity
         * then we will not set out widget and we will close this activity
         */

        // by default lets set the widget id to a invalid thing
        widgetId= AppWidgetManager.INVALID_APPWIDGET_ID;

        // Now we check if we get a widgetId from the system or not
        Bundle bundle = getIntent().getExtras() ;
        if (bundle != null) {
            widgetId = bundle.getInt(
                    AppWidgetManager.EXTRA_APPWIDGET_ID, AppWidgetManager.INVALID_APPWIDGET_ID);
        }

        // if the system didn't give a widgetId, then we stop the activity, and try to show some error to user
        if (widgetId == AppWidgetManager.INVALID_APPWIDGET_ID) {
            finish();
        }
    }



    private void createWidget(String myData) {
        // you can also do this creation thing, by putting a static instance method inside the widget class
        // just like we do in fragments, we put a static getInstance method, to create a fragment, inside the fragment class
        // we can do the same here too.
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget2) ;

        views.setTextViewText(R.id.widget2_TextView_Data1, myData);

        String time = new SimpleDateFormat("hh:mm").format(Calendar.getInstance().getTime()) ;
        views.setTextViewText(R.id.widget2_TextView_LastUpdated, "Last update on "+time);

        appWidgetManager.updateAppWidget(widgetId, views);


    }

    public void saveConfig(View v) {
        String myData = dataEditText.getText().toString() ;
        dataEditText.getText().clear();

        createWidget(myData);

        // Make sure we pass back the original widgetId
        Intent resultValue = new Intent();
        resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, widgetId);
        setResult(RESULT_OK, resultValue);

        finish();

    }






}