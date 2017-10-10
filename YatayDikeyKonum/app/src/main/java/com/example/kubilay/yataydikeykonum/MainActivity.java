package com.example.kubilay.yataydikeykonum;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
// import android.view.Window;
import android.view.Display;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity
{
  /**
   * Cihazın yatay (landscape) ve dikey (portrait) konumlarını algılama ve
   * ona göre işlem yapmak.
   *
   * Bunun için Android'de 2 farklı yöntem mevcuttur:
   *
   * (1) Bunlardan birincisi Window, WindowManager ve Display sınıflarını kullanarak
   * ekranın genişlik ve yükseklik değerlerini denetlemektir.
   *
   * (2) İkincisiyse yatay ve dikey konuma özel tasarım oluşturmaktır.
   */

  /**
   * Birinci Yöntem:
   */
  public void firstMethod()
  {
    // Window window = this.getWindow();
    // WindowManager windowManager = window.getWindowManager();
    // veya
    WindowManager windowManager = (WindowManager)
        this.getSystemService(Context.WINDOW_SERVICE);
    Display display = windowManager.getDefaultDisplay();

    // Yükseklik genişlikten büyükse cihaz dikey konumdadır.
    if (display.getHeight() > display.getWidth()) {
      this.setTitle("Cihaz Dikey Konumda (1. Yöntem)");
    } else {
      this.setTitle("Cihaz Yatay Konumda (1. Yöntem)");
    }
  }

  /**
   * İkinci Yöntem:
   * layout -> activity_main.xml dikey (portrait) kullanım içindir.
   * Bu yüzden New -> Android resource file dedikten sonra;
   * File name: activity_main.xml
   * Resource type: Layout
   * Directory name: layout-land
   * Bu şekilde yatay konum için tasarım oluşturabiliriz.
   */

  /**
   * Eğer cihazı döndürdüğümüzde dikey konumun değişmesini
   * istemiyorsak:
   * <activity android:screenOrientation="portrait" ...></activity>
   * Yatay konum değişmesin istersek:
   * <activity android:screenOrientation="landscape" ...></activity>
   */

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    firstMethod();
  }
}
