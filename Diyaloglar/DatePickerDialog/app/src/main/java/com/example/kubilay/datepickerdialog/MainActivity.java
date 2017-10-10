package com.example.kubilay.datepickerdialog;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
  /**
   * Yapı: DatePickerDialog(Context context, DatePickerDialog.OnDateSetListener listener,
   *                        int year, int month, int dayOfMonth)
   * context >> Context referansı
   * listener >> DatePickerDialog.OnDateSetListener arayüzünü uygulayan (implements)
   * bir sınıfın nesne referansını veya anonymous inner type almalıdır.
   * year >> Yıl
   * month >> Ay (Ocak 0 olarak kabul edilir)
   * dayOfMonth >> Gün
   */

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  public void btnDatePickerDialog_onClick(View view)
  {
    final String months[] = {
        "Ocak", "Şubat", "Mart", "Nisan", "Mayıs", "Haziran",
        "Temmuz", "Ağustos", "Eylül", "Ekim", "Kasım", "Aralık"
    };
    DatePickerDialog dpd = new DatePickerDialog(this,
        new DatePickerDialog.OnDateSetListener() {
          @Override
          public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
            // i -> Yıl
            // i1 -> Ay
            // i2 -> Gün
            Toast.makeText(MainActivity.this,
                (i2 + " / " + months[i1] + " / " + i),
                Toast.LENGTH_SHORT).show();
          }
        }, 2017, 9, 10);

    dpd.show();
  }
}
