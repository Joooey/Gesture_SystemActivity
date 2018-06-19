package com.example.wjyyy.gesturesystemactivity.Util;

import android.app.Activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Wjyyy on 2018/6/18.
 */

public class ActivityManager {
    private Map<String,Activity> activityMap;

    public ActivityManager() {
        activityMap=new HashMap<String, Activity>();
    }

    public void addActivity(String key,Activity activity){
       activityMap.put(key,activity);
    }
}
