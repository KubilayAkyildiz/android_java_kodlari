package com.example.kubilay.activitybaslatma;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
  /**
   * Eğer bir activity'den başka activity'ye geçilmek isteniyorsa Intent kullanılmalıdır.
   */

  private Button btnOpenOtherActivity;

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    btnOpenOtherActivity = (Button) findViewById(R.id.btnOpenOtherActivity);
    btnOpenOtherActivity.setOnClickListener(new View.OnClickListener()
    {
      @Override
      public void onClick(View view) {
        /**
         * Intent(Context packageContext, Class<?> cls) biçimi kullanılır.
         * packageContext, kaynak activity'yi almalıdır.
         * cls, gidilecek activity'nin Class türündeki referansını almalıdır.
         */
        Intent intent = new Intent(MainActivity.this, OtherActivity.class);
        /**
         * Eğer gidilecek activity'ye veriler taşımak isteniyorsa,
         * putExtra metodu kullanılmalıdır.
         * putExtra(String anahtar, değer)
         */
        intent.putExtra("integerValue", 17);
        intent.putExtra("floatValue", 2.8f);
        intent.putExtra("stringValue", "Hi from MainActivity!");
        // Intent nesnesini başlatalım.
        startActivity(intent);
      }
    });
  }
}
