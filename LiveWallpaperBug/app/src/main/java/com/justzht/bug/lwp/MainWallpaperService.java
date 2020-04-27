package com.justzht.bug.lwp;

import android.service.wallpaper.WallpaperService;

public class MainWallpaperService extends WallpaperService {
    @Override
    public Engine onCreateEngine() {
        return new MainWallpaperEngine();
    }

    private class MainWallpaperEngine extends Engine
    {

    }
}
