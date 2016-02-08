package me.austinward.ttyl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;

/**
 * Created by Kaylynn on 2/7/2016.
 */
public class IncomingSms extends BroadcastReceiver {

    // Get the object of SmsManager
    final SmsManager sms = SmsManager.getDefault();

    public void onReceive(Context context, Intent intent) {


        // Retrieves a map of extended data from the intent.
        final Bundle bundle = intent.getExtras();

        try {

            if (bundle != null) {

                final Object[] pdusObj = (Object[]) bundle.get("pdus");

                for (int i = 0; i < pdusObj.length; i++) {

                    SmsMessage currentMessage = SmsMessage.createFromPdu((byte[]) pdusObj[i]);
                    String phoneNumber = currentMessage.getDisplayOriginatingAddress();

                    String senderNum = phoneNumber;
                    String message = currentMessage.getDisplayMessageBody();




                    MainActivity test = new MainActivity();

                    String messageToSend;

                    if(test.driving && test.responded == false) {
                        String number = senderNum;
                        messageToSend = "I'm driving, ttyl!";


                        //for testing purposes, so no one else gets random texts
                        //comment this out so others can test
                        //TODO: don't forget this is here

//                        if (senderNum.equals("+16502450378")) {
                            SmsManager.getDefault().sendTextMessage(number, null, messageToSend, null, null);
//                        }

                        test.responded = true;
                    }



                } // end for loop
            } // bundle is null

        } catch (Exception e) {
            Log.e("SmsReceiver", "Exception smsReceiver" +e);

        }
    }
}