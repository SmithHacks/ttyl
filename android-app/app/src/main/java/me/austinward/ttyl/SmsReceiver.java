package me.austinward.ttyl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class SmsReceiver extends BroadcastReceiver {

    public static int MSG_TPE=0;
    private String getAddress;
    public void onReceive(Context context, Intent intent) {
//        String MSG_TYPE=intent.getAction();
//        if(MSG_TYPE.equals("android.provider.Telephony.SMS_RECEIVED")) {
////            Toast received = Toast.makeText(context,"SMS Received: "+MSG_TYPE , Toast.LENGTH_LONG);
////            received.show();
//
//            Bundle bundle = intent.getExtras();
//            Object messages[] = (Object[]) bundle.get("pdus");
//            SmsMessage smsMessage[] = new SmsMessage[messages.length];
//            for (int n = 0; n < messages.length; n++) {
//                smsMessage[n] = SmsMessage.createFromPdu((byte[]) messages[n]);
//            }
//
//            getAddress = smsMessage[0].getOriginatingAddress();
//            // Filter incoming messages
//            if(getAddress.equals("APPROVEDPHONENUMBER")) {
////                Toast approved = Toast.makeText(context,"Approved SMS from: " + smsMessage[0].getOriginatingAddress(), Toast.LENGTH_LONG);
////                approved.show();
//                // Message is approved and let through
//            } else {
////                Toast blocked = Toast.makeText(context,"Blocked SMS from: " + smsMessage[0].getOriginatingAddress(), Toast.LENGTH_LONG);
////                blocked.show();
////                // Message is blocked
//                abortBroadcast();
//            }
//            // End filter
//            for(int i=0;i<8;i++) {
//                System.out.println("Blocking SMS");
//            }

        }

    }

