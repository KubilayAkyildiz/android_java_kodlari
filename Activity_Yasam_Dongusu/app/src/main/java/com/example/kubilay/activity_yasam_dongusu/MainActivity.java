package com.example.kubilay.activity_yasam_dongusu;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity
{
  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Log.i("Bilgi:onCreate", "onCreate metodu çalıştı! Activity nesnesi oluşturuldu!");
  }

  @Override
  protected void onResume()
  {
    super.onResume();
    Log.i("Bilgi:onResume", "onResume metodu çalıştı! Activity yığında (stack) ön plana geldi!");
  }

  @Override
  protected void onDestroy()
  {
    super.onDestroy();
    Log.w("Bilgi:onDestroy", "onDestroy metodu çalıştı! Activity nesnei yok edildi");
  }

  @Override
  protected void onPause()
  {
    super.onPause();
    Log.w("Bilgi:onPause", "onPause metodu çalıştı! Activity yığında (stack) arka plana gitti!");
  }

  @Override
  protected void onRestart()
  {
    super.onRestart();
    Log.i("Bilgi:onRestart", "onRestart metodu çalıştı! Activity yeniden çalıştı!");
  }

  @Override
  protected void onStart()
  {
    super.onStart();
    Log.i("Bilgi:onStart", "onStart metodu çalıştı! Activity çalıştı!");
  }

  @Override
  protected void onStop()
  {
    super.onStop();
    Log.w("Bilgi:onStop", "onStop metodu çalıştı! Activity durdu!");
  }
}
