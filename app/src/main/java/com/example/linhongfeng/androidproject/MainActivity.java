package com.example.linhongfeng.androidproject;

import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.linhongfeng.androidproject.activity.ChangeWallpaperActivity;

import java.io.IOException;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mChangeWallpaper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mChangeWallpaper = findViewById(R.id.btn_change_wallpaper);
        mChangeWallpaper.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_change_wallpaper:
                Intent intent = new Intent(MainActivity.this, ChangeWallpaperActivity.class);
                startActivity(intent);
                initSkin();
                break;
        }
    }


    private void initSkin() {
        try {
            //使用资源文件  当然你也可以使用其他图片bitmap
            BitmapDrawable bitmap = (BitmapDrawable) getResources().getDrawable(R.drawable.a);
            WallpaperManager manager = WallpaperManager.getInstance(this);
            manager.setBitmap(bitmap.getBitmap());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
