package com.saphal.yatra.models;

import android.content.Context;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.saphal.yatra.R;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    ArrayList<HotelFire> profiles;

    public MyAdapter(Context c, ArrayList<HotelFire> p) {
        context = c;
        profiles = p;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.hotel_cardview, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
            HotelFire hotelfire=profiles.get(position);
        Toast.makeText(context, ""+profiles.get(position).getHname(), Toast.LENGTH_SHORT).show();
        holder.hot_name.setText(profiles.get(position).getHname());
//        holder.hot_address.setText(profiles.get(position).getHaddress());
//        holder.hot_phone.setText(profiles.get(position).getHphone());
//        holder.hot_website.setText(profiles.get(position).getHwebsite());
      // Glide.with(context).load(profiles.get(position).getImage()).into(holder.hotel_image);



    }

    @Override
    public int getItemCount() {
        return profiles.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView hot_name, hot_address, hot_phone, hot_website;
        ImageView hot_hotel_image;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            hot_name=(TextView) itemView.findViewById(R.id.hot_name);
            hot_address=(TextView)itemView.findViewById(R.id.hot_address);
            hot_phone=(TextView)itemView.findViewById(R.id.hot_phone);
            hot_website=(TextView)itemView.findViewById(R.id.hot_website);
            hot_hotel_image=(ImageView)itemView.findViewById(R.id.hotel_image);

        }
    }


}
