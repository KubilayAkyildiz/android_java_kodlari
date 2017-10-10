package com.example.kubilay.activitybaslatma;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class OtherActivity extends AppCompatActivity
{
  private TextView textView;
  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_other);

    textView = (TextView) findViewById(R.id.txtIntentValues);

    Intent intent = this.getIntent();
    String values =
        String.format("%d\n%.2f\n%s",
            intent.getIntExtra("integerValue", 0), // Varsayılan değer: 0
            intent.getFloatExtra("floatValue", 0), // Varsayılan değer: 0
            intent.getStringExtra("stringValue"));
    textView.setText(values);
  }
}
