package com.pioneer.base.mvp;

import com.pioneer.base.application.MyApplication;
import com.pioneer.base.frame.mvp.dataset.MVPDataSetBaseModel;
import com.pioneer.base.model.HomeModel;
import com.pioneer.base.network.listener.CommonSubscriber;
import com.pioneer.base.network.listener.OnSubscriberListener;
import com.pioneer.base.task.RxHomeTask;

public class MVPHomeModel extends MVPDataSetBaseModel {
    RxHomeTask rxHomeTask;

    @Override
    public void onCreate() {

    }

    @Override
    public void onDestroy() {
        if (null != rxHomeTask && rxHomeTask.isDisposed()) {
            rxHomeTask.dispose();
            rxHomeTask = null;
        }
    }

    public void getData(OnSubscriberListener<HomeModel> onSubscriberListener,String q,int sn,int pn) {
        rxHomeTask = new RxHomeTask(MyApplication.getInstance().getApplicationContext(),q,sn + "",pn + "");
        rxHomeTask.requestData(new CommonSubscriber<HomeModel>(onSubscriberListener));
    }
}
