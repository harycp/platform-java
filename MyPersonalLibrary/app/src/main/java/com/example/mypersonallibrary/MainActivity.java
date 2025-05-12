package com.example.mypersonallibrary;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvBooks;
    private ArrayList<Book> list = new ArrayList<>();
    private String title = "Mode List";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        setActionBarTitle(title);

        rvBooks = findViewById(R.id.rv_books);
        rvBooks.setHasFixedSize(true);

        list.addAll(BooksData.getListData());
        showRecycleList();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void setActionBarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    private void showSelectedBook(Book book) {
        Toast.makeText(this, "Kamu memilih " + book.getTitle(), Toast.LENGTH_SHORT).show();
    }

    private void showRecycleList() {
        rvBooks.setLayoutManager(new LinearLayoutManager(this));
        ListBookAdapter listBookAdapter = new ListBookAdapter(list);
        rvBooks.setAdapter(listBookAdapter);

        listBookAdapter.setOnItemClickCallback(new ListBookAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Book data) {
                showSelectedBook(data);
            }
        });
    }

    private void showRecyclerGrid() {
        rvBooks.setLayoutManager(new GridLayoutManager(this, 2));
        GridBookAdapter gridBookAdapter = new GridBookAdapter(list);
        rvBooks.setAdapter(gridBookAdapter);

        gridBookAdapter.setOnItemClickCallback(new ListBookAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Book data) {
                showSelectedBook(data);
            }
        });
    }

    private void showRecyclerCardView() {
        rvBooks.setLayoutManager(new LinearLayoutManager(this));
        CardViewBookAdapter cardViewWisataAdapter = new CardViewBookAdapter(list);
        rvBooks.setAdapter(cardViewWisataAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectMode) {
        if (selectMode == R.id.action_list) {
            title = "Mode List";
            showRecycleList();
        }
        if (selectMode == R.id.action_grid) {
            title = "Mode Grid";
            showRecyclerGrid();
        }
        if (selectMode == R.id.action_cardview) {
            title = "Mode CardView";
            showRecyclerCardView();
        }
        setActionBarTitle(title);
    }
}