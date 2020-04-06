package com.pioneer.base.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.pioneer.base.R;

public class SearchView extends RelativeLayout {
    private Context mContext;

    private RelativeLayout searchBox;
    private EditText searchTxt;
    private ImageView searchIcon;
    private TextView searchBtn;
    private OnSearchClickListener mOnSearchClickListener;

    public SearchView(Context context) {
        super(context);
        init();
    }

    public SearchView(Context context,AttributeSet attrs) {
        super(context,attrs);
        init();
    }

    public SearchView(Context context,AttributeSet attrs,int defStyleAttr) {
        super(context,attrs,defStyleAttr);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.search_layout, this);
        searchBox = (RelativeLayout) findViewById(R.id.search_box_container);
        searchTxt = (EditText) findViewById(R.id.home_search_txt);
        searchIcon = (ImageView) findViewById(R.id.home_search_img);
        searchBtn = (TextView) findViewById(R.id.home_search_btn);

        searchBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(null != mOnSearchClickListener) {
                    mOnSearchClickListener.onClick(getEditText());
                }
            }
        });
    }

    public String getEditText() {
        if(null != searchTxt && !TextUtils.isEmpty(searchTxt.getText().toString())) {
            return searchTxt.getText().toString();
        }
        return "";
    }

    public void setOnSearchClickListener(OnSearchClickListener clickListener) {
        this.mOnSearchClickListener = clickListener;
    }

    public interface OnSearchClickListener {
        public void onClick(String searchTxt);
    }
}
