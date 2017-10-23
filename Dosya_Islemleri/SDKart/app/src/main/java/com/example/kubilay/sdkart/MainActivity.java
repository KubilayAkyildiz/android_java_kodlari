package com.example.kubilay.sdkart;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity
{
  /**
   * SD karta erişmek için gerekli izin:
   * <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
   */

  TextView textView;
  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    textView = (TextView) findViewById(R.id.textView);

    ((Button) findViewById(R.id.btnWrite)).setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            try {
              // Eğer cihazda SD kart varsa
              if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                writeToSDCard("dosya.txt", "Merhaba\nDünya!\n");
              } else {
                Toast.makeText(MainActivity.this, "Cihazda SD kart yok!",
                    Toast.LENGTH_SHORT).show();
              }
            } catch (IOException e) {
              e.printStackTrace();
            }
          }
        }
    );

    ((Button) findViewById(R.id.btnRead)).setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            try {
              // Eğer cihazda SD kart varsa
              if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                textView.setText(readFromSDCard("dosya.txt"));
              } else {
                Toast.makeText(MainActivity.this, "Cihazda SD kart yok!",
                    Toast.LENGTH_SHORT).show();
              }
            } catch (IOException e) {
              e.printStackTrace();
            }
          }
        }
    );
  }

  void writeToSDCard(String name, String text) throws IOException
  {
    File dir = Environment.getExternalStorageDirectory();
    File file = new File(dir.getAbsolutePath() + "/YeniDizin");
    file.mkdirs();
    File data = new File(file, name);

    if (!data.exists()) {
      FileOutputStream fos = null;
      OutputStreamWriter osw = null;
      try {
        fos = new FileOutputStream(data);
        osw = new OutputStreamWriter(fos);
        osw.write(text);
      } finally {
        osw.close();
        fos.close();
      }
    } else {
      Toast.makeText(this, name + " dosyası zaten var!", Toast.LENGTH_SHORT).show();
    }
  }

  String readFromSDCard(String name) throws IOException
  {
    File file = new File(
        Environment.getExternalStorageDirectory()
            .getAbsolutePath() + "/YeniDizin", name);
    if (file.exists()) {
      FileInputStream fis = null;
      InputStreamReader isr = null;
      BufferedReader reader = null;
      try {
        fis = new FileInputStream(file);
        isr = new InputStreamReader(fis);
        reader = new BufferedReader(isr);
        String content = "", line;

        while ((line = reader.readLine()) != null) {
          content += line;
        }
        return content;
      } finally {
        reader.close();
        isr.close();
        fis.close();
      }
    } else {
      Toast.makeText(this, name + " dosyası bulunamadı!", Toast.LENGTH_SHORT).show();
    }
    return null;
  }
}
