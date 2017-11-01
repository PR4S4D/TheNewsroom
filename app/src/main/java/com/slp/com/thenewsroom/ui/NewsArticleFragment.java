package com.slp.com.thenewsroom.ui;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.slp.com.thenewsroom.R;
import com.slp.com.thenewsroom.data.News;
import com.slp.com.thenewsroom.utils.NewsRoomConstants;

public class NewsArticleFragment extends Fragment implements NewsRoomConstants {

    private OnFragmentInteractionListener mListener;
    private News newsArticle;

    public NewsArticleFragment() {

    }

    public static NewsArticleFragment newInstance(News news) {
        NewsArticleFragment fragment = new NewsArticleFragment();
        Bundle args = new Bundle();
        args.putParcelable(NEWS, news);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            newsArticle = getArguments().getParcelable(NEWS);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_news_article, container, false);
    }


    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
