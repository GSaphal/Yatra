package com.saphal.yatra;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.saphal.yatra.menu.MenuActivity;
import com.saphal.yatra.utils.FirebaseHelper;

public class LoginActivity extends AppCompatActivity {
    private boolean isValid = true;
    private TextInputEditText login_username, login_password;
    private FirebaseHelper mFirebaseHelper;
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login_username = findViewById(R.id.login_username);
        login_password = findViewById(R.id.login_password);
    }

    public void onClickBtnLogin(View view) {
        String email = login_username.getText().toString();
        String password = login_password.getText().toString();
        validData(email, password);
        mFirebaseHelper = new FirebaseHelper(getApplicationContext());

        if (isValid = true) {
            checkSignIn(email, password);

        }
    }
    private boolean validData(String email, String password) {
        if (email.isEmpty()) {
            login_username.setError("Username Cannot be Empty");
            isValid = false;
        } else if (password.isEmpty()) {
            login_password.setError("Password Cannot be Empty");
            isValid = false;
        } else if (password.length() < 5) {
            login_password.setError("Password must be more than 5 characters");
            isValid = false;
        }
        return isValid;
    }

    private void checkSignIn(String email, String pass) {
        mFirebaseHelper.getmAuth().signInWithEmailAndPassword(email, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = mFirebaseHelper.getmAuth().getCurrentUser();

                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            if(user.getUid().equals("lIjJoC6lXVQlfPY239f6MeohAIo1"))
                            {
                                updateUIadmin(user);
                            }
                            else
                                {
                                updateUI(user);
                            }
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(getApplicationContext(), task.getException().getMessage(),
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    }
                });
    }

    private void updateUIadmin(FirebaseUser user) {
        if (user != null) {
            Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }
    private void updateUI(FirebaseUser user) {
        if (user != null) {

            Intent intent = new Intent(getApplicationContext(),Main1Activity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }
}
