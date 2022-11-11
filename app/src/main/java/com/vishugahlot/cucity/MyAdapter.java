package com.vishugahlot.cucity;

import android.content.Context;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;

    ArrayList<User> list;
    private ItemClickListener mItemListener;

    public MyAdapter(Context context, ArrayList<User> list, ItemClickListener itemClickListener) {
        this.context = context;
        this.list = list;
        this.mItemListener = itemClickListener;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return  new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        User user = list.get(position);
        holder.firstName.setText(user.name);
        holder.lastName.setText(user.email);
        holder.age.setText(user.course);

        Glide.with(holder.image.getContext())
                .load(user.surl)
                .placeholder(com.google.android.gms.base.R.drawable.common_google_signin_btn_icon_dark)
                .circleCrop()
                .error(com.google.firebase.database.R.drawable.common_google_signin_btn_icon_dark_normal)
                .into(holder.image);

        holder.itemView.setOnClickListener(view -> {
            mItemListener.onItemClick(list.get(position));
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public interface ItemClickListener{
        void onItemClick(User details);
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView firstName, lastName, age;
        CircleImageView image;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            firstName = itemView.findViewById(R.id.namefetch);
            lastName = itemView.findViewById(R.id.emailfetch);
            age = itemView.findViewById(R.id.coursefetch);
            image = (CircleImageView)itemView.findViewById(R.id.imgTeach);

        }
    }
}
