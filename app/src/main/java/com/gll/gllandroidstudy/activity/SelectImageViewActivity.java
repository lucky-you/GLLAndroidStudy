package com.gll.gllandroidstudy.activity;

import android.Manifest;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import me.weyye.hipermission.HiPermission;
import me.weyye.hipermission.PermissionCallback;
import me.weyye.hipermission.PermissionItem;

/**
 * 选择图片
 */
public class SelectImageViewActivity extends BaseActivity {


    private TextView tv_choose_one_imageView, tv_choose_one_imageView_and_croup, tv_choose_more_imageView;
    private RecyclerView imageViewRecyclerView;
    private static final int COMPRESS_REQUEST_CODE = 2048;
    private static final int REQUEST_CODE = 1024;


    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_select_image_view);
        setPermission();
    }

    @Override
    protected void bindViews() {
        initTitle("图片选择");
        tv_choose_one_imageView = get(R.id.tv_choose_one_imageView);
        tv_choose_one_imageView_and_croup = get(R.id.tv_choose_one_imageView_and_croup);
        tv_choose_more_imageView = get(R.id.tv_choose_more_imageView);
        imageViewRecyclerView = get(R.id.imageViewRecyclerView);
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

    }


    @Override
    protected void setListener() {
        tv_choose_one_imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseOneImageView();

            }
        });

        tv_choose_one_imageView_and_croup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseOneImageAndCrop();
            }
        });
        tv_choose_more_imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseMoreImage();
            }
        });


    }


    /**
     * 选择单张并且裁剪
     */
    private void chooseOneImageAndCrop() {
    }

    /**
     * 选择单张
     */
    private void chooseOneImageView() {
    }

    /**
     * /选择多张
     */
    private void chooseMoreImage() {
    }


    public void setPermission() {
        List<PermissionItem> permissionItems = new ArrayList<PermissionItem>();
        permissionItems.add(new PermissionItem(Manifest.permission.WRITE_EXTERNAL_STORAGE, "存储空间", R.drawable.permission_ic_storage));
        permissionItems.add(new PermissionItem(Manifest.permission.CAMERA, "照相机", R.drawable.permission_ic_camera));
        permissionItems.add(new PermissionItem(Manifest.permission.ACCESS_FINE_LOCATION, "位置信息", R.drawable.permission_ic_location));
        HiPermission.create(this)
                .permissions(permissionItems)
                .checkMutiPermission(new PermissionCallback() {
                    @Override
                    public void onClose() {

                    }

                    @Override
                    public void onFinish() {
                        showToast("权限获取成功");

                    }

                    @Override
                    public void onDeny(String permission, int position) {

                    }

                    @Override
                    public void onGuarantee(String permission, int position) {

                    }
                });

    }
}
