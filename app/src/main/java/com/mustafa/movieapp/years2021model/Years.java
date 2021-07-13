package com.mustafa.movieapp.years2021model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Years{
    @SerializedName("Search")
    @Expose
    public List<Search> search;

    public List<Search> getSearch() {
        return search;
    }

    public void setSearch(List<Search> search) {
        this.search = search;
    }
}
