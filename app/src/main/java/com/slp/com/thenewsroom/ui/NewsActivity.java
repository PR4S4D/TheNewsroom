package com.slp.com.thenewsroom.ui;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.slp.com.thenewsroom.R;
import com.slp.com.thenewsroom.data.News;
import com.slp.com.thenewsroom.data.NewsArticles;
import com.slp.com.thenewsroom.network.NewsService;
import com.slp.com.thenewsroom.utils.NewsRoomConstants;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsActivity extends AppCompatActivity implements NewsRoomConstants, Callback<NewsArticles>{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        getNewsArticles();
    }

    private void getNewsArticles() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(NEWS_API_END_POINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        NewsService service = retrofit.create(NewsService.class);
        Map<String, String> queryMap = getNewsQuery();
        Call<NewsArticles> newsList = service.getNews(queryMap);

        newsList.enqueue(this);
    }

    @NonNull
    private Map<String, String> getNewsQuery() {
        Map<String,String> queryMap = new Hashtable<>();
        queryMap.put("source","techcrunch");
        queryMap.put("apiKey",NEWS_API_KEY);
        return queryMap;
    }

    @Override
    public void onResponse(Call<NewsArticles> call, Response<NewsArticles> response) {
        Log.d( "onResponse: ",response.body().toString() );
    }

    @Override
    public void onFailure(Call<NewsArticles> call, Throwable t) {
        Log.e( "onFailure: ", String.valueOf(t) );
    }
}
