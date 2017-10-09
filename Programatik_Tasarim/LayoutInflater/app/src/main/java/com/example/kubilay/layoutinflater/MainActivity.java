package com.example.kubilay.layoutinflater;

// import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

public class MainActivity extends AppCompatActivity
{
  /**
   * activity_main.xml dosyası programatik olarak (yani kodlarla) activity'ye yerleştirilecek.
   * Bunun için LayoutInflater sınıfı kullanılıyor.
   */

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);

    // LayoutInflater layoutInflater = (LayoutInflater)
    //    this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    //
    // ya da şöyle de kullanabiliriz:

    LayoutInflater layoutInflater = this.getLayoutInflater();
    View root = layoutInflater.inflate(R.layout.activity_main, null);
    // Burada inflate(int resource, ViewGroup root) biçimini kullandık.
    // resosurce'e activity_main.xml'in id'sini atadık, root'a null geçtik.

    //Burada ise root'u Activity'ye yerleştirdik.
    setContentView(root);
  }
}
