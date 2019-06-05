package com.gll.gllandroidstudy.activity;

import android.os.Bundle;
import android.view.View;

import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.base.BaseActivity;
import com.gll.gllandroidstudy.flowlayout.DefaultFlowTagAdapter;
import com.gll.gllandroidstudy.flowlayout.FlowTagLayout;
import com.gll.gllandroidstudy.utils.ResUtils;

import java.util.List;

/**
 * 仿珍爱网年月日选择
 */
public class SelectYearAndMouthActivity extends BaseActivity {

    private FlowTagLayout flowTagLayout;

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_select_year_and_mouth);
    }

    @Override
    protected void bindViews() {
        initTitle("流式布局的自定义");
        flowTagLayout = get(R.id.flowTagLayout);
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

        DefaultFlowTagAdapter tagAdapter = new DefaultFlowTagAdapter(mContext);
        flowTagLayout.setAdapter(tagAdapter);
        flowTagLayout.setTagCheckedMode(FlowTagLayout.FLOW_TAG_CHECKED_SINGLE);
        tagAdapter.addTags(ResUtils.getStringArray(R.array.tags_values));
        tagAdapter.setSelectedPositions(2);
        flowTagLayout.setOnTagSelectListener((parent, position, selectedList) -> showToast(getSelectedText(parent, selectedList)));

    }

    private String getSelectedText(FlowTagLayout parent, List<Integer> selectedList) {
        StringBuilder sb = new StringBuilder("选中的内容：\n");
        for (int index : selectedList) {
            sb.append(parent.getAdapter().getItem(index));
            sb.append(";");
        }
        return sb.toString();
    }

    @Override
    protected void setListener() {
    }

    @Override
    public void onClick(View v) {
    }
}
