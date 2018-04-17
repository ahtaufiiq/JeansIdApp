package makanbu.com.makanbu.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import de.hdodenhof.circleimageview.CircleImageView;
import makanbu.com.makanbu.Constants;
import makanbu.com.makanbu.R;
import makanbu.com.makanbu.model.User;

public class SignUpActivity extends AppCompatActivity {


    private static final int PICK_IMAGE = 1;
    // [START declare_auth]
    private FirebaseAuth mAuth;

    private static final String TAG = "EmailPassword";
    DatabaseReference databaseUser;
    private EditText eml;
    private EditText pass,mPhone;
    String email, password;
    Button button;
    private Uri imageUri;

    private StorageReference mStorage;
    private CircleImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        eml = (EditText) findViewById(R.id.et_email);
        pass = (EditText) findViewById(R.id.et_password);
        mPhone= findViewById(R.id.et_nomor);
        imageView= findViewById(R.id.setup_image);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);
            }
        });

        button = findViewById(R.id.btn_daftar);
        databaseUser = FirebaseDatabase.getInstance().getReference(Constants.table_1);
        mStorage = FirebaseStorage.getInstance().getReference().child("images");
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
                            add();
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

    public void add() {

        databaseUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String[] username = email.split("@");
                final String name = username[0];
                final String phone = mPhone.getText().toString();
                final String id = mAuth.getUid();

                if (imageUri != null && !TextUtils.isEmpty(name)) {

                    final StorageReference image = mStorage.child(id + ".jpg");

                    image.putFile(imageUri).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> uploadTask) {

                            if (uploadTask.isSuccessful()) {

                                String download_url = uploadTask.getResult().getDownloadUrl().toString();
                                User post = new User(id, email, phone, download_url);
                                databaseUser.child(id).setValue(post);

                            } else {
                                Toast.makeText(SignUpActivity.this, "Error : " + uploadTask.getException().getMessage(), Toast.LENGTH_LONG).show();
                            }
                        }
                    });

                    //displaying a success toast
                    Toast.makeText(SignUpActivity.this, "Uploaded", Toast.LENGTH_LONG).show();
                } else {
                    //if the value is not given displaying a toast
                    Toast.makeText(SignUpActivity.this, "Please Fill the form and choose image", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE) {
            imageUri = data.getData();
            imageView.setImageURI(imageUri);
        }
    }
}
