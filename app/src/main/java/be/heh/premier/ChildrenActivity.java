package be.heh.premier;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ChildrenActivity extends AppCompatActivity {
    EditText et_children_login;
    EditText et_children_pwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_children);
        et_children_login = findViewById(R.id.et_children_login);
        et_children_pwd = findViewById(R.id.et_children_pwd);
    }
    public void onChildrenClickManager(View v) {
// Récupérer la vue et accéder au bouton
        if (v.getId()==R.id.bt_children_main) {
            Toast.makeText(getApplicationContext(),
                    " Login : " + et_children_login.getText() + "\n Password : " + et_children_pwd.getText(),
                    Toast.LENGTH_SHORT).show();
            Intent intentMain = new Intent(this, MainActivity.class);
            startActivity(intentMain);
        }
        if(v.getId()==R.id.bt_children_list){
            Intent intentList = new Intent(this, ListActivity.class);
            startActivity(intentList);
        }
    }
}