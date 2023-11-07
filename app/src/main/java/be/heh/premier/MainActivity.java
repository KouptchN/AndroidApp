package be.heh.premier;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {
    SharedPreferences prefs_datas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prefs_datas = PreferenceManager.getDefaultSharedPreferences(getApplication());
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
                            .setPositiveButton("Oui", new DialogInterface.OnClickListener(){
                                @Override
                                public void onClick(DialogInterface dialog, int which){
                                    Intent intent = new Intent(getApplicationContext(), ChildrenActivity.class);
                                    startActivity(intent);
                                }
                            })
                            .setNegativeButton("Annuler",new DialogInterface.OnClickListener(){
                                @Override
                                public void onClick(DialogInterface dialog, int which){
                                    dialog.cancel();
                                }
                            })
                            .create().show();
        }
    }
}