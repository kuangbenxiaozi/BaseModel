package com.pioneer.base.view;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.pioneer.base.R;
import com.pioneer.base.model.HomeModel;

public class ItemPictureView extends RelativeLayout {
    private static final String TAG = ItemPictureView.class.getSimpleName();
    private Context mContext;
    private SimpleDraweeView mSimpleDraweeView;
    private TextView mTextView;
    private HomeModel.PictureItem mPictureItem;

    public ItemPictureView(Context context) {
        super(context);
        mContext = context;
        initViews();
    }

    public ItemPictureView(Context context,AttributeSet attrs) {
        super(context,attrs);
        mContext = context;
        initViews();
    }

    public ItemPictureView(Context context,AttributeSet attrs,int defStyleAttr) {
        super(context,attrs,defStyleAttr);
        mContext = context;
        initViews();
    }

    private void initViews() {
        inflate(mContext,R.layout.item_layout,this);
        mSimpleDraweeView = (SimpleDraweeView) findViewById(R.id.picture_view);

        mTextView = (TextView) findViewById(R.id.picture_des_txt);
    }

    public void setData(HomeModel.PictureItem pictureItem,int position) {
        HomeModel.PictureItem item = pictureItem;
        if(null != item) {
            String img = item.getImg();
            String link = item.getLink();
            String desString = item.getTitle();

            if(!TextUtils.isEmpty(img)) {
                Log.i(TAG,"img = " + img);
                mSimpleDraweeView.setVisibility(View.VISIBLE);
                //                        ImageRequest request = ImageRequestBuilder.newBuilderWithSource(Uri.parse(img))
                //                                .setProgressiveRenderingEnabled(true)
                //                                .build();
                //
                //                        DraweeController draweeController = Fresco.newDraweeControllerBuilder()
                //                                .setImageRequest(request)
                //                                .setAutoPlayAnimations(true) // 设置加载图片完成后是否直接进行播放
                //                                .setOldController(mSimpleDraweeView.getController())
                //                                .build();
                //                        mSimpleDraweeView.setController(draweeController);

                // mSimpleDraweeView.setImageURI(Uri.parse("http://pic153.nipic.com/file/20180120/18897988_204525611726_2.jpg"));
                mSimpleDraweeView.setImageURI(Uri.parse(img));
                // mSimpleDraweeView.setImageURI(Uri.parse("https://image.baidu.com/search/down?tn=download&ipn=dwnl&word=download&ie=utf8&fr=result&url=http%3A%2F%2Fa0.att.hudong.com%2F78%2F52%2F01200000123847134434529793168.jpg&thumburl=https%3A%2F%2Fss1.bdstatic.com%2F70cFvXSh_Q1YnxGkpoWK1HF6hhy%2Fit%2Fu%3D3173584241%2C3533290860%26fm%3D26%26gp%3D0.jpg"));
            } else {
                mSimpleDraweeView.setVisibility(View.GONE);
            }

            if(!TextUtils.isEmpty(link)) {
                mSimpleDraweeView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // goto link
                    }
                });
            }

            if(!TextUtils.isEmpty(desString)) {
                mTextView.setText(desString);
            } else {
                mTextView.setText("无标题");
            }
        }
    }
}
