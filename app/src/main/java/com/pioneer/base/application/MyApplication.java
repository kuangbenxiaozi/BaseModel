package com.pioneer.base.application;

import android.app.Application;

import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.pioneer.base.toolkit.image.ImageHttpImagePipelineConfigFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.internal.tls.OkHostnameVerifier;

public class MyApplication extends Application {
    private static Application mApplication;
    private static final int TIME_OUT_DATA = 15000;

    public static Application getInstance() {
        return mApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;

        ImagePipelineConfig config = null;
        DiskCacheConfig diskCacheConfig = DiskCacheConfig.newBuilder(mApplication)
                .setMaxCacheSize(100 * 1024 * 1024)
                .build();

        OkHttpClient okHttpClient = new OkHttpClient()
                .newBuilder()
                .hostnameVerifier(OkHostnameVerifier.INSTANCE)
                .writeTimeout(TIME_OUT_DATA, TimeUnit.MILLISECONDS)
                .readTimeout(TIME_OUT_DATA, TimeUnit.MILLISECONDS)
                .connectTimeout(TIME_OUT_DATA, TimeUnit.MILLISECONDS)
                .build();

        config = ImageHttpImagePipelineConfigFactory.newBuilder(mApplication, okHttpClient)
                .setMainDiskCacheConfig(diskCacheConfig)
                .setDownsampleEnabled(true)
                .setResizeAndRotateEnabledForNetwork(true)
                .build();

        try {
            Fresco.initialize(mApplication, config);
        } catch (UnsatisfiedLinkError error) {
            error.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
