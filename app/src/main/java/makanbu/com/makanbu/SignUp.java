package makanbu.com.makanbu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    @Override
    private EditText eml;
    private EditText pass;
    String email, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void signup(View view) {

        eml = (EditText) findViewById(R.id.fieldusername);
        pass = (EditText) findViewById(R.id.fieldpassword);
        email = eml.getText().toString();
        password = pass.getText().toString();


        if ((email.contains("a"))&&((password.contains("a")))) {
            Toast.makeText(this, "Berhasil Login", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(signup().this,LoginActivity.class);
            startActivity(intent);
        } else if ((email.matches("")||password.matches(""))) {
            Toast.makeText(this, "Isi Username dan Password", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Username/Password salah", Toast.LENGTH_SHORT).show();
        }
    }



}
