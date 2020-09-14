package com.myapp.beatify;

public class CreateSong {
    private String imgURL;
    private String txt;
//    private int img;

    public CreateSong(String imgURL, String txt) {
        this.imgURL = imgURL;
        this.txt = txt;
    }

    public String getImgURL() {
        return imgURL;
    }

    public String getTxt() {
        return txt;
    }
}
