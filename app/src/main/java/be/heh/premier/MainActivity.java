package be.heh.premier;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
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
            Toast.makeText(getApplicationContext(), "Clic sur bt : ==> Enfant", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, ChildrenActivity.class);
            startActivity(intent);
        }
    }
}