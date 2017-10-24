package com.example.kubilay.rawresourcekullanimi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class MainActivity extends AppCompatActivity
{
  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    InputStream stream = getResources().openRawResource(R.raw.kitap_listesi);
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder = null;
    try {
      dBuilder = dbf.newDocumentBuilder();
    } catch (ParserConfigurationException e) {
      e.printStackTrace();
    }
    Document doc = null;
    try {
      doc = dBuilder.parse(stream);
      doc.getDocumentElement().normalize();
    } catch (SAXException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    NodeList kitapList = doc.getElementsByTagName("kitap");
    String str = "";
    for (int i = 0; i < kitapList.getLength(); i++) {
      str += "------- " + (i + 1) + " -------\n";
      Node node = kitapList.item(i);
      for (int j = 0; j < node.getChildNodes().getLength(); j++) {
        Node data = node.getChildNodes().item(j);
        if (data.getNodeType() == Node.ELEMENT_NODE) {
          str += data.getNodeName() + " : " + data.getTextContent() + "\n";
        }
      }
    }
    str += "-----------------\n";

    TextView textView = (TextView) findViewById(R.id.textView);
    textView.setText(str);
  }
}
