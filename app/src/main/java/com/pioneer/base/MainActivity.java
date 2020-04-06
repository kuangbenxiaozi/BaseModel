package com.pioneer.base;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

import com.pioneer.base.adapter.PictureAdapter;
import com.pioneer.base.frame.mvp.MVPBaseActivity;
import com.pioneer.base.model.HomeModel;
import com.pioneer.base.mvp.HomePresenter;
import com.pioneer.base.mvp.HomeView;
import com.pioneer.base.mvp.MVPHomeModel;
import com.pioneer.base.view.ItemPictureView;
import com.pioneer.base.view.SearchView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends MVPBaseActivity<MVPHomeModel,HomeView,HomePresenter> implements HomeView {
    private static final String TAG = MainActivity.class.getSimpleName();

    private SearchView mSearchView;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSearchView = (SearchView) findViewById(R.id.search_view);
        mSearchView.setOnSearchClickListener(new SearchView.OnSearchClickListener() {
            @Override
            public void onClick(String searchTxt) {
                if(null != mPresenter) {
                    Log.i(TAG,"searchTxt = " + searchTxt);
                    mPresenter.setQ(searchTxt);
                    mPresenter.requestData();
                }
            }
        });

        mViewPager = (ViewPager) findViewById(R.id.view_pager);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected HomePresenter createPresenter() {
        return new HomePresenter();
    }

    @Override
    public void onShowLoading() {
        Log.i(TAG,"onShowLoading");
    }

    @Override
    public void onDisShowLoading() {
        Log.i(TAG,"onDisShowLoading");
    }

    @Override
    public void loadSuccess() {
        Log.i(TAG,"loadSuccess");
        if(null != mPresenter) {
            setData(mPresenter.getHomeModel());
        }
    }

    public void setData(HomeModel homeModel) {
        if(null == homeModel) {
            return;
        }
        List<HomeModel.PictureItem> pictureItems = homeModel.getList();
        final int number = pictureItems.size();
        ArrayList<View> views = new ArrayList<View>();
        for(int i = 0; i < number; i++) {
            HomeModel.PictureItem pictureItem = pictureItems.get(i);
            ItemPictureView itemPictureView = new ItemPictureView(this);
            itemPictureView.setData(pictureItem,i);
            views.add(itemPictureView);
        }
        mViewPager.setAdapter(new PictureAdapter(views));
    }

    @Override
    public void loadFailure(Throwable throwable) {
        Log.i(TAG,"loadFailure throwable = " + throwable.toString());
    }

    @Override
    public void showLoadingMore(boolean isLoading) {

    }

    @Override
    public void showLoadingMoreError() {

    }

    @Override
    public void onServiceStop(String errorContent) {

    }

    @Override
    public void loadFinished() {

    }
}
