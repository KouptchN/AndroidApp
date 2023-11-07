package be.heh.premier;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileActivity extends AppCompatActivity {
    TextView tv_file_datas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);
        tv_file_datas = (TextView) findViewById(R.id.tv_file_datas);
        tv_file_datas.setText("Contenu du fichier texte : \n");
        try{
            FileInputStream ins = openFileInput("monfichier.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(ins));
            StringBuilder out = new StringBuilder();
            String line;
            while((line = reader.readLine()) != null){
                out.append(line);
            }
            reader.close();
            ins.close();
            String[] items = out.toString().split("#");
            int i=0;
            int j=0;
            String chain="";
            String name="";
            for (String item : items)
            {
                if(i%2==0) {
                    j++;
                    name="Login";
                }else{
                    name="Password";
                }
                 chain = tv_file_datas.getText().toString() + Integer.toString(j) + ". "+
                         name  + " = " + item + "\n";
                tv_file_datas.setText(chain);
                i++;
            }
        }catch (FileNotFoundException e) { e.printStackTrace();}
        catch (IOException e) {e.printStackTrace();}
    }
    public void onFileClickManager(View v) {
        if (v.getId()==R.id.bt_file_children) {
                Intent intent = new Intent(this, ChildrenActivity.class);
                startActivity(intent);
                finish();
        }
    }
}