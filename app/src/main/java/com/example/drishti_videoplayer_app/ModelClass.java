package com.example.drishti_videoplayer_app;

public class ModelClass {

    private String url,video;

    public String getVideo() {
        return video;
    }

    public ModelClass() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ModelClass(String url,String video) {
        this.url = url;
        this.video = video;
    }


}
