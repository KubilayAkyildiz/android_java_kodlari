package com.example.kubilay.popupmenu;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
  private PopupMenu popupMenu;
  private TextView textView;

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    textView = (TextView) findViewById(R.id.textView);
    textView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        popupMenu.show();
      }
    });

    /**
     * Context context,
     * @NonNull View anchor >> Hangi nesneyle ilişkilendirelecek
     * int gravity >> Hizalama
     */
    popupMenu = new PopupMenu(this, textView, Gravity.END);
    popupMenu.inflate(R.menu.popup_design);
  }

  public void miRed_onClick(MenuItem item)
  {
    textView.setTextColor(Color.RED);
  }

  public void miGreen_onClick(MenuItem item)
  {
    textView.setTextColor(Color.GREEN);
  }

  public void miBlue_onClick(MenuItem item)
  {
    textView.setTextColor(Color.BLUE);
  }
}
