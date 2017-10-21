package com.example.kubilay.ozgunlistview;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Vector;

public class CustomAdapter extends BaseAdapter
{
  private Context _context;
  private Vector<Kuslar> _kuslar;

  public CustomAdapter(Context context, Vector<Kuslar> kuslar)
  {
    _context = context;
    _kuslar = kuslar;
  }

  @Override
  public int getCount()
  {
    return _kuslar.size();
  }

  @Override
  public Object getItem(int i)
  {
    return _kuslar.get(i);
  }

  @Override
  public long getItemId(int i)
  {
    return ((Kuslar) getItem(i)).kusunIdBilgisiniAl();
  }

  // Bu yöntem deklaratif tasarımı kullanır.
  @Override
  public View getView(int i, View view, ViewGroup viewGroup)
  {
    Kuslar kuslar = (Kuslar) getItem(i);

    LayoutInflater li = ((Activity) _context).getLayoutInflater();
    LinearLayout linLay = (LinearLayout)
        li.inflate(R.layout.design_listview_item, null);

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
      ((ImageView) linLay.findViewById(R.id.ivKus))
          .setImageDrawable(_context.getDrawable(kuslar.kusunResminiAl()));
    } else {
      ((ImageView) linLay.findViewById(R.id.ivKus))
          .setImageDrawable(_context.getResources().getDrawable(kuslar.kusunResminiAl()));
    }
    ((TextView) linLay.findViewById(R.id.tvKusAdi)).setText(kuslar.kusunAdiniAl());
    ((TextView) linLay.findViewById(R.id.tvKusId)).
        setText(String.valueOf(kuslar.kusunIdBilgisiniAl()));

    return linLay;
  }

  // Bu yöntem programatik tasarımı kullanır.
  /*@Override
  public View getView(int i, View view, ViewGroup viewGroup)
  {
    Kuslar kuslar = (Kuslar) getItem(i);

    LinearLayout linLay = new LinearLayout(_context);
    linLay.setOrientation(LinearLayout.HORIZONTAL);
    linLay.setGravity(Gravity.CENTER);

    ImageView ivKus = new ImageView(_context);
    TextView tvKusAdi = new TextView(_context);
    TextView tvKusId = new TextView(_context);

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
      ivKus.setImageDrawable(_context.getDrawable(kuslar.kusunResminiAl()));
    } else {
      ivKus.setImageDrawable(_context.getResources().getDrawable(kuslar.kusunResminiAl()));
    }
    tvKusAdi.setText(kuslar.kusunAdiniAl());
    tvKusId.setText(String.valueOf(kuslar.kusunIdBilgisiniAl()));

    ivKus.setLayoutParams(new ViewGroup.LayoutParams(
        ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    tvKusAdi.setLayoutParams(new ViewGroup.LayoutParams(
        ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    tvKusId.setLayoutParams(new ViewGroup.LayoutParams(
        ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

    ivKus.setPadding(10, 0, 0, 0);
    tvKusAdi.setPadding(10, 0, 0, 0);
    tvKusId.setPadding(10, 0, 0, 0);

    tvKusAdi.setTextColor(Color.parseColor("#000000"));
    tvKusAdi.setTextSize(20);
    tvKusId.setTextColor(Color.parseColor("#FF0000"));
    tvKusId.setTextSize(20);

    linLay.addView(ivKus);
    linLay.addView(tvKusAdi);
    linLay.addView(tvKusId);

    return linLay;
  }*/
}
