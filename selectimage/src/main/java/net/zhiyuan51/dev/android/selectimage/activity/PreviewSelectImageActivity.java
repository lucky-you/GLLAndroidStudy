package net.zhiyuan51.dev.android.selectimage.activity;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import net.zhiyuan51.dev.android.selectimage.ImageBean;
import net.zhiyuan51.dev.android.selectimage.helper.ImageHelper;
import net.zhiyuan51.dev.android.selectimage.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/10/30.
 * user: Administrator
 * date: 2018/10/30
 * time; 14:57
 * name: 预览图片
 */
public class PreviewSelectImageActivity extends AppCompatActivity {
    TextView tv_image_number;
    List<ImageBean> imageBeans=new ArrayList<>();
    ViewPager vp_images;
    ImageView iv_select;
    TextView tv_select_num;
    LinearLayout rl_back;
    int start_num;
    List<ImageBean> selectImage;
    int mMaxCount = ChoiceImageActivity.mMaxCount;
    ImageHelper imageHelper;
    PagerAdapter adapter;
    int type;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview_select_image);
        tv_image_number = findViewById(R.id.tv_image_number);
        vp_images = findViewById(R.id.vp_images);
        iv_select = findViewById(R.id.iv_select);
        tv_select_num = findViewById(R.id.tv_select_num);
        rl_back = findViewById(R.id.rl_back);
        imageHelper = ImageHelper.getGetImageHelperInstance();

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            //imageBeans = bundle.getParcelableArrayList("list");
            selectImage = bundle.getParcelableArrayList("select_lits");
            start_num = bundle.getInt("number") + 1;
            type=bundle.getInt("type",1);
            if(type==0){
                imageBeans= bundle.getParcelableArrayList("select_lits");;
                selectImage(0);
            }else {
                new LoadImage().execute();
            }
            if (selectImage.size() > 0) {
                tv_select_num.setText("完成(" + selectImage.size() + "/" + mMaxCount + ")");
            } else {
                tv_select_num.setText("完成");
            }
            tv_image_number.setText(start_num + "/" + imageBeans.size());
            // 设置左右两列缓存的数目
            vp_images.setOffscreenPageLimit(2);
            // 添加Adapter
             adapter = new ImageBrowseAdapter(this, imageBeans);
            vp_images.setAdapter(adapter);
            vp_images.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                }

                @Override
                public void onPageSelected(final int position) {
                    tv_image_number.setText(position + 1 + "/" + imageBeans.size());

                    selectImage(position);
                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });
        }
        rl_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = getIntent();
                data.putParcelableArrayListExtra("back_select_list", (ArrayList<? extends Parcelable>) selectImage);
                data.putExtra("type",1);
                setResult(ChoiceImageActivity.GET_PREVIEW, data);
                finish();
            }
        });
        tv_select_num.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selectImage.size()>0){
                    Intent data = new Intent();
                    data.putParcelableArrayListExtra("select_image_list", (ArrayList<? extends Parcelable>) selectImage);
                    data.putExtra("type",2);
                    setResult(ChoiceImageActivity.GET_PREVIEW, data);
                    finish();
                }
            }
        });
    }

    private void selectImage(final int position) {
        if (imageBeans.get(position).isSelect()) {
            iv_select.setBackgroundResource(R.mipmap.select_xz);
        } else {
            iv_select.setBackgroundResource(R.mipmap.no_xz);
        }
        iv_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageBean imageBean = imageBeans.get(position);
                boolean isSelected = !imageBeans.get(position).isSelect();
                if (isSelected) {
                    if (selectImage.size() >= mMaxCount) {
                        String warning = getString(R.string.boxing_too_many_picture_fmt, mMaxCount);
                        Toast.makeText(PreviewSelectImageActivity.this, warning, Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (!selectImage.contains(imageBean)) {
                        selectImage.add(imageBean);
                    }
                } else {
                    if (selectImage.size() >= 1 && selectImage.contains(imageBean)) {
                        selectImage.remove(imageBean);
                    }
                }
                if (isSelected) {
                    iv_select.setBackgroundResource(R.mipmap.select_xz);
                } else {
                    iv_select.setBackgroundResource(R.mipmap.no_xz);
                }
                imageBean.setSelect(isSelected);
                if (selectImage.size() > 0) {
                    tv_select_num.setText("完成(" + selectImage.size() + "/" + mMaxCount + ")");
                } else {
                    tv_select_num.setText("完成");
                }
            }
        });
    }




    class LoadImage extends AsyncTask<Void, Integer, Boolean> {
        List<ImageBean> imageBeanList;
        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            // dismissDialog();
            imageBeans.addAll(imageBeanList);
            checkSelectedMedia(imageBeanList,selectImage);
            adapter.notifyDataSetChanged();
            vp_images.setCurrentItem(start_num - 1);
            selectImage(start_num-1);

        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
//            showDialog();
        }

        @Override
        protected Boolean doInBackground(Void... voids) {
            if (imageHelper.getThumbnail(PreviewSelectImageActivity.this)) {
                if(imageHelper.getRealAddress().size()>0){
                    imageBeanList=imageHelper.getRealAddress();
                }
                return true;
            } else {
                return false;
            }

        }
    }

    public void checkSelectedMedia(List<ImageBean> allMedias, List<ImageBean> selectedMedias) {
        if (allMedias == null || allMedias.size() == 0) {
            return;
        }
        Map<String, ImageBean> map = new HashMap<>(allMedias.size());
        for (ImageBean allMedia : allMedias) {
            if (!(allMedia instanceof ImageBean)) {
                return;
            }
            ImageBean media = (ImageBean) allMedia;
            media.setSelect(false);
            map.put(media.getImage_path(), media);
        }
        if (selectedMedias == null || selectedMedias.size() < 0) {
            return;
        }
        for (ImageBean media : selectedMedias) {
            if (map.containsKey(media.getImage_path())) {
                map.get(media.getImage_path()).setSelect(true);
            }
        }
    }

    class ImageBrowseAdapter extends PagerAdapter {
        Context mContext;
        List<ImageBean> imageBeans;

        public ImageBrowseAdapter(Context mContext, List<ImageBean> imageBeans) {
            this.mContext = mContext;
            this.imageBeans = imageBeans;
        }

        @Override
        public int getCount() {
            return imageBeans.size();
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup view, int position, Object object) {
            view.removeView((View) object);
        }

        @Override
        public Object instantiateItem(ViewGroup view, int position) {
            ImageView imageView = new ImageView(mContext);
            //glideUtil.intoDefault(mContext,imageBeans.get())
            Glide.with(mContext).load(imageBeans.get(position).getImage_path()).
                    placeholder(R.drawable.ic_boxing_default_image)
                    .centerCrop().
                    into(imageView);
            view.addView(imageView);
            return imageView;
        }

    }
}
