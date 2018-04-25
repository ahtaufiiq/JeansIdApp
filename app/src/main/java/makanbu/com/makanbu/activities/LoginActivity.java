package makanbu.com.makanbu.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import makanbu.com.makanbu.R;

/**
 * Created by SP-SHOCK on 2/21/2018.
 */

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "EmailPassword";
    TextInputLayout mEmail;
    TextInputLayout mPassword;
    Button login;

    // [START declare_auth]
    private FirebaseAuth mAuth;
    // [END declare_auth]


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEmail = findViewById(R.id.user);
        mPassword = findViewById(R.id.password);
        // [START initialize_auth]
        mAuth = FirebaseAuth.getInstance();
        // [END initialize_auth]

        login = findViewById(R.id.lgn_btn);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn(mEmail.getEditText().getText().toString(), mPassword.getEditText().getText().toString());
            }
        });
    }


    private void signIn(String email, String password) {

        // [START sign_in_with_email]
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Intent intent = new Intent(LoginActivity.this, Home.class);
                            startActivity(intent);
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }

                    }
                });
        // [END sign_in_with_email]
    }

    public void Move(View view) {

        Intent pindah = new Intent(LoginActivity.this, SignUpActivity.class);
        startActivity(pindah);
    }

    public void closeLanding(View view) {
        Intent intent = new Intent(this, LandingActivity.class);
        startActivity(intent);
    }
}