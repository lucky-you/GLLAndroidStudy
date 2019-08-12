package com.gll.gllandroidstudy.activity;

import android.os.Bundle;
import android.support.design.widget.BottomSheetDialog;
import android.view.LayoutInflater;
import android.view.View;

import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.base.BaseActivity;

/**
 * BottomSheet的使用
 */
public class ConstraintLayoutActivity extends BaseActivity {


    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_constraint_layout);
    }

    @Override
    protected void bindViews() {
        initTitle("BottomSheet的使用");
        get(R.id.btnStart).setOnClickListener(this);
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

    }

    @Override
    protected void setListener() {
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnStart:
                showBottomDialog();

                break;
        }
    }

    private void showBottomDialog() {

        BottomSheetDialog dialog = new BottomSheetDialog(mContext);
        View dialogView = LayoutInflater.from(mContext).inflate(R.layout.include_bottom_dialog_layout, null);
        dialog.setContentView(dialogView);
        dialog.show();


    }

}
