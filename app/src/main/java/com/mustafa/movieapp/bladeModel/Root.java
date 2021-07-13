package com.mustafa.movieapp.bladeModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Root{
    @SerializedName("Poster")
    @Expose
    public String poster;

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }
}
