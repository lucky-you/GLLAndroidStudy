package com.gll.gllandroidstudy.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.model.YearAndMouthBean;

import java.util.List;

/**
 * author      : Z_B
 * date       : 2018/11/27
 * function  :
 */
public class SelectMouthAndDayDateAdapter extends BaseAdapter {

    private Context mContext;
    private List<YearAndMouthBean> mDateList;
    private OnGridViewItemClickListener onGridViewItemClickListener;

    private int clickPosition;


    public SelectMouthAndDayDateAdapter(Context mContext, List<YearAndMouthBean> mDateList) {
        this.mContext = mContext;
        this.mDateList = mDateList;
    }

    public void setOnGridViewItemClickListener(OnGridViewItemClickListener onGridViewItemClickListener) {
        this.onGridViewItemClickListener = onGridViewItemClickListener;
    }

    public void setClickPosition(int clickPosition) {
        this.clickPosition = clickPosition;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mDateList.size();
    }

    @Override
    public Object getItem(int position) {
        return mDateList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = View.inflate(mContext, R.layout.include_select_year_date_item_view, null);
            viewHolder.tvYearAndMouth = convertView.findViewById(R.id.tv_year_or_day);
            viewHolder.llItemRootLayout = convertView.findViewById(R.id.ll_item_root_layout);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tvYearAndMouth.setText(mDateList.get(position).getYearRight());
//        if (clickPosition == position) {
//            viewHolder.llItemRootLayout.setBackground(mContext.getResources().getDrawable(R.drawable.verification_edit_bg_normal));
//        }
        return convertView;
    }

    class ViewHolder {
        LinearLayout llItemRootLayout;
        TextView tvYearAndMouth;
    }

    public interface OnGridViewItemClickListener {

        void onItemClick(View rootView, boolean isSelect, int position);

    }


}
