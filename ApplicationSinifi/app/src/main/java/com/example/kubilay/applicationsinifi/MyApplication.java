package com.example.kubilay.applicationsinifi;

import android.app.Application;
import android.content.res.Configuration;
import android.util.Log;

/**
 * AndroidManifest.xml dosyasında bu sınıfı belirtmelisiniz:
 * <application android:name=".MyApplication" ...></application>
 */
public class MyApplication extends Application
{
  private static MyApplication app = null;

  public MyApplication create()
  {
    return app;
  }

  @Override
  public void onCreate()
  {
    super.onCreate();
    if (app == null) {
      app = this;
    }
    Log.i("Bilgi:onCreate", "MyApplication nesnesi oluşturuldu!");
  }

  @Override
  public void onTerminate()
  {
    super.onTerminate();
  }

  @Override
  public void onConfigurationChanged(Configuration newConfig)
  {
    super.onConfigurationChanged(newConfig);
    if (newConfig.hardKeyboardHidden == Configuration.KEYBOARDHIDDEN_YES) {
      Log.i("Bilgi:klavye", "Klavye gizlendi.");
    } else if (newConfig.hardKeyboardHidden == Configuration.KEYBOARDHIDDEN_NO) {
      Log.i("Bilgi:klavye", "Klavye açıldı.");
    }

    if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
      Log.i("Bilgi:konum", "Cihaz dikey konumda.");
    } else if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
      Log.i("Bilgi:konum", "Cihaz yatay konumda.");
    }
  }
}
