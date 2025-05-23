package com.example.crud_api;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.ViewHolder> {

    List<PlayerItem> result;
    Activity activity;

    public PlayerAdapter(List<PlayerItem> result, Activity activity){
        this.result = result;
        this.activity = activity;
    }
    public PlayerAdapter(MyPlayer myPlayer) {
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_player, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(result.get(position));
    }

    @Override
    public int getItemCount() {
        return result != null ? result.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv_no, tv_name, tv_birth_date, tv_position, tv_international, tv_team;
        ImageView posterView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_no = itemView.findViewById(R.id.tv_no);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_birth_date = itemView.findViewById(R.id.tv_birth_date);
            tv_position = itemView.findViewById(R.id.tv_position);
            tv_international = itemView.findViewById(R.id.tv_international);
            tv_team = itemView.findViewById(R.id.tv_team);
            posterView = itemView.findViewById(R.id.posterView);
        }

        public void bind(PlayerItem playerItem) {
            tv_no.setText(playerItem.no);
            tv_name.setText(playerItem.name);
            tv_birth_date.setText(playerItem.birth_date);
            tv_position.setText(playerItem.Position);
            tv_international.setText(playerItem.International);
            tv_team.setText(playerItem.Team);
            Glide.with(activity).load(playerItem.getPoster()).into(posterView);
        }
    }
}
