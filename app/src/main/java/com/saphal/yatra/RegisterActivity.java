package com.saphal.yatra;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.saphal.yatra.menu.MenuActivity;
import com.saphal.yatra.utils.FirebaseHelper;

import org.w3c.dom.Text;

public class RegisterActivity extends AppCompatActivity {

    private TextInputEditText tv_email, tv_password;
    private boolean isValid = true;
    private FirebaseAuth mAuth;
    private FirebaseHelper mFirebaseHelper;
    private static final String TAG = "RegisterActivity";
    private Button btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        tv_email = findViewById(R.id.tv_email);
        tv_password = findViewById(R.id.tv_password);
        btn_register = findViewById(R.id.btn_register);
        mAuth = FirebaseAuth.getInstance();
    }


    public void onClickBtnRegister(View view) {

        String email, password;
        email = tv_email.getText().toString();
        password = tv_password.getText().toString();
        validData(email, password);
        if (isValid = true) {
            signUpUser(email, password);
        }
    }

    private boolean validData(String email, String password) {
        if (email.isEmpty()) {
            tv_email.setError("Username Cannot be Empty");
            isValid = false;
        } else if (password.isEmpty()) {
            tv_password.setError("Password Cannot be Empty");
            isValid = false;
        } else if (password.length() < 5) {
            tv_password.setError("Password must be more than 5 characters");
            isValid = false;
        }
        return isValid;
    }

    private void signUpUser(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(RegisterActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }

                        // ...
                    }
                });
    }

    private void updateUI(FirebaseUser user) {
        if (user != null) {
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);

            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }


}

