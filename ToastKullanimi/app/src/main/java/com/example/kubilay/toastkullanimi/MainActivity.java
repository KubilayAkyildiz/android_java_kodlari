package com.example.kubilay.toastkullanimi;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  /**
   * Düz Toast mesajı
   */
  public void btnToast1_onClick(View view)
  {
    Toast toast = Toast.makeText(this, "Merhaba Dünya!", Toast.LENGTH_SHORT);
    // toast.setGravity(Gravity.CENTER, -7, 10);
    toast.show();
  }

  /**
   * Programatik olarak özelleştirilmiş Toast mesajı
   */
  public void btnToast2_onClick(View view)
  {
    Toast toast = new Toast(this);

    LinearLayout ll = new LinearLayout(this);
    ll.setOrientation(LinearLayout.HORIZONTAL);
    ll.setBackgroundColor(Color.parseColor("#bded3b"));
    ll.setGravity(Gravity.CENTER);

    ImageView imageView = new ImageView(this);
    Drawable img = null;
    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
      img = getDrawable(R.drawable.bird);
    } else {
      img = getResources().getDrawable(R.drawable.bird);
    }
    imageView.setImageDrawable(img);

    TextView textView = new TextView(this);
    textView.setText("Programatik Toast Mesajı");
    textView.setTextColor(Color.BLACK);
    textView.setTextSize(25);

    ll.addView(imageView);
    ll.addView(textView);

    toast.setView(ll);
    toast.show();
  }

  /**
   * Deklaratif olarak özelleştirilmiş Toast mesajı
   */
  public void btnToast3_onClick(View view)
  {
    // res/layout/custom_toast.xml

    Toast toast = new Toast(this);
    LayoutInflater li = this.getLayoutInflater();
    View toastDesign = li.inflate(R.layout.custom_toast, null);
    toast.setView(toastDesign);
    toast.show();
  }
}
