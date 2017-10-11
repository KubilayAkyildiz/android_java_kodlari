package com.example.kubilay.optionmenu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

// AppCompatActivity sınıfından türetilmeli.
public class MainActivity extends AppCompatActivity
{
  /**
   * Menüyü deklaratif olarak oluşturmak için MenuInflater
   * ile xml dosyası menüye uygulanır.
   * Programatik olarak menü oluşturmak için ise onCreateOptionsMenu
   * metodunun menu parametresinin add metodu kullanılır.
   */

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  /**
   * 1. Yöntem
   * MenuInflater ile menüyü yapılandıralım.
   */
  @Override
  public boolean onCreateOptionsMenu(Menu menu)
  {
    MenuInflater menuInflater = this.getMenuInflater();
    menuInflater.inflate(R.menu.menu_design, menu);
    return super.onCreateOptionsMenu(menu);
  }

  /**
   * Menüde olan elemanların hangisinin seçildiğini
   * bulmak için onOptionsItemSelected metodunun item
   * parametresinin getItemId metodu ile hangi elemanın
   * seçildiğini bulup ona göre işlemler yapabiliriz.
   */
  @Override
  public boolean onOptionsItemSelected(MenuItem item)
  {
    switch (item.getItemId()) {
      case R.id.miOpen:
        this.setTitle("'Aç' seçeneğini seçtiniz!");
        break;
      case R.id.miSave:
        this.setTitle("'Kaydet' seçeneğini seçtiniz!");
        break;
      case R.id.miSaveAs:
        this.setTitle("'Farklı Kaydet' seçeneğini seçtiniz!");
        break;
      case R.id.miCut:
        this.setTitle("'Kes' seçeneğini seçtiniz!");
        break;
      case R.id.miCopy:
        this.setTitle("'Kopyala' seçeneğini seçtiniz!");
        break;
      case R.id.miPaste:
        this.setTitle("'Yapıştır' seçeneğini seçtiniz!");
        break;
      case R.id.miExit:
        this.setTitle("'Çık' seçeneğini seçtiniz!");
        break;
    }
    return super.onOptionsItemSelected(item);
  }
  /**
   * Hangi elemanın seçildiğini bulmak için 2. bir yöntem
   * daha vardır. O da menu_design.xml dosyasında
   * <item onClick="miOpen_onClick" ...></item>
   * şeklinde kullanmaktır.
   *
   * Metot tanımı:
   * public void miOpen_onClick(MenuItem item) { ... }
   */

  /**
   * 2. Yöntem
   * Programatik olarak menü oluşturmak için.
   */
  /*
  @Override
  public boolean onCreateOptionsMenu(Menu menu)
  {
    MenuItem miOpen = menu.add("Aç");
    MenuItem miSave = menu.add("Kaydet");
    MenuItem miExit = menu.add("Çık");

    miOpen.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
      @Override
      public boolean onMenuItemClick(MenuItem menuItem) {
        MainActivity.this.setTitle("'Aç' seçeneğini seçtiniz!");
        return false;
      }
    });

    miSave.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
      @Override
      public boolean onMenuItemClick(MenuItem menuItem) {
        MainActivity.this.setTitle("'Kaydet' seçeneğini seçtiniz!");
        return false;
      }
    });

    miExit.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
      @Override
      public boolean onMenuItemClick(MenuItem menuItem) {
        MainActivity.this.setTitle("'Çık' seçeneğini seçtiniz!");
        return false;
      }
    });

    return super.onCreateOptionsMenu(menu);
  }
  */
}
