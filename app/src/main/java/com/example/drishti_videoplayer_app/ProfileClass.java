package com.example.drishti_videoplayer_app;

import android.net.Uri;
import android.provider.ContactsContract;

import java.io.Serializable;
import java.util.Date;

public class ProfileClass implements Serializable {

    private String name,email;
    private Uri uri;

    public void setName(String name) {
        this.name = name;
    }

    public ProfileClass() {
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUri(Uri uri) {
        this.uri = uri;
    }

    public ProfileClass(String name, String email, Uri uri) {
        this.name = name;
        this.email = email;
        this.uri = uri;
    }
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Uri getUri() {
        return uri;
    }

}
