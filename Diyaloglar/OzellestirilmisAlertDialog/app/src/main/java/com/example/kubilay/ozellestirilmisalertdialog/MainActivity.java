package com.example.kubilay.ozellestirilmisalertdialog;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
  /**
   * AlertDialog'un görünümünü tasarlamak.
   */

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  public void btnAlertDialog_onClick(View view)
  {
    LayoutInflater ll = (LayoutInflater)
        this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    View dialogDesign = ll.inflate(R.layout.design_alertdialog, null);

    ImageView ivIcon = (ImageView) ((LinearLayout) dialogDesign).findViewById(R.id.ivIcon);
    TextView txtTitle = (TextView) ((LinearLayout) dialogDesign).findViewById(R.id.txtTitle);
    TextView txtMessage = (TextView) ((LinearLayout) dialogDesign).findViewById(R.id.txtMessage);

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
      ivIcon.setImageDrawable(getDrawable(R.drawable.bird));
    } else {
      ivIcon.setImageDrawable(getResources().getDrawable(R.drawable.bird));
    }

    txtTitle.setText("** Kuşlar **");
    txtMessage.setText("Kuşları sever misin?");

    /** AlertDialog'u oluşturalım. */
    AlertDialog.Builder adBuilder = new AlertDialog.Builder(this);
    // Oluşturduğumuz View nesnesini setView ile AlertDialog'a yerleştirelim.
    adBuilder.setView(dialogDesign);

    adBuilder.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialogInterface, int i) {
        MainActivity.this.setTitle("Aferin, kuşları seviyorsun :)");
      }
    });

    adBuilder.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialogInterface, int i) {
        MainActivity.this.setTitle(":( Kuşları niçin sevmiyorsun ki?");
      }
    });

    adBuilder.show();
  }
}
