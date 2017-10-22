package com.example.kubilay.applicationsinifi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity
{
  /**
   * Application, uygulamaya ait birtakım değişmelerden,
   * activity yaşam döngüsünden ve yapılandırma ile ilgili
   * değişiklerden haberdar olmak için kullanılır.
   */

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    MyApplication myapp = null;
    myapp.create(); // Singleton olarak oluşturuldu.
  }
}
