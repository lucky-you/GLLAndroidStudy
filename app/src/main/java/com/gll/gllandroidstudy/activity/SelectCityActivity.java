package com.gll.gllandroidstudy.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.base.BaseActivity;
import com.gll.gllandroidstudy.callback.DownloadListener;
import com.gll.gllandroidstudy.download.DownloadUtil;
import com.gll.gllandroidstudy.utils.DateImageUtils;

import me.weyye.hipermission.HiPermission;
import me.weyye.hipermission.PermissionCallback;


/**
 * 城市选择的activity
 */
public class SelectCityActivity extends BaseActivity {

    private Button btnDownFile;

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_select_city);
    }

    @Override
    protected void bindViews() {
        initTitle("下载文件到本地");
        btnDownFile = get(R.id.btnDownFile);
        getPermission();
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

    }


    @Override
    protected void setListener() {
        btnDownFile.setOnClickListener(v -> {
            DownloadUtil downloadUtil = new DownloadUtil();
            downloadUtil.downloadFile(DateImageUtils.getVideoUrl(), new DownloadListener() {
                @Override
                public void onStart() {
                    showToast("开始下载");
                }

                @Override
                public void onProgress(int currentLength) {
                    Log.e("xy", "下载进度=" + currentLength);
                }

                @Override
                public void onFinish(String localPath) {
                    showToast("下载结束=" + localPath);
                }

                @Override
                public void onFailure(String errorInfo) {
                    showToast("下载失败=" + errorInfo);
                }
            });
        });
    }

    /**
     * 获取权限
     */
    private void getPermission() {
        HiPermission.create(mContext)
                .checkMutiPermission(new PermissionCallback() {
                    @Override
                    public void onClose() {
                    }

                    @Override
                    public void onFinish() {


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
