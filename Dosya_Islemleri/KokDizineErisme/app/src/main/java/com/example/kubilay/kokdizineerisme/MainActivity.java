package com.example.kubilay.kokdizineerisme;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import java.io.File;

public class MainActivity extends AppCompatActivity
{
  private TextView textView;

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    textView = (TextView) findViewById(R.id.textView);
    textView.setMovementMethod(new ScrollingMovementMethod());

    File rootDirectory = Environment.getRootDirectory();
    File files[] = rootDirectory.listFiles();
    String str = "";

    for (File file : files) {
      if (file.isDirectory()) {
        str += String.format("Dizin Adı: %s\nDizinin Boyutu: %d\n",
            file.getName(), file.getFreeSpace());
      } else {
        str += String.format("Dosya Adı: %s\nDosya Boyutu: %d\n",
            file.getName(), file.getFreeSpace());
      }
    }
    textView.setText(str);
  }
}
