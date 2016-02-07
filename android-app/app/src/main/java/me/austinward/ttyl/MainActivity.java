package me.austinward.ttyl;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.SmsManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button1;
    static Boolean driving = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Learn more: talktoyoulater.net", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(this);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

//    public void goToMaps() {
////        Snackbar.make(view, "Load Google Maps", Snackbar.LENGTH_LONG)
////                .setAction("Action", null).show();
////        Intent intent = new Intent(this,MapsActivity.class);
////        startActivity(intent);
//    }

    private void button1Click() {

    }
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.button1:
                driving();
                break;
        }
    }

    public void driving() {

        if (driving) {
            driving = false;
        }
        else {
            driving = true;
        }

        Context context = getApplicationContext();
        CharSequence text = "You are not driving";
        if (driving) {
            text = "You are driving";
        }

        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        TextView drivingDisplay=(TextView)findViewById(R.id.textView);
        if(driving) {
            drivingDisplay.setText("Driving");
        }
        else {
            drivingDisplay.setText("Not driving");
        }



    }



    public void textBack() {
        if(driving) {
            String messageToSend = "I am driving, ttyl!";
            String number = "+16319013544";

            SmsManager.getDefault().sendTextMessage(number, null, messageToSend, null,null);
        }
    }

}
