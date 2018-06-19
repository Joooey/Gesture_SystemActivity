package com.example.wjyyy.gesturesystemactivity.Util;

import android.app.Activity;
import android.app.Service;
import android.content.ContentResolver;
import android.content.Intent;
import android.media.AudioManager;
import android.provider.Settings;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by Wjyyy on 2018/6/17.
 */

public class SystemAction {

    private Activity context;
    private int brightness;
    private int change_value = 45;

    public SystemAction(Activity context) {
        this.context = context;
        setScrennManualMode();
        brightness = getScreenBrightness();

    }

    public void setScrennManualMode() {
        ContentResolver contentResolver = context.getContentResolver();
        try {
            int mode = Settings.System.getInt(contentResolver,
                    Settings.System.SCREEN_BRIGHTNESS_MODE);
            if (mode == Settings.System.SCREEN_BRIGHTNESS_MODE_AUTOMATIC) {
                Settings.System.putInt(contentResolver, Settings.System.SCREEN_BRIGHTNESS_MODE,
                        Settings.System.SCREEN_BRIGHTNESS_MODE_MANUAL);
            }
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void lighter() {
        if (brightness <= 255-change_value) {
            brightness += change_value;

        }else {
            brightness=255;
        }

        setScreenBrightness(brightness);
        /*int brightnessValue = getScreenBrightness();
        if (brightnessValue < 180)
            brightnessValue += 75;
        else
            brightnessValue = 255;
        Window localWindow = context.getWindow();
        WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
        localLayoutParams.screenBrightness = brightnessValue / 255.0F;
        localWindow.setAttributes(localLayoutParams);*/
    }

    public void darker() {
        if (brightness >= change_value) {
            brightness -= change_value;

        }else {
            brightness=0;
        }
        setScreenBrightness(brightness);
        /*int brightnessValue = getScreenBrightness();
        if (brightnessValue > 75)
            brightnessValue -= 75;
        Window localWindow = context.getWindow();
        WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
        localLayoutParams.screenBrightness = brightnessValue / 255.0F;
        localWindow.setAttributes(localLayoutParams);*/
    }

    public void showdesk() {

        Intent i = new Intent(Intent.ACTION_MAIN);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i.addCategory(Intent.CATEGORY_HOME);
        context.startActivity(i);

    }

    private AudioManager audioManager = null; // 音频


    public void volumedown() {

        audioManager = (AudioManager) context.getSystemService(Service.AUDIO_SERVICE);
        audioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC,
                AudioManager.ADJUST_LOWER, AudioManager.FLAG_PLAY_SOUND
                        | AudioManager.FLAG_SHOW_UI);
    }

    public void volumeup() {

        audioManager = (AudioManager) context.getSystemService(Service.AUDIO_SERVICE);
        audioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC,
                AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND
                        | AudioManager.FLAG_SHOW_UI);
    }

    //    public void backtoapp(){
//        Intent intent = new Intent(context.this);
//        intent.addCategory(Intent.CATEGORY_LAUNCHER);
//        intent.setAction(Intent.ACTION_MAIN);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
//    }
    private int getScreenBrightness() {
        ContentResolver contentResolver = context.getContentResolver();
        int defVal = 125;
        return Settings.System.getInt(contentResolver,
                Settings.System.SCREEN_BRIGHTNESS, defVal);
    }


    private void setScreenBrightness(int value) {
        setScrennManualMode();
        ContentResolver contentResolver = context.getContentResolver();
        Settings.System.putInt(contentResolver,
                Settings.System.SCREEN_BRIGHTNESS, value);
    }


}

