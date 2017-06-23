package com.example.liukang.splashdemo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button mSpJumpBtn;
    CountDownTimer countDownTimer = new CountDownTimer(3200,1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            mSpJumpBtn.setText("跳过("+millisUntilFinished/1000+"s)");
        }

        @Override
        public void onFinish() {
            mSpJumpBtn.setText("跳过(0s)");
            gotoSecondActivity();
        }
    };
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSpJumpBtn = (Button) findViewById(R.id.sp_jump_btn);
        mSpJumpBtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                gotoSecondActivity();
            }
        });
        startClock();
    }

    private void startClock(){
        mSpJumpBtn.setVisibility(View.VISIBLE);
        countDownTimer.start();
    }

    public void gotoSecondActivity(){
        Intent intent = new Intent(MainActivity.this,SecondActivity.class);
        startActivity(intent);
        finish();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(countDownTimer!=null){
            countDownTimer.cancel();
        }
    }


}
