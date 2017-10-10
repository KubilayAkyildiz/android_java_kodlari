package com.example.kubilay.cihazdugmelerinialgilama;


import android.os.Bundle;import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
  /**
   * Android'de cihazın hangi düğmesine basıldığını algılamak / yakalamak için
   * onKeyDown, onKeyUp, onKeyLongPress ve onKeyMultiple metotları kullanılır.
   */

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  @Override
  public boolean onKeyDown(int keyCode, KeyEvent event)
  {
    switch (keyCode) {
      case KeyEvent.KEYCODE_BACK:
        Toast.makeText(this, "Cihazda geri tuşuna basıldı.", Toast.LENGTH_SHORT).show();
        break;
      case KeyEvent.KEYCODE_HOME:
        Toast.makeText(this, "Cihazda anasayfa tuşuna basıldı.", Toast.LENGTH_SHORT).show();
        break;
      case KeyEvent.KEYCODE_VOLUME_UP:
        Toast.makeText(this, "Cihazda sesi yükseltme tuşuna basıldı.", Toast.LENGTH_SHORT).show();
        break;
      case KeyEvent.KEYCODE_VOLUME_DOWN:
        Toast.makeText(this, "Cihazda sesi kısma tuşuna basıldı.", Toast.LENGTH_SHORT).show();
        break;
    }

    return super.onKeyDown(keyCode, event);
  }

  /**
   * Cihazda geri tuşuna basıldığında activity kapanır. Bunu engellemek için taban sınıfın
   * onBackPressed metodunu çağırmayın.
   */
  @Override
  public void onBackPressed()
  {
    Toast.makeText(this, "Geri tuşuna basıldı!", Toast.LENGTH_SHORT).show();
    // super.onBackPressed();
  }
}
