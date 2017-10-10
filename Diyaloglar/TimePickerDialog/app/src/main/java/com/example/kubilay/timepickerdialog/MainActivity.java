package com.example.kubilay.timepickerdialog;

import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
  /**
   * Yapı: TimePickerDialog(Context context, TimePickerDialog.OnTimeSetListener listener,
   *                        int hourOfDay, int minute, boolean is24HourView)
   * context >> Context referansı
   * listener >> TimePickerDialog.OnTimeSetListener arayüzünü uygulayan (implements)
   * sınıf türünde bir nesne referansı veya anonymous inner type almalıdır.
   * hourOfDay >> Saat
   * minute >> Dakika
   * is24HourView >> 24 saat biçimi için true, 12 saat biçimi için false almalıdır.
   */

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  public void btnTimePickerDialog_onClick(View view)
  {
    TimePickerDialog tmd = new TimePickerDialog(this,
        new TimePickerDialog.OnTimeSetListener() {
          @Override
          public void onTimeSet(TimePicker timePicker, int i, int i1) {
            // i -> Saat değeri
            // i1 -> Dakika değeri
            Toast.makeText(MainActivity.this, (i + " : " + i1), Toast.LENGTH_SHORT).show();
          }
        }, 7, 30, true);

    tmd.show();
  }
}
