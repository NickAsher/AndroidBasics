package in.rafique.androidbasics.notifications;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class Activity_Notification extends AppCompatActivity {
    private static final String LOG_TAG = "Activity_PendingIntent" ;
    Context context ;
    NotificationManager notificationManager ;
    int normalNotfId = 1, expandedTextNotfId = 100, imageNotfId = 200, inboxNotfId = 300, actionNotfId = 400, stickyNotfId = 500  ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        context = this;
        notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE) ;
    }



    public void normalNotification(View v){
        Intent intent = new Intent(this, ActivityDemo_SomeText.class) ;
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT) ;

        Notification notification = new Notification.Builder(context)
                .setContentTitle("Normal Notification")
                .setContentText("This is the normal text of the normal notification ")
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.wheel))
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true) // removes the notification after it is clicked
                .build() ;

        notificationManager.notify(normalNotfId, notification);
        normalNotfId++ ;
    }

    public void expandedTextNotification(View v){
        Intent intent = new Intent(this, ActivityDemo_SomeText.class) ;
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 2, intent, PendingIntent.FLAG_UPDATE_CURRENT) ;

        Notification.BigTextStyle bigTextStyleBuilder = new Notification.BigTextStyle()
                .setSummaryText("summary Text")
                .setBigContentTitle("This is the bigContentTitle")
                .bigText("This my friend is the big long text, which is seen after extending the text by clicking down-arrow button. Generally you want the small text and big text to be the same so that is a seamless transition or make the small text some kind of email subject and big text is the body")
                .setSummaryText("Summary man") ;


        Notification notification = new Notification.Builder(context)
                .setContentTitle("Normal Title")
                .setContentText("THis is normal text of expanded notifcation")
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.wheel))
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true) // removes the notification after it is clicked
                .setStyle(bigTextStyleBuilder)
                .build();

        notificationManager.notify(imageNotfId, notification);
        expandedTextNotfId++ ;


    }



    public void expandedBigImageNotification(View v){
        Intent intent = new Intent(this, ActivityDemo_SomeText.class) ;
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 2, intent, PendingIntent.FLAG_UPDATE_CURRENT) ;

        Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle()
                .setBigContentTitle("Yolo Image Notification Title")
                .bigPicture(BitmapFactory.decodeResource(getResources(), R.drawable.someimage))
                .setSummaryText("Summary man") ;

        Notification notification = new Notification.Builder(context)
                .setContentTitle("Image Normal Title")
                .setContentText("THis is normal text of expanded notifcation")
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.wheel))
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true) // removes the notification after it is clicked
                .setStyle(bigPictureStyle)
                .build();

        notificationManager.notify(imageNotfId, notification);
        imageNotfId++ ;
    }

    public void inboxStyleNotification(View v){

        Intent intent = new Intent(this, ActivityDemo_SomeText.class) ;
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 2, intent, PendingIntent.FLAG_UPDATE_CURRENT) ;

        Notification.InboxStyle inboxStyle = new Notification.InboxStyle()
                .setBigContentTitle("Expanded Inbox")
                .addLine("This is Line 1")
                .addLine("This is Line 2")
                .addLine("This is Line 3")
                .setSummaryText("Summary man") ;

        Notification notification = new Notification.Builder(context)
                .setContentTitle("Inbox Normal Title")
                .setContentText("THis is normal text of Inbox notifcation")
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.wheel))
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true) // removes the notification after it is clicked
                .setStyle(inboxStyle)
                .build();

        notificationManager.notify(inboxNotfId, notification);
        inboxNotfId++ ;
    }


    public void expandedActionNotification(View v){
        Intent intent = new Intent(this, ActivityDemo_SomeText.class) ;
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 2, intent, PendingIntent.FLAG_UPDATE_CURRENT) ;

        Intent actionIntent1 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com")) ;
        PendingIntent actionPendingIntent1 = PendingIntent.getActivity(context, 3, actionIntent1, PendingIntent.FLAG_UPDATE_CURRENT) ;

        Notification notification = new Notification.Builder(context)
                .setContentTitle("Image Normal Title")
                .setContentText("THis is normal text of expanded notifcation")
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.wheel))
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true) // removes the notification after it is clicked
                .addAction(R.drawable.wheel, "Open Youtube", actionPendingIntent1)
                .build();

        notificationManager.notify(actionNotfId, notification);
        actionNotfId++ ;
    }


    public void StickyNotification(View v){
        //Note that adding an ACTION in stikcy notification, is not beneficial
        // as clicking the action does not remove the sticky notification
        // only clicking on the notification itself will remove it.
        Intent intent = new Intent(this, ActivityDemo_SomeText.class) ;
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 2, intent, PendingIntent.FLAG_UPDATE_CURRENT) ;

        Notification notification = new Notification.Builder(context)
                .setContentTitle("Form Not Filled")
                .setContentText("The deadline for some form is tomorrow fill now")
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.wheel))
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true) // removes the notification after it is clicked
                .setFlag(Notification.FLAG_NO_CLEAR, true)
                .build();

        notificationManager.notify(stickyNotfId, notification);
        stickyNotfId++ ;
    }


}