package be.heh.premier;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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