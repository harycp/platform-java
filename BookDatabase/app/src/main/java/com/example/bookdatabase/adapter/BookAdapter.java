package com.example.bookdatabase.adapter;

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

import com.example.bookdatabase.R;
import com.example.bookdatabase.activities.ListBooksActivity;
import com.example.bookdatabase.activities.UpdateActivity;
import com.example.bookdatabase.db.DbHelper;
import com.example.bookdatabase.model.Book;

import java.io.Serializable;
import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {
    private ArrayList<Book> listBooks = new ArrayList<>();
    private Activity activity;
    private DbHelper dbHelper;

    public BookAdapter(Activity activity) {
        this.activity = activity;
        dbHelper = new DbHelper(activity);
    }

    public ArrayList<Book> getListBooks() {
        return listBooks;
    }

    public void setListBooks(ArrayList<Book> listNotes) {
        if (listNotes.size() > 0) {
            this.listBooks.clear();
        }
        this.listBooks.addAll(listNotes);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BookAdapter.BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book, parent, false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookAdapter.BookViewHolder holder, int position) {
        holder.tvTitle.setText(listBooks.get(position).getTitle());
        holder.tvWriter.setText(listBooks.get(position).getWriter());
        holder.tvPages.setText(String.valueOf(listBooks.get(position).getPages()));
        holder.btnEdit.setOnClickListener((View v) -> {
            Intent intent = new Intent(activity, UpdateActivity.class);
            intent.putExtra("user", (Serializable) listBooks.get(position));
            activity.startActivity(intent);
        });

        holder.btnDelete.setOnClickListener((View v) -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            builder.setTitle("Konfirmasi hapus");
            builder.setMessage("Apakah yakin akan dihapus?");
            builder.setPositiveButton("YA", (dialog, which) -> {
                dbHelper.deleteUser(listBooks.get(position).getId());
                Toast.makeText(activity, "Hapus berhasil!", Toast.LENGTH_SHORT).show();
                Intent myIntent = new Intent(activity, ListBooksActivity.class);
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
        return listBooks.size();
    }

    public class BookViewHolder extends RecyclerView.ViewHolder{
        final TextView tvTitle, tvWriter, tvPages;
        final Button btnEdit, btnDelete;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_item_title);
            tvWriter = itemView.findViewById(R.id.tv_item_writer);
            tvPages = itemView.findViewById(R.id.tv_item_pages);
            btnEdit = itemView.findViewById(R.id.btn_edit);
            btnDelete = itemView.findViewById(R.id.btn_delete);
        }
    }
}
