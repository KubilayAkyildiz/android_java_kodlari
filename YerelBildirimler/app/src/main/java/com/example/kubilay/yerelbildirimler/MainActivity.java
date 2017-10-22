package com.example.kubilay.yerelbildirimler;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;

public class MainActivity extends AppCompatActivity
{
  private final int nID = 0x000001;
  private NotificationManager notMng;
  private NotificationCompat.Builder nb;

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    notMng = (NotificationManager)
        this.getSystemService(Context.NOTIFICATION_SERVICE);
    nb = new NotificationCompat.Builder(this);
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
      nb.setColor(Color.parseColor("#a442f4"));
    }
    nb.setContentTitle("Yeni Bir Bildirim");
    nb.setContentText("Merhaba, bugün nasılsınız?");
    nb.setSmallIcon(R.drawable.star);
    nb.setTicker("Bildirim aldınız!");
    nb.setAutoCancel(true);
    nb.setLights(Color.parseColor("#a442f4"), 500, 500);

    // Bildirime tıklayarak istenilen Activity'yi açmak için.
    Intent intent = new Intent(this, NewActivity.class);
    PendingIntent pIntent = PendingIntent.getActivity(
        this, nID, intent, 0);
    nb.setContentIntent(pIntent);
  }

  public void btnNotification_onClick(View view)
  {
    final Notification not = nb.build();
    not.vibrate = new long[] { 500, 400, 500, 400 };
    notMng.notify(nID, not);
  }
}
