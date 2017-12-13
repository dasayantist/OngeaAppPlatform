package com.knatcom.ongeaappplatform;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Sms extends AppCompatActivity {
    Button send;
EditText smsbd, counselor,telno,loc;
    private static  final int MY_PERMISSION_REQUEST_SEND_SMS = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
        send =(Button) findViewById(R.id.sender);
        counselor =(EditText) findViewById(R.id.counselor);
        smsbd =(EditText) findViewById(R.id.smsbd);
        loc =(EditText) findViewById(R.id.loc);
        telno =(EditText) findViewById(R.id.telno);
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permisssion, int[] grantResult){
        super.onRequestPermissionsResult(requestCode, permisssion, grantResult);
        switch (requestCode){
            case MY_PERMISSION_REQUEST_SEND_SMS:
            {
              if (grantResult.length>=0 && grantResult[0]== PackageManager.PERMISSION_GRANTED) {
                  MyMessage();
              }else{
                  Toast.makeText(this,"you don't have required permission to make the Action",Toast.LENGTH_SHORT).show();
              }
            }
        }
    }
    public void back(View view){
        Intent i = new Intent(this,Service1.class);
        startActivity(i);
    }

    public void sendsms(View view){
int permissiononCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS);
        if(permissiononCheck == PackageManager.PERMISSION_GRANTED){
            MyMessage();
        }else ActivityCompat.requestPermissions(this,new  String[]{Manifest.permission.SEND_SMS},
                MY_PERMISSION_REQUEST_SEND_SMS);
    }
    public void MyMessage(){
        String myNumber =telno.getText().toString().trim();
        String myMsg = smsbd.getText().toString().trim();
        String myTelno = telno.getText().toString().trim();
        String myLoc = loc.getText().toString().trim();
        if(myNumber ==null || myNumber.equals("") ||myMsg ==null || myMsg.equals("") ||myTelno ==null || myTelno.equals("") ||myLoc ==null || myLoc.equals("")){
            Toast.makeText(this,"Please field the required field",Toast.LENGTH_SHORT).show();
        }else{
            if(TextUtils.isDigitsOnly(myNumber)){
                SmsManager smsManager =SmsManager.getDefault();
                smsManager.sendTextMessage(myNumber,null, "Hello /n" + myMsg + "/n" +telno + " /n at" + loc  ,null,null);
                Toast.makeText(this,"Message sent",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this,"Please enter Interger only",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
