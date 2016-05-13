package com.slabs.rcguattendance;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Environment;
import android.text.Editable;
import android.util.EventLog;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

/**
 * Created by Sreekanth Putta on 11-05-2016.
 */
public class settings extends Activity
{
    EditText Eseteventname, Epassword;
    TextView Tseteventname;
    Button Bseteventname, Bpassword;
    public String pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        getActionBar().setDisplayHomeAsUpEnabled(true);

        Eseteventname   = (EditText) findViewById(R.id.eseteventname);
        Tseteventname   = (TextView) findViewById(R.id.tseteventname);
        Bseteventname   = (Button) findViewById(R.id.bseteventname);
        Epassword       = (EditText) findViewById(R.id.epassword);



        Bseteventname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Eseteventname.getText().length()!=0){
                    // Create custom dialog object
                    final Dialog dialog = new Dialog(settings.this);
                    // Include dialog.xml file
                    dialog.setContentView(R.layout.custom_dialog);
                    // Set dialog title
                    dialog.setTitle("Authentication");

                    // set values for custom dialog components - text, image and button

                    dialog.show();

                    Bpassword       = (Button)dialog.findViewById(R.id.bpassword);
                    Bpassword.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            auth();
                            //Log.e("qqqqqqqqqqqqqqqqqwwwwwwwwwwwwwwwwwwwwwwwwwwwww",pass);
                            dialog.dismiss();
                        }
                    });
                }
                else {
                    Eseteventname.setError("Can't be empty");
                }

            }
        });
    }
    public void auth(){
        pass="rcgu123$";
        //Log.e(pass, String.valueOf(R.string.password));
        if(pass.equals(pass)){
            Toast.makeText(getApplicationContext(),"Password Matched",Toast.LENGTH_LONG).show();
            MainActivity.Eventname=Eseteventname.getText().toString();
            MainActivity.Tevent.setText(Eseteventname.getText().toString());
            if(new File(Environment.getExternalStorageDirectory().getPath()+"/RCGU Attendance/"+MainActivity.Tevent.getText().toString()+".xls").exists()){
                Toast.makeText(getApplicationContext(),"Adding people to the Existing event",Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(getApplicationContext(),"New Event created",Toast.LENGTH_SHORT).show();
            }
            Log.e(Eseteventname.getText().toString(),"njbjkxcv");
        }
    }
}
