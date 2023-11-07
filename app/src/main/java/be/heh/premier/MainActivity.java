package be.heh.premier;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.BatteryManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {
    private static final int NOTIFY_ID=1234;
    NotificationManager noma =null;
    int cpt=0;
    SharedPreferences prefs_datas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prefs_datas = PreferenceManager.getDefaultSharedPreferences(getApplication());
        noma=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        if(!prefs_datas.getAll().isEmpty())
        {
            Toast.makeText(getApplicationContext(), "votre login est : "
                            + prefs_datas.getString("login","NULL") + "\n"
                            + "votre password est : " + prefs_datas.getString("pwd","NULL") + "\n",
                            Toast.LENGTH_SHORT)
                    .show();
        }
    }
    public void onMainClickManager(View v) {
// Récupérer la vue et accéder au bouton
        if (v.getId()==R.id.bt_main_children) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Alerte activité")
                            .setMessage("Voulez-vous afficher l'activité Children ?")
                            .setCancelable(false)
                            .setIcon(R.mipmap.ic_launcher)
                            .setPositiveButton("Oui", (dialog, which) -> {
                                notifier();
                            })
                            .setNegativeButton("Annuler", (dialog, which) -> dialog.cancel())
                            .create().show();
        }
    }
    private void notifier() {
        Intent intent = new Intent(this, ChildrenActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE);
        BatteryManager bm = (BatteryManager)getSystemService(BATTERY_SERVICE);
        int batLevel = bm.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY);
        NotificationManager noma = getSystemService(NotificationManager.class);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("default_channel", "Default Channel", NotificationManager.IMPORTANCE_DEFAULT);
            noma.createNotificationChannel(channel);
        }

        Notification.Builder notification = new Notification.Builder(this, "default_channel")
                .setAutoCancel(true)
                .setContentTitle("Notification !")
                .setContentText("Cliquez pour passer a l'activité Enfant.\n"+"Niveau de batterie :"+batLevel)
                .setContentIntent(pi)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setWhen(System.currentTimeMillis())
                .setNumber(++cpt);

        Notification notif = notification.build();

        noma.notify(NOTIFY_ID, notif);
    }

    public void arretNotifier() {
        NotificationManager noma = getSystemService(NotificationManager.class);
        noma.cancel(NOTIFY_ID);
    }
}