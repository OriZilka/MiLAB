package com.example.orizilka.ex_03_notifications;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;


/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class QuoteService extends IntentService {
    // TODO: Rename actions, choose action names that describe tasks that this
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    public static final String ACTION_ONE = "com.example.orizilka.ex_03_notifications.action.ONE";
    public static final String ACTION_TWO = "com.example.orizilka.ex_03_notifications.action.TWO";

    public static final String[] Array = {"Lorem Ipsum Story", "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
                                        "Donec eget aliquam ante.",
                                        "Cras risus augue, consequat non quam non, tincidunt dictum eros.",
                                        "Fusce nec arcu quam.", "Donec accumsan turpis mollis nunc aliquet, eget faucibus quam malesuada.",
                                        "Aliquam nunc ipsum, feugiat sed fermentum ut, viverra at ipsum. Cras aliquam, ipsum non interdum feugiat, eros massa scelerisque neque, id scelerisque nisl orci sed eros.",
                                        "Maecenas aliquet ut erat a auctor.",
                                        "In in pharetra arcu.",
                                        "Donec nisl justo, tincidunt vel pharetra sit amet, lobortis quis velit.",
                                        "Phasellus sit amet nisi ante.",
                                        "Pellentesque pretium, est rhoncus lacinia maximus, metus ex ultricies diam, sed faucibus risus nibh eget metus.",
                                        "Praesent hendrerit dignissim eros, a tristique ex bibendum at.",
                                        "Nullam fermentum porttitor felis, eget fermentum sapien varius nec.",
                                        "Donec consequat mattis quam, ac euismod sem eleifend vitae.",
                                        "Nulla ipsum nisl, sodales nec egestas vel, molestie eu purus.",
                                        "Fusce semper convallis ultrices. Nulla vel gravida tortor.",
                                        "Etiam pellentesque elementum justo, vitae mollis risus malesuada id.",
                                        "Mauris placerat pretium tortor eu tincidunt. Vivamus luctus nisl velit, non eleifend dolor consectetur in.",
                                        "Mauris tempor, dui quis aliquam lobortis, lectus dui scelerisque quam, id bibendum massa nisl ut sem.",
                                        "Vestibulum aliquam libero sed posuere posuere.",
                                        "Morbi aliquet fermentum lacus vel vestibulum.",
                                        "Nulla ante felis, volutpat sed ornare nec, sodales placerat nisi.",
                                        "Donec consectetur accumsan vehicula. ",
                                        "Cras dapibus sapien eget nisl malesuada, sit amet pretium nibh pharetra.",
                                        "Sed scelerisque sem in velit pretium lobortis a et arcu",
                                        "Integer ac ipsum enim. ",
                                        "Vestibulum in sem ut tortor ultrices blandit.",
                                        "In eget tortor quis metus finibus molestie non a ante.",
                                        "Nam et imperdiet tortor. Etiam at diam egestas, ornare odio mollis, ornare felis.",
                                        "Praesent lacus libero, pulvinar sed rutrum vitae, cursus vitae dolor.",
                                        "Mauris at elementum lectus.",
                                        "In id tellus porttitor, aliquam sem a, luctus dui.",
                                        "Vivamus egestas tincidunt nibh, eget mollis magna accumsan quis.",
                                        "Aenean dictum augue aliquam lectus imperdiet egestas.",
                                        "Nunc elementum sollicitudin accumsan.",
                                        "Pellentesque fringilla vel mauris non fermentum. Nulla facilisi.",
                                        "Vivamus ac bibendum risus. In eget enim facilisis, posuere est quis, fringilla ligula.",
                                        "Sed ac nisi egestas, euismod massa et, varius eros.",
                                        "Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae;",
                                        "Suspendisse condimentum elit in vehicula vestibulum.",
                                        "Sed eget velit et arcu posuere aliquam a non risus. ",
                                        "Vestibulum in lectus vel ligula molestie tempus.",
                                        "Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.",
                                        "Nullam congue, leo eu accumsan pulvinar, felis velit mollis lacus, quis interdum massa diam a arcu.",
                                        "Aliquam dictum ex nec magna ultricies sagittis. ",
                                        "Vestibulum aliquam quam elit, in congue mi maximus eget. ",
                                        "Mauris dolor tellus, tempus vitae enim a, pulvinar tincidunt purus.",
                                        "Cras a accumsan odio, at aliquam risus.",};


    public static AlarmManager myAlarmer;
    public static NotificationManagerCompat notificationManager;
    public static int intentNumber = 1;
    public static final long SEC_BETWEEN_NOTIFICATIONS = 50 * 100;
    private static int placeInArray = 0;



    public QuoteService() {
        super("QuoteService");
    }

    /**
     * Starts this service to perform action one with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionOne(Context context) {
        Intent intent = new Intent(context, QuoteService.class);
        intent.setAction(ACTION_ONE);
        context.startService(intent);
    }

    /**
     * Starts this service to perform action one with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionTwo(Context context) {
        Intent intent = new Intent(context, QuoteService.class);
        intent.setAction(ACTION_TWO);
        context.startService(intent);
    }



    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_ONE.equals(action)) {
                startAlarmManager();
                handleActionOne();
            } else {
                    if (ACTION_TWO.equals(action)){
                        handleActionOne();
                    } else {
                    throw new RuntimeException("Unknown action was given"); }
            }
        }
    }

    private void startAlarmManager() {
        Intent myIntent = new Intent(this, NotificationReceiver.class);
        myAlarmer = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
        myAlarmer.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                SystemClock.elapsedRealtime(), SEC_BETWEEN_NOTIFICATIONS,
                PendingIntent.getBroadcast(this, 0, myIntent, 0));
        registerNotificationChannel();

    }

    protected void registerNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationManager nm = getSystemService(NotificationManager.class);
            nm.createNotificationChannel(new NotificationChannel("ID", "1", NotificationManager.IMPORTANCE_HIGH));
        }
    }

    /**
     * Handle action one in the provided background thread with the provided
     * parameters.
     */
    private void handleActionOne() {
        // TODO: Handle action one

        String currentQuote = Array[placeInArray];
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "ID")
                .setSmallIcon(R.drawable.ic_launcher)
                .setContentTitle(currentQuote)
                .setAutoCancel(false)
                .setPriority(NotificationCompat.PRIORITY_HIGH);

        notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(intentNumber, builder.build());

        placeInArray = (++placeInArray % Array.length);
    }


}
