package com.example.myapplication;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MoviesViewAdapter extends RecyclerView.Adapter<MoviesViewAdapter.ViewHolder> {
    private LayoutInflater inflater;
    private ArrayList<Data> mydata;
    private OnMovieClickListener myclicklisiner;

    public MoviesViewAdapter(Context context, OnMovieClickListener listener, ArrayList<Data> datmove) {
        myclicklisiner = listener;
        mydata = datmove;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesViewAdapter.ViewHolder holder, int position) {
        holder.onsetholder(mydata.get(position));

    }

    @Override
    public int getItemCount() {
        return mydata.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView ivImage;
        public TextView tvTitle;
        public TextView tvtext;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Log.e("CLIC1", "11111111111111111111111111111111111111111111111");
            ivImage = itemView.findViewById(R.id.mg);
            tvTitle = itemView.findViewById(R.id.titl);
            tvtext = itemView.findViewById(R.id.tex);
            Log.d("TTTT","J");
            itemView.setOnClickListener(this);


        }

        public void onsetholder(Data dat) {
            Log.d("CLIC1", "11111111111111111111111111111111111111111111111");
            ivImage.setImageResource(dat.getPicture());
            tvTitle.setText(dat.getTitle());
            tvtext.setText(dat.getText());
        }

        @Override
        public void onClick(View v) {
            Log.e("CLIC1", "11111111111111111111111111111111111111111111111");
            if (myclicklisiner == null) return;
            myclicklisiner.onmovieclicked(getAdapterPosition());

        }
    }
}
