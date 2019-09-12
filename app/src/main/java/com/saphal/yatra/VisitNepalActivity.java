package com.saphal.yatra;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class VisitNepalActivity extends AppCompatActivity {
    Dialog myDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visit_nepal);

        myDialog=new Dialog(this);

    }

    public void ShowpopupA(View v) {
        TextView txtclosea;
        Button btn_bookthisa;
        myDialog.setContentView(R.layout.popupvisita);
        txtclosea = (TextView) myDialog.findViewById(R.id.txtclosea);
        btn_bookthisa = (Button) myDialog.findViewById(R.id.btn_bookthisa);
        txtclosea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.show();
    }

    public void ShowpopupB(View v){
        TextView txtcloseb;
        Button btn_bookthisb;
        myDialog.setContentView(R.layout.popupvisitb);
        txtcloseb = (TextView) myDialog.findViewById(R.id.txtcloseb);
        btn_bookthisb = (Button) myDialog.findViewById(R.id.btn_bookthisb);
        txtcloseb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.show();
    }


}