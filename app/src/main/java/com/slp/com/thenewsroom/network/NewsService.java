package com.slp.com.thenewsroom.network;

import com.slp.com.thenewsroom.data.News;
import com.slp.com.thenewsroom.data.NewsArticles;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by Lakshmiprasad on 01/11/2017.
 */

public interface NewsService {

    @GET("articles")
    Call<NewsArticles> getNews(@QueryMap Map<String,String> queryMap);

}
