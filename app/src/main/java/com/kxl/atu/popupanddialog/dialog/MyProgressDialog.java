package com.kxl.atu.popupanddialog.dialog;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.kxl.atu.popupanddialog.R;

/**
 * Created by Administrator on 2017/7/10.
 */

public class MyProgressDialog extends ProgressDialog
{


    private Context mContext;
    private String mTips;
    private int mResId;
    private ImageView mImg;
    private TextView mTxt;


    public MyProgressDialog(Context context, String content, int id)
    {
        super(context, R.style.CustomProgressDialog);
        this.mContext = context;
        this.mTips = content;
        this.mResId = id;

        setCanceledOnTouchOutside(true);
        setCancelable(true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        getWindow().requestFeature(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
        super.onCreate(savedInstanceState);
        initView();
        initData();
    }

    private void initView()
    {
        setContentView(R.layout.progress_dialog);
        mImg = (ImageView) findViewById(R.id.loadingIv);
        mTxt = (TextView) findViewById(R.id.loadingTv);
    }

    private void initData()
    {
        mImg.setBackgroundResource(mResId);
        final AnimationDrawable mAnimation = (AnimationDrawable) mImg.getBackground();
        mImg.post(new Runnable() {
            @Override
            public void run() {
                mAnimation.start();
            }
        });
        mTxt.setText(mTips);
    }
}
