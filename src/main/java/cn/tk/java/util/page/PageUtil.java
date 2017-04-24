package cn.tk.java.util.page;

import java.util.ArrayList;
import java.util.List;

/*
* @author: lijinlong
* @mail: lijinlong3@jd.com
* @date: 2017/4/24
* @description: 分页工具
*
* 寻找分页有点儿像在内存中寻找某一个数据的过程。
* index, offset
*
* index: 表示内存地址， offset 表示每个内存单位的大小， 二者将内存空间划分
* 成一个个长方形。
*/
public class PageUtil<T> {

    /*
    * @description: 根据 targetList 截取链表的某一段
    * @param: dataList：数据列表
    * @param: pageNo: 当前页数
    * @param: pageSize: 每页个数
    *
    * 总个数 nums
    * 总页数 pages
    *
    * example：105 个数，每页 10 个数
    * page 从 1 开始计算
    *
    * 0   ~  9
    * 10  ~  19
    * 20  ~  29
    * ...
    * 90  ~  99
    * 100 ~  104
    *
    * 注：
    * （1）每页个数不能超过总个数：pageSize < nums
    * （2）当前页数不能超过总页数: pageNo < pages
    * （3）最后一页要做特殊处理，最后一页的 endIndex 就是 nums
    *
    * 总结： 个数不越界、页数不越界、最后一页不越界。
    */
    public static <T> List<T> getRangeList(List<T> dataList, int pageNo, int pageSize)
    {
        if (dataList == null)
            return null;

        int nums = dataList.size();
        int pages = nums / pageSize + 1;

        if (pageSize > nums)
            return null;
        if (pageNo > pages)
            return null;

        int startIndex = (pageNo - 1) * pageSize;
        int endIndex = startIndex + pageSize;

        if (endIndex > nums)
            endIndex = nums;
        return dataList.subList(startIndex, endIndex);
    }
}