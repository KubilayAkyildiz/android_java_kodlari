package com.example.kubilay.ozgunlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Vector;

public class MainActivity extends AppCompatActivity
{
  private ListView _listView;
  private CustomAdapter _adapter;
  private Vector<Kuslar> _kuslar;

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    //setContentView(R.layout.activity_main);

    _listView = new ListView(this);
    _listView.setLayoutParams(
        new LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

    _kuslar = new Vector<>();
    _kuslar.add(new Kuslar(R.drawable.muhabbet_kusu, "Muhabbet Kuşu", 0x1));
    _kuslar.add(new Kuslar(R.drawable.papagan, "Papağan", 0x2));
    _kuslar.add(new Kuslar(R.drawable.serce, "Serçe", 0x3));

    _adapter = new CustomAdapter(this, _kuslar);
    _listView.setAdapter(_adapter);

    setContentView(_listView);

    _listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        LinearLayout linearLayout = (LinearLayout) view;
        Toast.makeText(MainActivity.this,
            ((TextView)linearLayout.findViewById(R.id.tvKusAdi)).getText().toString(),
            Toast.LENGTH_SHORT).show();
      }
    });
  }
}
