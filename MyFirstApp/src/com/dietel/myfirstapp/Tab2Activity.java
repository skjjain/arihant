package com.dietel.myfirstapp;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.TextView;
import android.app.Activity;

public class Tab2Activity  extends Activity
{
        @Override
        public void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            
            TextView  tv=new TextView(this);
            tv.setTextSize(25);
            tv.setGravity(Gravity.CENTER_VERTICAL);
            tv.setText("This Is Tab2 Activity");
            
            setContentView(tv);
        }
}