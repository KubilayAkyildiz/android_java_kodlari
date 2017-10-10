package com.example.kubilay.ozgundialog;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
  /**
   * Eğer sıfırdan kendi diyaloğumuzu oluşturmak istiyorsak
   * Dialog sınıfından oluşturulmuş nesneye setContentView
   * metoduyla tasarımımızı geçirebiliriz.
   */

  Dialog dialog;

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    dialog = new Dialog(this);

    LayoutInflater li = this.getLayoutInflater();
    View design = li.inflate(R.layout.custom_dialog, null);

    final EditText etxtValue = design.findViewById(R.id.etxtValue);
    Button btnOK = design.findViewById(R.id.btnOK);
    Button btnCancel = design.findViewById(R.id.btnCancel);

    btnOK.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        if (!etxtValue.getText().toString().equals("")) {
          MainActivity.this.setTitle(etxtValue.getText());
          dialog.dismiss(); // Dialog'u kapat.
        } else {
          Toast.makeText(MainActivity.this, "Boş bırakamazsınız!", Toast.LENGTH_SHORT).show();
        }
      }
    });

    btnCancel.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        dialog.dismiss(); // Dialog'u kapat.
      }
    });

    // Oluşturduğumuz tasarımı dialog'a geçirelim.
    dialog.setContentView(design);
  }

  public void btnDialog_onClick(View view)
  {
    dialog.show();
  }
}
