package com.gll.gllandroidstudy.download;

import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;

import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.base.BaseApplication;
import com.gll.gllandroidstudy.callback.DownloadListener;
import com.gll.gllandroidstudy.retrofit.ApiService;
import com.gll.gllandroidstudy.retrofit.RetrofitFactory;
import com.gll.gllandroidstudy.utils.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

public class DownloadUtil {

    private static final String TAG = "xy";
    private static final String PATH_CHALLENGE_VIDEO = Environment.getExternalStorageDirectory() + "/" + BaseApplication.getInstance().getString(R.string.app_name);
    //视频下载相关
    protected ApiService mApiService;
    private String mVideoPath; //下载到本地的视频路径

    public DownloadUtil() {
        if (mApiService == null) {
            mApiService = RetrofitFactory.getInstance();
        }
    }

    /**
     * 下载文件
     */
    public void downloadFile(String url, final DownloadListener downloadListener) {
        //通过Url得到保存到本地的文件名
        String name = url;
        if (FileUtils.createOrExistsDir(PATH_CHALLENGE_VIDEO)) {
            int index = name.lastIndexOf('/');//一定是找最后一个'/'出现的位置
            if (index != -1) {
                name = name.substring(index);
                mVideoPath = PATH_CHALLENGE_VIDEO + name;
            }
        }
        if (TextUtils.isEmpty(mVideoPath)) {
            Log.e(TAG, "downloadVideo: 存储路径为空了");
            return;
        }
        //建立一个文件
        File mFile = new File(mVideoPath);
        if (!FileUtils.isFileExists(mFile) && FileUtils.createOrExistsFile(mFile)) {
            if (mApiService == null) {
                Log.e(TAG, "downloadVideo: 下载接口为空了");
                return;
            }
            mApiService.download(url)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<ResponseBody>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                            downloadListener.onStart();
                        }

                        @Override
                        public void onNext(ResponseBody responseBody) {
                            writeFile2Disk(responseBody, mFile, downloadListener);
                        }

                        @Override
                        public void onError(Throwable e) {
                            downloadListener.onFailure(e.getMessage());
                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        } else {
            downloadListener.onFinish(mVideoPath);
        }
    }

    /**
     * 写入存储
     */
    private void writeFile2Disk(ResponseBody response, File file, DownloadListener downloadListener) {
        downloadListener.onStart();
        long currentLength = 0;
        OutputStream os = null;
        if (response == null) {
            downloadListener.onFailure("资源错误!");
            return;
        }
        InputStream is = response.byteStream();
        long totalLength = response.contentLength();
        try {
            os = new FileOutputStream(file);
            int len;
            byte[] buff = new byte[1024];
            while ((len = is.read(buff)) != -1) {
                os.write(buff, 0, len);
                currentLength += len;
                Log.e(TAG, "当前进度: " + currentLength);
                downloadListener.onProgress((int) (100 * currentLength / totalLength));
                if ((int) (100 * currentLength / totalLength) == 100) {
                    downloadListener.onFinish(mVideoPath);
                }
            }
        } catch (FileNotFoundException e) {
            downloadListener.onFailure("未找到文件!");
            e.printStackTrace();
        } catch (IOException e) {
            downloadListener.onFailure("IO错误!");
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
