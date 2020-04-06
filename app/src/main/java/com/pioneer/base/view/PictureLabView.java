package com.pioneer.base.view;

import android.content.Context;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.pioneer.base.frame.handle.NoLeakHandlerInterface;

public class PictureLabView extends LinearLayout implements NoLeakHandlerInterface {
    public PictureLabView(Context context) {
        super(context);
    }

    public PictureLabView(Context context,@Nullable AttributeSet attrs) {
        super(context,attrs);
    }

    public PictureLabView(Context context,@Nullable AttributeSet attrs,int defStyleAttr) {
        super(context,attrs,defStyleAttr);
    }

    @Override
    public boolean isValid() {
        return false;
    }

    @Override
    public void handleMessage(Message msg) {

    }
}
