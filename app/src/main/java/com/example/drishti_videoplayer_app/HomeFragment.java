package com.example.drishti_videoplayer_app;

import android.Manifest;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.youtube.player.YouTubeBaseActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class HomeFragment extends Fragment{
    private List<ModelClass> youtube;
    private RecyclerView recyclerView;
    private MyAdapter myAdapter;
    private ImageView shuffle;
    public HomeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.videoView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        shuffle = getActivity().findViewById(R.id.shuffleBtn);
        youtube = new ArrayList<>();
        youtube.clear();

        youtube.add(new ModelClass("https://img.youtube.com/vi/IEF6mw7eK4s/0.jpg","IEF6mw7eK4s"));
        youtube.add(new ModelClass("https://img.youtube.com/vi/8CEJoCr_9UI/0.jpg","8CEJoCr_9UI"));
        youtube.add(new ModelClass("https://img.youtube.com/vi/344u6uK9qeQ/0.jpg","344u6uK9qeQ"));
        youtube.add(new ModelClass("https://img.youtube.com/vi/3-nM3yNi3wg/0.jpg","3-nM3yNi3wg"));
//        youtube.add(new ModelClass("https://img.youtube.com/vi/RlcY37n5j9M/0.jpg","RlcY37n5j9M"));
        youtube.add(new ModelClass("https://img.youtube.com/vi/nB7nGcW9TyE/0.jpg","nB7nGcW9TyE"));

        shuffle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.shuffle(youtube);
                myAdapter = new MyAdapter(youtube,getActivity());
                recyclerView.setAdapter(myAdapter);
            }
        });
        myAdapter = new MyAdapter(youtube,getActivity());
        recyclerView.setAdapter(myAdapter);
        return view;
    }
}