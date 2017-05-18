package cn.tk.java.faq;

import cn.tk.java.util.page.PageUtil;

import java.util.List;

/**
 * Author: lijinlong
 * Mail: lijinlong3@jd.com
 * Date: 2017/5/8
 * Description: 瀑布流分页问题解决
 */
public class WaterfallPage {
    /**
     * Description: 利用 uniqueId 找到在 dataList 中的位置，找该位置之后的 pageSize 条记录。
     *
     * uniqueId：可以为订单号，主键
     */
    public static <T> List<T> getPageList(List<T> dataList, T uniqueId, int pageSize){
        //1. 返回第一页
        if (uniqueId == null){
            return PageUtil.getRangeList(dataList, 1, pageSize);
        }

        //2. 返回第 m 页
        int startIndex = dataList.indexOf(uniqueId);
        startIndex = (startIndex != -1) ? startIndex+1 : null;
        int endIndex = startIndex + pageSize;
        int lastIndex =  dataList.size();

        //3. endIndex 越界的时候只返回存在的部分
        if (endIndex > lastIndex)
            return dataList.subList(startIndex, lastIndex);
        else
            return dataList.subList(startIndex, endIndex);
    }
}
