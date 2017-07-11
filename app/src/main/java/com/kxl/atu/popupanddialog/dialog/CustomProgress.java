package com.kxl.atu.popupanddialog.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.kxl.atu.popupanddialog.R;

/**
 * Created by 阿土 on 2017/7/10.
 */

public class CustomProgress extends Dialog
{

    public CustomProgress(Context context)
    {
        super(context);
    }

    public CustomProgress(Context context, int themeResId)
    {
        super(context, themeResId);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus)
    {
        ImageView imageView = (ImageView) findViewById(R.id.loadingIv);
        //获取imageview上的动画背景
        AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getBackground();
        //开始动画
        animationDrawable.start();
    }

    public void setTipMessage(CharSequence message)
    {
        if (message != null && message.length() > 0)
        {
            TextView textView = (TextView) findViewById(R.id.loadingTv);
            textView.setVisibility(View.VISIBLE);

            textView.setText(message);
            textView.invalidate();
        }
    }

    public static CustomProgress show(Context context,CharSequence message,boolean cancleable,OnCancelListener onCancelListener)
    {
        CustomProgress dialog = new CustomProgress(context,R.style.CustomProgressDialog);
        dialog.setTitle("");
        dialog.setContentView(R.layout.progress_dialog);
        if (message == null || message.length() == 0)
        {
            dialog.findViewById(R.id.loadingTv).setVisibility(View.GONE);
        }
        else
        {
            TextView tv = (TextView) dialog.findViewById(R.id.loadingTv);
            tv.setText(message);
        }
        //按返回建是否取消
        dialog.setCancelable(cancleable);
        //监听返回键处理
        dialog.setOnCancelListener(onCancelListener);
        dialog.getWindow().getAttributes().gravity = Gravity.CENTER;
        WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
        //设置背景层透明度
        lp.dimAmount = 0.2f;
        dialog.getWindow().setAttributes(lp);
        dialog.show();
        return dialog;
    }

}
