package com.example.drishti_videoplayer_app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.github.dhaval2404.imagepicker.ImagePicker;

import java.io.Serializable;


public class FormFragment extends Fragment{

    private ImageView imageView;
    private EditText emailText , nameText;
    private String name,email;
    private Button submit;
    private Uri uri;
    Bundle bundle = new Bundle();
    public FormFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_form, container, false);

        imageView = (ImageView) view.findViewById(R.id.profile_Img);
        emailText = (EditText) view.findViewById(R.id.emailView);
        nameText  = (EditText) view.findViewById(R.id.name);
        submit    = (Button) view.findViewById(R.id.submitBtn);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImagePicker.with(FormFragment.this).cameraOnly()
                        .crop()	    			//Crop image(Optional), Check Customization for more option
                        .compress(1024)			//Final image size will be less than 1 MB(Optional)
                        .maxResultSize(1080, 1080)	//Final image resolution will be less than 1080 x 1080(Optional)
                        .start();
            }
        });



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                email = emailText.getText().toString();
                name  = nameText.getText().toString();
                if(!TextUtils.isEmpty(email) && !TextUtils.isEmpty(name)) {
                    bundle.putString("Email", email);
                    bundle.putString("Name", name);
                    Fragment fragment = new DisplayFragment();
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragment.setArguments(bundle);
                    fragmentTransaction.replace(R.id.framelayout, fragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
                else
                {
                    Toast.makeText(getActivity(), "Please Enter the Following Details", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        uri = data.getData();
        imageView.setImageURI(uri);
        bundle.putString("URI",uri.toString());

    }
}