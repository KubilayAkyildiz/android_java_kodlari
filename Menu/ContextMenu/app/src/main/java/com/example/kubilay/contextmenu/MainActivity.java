package com.example.kubilay.contextmenu;

import android.app.Dialog;
import android.content.ClipboardManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
  private EditText editText;
  private ImageView imageView;
  ClipboardManager clipboardManager;

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    editText = (EditText) findViewById(R.id.editText);
    imageView = (ImageView) findViewById(R.id.imageView);

    // EditText'e ve ImageView'e bağlam (context) menüleri
    // ilişkilendirelim.
    this.registerForContextMenu(editText);
    this.registerForContextMenu(imageView);

    /** EditText - Kes, Kopyala, Yapıştır işlemleri için */
    clipboardManager = (ClipboardManager)
        this.getSystemService(this.CLIPBOARD_SERVICE);
  }

  // Hangi View için hangi menü açılacak?
  @Override
  public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
  {
    if (v.getId() == R.id.editText) {
      this.getMenuInflater().inflate(R.menu.edittext_menu, menu);
    } else if (v.getId() == R.id.imageView) {
      this.getMenuInflater().inflate(R.menu.imageview_menu, menu);
    }
    super.onCreateContextMenu(menu, v, menuInfo);
  }

  // Hangi elemanda hangi işlem gerçekleştirilecek?
  @Override
  public boolean onContextItemSelected(MenuItem item)
  {
    switch (item.getItemId()) {
      /** EditText işlemleri için */
      case R.id.miCut:
        clipboardManager.setText(editText.getText().toString());
        editText.setText("");
        Toast.makeText(this, "Kesildi!", Toast.LENGTH_SHORT).show();
        break;
      case R.id.miCopy:
        clipboardManager.setText(editText.getText().toString());
        Toast.makeText(this, "Kopyalandı!", Toast.LENGTH_SHORT).show();
        break;
      case R.id.miPaste:
        editText.setText(clipboardManager.getText());
        break;

      /** ImageView işlemleri için */
      case R.id.miSetWidthAndHeight:
        setWidthAndHeightDialog();
        break;
    }

    return super.onContextItemSelected(item);
  }

  /** Diyalog */

  private void setWidthAndHeightDialog()
  {
    final Dialog dialog = new Dialog(this);
    LinearLayout ll = new LinearLayout(this);
    ll.setOrientation(LinearLayout.VERTICAL);

    final EditText etxtSetWidth = new EditText(this);
    etxtSetWidth.setHint("Genişlik");
    // Yalnızca sayılar girilebilir.
    etxtSetWidth.setInputType(InputType.TYPE_CLASS_NUMBER);

    final EditText etxtSetHeight = new EditText(this);
    etxtSetWidth.setHint("Yükseklik");
    // Yalnızca sayılar girilebilir.
    etxtSetHeight.setInputType(InputType.TYPE_CLASS_NUMBER);

    Button btnOK = new Button(this);
    btnOK.setText("Tamam");

    ll.addView(etxtSetWidth);
    ll.addView(etxtSetHeight);
    ll.addView(btnOK);

    dialog.setContentView(ll);

    btnOK.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        imageView.setMinimumWidth(
            Integer.parseInt(etxtSetWidth.getText().toString()));
        imageView.setMinimumHeight(
            Integer.parseInt(etxtSetHeight.getText().toString()));
        dialog.dismiss();
      }
    });

    dialog.show();
  }
}
