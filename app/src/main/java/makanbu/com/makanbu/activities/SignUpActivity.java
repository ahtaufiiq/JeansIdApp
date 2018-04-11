package makanbu.com.makanbu.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import makanbu.com.makanbu.R;
import makanbu.com.makanbu.model.User;

public class SignUpActivity extends AppCompatActivity {


    // [START declare_auth]
    private FirebaseAuth mAuth;

    private static final String TAG = "EmailPassword";
    DatabaseReference databaseUser;
    private EditText eml;
    private EditText pass;
    String email, password;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        eml = (EditText) findViewById(R.id.et_email);
        pass = (EditText) findViewById(R.id.et_password);

        button = findViewById(R.id.btn_daftar);
        databaseUser = FirebaseDatabase.getInstance().getReference("Profile");
        // [START initialize_auth]
        mAuth = FirebaseAuth.getInstance();
        // [END initialize_auth]

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = eml.getText().toString();
                password = pass.getText().toString();

                createAccount(email, password);
                Toast.makeText(SignUpActivity.this, email,
                        Toast.LENGTH_SHORT).show();


            }

        });

    }

    private void createAccount(final String email, final String password) {
        Log.d(TAG, "createAccount:" + email);

        // [START create_user_with_email]
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            String id = mAuth.getUid();
                            User user = new User(email, password);
                            databaseUser.child(id).setValue(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(SignUpActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }
                    }
                });
        // [END create_user_with_email]
    }


    public void back(View view) {
        Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}
