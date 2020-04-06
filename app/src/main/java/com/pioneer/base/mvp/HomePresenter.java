package com.pioneer.base.mvp;

import android.os.Looper;
import android.os.Message;
import android.util.Log;

import com.pioneer.base.frame.handle.NoLeakHandler;
import com.pioneer.base.frame.handle.NoLeakHandlerInterface;
import com.pioneer.base.frame.mvp.dataset.MVPDataSetBasePresenter;
import com.pioneer.base.model.HomeModel;
import com.pioneer.base.network.listener.CommonSubscriber;
import com.pioneer.base.network.listener.OnSubscriberListener;

import io.reactivex.disposables.Disposable;

public class HomePresenter extends MVPDataSetBasePresenter<MVPHomeModel, HomeView> implements NoLeakHandlerInterface {
    private static final String TAG = HomePresenter.class.getSimpleName();
    private NoLeakHandler.WeakRefHandler mHandler;

    private String q = "";
    private int sn = 0;
    private int pn = 50;
    private HomeModel mHomeModel;

    @Override
    public void attachView(HomeView view) {
        super.attachView(view);
        if (mHandler == null || !mHandler.isHostReachable()) {
            mHandler = new NoLeakHandler(Looper.getMainLooper(), this).handler();
        }
    }

    @Override
    public void detachView() {
        super.detachView();
        if (mHandler != null) {
            mHandler.removeCallbacksAndMessages(null);
        }
    }

    @Override
    protected MVPHomeModel createModel() {
        return new MVPHomeModel();
    }

    public void requestData() {
        model.getData(new OnSubscriberListener<HomeModel>() {
            @Override
            public void onStart(Disposable disposable) {
                mViewRef.get().onShowLoading();
            }

            @Override
            public void onComplete() {
                mViewRef.get().onDisShowLoading();
            }

            @Override
            public void onSuccess(HomeModel model) {
                mHomeModel = model;
                mViewRef.get().loadSuccess();
            }

            @Override
            public void onFailure(CommonSubscriber.EXCEPTION_TYPE type,Throwable t) {
                Log.i(TAG,"loadFailure type" + type.name() + " t = " + t.toString());
                mViewRef.get().onDisShowLoading();
                mViewRef.get().loadFailure(t);
            }
        },q,sn,pn);
    }

    public HomeModel getHomeModel() {
        return mHomeModel;
    }

    @Override
    public void onRefreshComplete(Object obj) {

    }

    @Override
    public void onRefreshFail(Object obj) {

    }

    @Override
    public void onLoadNextComplete(boolean hasMore, Object obj) {

    }

    @Override
    public void onLoadNextFail(Object obj) {

    }

    @Override
    public void onNoDataFound() {

    }

    @Override
    public void onLoadDataDone() {

    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public void handleMessage(Message msg) {
//        switch (msg.what) {
//            case 0:
//                mViewRef.get().onShowLoading();
//                break;
//            case 1:
//                mViewRef.get().onDisShowLoading();
//                break;
//            case 2:
//                mViewRef.get().loadSuccess();
//                break;
//            case 3:
//                Bundle bundle = msg.getData();
//                if(null != bundle) {
//
//                }
//                mViewRef.get().loadFailure();
//                break;
//        }
    }

    public void setQ(String q) {
        this.q = q;
    }
}
