package com.pioneer.base.task;

import android.content.Context;

import com.pioneer.base.model.HomeModel;
import com.pioneer.base.network.task.BaseGetTask;
import com.pioneer.base.service.RxHomeService;

import io.reactivex.Observable;

public class RxHomeTask extends BaseGetTask<RxHomeService,HomeModel> {

    public RxHomeTask(Context context,String q,String sn,String pn) {
        super(context);
        addQueryParams("q",q);
        addQueryParams("sn",sn);
        addQueryParams("pn",pn);
    }

    @Override
    protected String getHost() {
        return "https://image.so.com/";
    }

    @Override
    protected String getPath() {
        return "j";
    }

    @Override
    protected Observable<HomeModel> createActualObservable(RxHomeService rxHomeService) {
        return rxHomeService.executeTask(getPath(),mHeaderParams, mQueryParams);
    }
}
