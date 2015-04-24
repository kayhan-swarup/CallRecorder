package com.example.kayhan.callrecorder;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.sip.SipSession;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Kayhan on 4/24/2015.
 */
public class CallReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {


        try{
            String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
            Bundle bundle = intent.getExtras();
            int state1=bundle.getInt(TelephonyManager.EXTRA_STATE);
            if(state.equals(TelephonyManager.EXTRA_STATE_RINGING))
            {
                Toast.makeText(context, "Phone Is Ringing", Toast.LENGTH_LONG).show();
                // Your Code
            }

            if(state.equals(TelephonyManager.EXTRA_STATE_OFFHOOK))
            {
                Toast.makeText(context, "Call Recieved", Toast.LENGTH_LONG).show();
                // Your Code
            }

            if (state.equals(TelephonyManager.EXTRA_STATE_IDLE))
            {

                Toast.makeText(context, "Phone Is Idle", Toast.LENGTH_LONG).show();
                // Your Code

            }
        }catch (Exception e){}

//
//        TelephonyManager manager  = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
//        manager.listen(new MyPhoneStateListener(context),PhoneStateListener.LISTEN_CALL_STATE);

    }


    private class MyPhoneStateListener extends PhoneStateListener {
        Context context;
        MyPhoneStateListener(Context context){
            this.context = context;
        }
        public void onCallStateChanged(int state, String incomingNumber) {

            Log.d("MyPhoneListener", state + "   incoming no:" + incomingNumber);

            if (state == TelephonyManager.CALL_STATE_RINGING) {
                //Record Call
                Toast.makeText(context,"Received!!!!", Toast.LENGTH_LONG).show();
                Log.d("STATE","RECEIVED!");

            }
        }
    }
}
