package com.example.kubilay.titresim;

import android.content.Context;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity
{
  /**
   * Not: AndroidManifest.xml dosyasına şunu eklemelisiniz:
   * <uses-permission android:name="android.permission.VIBRATE" />
   */
  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  // 2 saniye titreştiren metot
  public void btnTitret_1_onClick(View view)
  {
    Vibrator vibrator = (Vibrator)
        this.getSystemService(Context.VIBRATOR_SERVICE);
    vibrator.vibrate(2000);
  }

  // ???
  public void btnTitret_2_onClick(View view)
  {
    Vibrator vibrator = (Vibrator)
        this.getSystemService(Context.VIBRATOR_SERVICE);
    long pattern[] = { 1000, 500, 1000, 1000 };
    vibrator.vibrate(pattern, 0);
  }
}
