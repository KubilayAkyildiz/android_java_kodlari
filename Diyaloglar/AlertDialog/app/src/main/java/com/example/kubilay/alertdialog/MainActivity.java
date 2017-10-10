package com.example.kubilay.alertdialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  public void btnAlertDialog_onClick(View view)
  {
    AlertDialog.Builder alertDBuilder = new AlertDialog.Builder(this);
    alertDBuilder.setTitle("** Kuşlar **")
        .setIcon(R.drawable.bird)
        .setMessage("Kuşları sever misin?");

    alertDBuilder.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialogInterface, int i) {
        MainActivity.this.setTitle("Aferin, kuşları seviyorsun :)");
      }
    });

    alertDBuilder.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialogInterface, int i) {
        MainActivity.this.setTitle(":( Kuşları niçin sevmiyorsun ki?");
      }
    });

    // AlertDialog'u gösterelim.
    AlertDialog alertDialog = alertDBuilder.create();
    alertDialog.show();
  }

  /**
   * Eğer AlertDialog üzerinde checkbox halinde birden fazla seçeneğin olduğu
   * bir tasarım yapılmak isteniyorsa Builder sınıfının setMultiChoiceItems metodu
   * kullanılır.
   * Yapı: setMultiChoiceItems(CharSequence[] items, boolean[] checkedItems,
   *                           final OnMultiChoiceClickListener listener)
   *
   * items >> Liste olarak gözükecek seçenekleri tutan dizi.
   *
   * checkedItems >> Başlangıçta hangi seçeneklerin işaretli olup olmayacağını
   * gösteren dizidir. İşaretliler için true, işaretsizler için false kullanılmalı.
   * Ayrıca bu dizinin eleman sayısı items dizisinin eleman sayısıyla aynı olmalı.
   *
   * listener >> Liste üzerindeki seçeneklerden seçim yapıldığında veyahut iptal
   * edildiğinde onClick metodunu çağıran nesnedir. Bu metodun int i parametresi
   * seçilen veya iptal edilen seçeneğin dizideki sıra numarasını tutar.
   * boolean b parametresi ise seçeneğin seçili olup olmadığı bilgisini tutar.
   * b = true ise seçenek seçilmiştir, b = false ise seçenek iptal edilmiştir.
   */

  TextView txtLangs;
  String selectedLangs = "";

  public void otherAlertDialog(View view)
  {
    final String languages[] = {
        "Türkçe", "İngilizce", "Arapça", "Farsça",
        "Almanca", "Japonca", "İspanyolca"
    };

    final boolean checkedLangs[] = {
        false, false, false, false, false, false, false
    };

    txtLangs = (TextView) findViewById(R.id.txtLangs);

    AlertDialog.Builder adBuilder = new AlertDialog.Builder(this);
    adBuilder.setTitle("Hangi dilleri biliyorsun?")
        .setIcon(R.drawable.lang_icon);

    // Her checkbox işaretlendiğinde çalışır.
    DialogInterface.OnMultiChoiceClickListener listener =
        new DialogInterface.OnMultiChoiceClickListener() {
          @Override
          public void onClick(DialogInterface dialogInterface, int i, boolean b) {
            if (b) { // Eğer checkbox işaretliyse
              selectedLangs += languages[i] + "\n";
            }
          }
        };

    adBuilder.setMultiChoiceItems(languages, checkedLangs, listener);

    adBuilder.setPositiveButton("Onayla", new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialogInterface, int i) {
        txtLangs.setText("Bildiğin Diller:\n" + selectedLangs);
        selectedLangs = "";
      }
    });

    adBuilder.show();
  }
}
