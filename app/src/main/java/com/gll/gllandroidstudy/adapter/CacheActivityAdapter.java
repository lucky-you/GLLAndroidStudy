package com.gll.gllandroidstudy.adapter;

import android.content.Context;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.gll.gllandroidstudy.model.NoticeMessage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by: Z_B on 2018/8/12.
 * Function:
 */
public class CacheActivityAdapter extends RecyclerView.Adapter<BindViewHolder> {


    private static final int ITEM_TYPE_ON = 1;
    private static final int ITEM_TYPE_OFF = 2;
    private final LayoutInflater layoutInflater;
    private OnItemClickListener onItemClickListener;
    private List<NoticeMessage> noticeMessageList;

    public CacheActivityAdapter(Context context) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        noticeMessageList = new ArrayList<>();

    }

    public interface OnItemClickListener {
        void onMessageClick();
    }

    @Override
    public int getItemViewType(int position) {
        NoticeMessage noticeMessage = noticeMessageList.get(position);
        if (noticeMessage.isFired) {
            return ITEM_TYPE_OFF;
        } else {
            return ITEM_TYPE_ON;
        }
    }

    @NonNull
    @Override
    public BindViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull BindViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
