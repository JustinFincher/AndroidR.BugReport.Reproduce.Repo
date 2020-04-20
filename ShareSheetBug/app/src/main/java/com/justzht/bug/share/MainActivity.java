package com.justzht.bug.share;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.databinding.DataBindingUtil;

import com.justzht.bug.share.databinding.ActivityMainBinding;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setActivity(this);
    }

    public void share(View v)
    {
        Log.d("MainActivity", "share");
        File cacheDir = getCacheDir();
        File savedFile = new File(cacheDir.getAbsolutePath(),"thisisfine.jpg");

        Bitmap bitmap = BitmapFactory.decodeResource(v.getResources(),R.mipmap.this_is_fine);
        if (bitmap == null) { return; }

        try {
            FileOutputStream outputStream = new FileOutputStream(savedFile.getAbsolutePath());
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!savedFile.exists()) { return; }
        Uri uri = FileProvider.getUriForFile(v.getContext(), "com.justzht.bug", savedFile);

        Intent sendIntent = new Intent(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "test");
        sendIntent.putExtra(Intent.EXTRA_STREAM, uri);
        sendIntent.setDataAndType(uri,"image/jpg");
        sendIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        Intent chooser = Intent.createChooser(sendIntent, "test share");

        Intent saveImageIntent = new Intent(v.getContext(), SaveImageActivity.class);
        saveImageIntent.putExtra("path",savedFile.getAbsolutePath());

        Intent[] extraIntents = { saveImageIntent };
        chooser.putExtra(Intent.EXTRA_INITIAL_INTENTS,  extraIntents);
        this.startActivity(chooser);
    }
}
