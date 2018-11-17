package com.zhenxing.loanapp;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.zhenxing.loanapp.base.BaseActivity;
import com.zhenxing.loanapp.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity {
    ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mainBinding = DataBindingUtil.setContentView(MainActivity.this, R.layout.activity_main);

        initView();
    }

    private void initView() {

        // TBDataBindingAdapter adapter=new TBDataBindingAdapter(this,)
    }
}
