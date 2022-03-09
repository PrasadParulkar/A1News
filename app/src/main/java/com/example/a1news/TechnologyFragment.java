package com.example.a1news;

import android.os.Bundle;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Callback;
import retrofit2.Response;

public class TechnologyFragment extends Fragment {

    String api="5f293a13c31945578aed7bf3f1d5d6ea";
    ArrayList<ModelClass> modelClassArrayList;
    Adapter adapter;
    String country="in";
    private RecyclerView recyclerViewoftech;
    private String category="technology";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.technologyfragment,null);


        recyclerViewoftech=v.findViewById(R.id.recyclerviewoftech);
        modelClassArrayList=new ArrayList<>();
        recyclerViewoftech.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter=new Adapter(getContext(),modelClassArrayList);
        recyclerViewoftech.setAdapter(adapter);

        findNews();

        return v;
    }

    private void findNews() {

        ApiUtilies.getApiInterface().getCategoryNews(country,category,100,api).enqueue(new Callback<a1News>() {
            @Override
            public void onResponse(retrofit2.Call<a1News> call, Response<a1News> response) {
                if (response.isSuccessful()) {
                    modelClassArrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(retrofit2.Call<a1News> call, Throwable t) {

            }

        });

    }

}
