# Live Wallpaper Bug Demo

# Expected: (Android Q / QQ2A.200405.005)

- Can open wallpaper preview 

# Actual Result: (Android R DP3 / RPP3.200320.017)

- Wallpaper preview does not show up with logs:

```
2020-04-27 13:58:36.614 1450-3354/? I/ActivityTaskManager: START u0 {act=android.service.wallpaper.CHANGE_LIVE_WALLPAPER flg=0x10000000 cmp=com.android.wallpaper.livepicker/.LiveWallpaperChange (has extras)} from uid 10256
2020-04-27 13:58:36.614 1450-1555/? E/EventSequenceValidator: IntentStarted during UNKNOWN.Intent { act=android.service.wallpaper.CHANGE_LIVE_WALLPAPER flg=0x10000000 (has extras) }
2020-04-27 13:58:36.615 1450-1555/? I/EventSequenceValidator: inc AccIntentStartedEvents to 2
2020-04-27 13:58:36.615 1450-1561/? I/DropBoxManagerService: add tag=system_server_wtf isTagEnabled=true flags=0x2
2020-04-27 13:58:36.619 831-831/? D/android.hardware.power@1.3-service.pixel-libperfmgr: LAUNCH: 1
2020-04-27 13:58:36.624 1450-1555/? E/EventSequenceValidator: onActivityLaunched during UNKNOWN.
2020-04-27 13:58:36.624 1148-2188/? D/iorapd: AppLaunchEventState#OnNewEvent aborting trace due to non-cold temperature
2020-04-27 13:58:36.625 1450-1561/? I/DropBoxManagerService: add tag=system_server_wtf isTagEnabled=true flags=0x2
2020-04-27 13:58:36.635 8237-8237/? W/CHANGE_LIVE_WALLPAPER: Not a live wallpaper: ComponentInfo{com.justzht.bug.lwp/com.justzht.bug.lwp.MainWallpaperService}
2020-04-27 13:58:36.638 1450-1555/? E/EventSequenceValidator: onActivityLaunchCancelled during UNKNOWN.
2020-04-27 13:58:36.638 1450-1555/? I/EventSequenceValidator: dec AccIntentStartedEvents to 1
2020-04-27 13:58:36.660 831-831/? D/android.hardware.power@1.3-service.pixel-libperfmgr: LAUNCH: 0
```

# How to reproduce

- Build & run the app
- Click preview button
