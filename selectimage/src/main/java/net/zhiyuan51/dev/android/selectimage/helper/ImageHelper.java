package net.zhiyuan51.dev.android.selectimage.helper;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;

import net.zhiyuan51.dev.android.selectimage.ImageBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/10/30.
 * user: Administrator
 * date: 2018/10/30
 * time; 9:07
 * name: net.zhiyuan51.dev.android.getphoneimage
 */
public class ImageHelper {
    String where = MediaStore.Images.Media.MIME_TYPE + "=? or "
            + MediaStore.Images.Media.MIME_TYPE + "=? or "
            + MediaStore.Images.Media.MIME_TYPE + "=?";
    String[] whereArgs = new String[]{"image/jpeg", "image/png", "image/jpg"};
    List<ImageBean> imageBeans = new ArrayList<>();
    Map<Object, String> thum;
    Context mContext;
    private static ImageHelper getImageHelperInstance;
    private ImageHelper() {

    }

    public static ImageHelper getGetImageHelperInstance() {
        if (getImageHelperInstance == null) {
            synchronized (ImageHelper.class) {
                if (getImageHelperInstance == null) {
                    getImageHelperInstance = new ImageHelper();
                }
            }
        }
        return getImageHelperInstance;
    }

    /**
     * 获取缩略图
     */
    public boolean getThumbnail(Context mContext) {
        this.mContext=mContext;
        String[] projection = {
                MediaStore.Images.Thumbnails.IMAGE_ID,
                MediaStore.Images.Thumbnails.DATA
        };
        //查询
        Cursor mCursor = mContext.getContentResolver().query(
                MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, projection, null, null,
                null);
        if (mCursor != null) {
            if (mCursor.moveToFirst()) {
                do {
                    thum = new HashMap<>();
                    String id = mCursor.getString(mCursor.getColumnIndex(MediaStore.Images.Thumbnails.IMAGE_ID));
                    String data = mCursor.getString(mCursor.getColumnIndex(MediaStore.Images.Thumbnails.DATA));
                    thum.put(id, data);
                } while (mCursor.moveToNext());
                mCursor.close();
              return true;
            } else {
                return false;
            }

        } else {
            return false;
        }
    }
    /**
     * h获取正常图片的path
     */
    public  List<ImageBean> getRealAddress() {
        imageBeans.clear();
        Cursor mCursor = mContext.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                new String[]{
                        MediaStore.Images.Media._ID,
                        MediaStore.Images.Media.DATA,
                        MediaStore.Images.Media.DISPLAY_NAME,
                        MediaStore.Images.Media.SIZE,
                        MediaStore.Images.Media.DESCRIPTION,
                },
                where,
                whereArgs,
                MediaStore.Images.Media.DATE_MODIFIED + " desc "
        );
        if (mCursor.moveToFirst()) {
            do {
                String name = mCursor.getString(mCursor.getColumnIndex(MediaStore.Images.Media.DISPLAY_NAME));
                String data = mCursor.getString(mCursor.getColumnIndex(MediaStore.Images.Media.DATA));
                String desc = mCursor.getString(mCursor.getColumnIndex(MediaStore.Images.Media.DESCRIPTION));
                double size = mCursor.getDouble(mCursor.getColumnIndex(MediaStore.Images.Media.SIZE));
                String id = mCursor.getString(mCursor.getColumnIndex(MediaStore.Images.Media._ID));
                imageBeans.add(new ImageBean(name, size, data, desc, thum.get(id),false));
            } while (mCursor.moveToNext());
            mCursor.close();
        }
        return imageBeans;
    }

}
