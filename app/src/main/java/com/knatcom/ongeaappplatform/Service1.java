package com.knatcom.ongeaappplatform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Service1 extends AppCompatActivity {
    RadioGroup types=null;
    RadioButton radioSms, radioCall;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service1);
        radioCall= (RadioButton) findViewById(R.id.call);
        radioSms= (RadioButton) findViewById(R.id.sms);
    }


public void initiate(View view) {
    if (radioCall.isChecked()){
        Intent main = new Intent(Service1.this, Call.class);
        startActivity(main);
    }else {
        Intent m = new Intent(Service1.this, Sms.class);
        startActivity(m);
    }
  /* switch (types.getCheckedRadioButtonId()) {
        case R.id.Call:
            Intent main = new Intent(Service1.this, Call.class);
            startActivity(main);
            break;
        case R.id.Sms:
            Intent m = new Intent(Service1.this, Sms.class);
            startActivity(m);
            break;

    }*/
}


}
