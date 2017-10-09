package com.example.kubilay.programatik_tasarim_ornegi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity
{
  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    // setContentView(R.layout.activity_main);

    LinearLayout linearLayout = new LinearLayout(this);
    // Tasarım nesnelerini alt alta yerleştir:
    linearLayout.setOrientation(LinearLayout.VERTICAL);

    // EditText oluşturalım:
    EditText editText = new EditText(this);
    editText.setWidth(650); // pixel cinsinden
    editText.setHeight(70); // pixel cinsinden
    linearLayout.addView(editText); // editText nesnesini linearLayout'a ekledik.

    // Buton oluşturalım:
    Button button = new Button(this);
    button.setText("Örnek Button");
    button.setWidth(300); // pixel cinsinden
    button.setHeight(70); // pixel cinsinden
    linearLayout.addView(button); // button nesnesini linearLayout'a ekledik.

    // Switch oluşturalım:
    Switch switch_ = new Switch(this);
    switch_.setText("Örnek Switch");
    linearLayout.addView(switch_); // switch_ nesnesini linearLayout'a ekledik.

    // linearLayout'u Activity'ye yerleştirelim.
    this.setContentView(linearLayout);
  }
}
