package com.example.facebook.app;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.facebook.R;
import com.example.facebook.app.dto.User;

import java.util.ArrayList;

public class User_RecycleViewAdapter extends RecyclerView.Adapter<User_RecycleViewAdapter.ViewHolder>{
    Context context;
    ArrayList<User> users;
    public User_RecycleViewAdapter(Context context, ArrayList<User> users){

    }

    @NonNull
    @Override
    public User_RecycleViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recyler_row, parent, false);
        return new User_RecycleViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull User_RecycleViewAdapter.ViewHolder holder, int position) {
        holder.name.setText(users.get(position).getFirstName());
        holder.surname.setText(users.get(position).getLastName());
        holder.email.setText(users.get(position).getEmail());
//        holder.avatar.setImageResource(users.get(position).getAvatar());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView avatar;
        TextView name, surname, email;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            avatar = itemView.findViewById(R.id.imageView);
            name = itemView.findViewById(R.id.nameId);
            surname = itemView.findViewById(R.id.surnameId);
            email = itemView.findViewById(R.id.emailId);
        }
    }
}
