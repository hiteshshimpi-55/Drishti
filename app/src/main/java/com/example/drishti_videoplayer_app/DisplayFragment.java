package com.example.drishti_videoplayer_app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;


public class DisplayFragment extends Fragment {


    Intent intent;
    ImageView imageView;
    TextView email,name;
    Bundle bundle;
    Uri uri;
    public DisplayFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_display, container, false);
        imageView = (ImageView)view.findViewById(R.id.displayImg);
        email     = (TextView)view.findViewById(R.id.email);
        name      = (TextView) view.findViewById(R.id.nameView);

        bundle = getArguments();
        if (this.getArguments() != null) {
            if (!TextUtils.isEmpty(bundle.getString("Email")) && !TextUtils.isEmpty(bundle.getString("Name"))) {
                email.setText(bundle.getString("Email"));
                name.setText(bundle.getString("Name"));
            } else {
                Toast.makeText(getActivity(), "No Data was entered", Toast.LENGTH_SHORT).show();
            }
            if (bundle.getString("URI") == null)
                Toast.makeText(getActivity(), "No Image was selected", Toast.LENGTH_SHORT).show();
            else {
                uri = Uri.parse(bundle.getString("URI"));
                imageView.setImageURI(uri);
            }
        }
        else
        {
            Toast.makeText(getActivity(), "Please Enter Details in Form fragment", Toast.LENGTH_SHORT).show();
        }
        return view;
    }
}