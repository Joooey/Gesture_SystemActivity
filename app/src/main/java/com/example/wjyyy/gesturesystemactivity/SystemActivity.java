package com.example.wjyyy.gesturesystemactivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.wjyyy.gesturesystemactivity.Util.SystemAction;

import org.jetbrains.annotations.Nullable;

/**
 * Created by Wjyyy on 2018/6/16.
 */

public class SystemActivity extends Activity {

    public Button btnApproachRecord;
    public Button btnApartRecord;
    public Button btnClickRecord;
    public Button btnFlipRecord;
    public Button btnCircleRecord;
   // private AudioManager audioManager = null; // 音频

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnApproachRecord= (Button) findViewById(R.id.btnapproachrecord);
        btnApartRecord = (Button) findViewById(R.id.btnapartrecord);
        btnFlipRecord = (Button) findViewById(R.id.btnfliprecord);
        btnCircleRecord = (Button) findViewById(R.id.btncirclerecord);
        btnClickRecord = (Button) findViewById(R.id.btnclickrecord);
       // audioManager = (AudioManager) getSystemService(Service.AUDIO_SERVICE);


        InitListener();

//        try {
//            Init();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }


    SystemAction systemAction = new SystemAction(SystemActivity.this);
    private void InitListener() {

        btnApproachRecord.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                systemAction.lighter();
            }
        });


        btnApartRecord.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                systemAction.darker();
            }
        });

        btnFlipRecord.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                systemAction.showdesk();
            }
        });


        btnCircleRecord.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                systemAction.volumeup();
            }
        });

        btnClickRecord.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                systemAction.volumedown();
            }
        });


    }

}


