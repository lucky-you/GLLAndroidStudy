package com.gll.gllandroidstudy.Index;

import android.text.TextUtils;
import android.util.SparseArray;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * 数据处理
 */

public class SideBarSortMode {
    private List<? extends SortModel> sourceDateList;//数据源
    private List<? extends SortModel> currentDateList;//当前使用的数据源
    /**
     * 首字母与首字母首次在数据源中出现的位置的映射
     */
    private SparseArray<String> sparseArray = new SparseArray();
    /**
     * 拼音排序的比较器
     */
    private PinyinComparator pinyinComparator = new PinyinComparator();
    /**
     * 实例化汉字转拼音类
     */
    private CharacterParser characterParser = CharacterParser.getInstance();


    public SideBarSortMode() {

    }

    /**
     * 设置数据源,外部列表数据源更新时,需要再次调用
     *
     * @param sourceDateList 数据源
     */
    public void setSourceDateList(List<? extends SortModel> sourceDateList) {
        this.sourceDateList = sourceDateList;
        filledData(sourceDateList);
        // 根据a-z进行排序源数据
        Collections.sort(sourceDateList, pinyinComparator);
        updateSourceData(sourceDateList);
    }

    /**
     * 更新数据源,内部用于搜索的时候
     *
     * @param sourceDateList 数据源
     */
    private void updateSourceData(List<? extends SortModel> sourceDateList) {
        this.currentDateList = sourceDateList;
        String chart = "";
        sparseArray.clear();
        for (int i = 0; i < sourceDateList.size(); i++) {
            String sortLetters = sourceDateList.get(i).getSortLetters();
            if (!chart.equals(sortLetters)) {
                chart = sortLetters;
                sparseArray.put(i, sortLetters);
            }
        }

    }

    /**
     * 获取指定索引的拼音首字母
     *
     * @param position 索引位置
     * @return
     */
    public String getSortLetterTitle(int position) {
        return sparseArray.get(position);
    }

    /**
     * 获取返回的字母数组
     *
     * @return 数组
     */
    public String[] getSortLetterTitle() {
        List<String> LetterList = new ArrayList<>();
        for (int i = 0; i < sparseArray.size(); i++) {
            int key = sparseArray.keyAt(i);
            String letter = sparseArray.get(key);
            if (!TextUtils.isEmpty(letter))
                LetterList.add(letter);
        }
        String[] stringLetter = new String[LetterList.size()];
        return LetterList.toArray(stringLetter);
    }


    /**
     * 根据输入框中的值来过滤数据并更新ListView
     *
     * @param filterStr 过滤文本(搜索关键字)
     */
    public <T extends SortModel> List<T> getData(String filterStr) {
        List<T> filterDateList = new ArrayList<T>();
        if (TextUtils.isEmpty(filterStr)) {
            if (sourceDateList != null) {
                filterDateList.addAll((Collection<? extends T>) sourceDateList);
            }
        } else {
            filterDateList.clear();
            if (sourceDateList != null)
                for (SortModel sortModel : sourceDateList) {
                    String name = String.valueOf(sortModel);
                    if (name.toLowerCase().contains(filterStr.toLowerCase()) || characterParser.getSelling(name).startsWith(filterStr)) {
                        filterDateList.add((T) sortModel);
                    }
                }
        }
        // 根据a-z进行排序
        Collections.sort(filterDateList, pinyinComparator);
        updateSourceData(filterDateList);
        return (List<T>) filterDateList;
    }

    /**
     * 获取指定数据源中指定索引的实体类
     *
     * @param position
     * @param <T>
     * @return
     */
    public <T extends SortModel> T getItem(int position) {
        if (currentDateList != null && position < currentDateList.size() && position >= 0)
            return (T) currentDateList.get(position);
        return null;
    }

    /**
     * 获取section对应的第一个列表项
     * 快速定位的首字母
     *
     * @param section 快速定位组件中触摸到的字母所在的索引位置
     * @return
     */
    public int getPositionForSection(int section) {
        if (currentDateList != null && currentDateList.size() > 0) {
            for (int i = 0; i < currentDateList.size(); ++i) {
                String sortStr = currentDateList.get(i).getSortLetters();
                char firstChar = sortStr.toUpperCase().charAt(0);
                if (firstChar == section) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * 获取position所在的section位置
     * 快速定位的首字母
     *
     * @return
     */
    public int getSectionForPosition(int position) {
        return currentDateList.get(position).getSortLetters().charAt(0);
    }

    private String getAlpha(String str) {
        String sortStr = str.trim().substring(0, 1).toUpperCase();
        return sortStr.matches("[A-Z]") ? sortStr : "#";
    }

    /**
     * 填充数据
     */
    public List<SortModel> filledData(String[] date) {
        List<SortModel> mSortList = new ArrayList();
        for (int i = 0; i < date.length; ++i) {
            SortModel sortModel = new SortModel();
            sortModel.setName(date[i]);
            String pinyin = characterParser.getSelling(date[i]);
            String sortString = pinyin.substring(0, 1).toUpperCase();
            if (sortString.matches("[A-Z]")) {
                sortModel.setSortLetters(sortString.toUpperCase());
            } else {
                sortModel.setSortLetters("#");
            }
            mSortList.add(sortModel);
        }
        return mSortList;
    }


    /**
     * 填充数据
     */
    public void filledData(List<? extends SortModel> date) {
        int i = 0;
        for (int length = date.size(); i < length; ++i) {
            SortModel sortModel = (SortModel) date.get(i);
            String pinyin = characterParser.getSelling(String.valueOf(date.get(i)));
            String sortString = pinyin.substring(0, 1).toUpperCase();
            if (sortString.matches("[A-Z]")) {
                sortModel.setSortLetters(sortString.toUpperCase());
            } else {
                sortModel.setSortLetters("#");
            }
        }
    }


    private void filterData(String filterStr, List<SortModel> SourceDateList) {
        List<SortModel> filterDateList = new ArrayList();
        if (!TextUtils.isEmpty(filterStr)) {
            filterDateList.clear();
            Iterator var5 = SourceDateList.iterator();
            while (true) {
                SortModel sortModel;
                String name;
                do {
                    if (!var5.hasNext()) {
                        return;
                    }
                    sortModel = (SortModel) var5.next();
                    name = sortModel.getName();
                }
                while (name.indexOf(filterStr.toString()) == -1 && !characterParser.getSelling(name).startsWith(filterStr.toString()));
                filterDateList.add(sortModel);
            }
        }
    }
}
