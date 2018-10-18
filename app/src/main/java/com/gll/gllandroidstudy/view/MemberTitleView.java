package com.gll.gllandroidstudy.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.model.NoticeMessage;

/**
 * author      : Z_B
 * date       : 2018/10/18
 * function  :
 */
public class MemberTitleView extends FrameLayout {

    TextView tvMemberName, tvMemberNumber;

    public MemberTitleView(@NonNull Context context) {
        this(context, null);
    }

    public MemberTitleView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MemberTitleView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        View headerView = View.inflate(context, R.layout.include_view_flipper_view, this);
        tvMemberName = headerView.findViewById(R.id.tv_member_name);
        tvMemberNumber = headerView.findViewById(R.id.tv_member_number);

    }


    public void setMemberDate(NoticeMessage noticeMessages) {
        tvMemberName.setText(noticeMessages.messageTitle);
        tvMemberNumber.setText(noticeMessages.messageUrl);

    }


}
