package com.justzht.bug.lwp;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.justzht.bug.lwp.R;
import com.justzht.bug.lwp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private static final String TAG  = "MainActivity";

    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setActivity(this);
    }

    public void openLwpPreview(View v)
    {
        Intent intent;
        try {
            intent = new Intent("android.service.wallpaper.CHANGE_LIVE_WALLPAPER");
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra("android.service.wallpaper.extra.LIVE_WALLPAPER_COMPONENT", new ComponentName(this, MainWallpaperService.class));
            startActivity(intent);
        } catch (Exception ex) {
            Log.e(TAG, "openLwpPreview: " + ex);
            try {
                intent = new Intent("android.intent.action.SET_WALLPAPER");
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            } catch (Exception ex1) {
                Log.e(TAG, "openLwpPreview: " + ex1);
            }
        }
    }
}
