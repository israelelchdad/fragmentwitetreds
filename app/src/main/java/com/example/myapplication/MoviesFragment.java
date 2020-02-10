package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class MoviesFragment  extends Fragment implements OnMovieClickListener{
    private OnMovieFragmentClickListener myframlisiner;
    private RecyclerView mrecycleview;

    public static  int indexitem;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof  OnMovieFragmentClickListener ){
            myframlisiner =(OnMovieFragmentClickListener) context;
        }
        else {
            throw new RuntimeException(context.toString()+ " must to be implement OnMovieFragmentClickListener ");
        }
    }



    @Override
    public void onDetach() {
        super.onDetach();
        myframlisiner = null;
    }



    private RecyclerView.LayoutManager mylayotmaneger;
    private RecyclerView.Adapter myAdapter;

    @Nullable




    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.moviesfragment,container,false);
        mrecycleview = view.findViewById(R.id.movies_fragment_rcv);

        initrecycleview();
        return view;
    }




    private void initrecycleview() {
        if (getContext() != null)   {
            mylayotmaneger = new LinearLayoutManager(getContext());
            mrecycleview.setLayoutManager(mylayotmaneger);
            myAdapter = new MoviesViewAdapter(getContext(),this, MainActivity.araydata());
            mrecycleview.setAdapter(myAdapter);

        }
    }

    @Override
    public void onmovieclicked(int itemposition) {
        indexitem =itemposition;
        if (myframlisiner != null){
        myframlisiner.onMovieClicked(MainActivity.araydata().get(itemposition));
        }

    }
}
