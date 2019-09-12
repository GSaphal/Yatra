package com.saphal.yatra;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.saphal.yatra.menu.MenuActivity;
import com.saphal.yatra.utils.FirebaseHelper;

public class AdminLoginActivity extends AppCompatActivity {
    private boolean isValid = true;
    private EditText admin_login_username, admin_login_password;
    private FirebaseHelper mFirebaseHelper;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        admin_login_username = findViewById(R.id.admin_login_username);
        admin_login_password = findViewById(R.id.admin_login_password);
    }

    public void onClickBtnLogin(View view) {
        String email = admin_login_username.getText().toString();
        String password = admin_login_password.getText().toString();


    }
}