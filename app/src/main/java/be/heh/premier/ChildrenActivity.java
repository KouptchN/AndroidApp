package be.heh.premier;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ChildrenActivity extends AppCompatActivity {
    EditText et_children_login;
    EditText et_children_pwd;
    SharedPreferences prefs_datas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_children);
        et_children_login = findViewById(R.id.et_children_login);
        et_children_pwd = findViewById(R.id.et_children_pwd);
        prefs_datas= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
    }
    public void onChildrenClickManager(View v) {
// Récupérer la vue et accéder au bouton
        if (v.getId()==R.id.bt_children_main) {
            if(et_children_login.getText().toString().isEmpty() || et_children_pwd.getText().toString().isEmpty()){
                Toast.makeText(getApplicationContext(), "Complétez tous les champs !",
                        Toast.LENGTH_SHORT).show();
            }
            else {
                SharedPreferences.Editor editeur_datas=prefs_datas.edit();
                editeur_datas.putString("login",et_children_login.getText().toString());
                editeur_datas.putString("pwd",et_children_pwd.getText().toString());
                editeur_datas.commit();
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }
        if (v.getId()==R.id.bt_children_list) {
                Intent intent = new Intent(this, ListActivity.class);
                startActivity(intent);
                finish();
        }
        if (v.getId()==R.id.bt_children_save){
            String str = et_children_login.getText().toString() + "#" +
                    et_children_pwd.getText().toString() + "#";
            Toast.makeText(getApplicationContext(),str,Toast.LENGTH_LONG).show();
            try {
                FileOutputStream ous = openFileOutput("monfichier.txt", MODE_APPEND);
                byte[] tab;
                tab = str.toString().getBytes();
                ous.write(tab);
                ous.close();

            }catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(v.getId()==R.id.bt_children_File){
            Intent intentFile = new Intent(this, FileActivity.class);
            startActivity(intentFile);
        }
    }
}