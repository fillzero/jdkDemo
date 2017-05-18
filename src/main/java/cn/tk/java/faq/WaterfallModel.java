package cn.tk.java.faq;

import java.util.List;

/**
 * Author: lijinlong
 * Mail: lijinlong3@jd.com
 * Date: 2017/5/8
 * Description:
 */
public class WaterfallModel {
    /**
     * Description: 利用 uniqueId 找到在 dataList 中的位置，找该位置之后的 pageSize 条记录。
     *
     * uniqueId：可以为订单号，主键
     */
    public static <T> List<T> getPageList(List<T> dataList, Long uniqueId, int pageSize){
        return dataList;
    }
}
