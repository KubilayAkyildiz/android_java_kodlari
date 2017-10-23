package com.example.kubilay.dosyaokumayazma;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity
{
  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    final Button btnWriteFile = (Button) findViewById(R.id.btnWriteFile);
    final Button btnReadFile = (Button) findViewById(R.id.btnreadFile);
    final TextView textView = (TextView) findViewById(R.id.textView);

    final File file = new File(this.getFilesDir() + "/YeniDizin");

    btnWriteFile.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        createDirectory(MainActivity.this.getFilesDir(), "YeniDizin");
        MainActivity.this.setTitle("/files/YeniDizin dizini oluşturuldu!");
        try {
          if (file.exists()) {
            writeFile(file, "metin.txt");
            textView.setText("metin.txt dosyası oluşturuldu ve değerler yazıldı!");
          } else {
            textView.setText("YeniDizin dizini mevcut değil!");
          }
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    });

    btnReadFile.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        if (new File(file + "/metin.txt").exists()) {
          try {
            String content = readFile(file, "metin.txt");
            textView.setText(content);
          } catch (IOException e) {
            e.printStackTrace();
          }
        } else {
          textView.setText("metin.txt dosyası bulunamadı!");
        }
      }
    });
  }

  /**
   * Dizin oluşturma
   */
  void createDirectory(File parent, String name)
  {
    File dir = new File(parent, name);
    dir.mkdir();
  }

  /**
   * Dosya yazma
   */
  void writeFile(File parent, String name) throws IOException
  {
    File file = new File(parent, name);
    FileOutputStream fos = null;
    OutputStreamWriter osw = null;
    try {
      fos = new FileOutputStream(file);
      osw = new OutputStreamWriter(fos);
      osw.write("Merhaba Dünya! - Satır 1");
      osw.write("Android Programlama - Satır 2");
    } finally {
      osw.close();
      fos.close();
    }
  }

  /**
   * Dosya okuma
   */
  String readFile(File parent, String name) throws IOException
  {
    File file = new File(parent, name);
    FileInputStream fis = new FileInputStream(file);
    InputStreamReader isr = new InputStreamReader(fis);
    BufferedReader reader = new BufferedReader(isr);
    String content = "", line;

    try {
      while ((line = reader.readLine()) != null) {
        content += line + "\n";
      }
    } finally {
      reader.close();
      isr.close();
      fis.close();
    }
    return content;
  }
}
