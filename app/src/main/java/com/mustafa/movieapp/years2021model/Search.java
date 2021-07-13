package com.mustafa.movieapp.years2021model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Search{
    @SerializedName("Title")
    @Expose
    public String title;

    @SerializedName("Poster")
    @Expose
    public String poster;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }
}
