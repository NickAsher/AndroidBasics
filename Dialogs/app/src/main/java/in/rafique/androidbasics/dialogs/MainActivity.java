package in.rafique.androidbasics.dialogs;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Context context ;
    private static final String LOG_TAG = "MainActivity => " ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this ;
    }



    public void showNormalAlertDialog(View v){
        AlertDialog dialog = new AlertDialog.Builder(context)
                .setTitle("My Normal AlertDialog Title")
                .setMessage("This is the normal Dialog message man")
                .setCancelable(false)
                .setPositiveButton("Positive-Btn", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(context, "You clicked positive button man", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Negative-Btn", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                       Toast.makeText(context, "You Clicked Negative button man", Toast.LENGTH_SHORT).show();
                    }
                })
                .show() ; // the show() method turns a AlertDialog.Builder to AlertDialog and returns it.


    }

    public void showCustomLayoutAlertDialog(View v){
        final Dialog dialog = new Dialog(context) ;
        dialog.setCancelable(false); // dialog won't close if clicked outside dialog Window

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.dialog_custom_dialog);

        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        int width = metrics.widthPixels;
        dialog.getWindow().setLayout((5*width)/10, WindowManager.LayoutParams.WRAP_CONTENT);


        Button btn_Postitive = dialog.findViewById(R.id.dialogCustomDialog_Btn_Positive) ;
        Button btn_Negative = dialog.findViewById(R.id.dialogCustomDialog_Btn_Negative) ;


        btn_Negative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Negative button clicked", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        btn_Postitive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Positive button clicked", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        dialog.show();

    }






    public void showDatePickerDialog(View v){
        Calendar c = Calendar.getInstance() ;
        // These values become the pre-selected values when datePicker is opened
        int currentYear = c.get(Calendar.YEAR);
        int currentMonth = c.get(Calendar.MONTH);
        int currentDay = c.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                int realMonth = month+1 ; //in stupid java library months starts from 0 instead from 1 ;
                Toast.makeText(context, "Date selected is " + year + " - " + month + " - " + day, Toast.LENGTH_LONG).show();
            }
        }, 2017, currentMonth, currentDay); //used 2017 to show you the difference

        Toast.makeText(context, "The year is 2017 intentionally", Toast.LENGTH_SHORT).show();
        datePickerDialog.show();

    }

    public void showTimePickerDialog(View v){
        Calendar c = Calendar.getInstance() ;
        int currentHour = c.get(Calendar.HOUR);
        int currentMinute = c.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(context, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                Toast.makeText(context, "Time selected is " + hour + ":" + minute, Toast.LENGTH_LONG).show();

            }
        }, currentHour, currentMinute, true) ;

        timePickerDialog.show();

    }

    public void showDialogFragment(View v){
        DialogFragment_Hello dfHello = DialogFragment_Hello.getInstance("Arijit Singh") ;
        dfHello.show(getSupportFragmentManager(), "dfHelloTag");

    }
}