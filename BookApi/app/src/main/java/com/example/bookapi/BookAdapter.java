package com.example.bookapi;

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

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {
    List<BookItem> result;
    Activity activity;

    public BookAdapter(List<BookItem> result, Activity activity){
        this.result = result;
        this.activity = activity;
    }
    public BookAdapter(MyBook myBook) {
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_book, parent, false));
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
        TextView tv_no, tv_title, tv_writer, tv_pages, tv_genre, tv_publisher;
        ImageView coverView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_no = itemView.findViewById(R.id.tv_no);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_writer = itemView.findViewById(R.id.tv_writer);
            tv_pages = itemView.findViewById(R.id.tv_pages);
            tv_genre = itemView.findViewById(R.id.tv_genre);
            tv_publisher = itemView.findViewById(R.id.tv_publisher);
            coverView = itemView.findViewById(R.id.coverView);
        }

        public void bind(BookItem bookItem) {
            tv_no.setText(bookItem.no);
            tv_title.setText(bookItem.title);
            tv_writer.setText(bookItem.writer);
            tv_pages.setText(bookItem.pages);
            tv_genre.setText(bookItem.genre);
            tv_publisher.setText(bookItem.publisher);
            Glide.with(activity).load(bookItem.getCover()).into(coverView);
        }
    }
}
