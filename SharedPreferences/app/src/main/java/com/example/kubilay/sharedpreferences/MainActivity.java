package com.example.kubilay.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
  /**
   * SharedPreferences Android'de kullanıcının
   * tercihleriyle ilgili ya da uygulamanın ayarlarıyla
   * ilgili verileri tutmak için kullanılır.
   * SharedPreferences ve Editor arayüzleri ile bu
   * işlemler yapılır.
   * SharedPreferences türünde nesne üretmek için 2
   * yol vardır, bunlar şu 2 metotla üretilir:
   * 1-) Context.getSharedPreferences(String name, int mode)
   * 2-) Activity.getPreferences(int mode)
   * getSharedPreferences metodu uygulamadaki tüm Activity'ler
   * için erişilebilir verileri tutar.
   * getPreferences metodu ise sadece üretildiği Activity
   * içinde erişilebilen verileri tutar.
   *
   * SharedPreferences.Editor şu şekilde çalışır:
   * Nesne oluşturulduğunda bellekte bir HashMap<String, Object>
   * nesnesi oluşturulur. putType metotlarıyla anahtar-değer
   * olarak veriler eklenir. Daha sonra bu HashMap'in bir xml
   * dosyasına kaydedilmesi için ise SharedPreferences.Editor.commit
   * metodu kullanılır.
   *
   * Context.getSharedPreferences(String name, int mode)
   * İlk parametre xml dosyasına verilen ismi alır.
   * İkinci parametre ise diğer uygulamaların bu verilere
   * erişip değişiklik yapıp yapamayacağını belirtir.
   *
   * Not: API-17 ile ve sonrasıyla beraber evrensel olarak dosya
   * okuma ve yazma özellikleri zararlı görülerek
   * MODE_WORLD_READABLE ve MODE_WORLD_WRITEABLE
   * özellikleriyle beraber kullanımdan kaldırılmıştır (deprecated).
   * https://developer.android.com/reference/android/content/Context.html#MODE_WORLD_READABLE
   *
   * Activity.getPreferences(int mode)
   * Burada xml ismi Activity'nin adıdır.
   * mode parametresi getSharedPreferences'ın ikinci parametresinin
   * göreviyle aynıdır.
   */

  private SharedPreferences sp;
  private SharedPreferences.Editor spEditor;

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    // setContentView(R.layout.activity_main);

    sp = this.getPreferences(Context.MODE_PRIVATE);
    spEditor = sp.edit();

    spEditor.putString("sistem", "Android");
    spEditor.putInt("sayı", 17);
    spEditor.putFloat("küsüratlı_sayı", 1.5f);
    spEditor.putBoolean("mantık", true);

    spEditor.commit();

    sp.registerOnSharedPreferenceChangeListener(
        new SharedPreferences.OnSharedPreferenceChangeListener() {
          @Override
          public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {
            Toast.makeText(MainActivity.this, "'sistem' değeri değişti!", Toast.LENGTH_SHORT).show();
          }
        });

    final EditText etxt = new EditText(this);
    Button btn = new Button(this);
    btn.setText("Verileri Değiştir");
    btn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        if (sp.contains("sistem")) {
          spEditor.putString("sistem", etxt.getText().toString());
          spEditor.commit();
        }
      }
    });

    final TextView textView = new TextView(this);

    Button btnFetch = new Button(this);
    btnFetch.setText("Değerleri Getir");
    btnFetch.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        String values = sp.getString("sistem", "#empty") + "\n";
        values += sp.getInt("sayı", 0) + "\n";
        values += sp.getFloat("küsüratlı_sayı", 0f) + "\n";
        values += sp.getBoolean("mantık", false) + "\n";
        textView.setText(values);
      }
    });

    LinearLayout ll = new LinearLayout(this);
    ll.setOrientation(LinearLayout.VERTICAL);
    ll.addView(etxt);
    ll.addView(btn);
    ll.addView(btnFetch);
    ll.addView(textView);

    setContentView(ll);
  }
}
