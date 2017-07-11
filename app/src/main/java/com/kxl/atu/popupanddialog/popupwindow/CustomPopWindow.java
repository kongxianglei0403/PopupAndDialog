package com.kxl.atu.popupanddialog.popupwindow;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;

/**
 * Created by Atu on 2017/7/10.
 */

public class CustomPopWindow
{
    private Context mContext;
    private View contentView;
    private PopupWindow mPopupWindow;

    private CustomPopWindow(Builder builder)
    {
        mContext = builder.context;
        contentView = LayoutInflater.from(mContext).inflate(builder.contentView,null);
        mPopupWindow = new PopupWindow(contentView,builder.width,builder.height,builder.fouse);

        mPopupWindow.setOutsideTouchable(builder.outsidecancle);
        mPopupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mPopupWindow.setAnimationStyle(builder.animstyle);
    }

    /**
     * 隐藏
     */
    public void dismiss()
    {
        if (mPopupWindow != null)
        {
            mPopupWindow.dismiss();
        }
    }

    /**
     * 根据viewid获取view
     * @param viewId
     * @return
     */
    public View getItemView(int viewId)
    {
        if (mPopupWindow != null)
        {
            return this.contentView.findViewById(viewId);
        }
        return null;
    }

    /**
     * 根据父布局  显示位置
     * @param rootview
     * @param gravity
     * @param x
     * @param y
     * @return
     */
    public CustomPopWindow showAtLocation(int rootview,int gravity,int x,int y)
    {
        if (mPopupWindow != null)
        {
            View rootView = LayoutInflater.from(mContext).inflate(rootview,null);
            mPopupWindow.showAtLocation(rootView,gravity,x,y);
        }
        return this;
    }


    /**
     * 根据id获取view  并显示在该view的位置
     * @param targetviewid
     * @param gravity
     * @param offx
     * @param offy
     * @return
     */
    public CustomPopWindow showAsLocation(int targetviewid,int gravity,int offx,int offy)
    {
        if (mPopupWindow != null)
        {
            View targetView = LayoutInflater.from(mContext).inflate(targetviewid,null);
            mPopupWindow.showAsDropDown(targetView,gravity,offx,offy);
        }
        return this;
    }

    /**
     * 显示在指定view的位置
     * @param targetview
     * @param gravity
     * @param offx
     * @param offy
     * @return
     */
    public CustomPopWindow showAsLocation(View targetview,int gravity,int offx,int offy)
    {
        if (mPopupWindow != null)
        {
            mPopupWindow.showAsDropDown(targetview, gravity, offx, offy);
        }
        return this;
    }

    /**
     * 根据id设置焦点监听
     * @param viewid
     * @param listener
     */
    public void setOnFocusListener(int viewid, View.OnFocusChangeListener listener)
    {
        View view = getItemView(viewid);
        view.setOnFocusChangeListener(listener);
    }

    public static class Builder
    {

        public Context context;
        public int contentView;
        public int width;
        public int height;
        public boolean fouse;
        public boolean outsidecancle;
        public int animstyle;

        public Builder setContext(Context context)
        {
            this.context = context;
            return this;
        }

        public Builder setContentView(int contentView)
        {
            this.contentView = contentView;
            return this;
        }

        public Builder setWidth(int width)
        {
            this.width = width;
            return this;
        }

        public Builder setHeight(int height)
        {
            this.height = height;
            return this;
        }

        public Builder setFouse(boolean fouse)
        {
            this.fouse = fouse;
            return this;
        }

        public Builder setOutsidecancle(boolean outsidecancle)
        {
            this.outsidecancle = outsidecancle;
            return this;
        }

        public Builder setAnimstyle(int animstyle)
        {
            this.animstyle = animstyle;
            return this;
        }

        public CustomPopWindow build()
        {
            return new CustomPopWindow(this);
        }
    }
}
