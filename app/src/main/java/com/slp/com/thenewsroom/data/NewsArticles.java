package com.slp.com.thenewsroom.data;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lakshmiprasad on 01/11/2017.
 */

public class NewsArticles implements Parcelable {
    private String status;
    private String source;
    private String sortBy;
    private List<News> articles;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public List<News> getArticles() {
        return articles;
    }

    public void setArticles(List<News> articles) {
        this.articles = articles;
    }

    protected NewsArticles(Parcel in) {
        status = in.readString();
        source = in.readString();
        sortBy = in.readString();
        if (in.readByte() == 0x01) {
            articles = new ArrayList<News>();
            in.readList(articles, News.class.getClassLoader());
        } else {
            articles = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(status);
        dest.writeString(source);
        dest.writeString(sortBy);
        if (articles == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(articles);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<NewsArticles> CREATOR = new Parcelable.Creator<NewsArticles>() {
        @Override
        public NewsArticles createFromParcel(Parcel in) {
            return new NewsArticles(in);
        }

        @Override
        public NewsArticles[] newArray(int size) {
            return new NewsArticles[size];
        }
    };


    @Override
    public String toString() {
        return "NewsArticles{" +
                "status='" + status + '\'' +
                ", source='" + source + '\'' +
                ", sortBy='" + sortBy + '\'' +
                ", articles=" + articles +
                '}';
    }
}