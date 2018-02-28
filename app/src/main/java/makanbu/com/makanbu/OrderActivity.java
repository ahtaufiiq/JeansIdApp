package makanbu.com.makanbu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.EditText;

/**
 * Created by taufiq on 28/02/18.
 */

public class OrderActivity extends Activity {

    EditText editTextAlamat, editTextJumlah, editTextCatatan;
    String alamat, jumlah, catatan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_order);

        editTextJumlah = findViewById(R.id.editTextJumlah);
        editTextAlamat = findViewById(R.id.alamatPengiriman);
        editTextCatatan = findViewById(R.id.catatan);

    }

    public void order(View view) {
        alamat = editTextAlamat.getText().toString();
        jumlah = editTextJumlah.getText().toString();
        catatan = editTextCatatan.getText().toString();
        Log.d("value", alamat);
        Log.d("value", jumlah);
        Log.d("value", catatan);

        Intent intent = new Intent(this, ReviewAfterOrder.class);
        startActivity(intent);

    }
}
