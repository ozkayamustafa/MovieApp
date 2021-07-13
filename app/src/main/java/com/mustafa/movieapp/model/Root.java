package com.mustafa.movieapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mustafa.movieapp.model.Search;

import java.util.List;

public class Root{

    @SerializedName("Search")
    @Expose
    public List<Search> search;

    @SerializedName("totalResults")
    @Expose
    public String totalResults;

    @SerializedName("Response")
    @Expose
    public String response;

    public List<Search> getSearch() {
        return search;
    }

    public void setSearch(List<Search> search) {
        this.search = search;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
