package cn.tk.java.faq;

import cn.tk.java.util.page.PageUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by lijinlong3 on 2017/5/8.
 * 分页加载动态数据
 */
public class WaterfallPageTest {
    private static List<Integer> list = new ArrayList<Integer>();

    static {
        list.add(1);
        list.add(2);
        list.add(3);
        Collections.reverse(list);
    }

    /**
     * Description: 直接分页加载动态数据：数据重复
     * 只有降序会出现这个问题，因为数据会插到列表的最前面
     * 第一页：6,5,4
     * 第二页：6,5,4
     */
    @Test
    public void testGetPageError()
    {
        //1. 显示第一页数据
        addList(4, 5, 6);
        List<Integer> firstPage = PageUtil.getRangeList(list, 1, 3);
        System.out.println(firstPage);


        //2. 显示第二页数据
        addList(7, 8, 9);
        List<Integer> secondPage = PageUtil.getRangeList(list, 2, 3);
        System.out.println(secondPage);
    }

    /**
     * Description: 使用瀑布流分页工具：可以正确返回没有重复
     * 第一页：6,5,4
     * 第二页：3,2,1
     */
    @Test
    public void testGetPageSuccess()
    {
        //1. 显示第一页数据
        addList(4, 5, 6);
        List<Integer> firstPage = WaterfallPage.getPageList(list, null, 3);
        Integer lastRecord = firstPage.get(2);
        System.out.println(firstPage);

        //2. 显示第二页数据：可以拿到历史数据
        addList(7, 8, 9);
        List<Integer> secondPage = WaterfallPage.getPageList(list, lastRecord, 4);
        Integer sLastRecord = secondPage.get(2);
        System.out.println(secondPage);

        //2. 显示第三页数据： 拿不到数据
        addList(10, 11, 12);
        List<Integer> thirdPage = WaterfallPage.getPageList(list, sLastRecord, 3);
        System.out.println(thirdPage);
    }

    /**
     * Description: 批量添加数据后降序输出
     * 顺序添加 ==》逆序显示 ==》导致新添加的数据在最前端显示
     */
    public void addList(Integer ... elements)
    {
        Collections.reverse(list);//顺序
        for (Integer element : elements) {
            list.add(element);
        }
        Collections.reverse(list);//逆序
    }
}