package com.example.socialmediaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import com.example.socialmediaapp.DRVinterface.LoadMore;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DashBoardActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private StaticRvAdapter staticRvAdapter;
    private DynamicRVAdapter dynamicRVAdapter;


    List<DynamicRVModel> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        ArrayList<StaticRvModel> item = new ArrayList<>();
        item.add(new StaticRvModel(R.drawable.soccercolor, "soccer"));
        item.add(new StaticRvModel(R.drawable.basketball, "basketball"));
        item.add(new StaticRvModel(R.drawable.volleyball, "volleyball"));
        item.add(new StaticRvModel(R.drawable.tennisball, "tennisball"));
        item.add(new StaticRvModel(R.drawable.baseball, "baseball"));

        recyclerView = findViewById(R.id.view1);
        staticRvAdapter = new StaticRvAdapter(item);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(staticRvAdapter);





        items.add(new DynamicRVModel("Soccer"));
        items.add(new DynamicRVModel("Basketball"));
        items.add(new DynamicRVModel("Volleyball"));
        items.add(new DynamicRVModel("Baseball"));
        items.add(new DynamicRVModel("Tennis"));
        items.add(new DynamicRVModel("Soccer"));
        items.add(new DynamicRVModel("Basketball"));
        items.add(new DynamicRVModel("Volleyball"));
        items.add(new DynamicRVModel("Baseball"));
        items.add(new DynamicRVModel("Tennis"));
        items.add(new DynamicRVModel("Soccer"));
        items.add(new DynamicRVModel("Basketball"));
        items.add(new DynamicRVModel("Volleyball"));
        items.add(new DynamicRVModel("Baseball"));
        items.add(new DynamicRVModel("Tennis"));
        items.add(new DynamicRVModel("Soccer"));
        items.add(new DynamicRVModel("Basketball"));
        items.add(new DynamicRVModel("Volleyball"));
        items.add(new DynamicRVModel("Baseball"));
        items.add(new DynamicRVModel("Tennis"));

        RecyclerView drv = findViewById(R.id.view2);
        drv.setLayoutManager(new LinearLayoutManager(this));
        dynamicRVAdapter = new DynamicRVAdapter(drv, this, items);
        drv.setAdapter(dynamicRVAdapter);
        dynamicRVAdapter.setLoadMore(new LoadMore() {
            @Override
            public void onLoadMore() {
                if (items.size() <= 10) {
                    items.add(null);
                    dynamicRVAdapter.notifyItemInserted(items.size() - 1);
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            items.remove(items.size() - 1);
                            dynamicRVAdapter.notifyItemRemoved(items.size());

                            int index = items.size();
                            int end = index + 10;
                            for (int i = index; i < end; i++) {
                                String name = UUID.randomUUID().toString();
                                DynamicRVModel item = new DynamicRVModel(name);
                                items.add(item);
                        }
                            dynamicRVAdapter.notifyDataSetChanged();
                            dynamicRVAdapter.setLoaded();
                    }
                    }, 4000);
                }
                else
                    Toast.makeText(DashBoardActivity.this, "Data Complete", Toast.LENGTH_SHORT).show();

            }

        });
    }
    }