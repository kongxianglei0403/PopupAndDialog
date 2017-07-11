package com.kxl.atu.popupanddialog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.kxl.atu.popupanddialog.dialog.CustomProgress;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void showpop(View view)
    {
        /*CustomPopWindow customPopWindow = new CustomPopWindow.Builder()
                .setContext(this)
                .setContentView(R.layout.layout_popup)
                .setWidth(LinearLayout.LayoutParams.WRAP_CONTENT)
                .setHeight(LinearLayout.LayoutParams.WRAP_CONTENT)
                .setAnimstyle(R.style.popup_anim_style)
                .setFouse(true)
                .setOutsidecancle(true)
                .build()
                .showAtLocation(R.layout.activity_main, Gravity.CENTER,0,0);*/
        //new MyProgressDialog(this,"正在加载...",R.drawable.frame).show();
        CustomProgress.show(this,"正在加载...",true,null);
    }

}
