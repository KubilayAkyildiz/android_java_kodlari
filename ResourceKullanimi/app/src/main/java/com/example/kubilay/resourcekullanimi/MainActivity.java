package com.example.kubilay.resourcekullanimi;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity
{
  /**
   * Kaynaklar (Resources) çağunlukla uygulamaların birden fazla dile destek vermesi
   * gerektiği durumlarda kullanılır. Bunun dışında her türlü türdeki değerler tutulabilir.
   */

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Button button = (Button) findViewById(R.id.button);
    /**
     * Butona kaynaktaki ismi vermek
     */
    // R.string.button_name -> res/values/strings.xml içerisinde tanımlı.
    button.setText(R.string.button_name);

    /**
     * Butona kaynaktaki rengi vermek
     */
    // R.color.renkSari -> res/values/colors.xml içerisinde tanımlı.
    // Eğer Android cihaz 6.0 veya üzeriyse
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
      button.setBackgroundColor(this.getColor(R.color.colorYellow));
    } else {
      button.setBackgroundColor(getResources().getColor(R.color.colorYellow));
    }

    /**
     * Kaynaktaki diziyi almak
     */
    // R.array.array_names -> res/values/strings.xml içerisinde tanımlı.
    String names[] = this.getResources().getStringArray(R.array.array_names);

    /**
     * Kaynaktaki resmi kullanmak
     */
    ImageView imageView = (ImageView) findViewById(R.id.imageView);
    Drawable image;
    // R.drawable.bird -> res/drawable içerisinde tanımlı.
    // Eğer Android cihaz 5.0 veya üzeriyse
    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
      image = this.getDrawable(R.drawable.bird);
    } else {
      image = getResources().getDrawable(R.drawable.bird);
    }
    imageView.setImageDrawable(image);

    /**
     * Cihazda kullanılan dile göre değer almak
     *
     * Şu adımı uygulayın: New -> Android resource file
     * File name: strings.xml
     * Directory name: values-tr
     *
     * values/strings.xml'de title'ın İngilizce değeri yazılı
     * values-tr/strings.xml'de title'ın Türkçe değeri yazılı
     */
    // Cihazınızın Türkçe veya İngilizce olmasına göre değeri alacak.
    this.setTitle(R.string.title);
  }
}
