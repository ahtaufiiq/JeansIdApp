package makanbu.com.makanbu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {


    private EditText eml;
    private EditText pass;
    String email, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }
    public void signup(View view) {

        eml = (EditText) findViewById(R.id.editText3);
        pass = (EditText) findViewById(R.id.editText2);
        email = eml.getText().toString();
        password = pass.getText().toString();


    }



}
