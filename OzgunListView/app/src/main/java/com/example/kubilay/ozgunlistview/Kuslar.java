package com.example.kubilay.ozgunlistview;

public class Kuslar
{
  private int _kusunResmi;
  private String _kusunAdi;
  private int _kusId;

  public Kuslar(int kusunResmi, String kusunAdi, int kusId)
  {
    _kusunResmi = kusunResmi;
    _kusunAdi = kusunAdi;
    _kusId = kusId;
  }

  public int kusunResminiAl()
  {
    return _kusunResmi;
  }

  public void kusunResminiAyarla(int resim)
  {
    _kusunResmi = resim;
  }

  public String kusunAdiniAl()
  {
    return _kusunAdi;
  }

  public void kusunAdiniAyarla(String ad)
  {
    _kusunAdi = ad;
  }

  public int kusunIdBilgisiniAl()
  {
    return _kusId;
  }

  public void kusunIdBilgisiniAyarla(int id)
  {
    _kusId = id;
  }
}
