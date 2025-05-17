package com.example.ourgroups.adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ourgroups.R;
import com.example.ourgroups.activities.ListGroupsActivity;
import com.example.ourgroups.activities.UpdateActivity;
import com.example.ourgroups.db.DbHelper;
import com.example.ourgroups.model.Group;

import java.io.Serializable;
import java.util.ArrayList;

public class GroupAdapter extends RecyclerView.Adapter<GroupAdapter.GroupViewHolder> {
    private ArrayList<Group> listGroups = new ArrayList<>();
    private Activity activity;
    private DbHelper dbHelper;

    public GroupAdapter(Activity activity) {
        this.activity = activity;
        dbHelper = new DbHelper(activity);
    }
    public ArrayList<Group> getListGroups() {
        return listGroups;
    }
    public void setListGroups(ArrayList<Group> listNotes) {
        if (listNotes.size() > 0) {
            this.listGroups.clear();
        }
        this.listGroups.addAll(listNotes);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public GroupViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_group, parent, false);
        return new GroupViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GroupViewHolder holder, int position) {
        holder.tvName.setText(listGroups.get(position).getName());
        holder.tvNim.setText(listGroups.get(position).getNim());
        holder.tvEmail.setText(listGroups.get(position).getEmail());
        holder.tvKelompok.setText(listGroups.get(position).getKelompok());
        holder.tvAplikasi.setText(listGroups.get(position).getAplikasi());
        holder.btnEdit.setOnClickListener((View v) -> {
            Intent intent = new Intent(activity, UpdateActivity.class);
            intent.putExtra("user", (Serializable) listGroups.get(position));
            activity.startActivity(intent);
        });

        holder.btnDelete.setOnClickListener((View v) -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            builder.setTitle("Konfirmasi hapus");
            builder.setMessage("Apakah yakin akan dihapus?");
            builder.setPositiveButton("YA", (dialog, which) -> {
                dbHelper.deleteUser(listGroups.get(position).getId());
                Toast.makeText(activity, "Hapus berhasil!", Toast.LENGTH_SHORT).show();
                Intent myIntent = new Intent(activity, ListGroupsActivity.class);
                activity.startActivity(myIntent);
                activity.finish();
            });

            builder.setNegativeButton("TIDAK", (dialog, which) -> dialog.dismiss());
            AlertDialog alert = builder.create();
            alert.show();
        });
    }

    @Override
    public int getItemCount() {
        return listGroups.size();
    }

    public class GroupViewHolder extends RecyclerView.ViewHolder{
        final TextView tvName, tvNim, tvEmail, tvKelompok, tvAplikasi;
        final Button btnEdit, btnDelete;
        public GroupViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvNim = itemView.findViewById(R.id.tv_item_nim);
            tvEmail = itemView.findViewById(R.id.tv_item_email);
            tvKelompok = itemView.findViewById(R.id.tv_item_kelompok);
            tvAplikasi = itemView.findViewById(R.id.tv_item_aplikasi);
            btnEdit = itemView.findViewById(R.id.btn_edit);
            btnDelete = itemView.findViewById(R.id.btn_delete);
        }
    }
}
