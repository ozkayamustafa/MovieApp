package com.mustafa.movieapp.yearsFragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mustafa.movieapp.Api.ApiClient;
import com.mustafa.movieapp.Api.IMovieApi;
import com.mustafa.movieapp.R;
import com.mustafa.movieapp.adapter.YearsAdapter;
import com.mustafa.movieapp.years2021model.Search;
import com.mustafa.movieapp.years2021model.Years;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class Fragment2021 extends Fragment {
    RecyclerView recyclerView;
    CompositeDisposable cd;
    YearsAdapter adapter;
    Context context;
    public Fragment2021(Context context){
        this.context = context;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        apiConnection();
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_2021,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        recyclerView = view.findViewById(R.id.row2021);

        super.onViewCreated(view, savedInstanceState);
    }


    public void apiConnection(){
        IMovieApi movieApi = ApiClient.getInstance().create(IMovieApi.class);
        cd = new CompositeDisposable();


    }
    public void handlerYear(Years years){
        List<Search> searches = years.getSearch();
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(context,2);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new YearsAdapter(searches,getContext());
        recyclerView.setNestedScrollingEnabled(true);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onDestroy() {
        cd.clear();
        super.onDestroy();
    }
}
