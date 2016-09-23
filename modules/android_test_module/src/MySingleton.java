// package com.android.godot; // for 1.1
package org.godotengine.godot; // for 2.0
import android.app.Activity;

public class MySingleton extends Godot.SingletonBase {

    public int myFunction(String p_str) {
        // a function to bind
        return p_str.length();
    }

    static public Godot.SingletonBase initialize(Activity p_activity) {
        return new MySingleton(p_activity);
    }

    public MySingleton(Activity p_activity) {
        //register class name and functions to bind
        registerClass("MySingleton", new String[]{"myFunction"});

        // you might want to try initializing your singleton here, but android
        // threads are weird and this runs in another thread, so you usually have to do
        p_activity.runOnUiThread(new Runnable() {
                public void run() {
                    //useful way to get config info from engine.cfg
                    String key = GodotLib.getGlobal("plugin/api_key");
                    //SDK.initializeHere();
                }
        });

    }

    // forwarded callbacks you can reimplement, as SDKs often need them

    /*protected void onMainActivityResult(int requestCode, int resultCode, Intent data) {}

    protected void onMainPause() {}
    protected void onMainResume() {}
    protected void onMainDestroy() {}

    protected void onGLDrawFrame(GL10 gl) {}
    protected void onGLSurfaceChanged(GL10 gl, int width, int height) {} // singletons will always miss first onGLSurfaceChanged call*/

}