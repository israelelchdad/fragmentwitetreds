package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class fragmentto extends Fragment {
    private Data data;
    private ImageView img;
    private ImageView img2;
    private TextView title;
    private TextView text;
    private static final String MOVIE_BUNDLE_KEY = "unique_movie_key";



    public static fragmentto newinstans(Data dat){

        fragmentto fragment = new fragmentto();
        Bundle args =new Bundle();
      args.putParcelable(MOVIE_BUNDLE_KEY,dat);
//        args.putString("title",dat.getTitle());
//        args.putString("text",dat.getText());
//        args.putInt("picture",dat.getPicture());
//
      fragment.setArguments(args);

    return fragment;

    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments()!=null){
       data = getArguments().getParcelable(MOVIE_BUNDLE_KEY);
//            data.setTitle(getArguments().getString("title"));
//            data.setText(getArguments().getString("text"));
//           data.setPicture(getArguments().getInt("picture"));
//            data.setTitle("title");
//            data.setText("text");
//            data.setPicture(R.drawable.code_8);
        Log.d("data","0");

       }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fratow,container,false);
        Log.d("data","1");
        initview(view);
//        String d =data.toString();
//       Log.d("data",d);
        if (data != null){
            Log.d("data","2");
            Log.d("dattttt",data.getText());
            loadmovie();
        }
        return view;
    }


    private void loadmovie() {
        Log.d("dattttt",data.getText());

        img.setImageResource(data.getPicture());
        img2.setImageResource(data.getPicture());
        title.setText(data.getTitle());
        text.setText(data.getText());

    }

    private void initview(View view) {
        img = view.findViewById(R.id.imge);
        img2 = view.findViewById(R.id.imge2);
        title = view.findViewById(R.id.title);
        text = view.findViewById(R.id.textt);
        Button button = view.findViewById(R.id.ft_b);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(data.getLink()));
                startActivity(intent);

            }
        });
    }
}


