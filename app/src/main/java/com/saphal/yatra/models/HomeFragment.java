package com.saphal.yatra.models;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.saphal.yatra.HotelActivity;
import com.saphal.yatra.HotelDisplayActivity;
import com.saphal.yatra.PackageActivity;
import com.saphal.yatra.R;
import com.saphal.yatra.VisitNepalActivity;


public class HomeFragment extends Fragment {


    private ImageButton btn_package;
    private ImageButton btn_hotel;
    private ImageButton btn_nepal;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_home, container, false);
        btn_package=view.findViewById(R.id.btn_package);
        btn_package.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), PackageActivity.class));
            }
        });
        btn_nepal=view.findViewById(R.id.btn_nepal);
        btn_nepal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), VisitNepalActivity.class));
            }
        });
        btn_hotel=view.findViewById(R.id.btn_hotel);
        btn_hotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), HotelDisplayActivity.class));
            }
        });

        return view;


    }

}