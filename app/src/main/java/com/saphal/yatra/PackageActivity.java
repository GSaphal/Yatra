package com.saphal.yatra;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.saphal.yatra.R;
import com.saphal.yatra.menu.CostumizedActivity;


public class PackageActivity extends AppCompatActivity {
    Dialog myDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package);

        myDialog=new Dialog(this);



        //set the statue bar background to transparent

        //Window w=getWindow();
        //w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);



        //setup recycler view with adapter

        //RecyclerView recyclerView=findViewById(R.id.rv_list);
        //List<item>  mlist = new ArrayList<>();
        //mlist.add(new item(R.drawable.oneweek,"One week Package"));
        //mlist.add(new item(R.drawable.twoweek,"Two week Package"));
        //mlist.add(new item(R.drawable.oneweek,"One month Package"));

        //Adapter adapter=new Adapter(this,mlist);
        //recyclerView.setAdapter(adapter);
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
    public void Showpopup1(View v) {
        TextView txtclose1;
        Button btn_bookthis1;
        myDialog.setContentView(R.layout.popuppackage1);
        txtclose1 = (TextView) myDialog.findViewById(R.id.txtclose1);
        btn_bookthis1 = (Button) myDialog.findViewById(R.id.btn_bookthis1);
        txtclose1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.show();
    }

    public void Showpopup2(View v){
        TextView txtclose2;
        Button btn_bookthis2;
        myDialog.setContentView(R.layout.popuppackage2);
        txtclose2 = (TextView) myDialog.findViewById(R.id.txtclose2);
        btn_bookthis2 = (Button) myDialog.findViewById(R.id.btn_bookthis2);
        txtclose2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.show();
    }

    public void Showpopup3(View v){
        TextView txtclose3;
        Button btn_bookthis3;
        myDialog.setContentView(R.layout.popuppackage3);
        txtclose3 = (TextView) myDialog.findViewById(R.id.txtclose3);
        btn_bookthis3 = (Button) myDialog.findViewById(R.id.btn_bookthis3);
        txtclose3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.show();

    }

    public void onBtnSubmit(View view) {
        Intent intent=new Intent(getApplicationContext(), CostumizedActivity.class);
        startActivity(intent);
    }
}