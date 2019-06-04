package com.gll.gllandroidstudy.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.base.BaseActivity;
import com.gll.gllandroidstudy.base.BaseApplication;
import com.gll.gllandroidstudy.model.TimeAndStatus;
import com.gll.gllandroidstudy.selectimage.adapter.NineGridImageAdapter;
import com.gll.gllandroidstudy.selectimage.view.FullyGridLayoutManager;
import com.gll.gllandroidstudy.utils.BarUtils;
import com.gll.gllandroidstudy.utils.CommonUtil;
import com.gll.gllandroidstudy.utils.SharedPreferenceHelper;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.tools.PictureFileUtils;

import java.util.ArrayList;
import java.util.List;

import me.weyye.hipermission.HiPermission;
import me.weyye.hipermission.PermissionCallback;

/**
 * 选择图片
 */
public class SelectImageViewActivity extends BaseActivity {



    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_select_image_view);
    }

    @Override
    protected void bindViews() {
        initTitle("图片选择");
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

    }

    @Override
    protected void setListener() {
    }


}
