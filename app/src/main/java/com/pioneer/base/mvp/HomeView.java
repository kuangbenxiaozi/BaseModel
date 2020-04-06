package com.pioneer.base.mvp;

import com.pioneer.base.frame.mvp.dataset.MVPDataSetBaseViewInterface;

public interface HomeView extends MVPDataSetBaseViewInterface {

    public void onShowLoading();

    public void onDisShowLoading();

    public void loadSuccess();

    public void loadFailure(Throwable throwable);
}
