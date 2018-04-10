package makanbu.com.makanbu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import makanbu.com.makanbu.model.Order;

/**
 * Created by taufiq on 28/02/18.
 */

public class OrderActivity extends Activity {

    EditText editTextAlamat, editTextJumlah, editTextCatatan;
    TextView harga;
    String alamat;
    String jumlah;
    String catatan;
    int total;
    String hargaMakanan;
    // [START declare_auth]
    private FirebaseAuth mAuth;
    DatabaseReference databaseOrder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_order);
        mAuth= FirebaseAuth.getInstance();
        editTextJumlah = findViewById(R.id.editTextJumlah);
        editTextAlamat = findViewById(R.id.alamatPengiriman);
        editTextCatatan = findViewById(R.id.catatan);
        harga = findViewById(R.id.harga_makanan);

        databaseOrder = FirebaseDatabase.getInstance().getReference("Order");
    }

    public void order(View view) {
        alamat = editTextAlamat.getText().toString();
        jumlah = editTextJumlah.getText().toString();
        catatan = editTextCatatan.getText().toString();
        hargaMakanan=harga.getText().toString();

        String id = databaseOrder.push().getKey();
        Order order = new Order(alamat,jumlah,catatan,hargaMakanan);
        databaseOrder.child(id).setValue(order);
        Intent intent = new Intent(this, ReviewAfterOrder.class);
        intent.putExtra("alamat",alamat);
        intent.putExtra("jumlah",jumlah);
        intent.putExtra("catatan",catatan);


    }
}
