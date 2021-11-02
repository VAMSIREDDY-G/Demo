package edu.umkc.demo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SummaryActivity extends AppCompatActivity {

    TextView myMsg;
    Button btn,btn2;
//    String Msg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        Intent intent = getIntent();
        myMsg = (TextView) findViewById(R.id.textmsg);
        myMsg.setText(getIntent().getStringExtra("MESSAGE"));
//        Msg=getIntent().getStringExtra("MESSAGE");
//        Msg = intent.getStringExtra("MESSAGE");


        btn = findViewById(R.id.goToOrder);
        //btn2 = findViewById(R.id.subBtn);

        btn.setOnClickListener((view) -> {

            Intent intent2 = new Intent(SummaryActivity.this, MainActivity.class);
            startActivity(intent2);
        });
    }

//    public void sendEmail(View view) {
//
//        Intent intent2 = new Intent(Intent.ACTION_SEND);
//        intent2.setType("text/plain");
//        intent2.putExtra(Intent.EXTRA_EMAIL, new String[]{"preethiyadav1997@gmail.com"});
//        intent2.putExtra(Intent.EXTRA_SUBJECT, "Pizza Ordering App's Order");
//        intent2.putExtra(Intent.EXTRA_TEXT, Msg);
//
////        if (intent.resolveActivity(getPackageManager()) != null) {
////            startActivity(intent);
////        }
//            Intent intent3 = new Intent(Intent.ACTION_VIEW);
//            if (intent3.resolveActivity(getPackageManager()) !=null){
//                startActivity(intent3);
//            }
//        }

}