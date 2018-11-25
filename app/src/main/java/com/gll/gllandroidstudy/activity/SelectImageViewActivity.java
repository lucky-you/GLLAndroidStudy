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


    private TextView tvTypeOne, tvTypeTwo;
    private RecyclerView selectImageRecyclerView;
    private List<LocalMedia> selectList = new ArrayList<>();
    private int maxSelectNum = 8;
    private NineGridImageAdapter nineGridImageAdapter;

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_select_image_view);
    }

    @Override
    protected void bindViews() {
        initTitle("图片选择");
        tvTypeOne = get(R.id.tv_select_one);
        tvTypeTwo = get(R.id.tv_select_two);
        selectImageRecyclerView = get(R.id.selectImageRecyclerView);
        BarUtils.addMarginTopEqualStatusBarHeight(get(R.id.ll_root_layout));
        BarUtils.setStatusBarColor(this, ContextCompat.getColor(BaseApplication.getInstance(), R.color.colorPrimary), 0);
        questPermission();
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        FullyGridLayoutManager manager = new FullyGridLayoutManager(mContext, 4, GridLayoutManager.VERTICAL, false);
        selectImageRecyclerView.setLayoutManager(manager);

        nineGridImageAdapter = new NineGridImageAdapter(mContext, onAddPicClickListener);
        nineGridImageAdapter.setList(selectList);
        nineGridImageAdapter.setSelectMax(maxSelectNum);
        selectImageRecyclerView.setAdapter(nineGridImageAdapter);

    }

    private NineGridImageAdapter.onAddPicClickListener onAddPicClickListener = new NineGridImageAdapter.onAddPicClickListener() {

        @Override
        public void onAddPicClick() {
            PictureSelector.create(SelectImageViewActivity.this)
                    .openGallery(PictureMimeType.ofAll())// 全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()、音频.ofAudio()
                    .theme(R.style.picture_QQ_style)// 主题样式设置 具体参考 values/styles   用法：R.style.picture.white.style
                    .maxSelectNum(maxSelectNum)// 最大图片选择数量
                    .minSelectNum(2)// 最小选择数量
                    .imageSpanCount(4)// 每行显示个数
                    .selectionMode(PictureConfig.MULTIPLE)// 多选 or 单选
                    .previewImage(true)// 是否可预览图片
                    .previewVideo(true)// 是否可预览视频
                    .enablePreviewAudio(false) // 是否可播放音频
                    .isCamera(true)// 是否显示拍照按钮
                    .isZoomAnim(true)// 图片列表点击 缩放效果 默认true
                    .enableCrop(false)// 是否裁剪
                    .compress(false)// 是否压缩
                    .synOrAsy(true)//同步true或异步false 压缩 默认同步
                    .glideOverride(160, 160)// glide 加载宽高，越小图片列表越流畅，但会影响列表图片浏览的清晰度
                    .withAspectRatio(3, 4)// 裁剪比例 如16:9 3:2 3:4 1:1 可自定义
                    .freeStyleCropEnabled(true)// 裁剪框是否可拖拽
                    .circleDimmedLayer(false)// 是否圆形裁剪
                    .showCropFrame(false)// 是否显示裁剪矩形边框 圆形裁剪时建议设为false
                    .showCropGrid(false)// 是否显示裁剪矩形网格 圆形裁剪时建议设为false
                    .openClickSound(false)// 是否开启点击声音
                    .selectionMedia(selectList)// 是否传入已选图片
                    .minimumCompressSize(100)// 小于100kb的图片不压缩
                    .forResult(PictureConfig.CHOOSE_REQUEST);//结果回调onActivityResult code
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case PictureConfig.CHOOSE_REQUEST:
                    // 图片选择结果回调
                    selectList = PictureSelector.obtainMultipleResult(data);
                    // 例如 LocalMedia 里面返回三种path
                    // 1.media.getPath(); 为原图path
                    // 2.media.getCutPath();为裁剪后path，需判断media.isCut();是否为true
                    // 3.media.getCompressPath();为压缩后path，需判断media.isCompressed();是否为true
                    // 如果裁剪并压缩了，已取压缩路径为准，因为是先裁剪后压缩的
                    for (LocalMedia media : selectList) {
                        Log.i("图片-----》", media.getPath());
                    }
                    nineGridImageAdapter.setList(selectList);
                    nineGridImageAdapter.notifyDataSetChanged();
                    break;
            }
        }
    }

    @Override
    protected void setListener() {
        nineGridImageAdapter.setOnItemClickListener(new NineGridImageAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                if (selectList.size() > 0) {
                    LocalMedia media = selectList.get(position);
                    String pictureType = media.getPictureType();
                    int mediaType = PictureMimeType.pictureToVideo(pictureType);
                    switch (mediaType) {
                        case 1:
                            // 预览图片 可自定长按保存路径
                            PictureSelector.create(SelectImageViewActivity.this).themeStyle(R.style.picture_QQ_style).openExternalPreview(position, selectList);
                            break;
                    }
                }
            }
        });
    }

    private void questPermission() {
        HiPermission.create(mContext)
                .checkMutiPermission(new PermissionCallback() {
                    @Override
                    public void onClose() {
                        showToast("They cancelled our request");
                    }

                    @Override
                    public void onFinish() {
                        showToast("All permissions requested completed");
                        PictureFileUtils.deleteCacheDirFile(SelectImageViewActivity.this);
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
