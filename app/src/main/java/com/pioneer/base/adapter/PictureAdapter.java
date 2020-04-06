package com.pioneer.base.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class PictureAdapter extends PagerAdapter {
    private List<View> list;

    public PictureAdapter(List<View> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        if (null != list && 0 < list.size()) {
            return list.size();
        } else {
            return 0;
        }
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container,int position,Object object) {
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(list.get(position));
        return list.get(position);
    }
}
