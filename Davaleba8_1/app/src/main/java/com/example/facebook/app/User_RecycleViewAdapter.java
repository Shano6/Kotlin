package com.example.facebook.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.facebook.R;
import com.example.facebook.app.dto.Note;
import java.util.ArrayList;

public class User_RecycleViewAdapter extends RecyclerView.Adapter<User_RecycleViewAdapter.ViewHolder>{
    Context context;
    ArrayList<Note> notes;

    public User_RecycleViewAdapter(Context context, ArrayList<Note> notes){
        this.context = context;
        this.notes = notes;
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
        holder.name.setText(notes.get(position).getName());
        holder.description.setText(notes.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView name, description;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.nameId);
            description = itemView.findViewById(R.id.descriptionId);
        }
    }
}
