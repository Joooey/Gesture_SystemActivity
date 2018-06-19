package com.example.wjyyy.gesturesystemactivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.example.wjyyy.gesturesystemactivity.Util.ActivityManager;
import com.example.wjyyy.gesturesystemactivity.Util.SystemAction;
import com.github.dfqin.grantor.PermissionListener;
import com.github.dfqin.grantor.PermissionsUtil;

import org.jetbrains.annotations.Nullable;

/**
 * Created by Wjyyy on 2018/6/16.
 */

public class SystemActivity extends Activity {

    private Button btnApproachRecord;
    private Button btnApartRecord;
    private Button btnClickRecord;
    private Button btnFlipRecord;
    private Button btnCircleRecord;
    private SystemAction systemAction;
    private ActivityManager activityManager;


    @Override
    protected void onStart() {
        Log.i("info","onStart");
        super.onStart();
    }
    @Override
    protected void onRestart() {
        Log.i("info","onRestart");
        super.onRestart();
    }
    @Override
    protected void onResume() {
        Log.i("info","onResume");
        super.onResume();
    }
    @Override
    protected void onPostResume() {
        Log.i("info","onPostResume");
        super.onPostResume();
    }
    @Override
    protected void onPause() {
        Log.i("info","onPause");
        super.onPause();
    }
    @Override
    protected void onStop() {
        Log.i("info","onStop");
        super.onStop();
    }
    @Override
    protected void onDestroy() {
        Log.i("info","onDestroy");
        super.onDestroy();
    }


    // private AudioManager audioManager = null; // 音频

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RequestPermission();
        btnApproachRecord= (Button) findViewById(R.id.btnapproachrecord);
        btnApartRecord = (Button) findViewById(R.id.btnapartrecord);
        btnFlipRecord = (Button) findViewById(R.id.btnfliprecord);
        btnCircleRecord = (Button) findViewById(R.id.btncirclerecord);
        btnClickRecord = (Button) findViewById(R.id.btnclickrecord);
       // audioManager = (AudioManager) getSystemService(Service.AUDIO_SERVICE);
         systemAction = new SystemAction(SystemActivity.this);
     //   activityManager=new ActivityManager();
      //  activityManager.addActivity("app",SystemActivity.this);
        //activityManager.addActivity("sys",);


     InitListener();

//        try {
//            Init();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }



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

    private void RequestPermission() {
        String[] permissions = {Manifest.permission.WRITE_SETTINGS};
        if (PermissionsUtil.hasPermission(SystemActivity.this, permissions)) {
            //已经获取相关权限
        } else {
            PermissionsUtil.requestPermission(SystemActivity.this, new PermissionListener() {
                @Override
                public void permissionGranted(@NonNull String[] permission) {
//用户授予了权限
                }

                @Override
                public void permissionDenied(@NonNull String[] permission) {
//用户拒绝了权限
                    Toast.makeText(SystemActivity.this, "相关权限被拒绝，本应用将无法正常运行", Toast.LENGTH_SHORT).show();
                }
            }, permissions);
        }
    }

}


