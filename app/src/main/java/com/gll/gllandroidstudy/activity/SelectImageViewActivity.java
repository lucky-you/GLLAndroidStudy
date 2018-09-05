package com.gll.gllandroidstudy.activity;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bilibili.boxing.Boxing;
import com.bilibili.boxing.model.config.BoxingConfig;
import com.bilibili.boxing.model.config.BoxingCropOption;
import com.bilibili.boxing.model.entity.BaseMedia;
import com.bilibili.boxing.model.entity.impl.ImageMedia;
import com.bilibili.boxing.utils.BoxingFileHelper;
import com.bilibili.boxing.utils.ImageCompressor;
import com.bilibili.boxing_impl.ui.BoxingActivity;
import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.adapter.MediaResultAdapter;
import com.gll.gllandroidstudy.base.BaseActivity;
import com.gll.gllandroidstudy.callback.OnRecyclerViewItemClickListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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

    private MediaResultAdapter mediaResultAdapter;
    private ArrayList<BaseMedia> selImageList = new ArrayList<>(); //当前选择的所有图片
    private int maxImgCount = 9;               //允许选择图片最大数

    private int chooseType = 1;

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

        mediaResultAdapter = new MediaResultAdapter(maxImgCount, selImageList);
        imageViewRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        imageViewRecyclerView.setHasFixedSize(true);
        imageViewRecyclerView.setAdapter(mediaResultAdapter);
    }


    @Override
    protected void setListener() {
        tv_choose_one_imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseType = 1;
                chooseOneImageView();

            }
        });

        tv_choose_one_imageView_and_croup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseType = 2;
                chooseOneImageAndCrop();
            }
        });
        tv_choose_more_imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseType = 3;
                chooseMoreImage();
            }
        });

        mediaResultAdapter.setOnItemClickListener(new OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                switch (chooseType) {
                    case 1:
                        chooseOneImageView();
                        break;
                    case 2:
                        chooseOneImageAndCrop();
                        break;
                    case 3:
                        chooseMoreImage();
                        break;
                }

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            final ArrayList<BaseMedia> medias = Boxing.getResult(data);
            if (requestCode == REQUEST_CODE) {
                mediaResultAdapter.setList(medias);
            } else if (requestCode == COMPRESS_REQUEST_CODE) {
                final List<BaseMedia> imageMedias = new ArrayList<>(1);
                BaseMedia baseMedia = medias.get(0);
                if (!(baseMedia instanceof ImageMedia)) {
                    return;
                }
                final ImageMedia imageMedia = (ImageMedia) baseMedia;
                // the compress task may need time
                if (imageMedia.compress(new ImageCompressor(this))) {
                    imageMedia.removeExif();
                    imageMedias.add(imageMedia);
                    mediaResultAdapter.setList(imageMedias);
                }

            }
        }
    }

    /**
     * 选择单张并且裁剪
     */
    private void chooseOneImageAndCrop() {
        String cachePath = BoxingFileHelper.getCacheDir(mContext);
        if (TextUtils.isEmpty(cachePath)) {
            Toast.makeText(getApplicationContext(), R.string.boxing_storage_deny, Toast.LENGTH_SHORT).show();
            return;
        }
        Uri destUri = new Uri.Builder()
                .scheme("file")
                .appendPath(cachePath)
                .appendPath(String.format(Locale.US, "%s.png", System.currentTimeMillis()))
                .build();
        BoxingConfig singleCropImgConfig = new BoxingConfig(BoxingConfig.Mode.SINGLE_IMG).withCropOption(new BoxingCropOption(destUri))
                .withMediaPlaceHolderRes(R.drawable.ic_boxing_default_image);
        Boxing.of(singleCropImgConfig).withIntent(mContext, BoxingActivity.class).start(SelectImageViewActivity.this, REQUEST_CODE);
    }

    /**
     * 选择单张
     */
    private void chooseOneImageView() {
        BoxingConfig singleImgConfig = new BoxingConfig(BoxingConfig.Mode.SINGLE_IMG).withMediaPlaceHolderRes(R.drawable.ic_boxing_default_image);
        Boxing.of(singleImgConfig).withIntent(mContext, BoxingActivity.class).start(SelectImageViewActivity.this, COMPRESS_REQUEST_CODE);
    }

    /**
     * /选择多张
     */
    private void chooseMoreImage() {
        BoxingConfig config = new BoxingConfig(BoxingConfig.Mode.MULTI_IMG)
                .needCamera(R.drawable.ic_camera_image)
//                .withMaxCount(3)
                .needGif();
        Boxing.of(config).withIntent(mContext, BoxingActivity.class).start(SelectImageViewActivity.this, REQUEST_CODE);
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
