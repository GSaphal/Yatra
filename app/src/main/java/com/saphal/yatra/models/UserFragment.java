package com.saphal.yatra.models;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.saphal.yatra.Main1Activity;
import com.saphal.yatra.MainActivity;
import com.saphal.yatra.PackageActivity;
import com.saphal.yatra.R;


public class UserFragment extends Fragment {


    private Button btn_logout;
    private FirebaseAuth firebaseAuth;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_user, container, false);
        btn_logout = view.findViewById(R.id.btn_logout);
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertsignout();

            }

        });
        return view;
    }
        public void alertsignout()
        {
            AlertDialog.Builder alertDialog2 = new
                    AlertDialog.Builder(
                    getActivity());

            // Setting Dialog Title
            alertDialog2.setTitle("Confirm Logout");

            // Setting Dialog Message
            alertDialog2.setMessage("Are you sure you want to Logout?");

            // Setting Positive "Yes" Btn
            alertDialog2.setPositiveButton("YES",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // Write your code here to execute after dialog
                            firebaseAuth.getInstance().signOut();
                            Intent i = new Intent(getActivity(), MainActivity.class);
                            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
                                    Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(i);
                        }
                    });


            // Setting Negative "NO" Btn
            alertDialog2.setNegativeButton("NO",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // Write your code here to execute after dialog

                            dialog.cancel();
                        }
                    });

            // Showing Alert Dialog
            alertDialog2.show();


        }
        


    }