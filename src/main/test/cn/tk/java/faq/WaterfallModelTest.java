package cn.tk.java.faq;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Author: lijinlong
 * Mail: lijinlong3@jd.com
 * Date: 2017/5/8
 * Description: 分页的数据不再是简单的数据类型，而是复杂数据类型，比如说是一个购买参与人、或者头条的一条新闻、一条微博
 * 要从中抓取唯一的部分进行重复判定。
 */
public class WaterfallModelTest {
    private static List<Participant> participants = new ArrayList<Participant>();

    static {
        Participant p1 = new Participant();
        p1.setId(1l);
        p1.setName("ljl");
        p1.setPTime(new Date());
        Participant p2 = new Participant();
        p2.setId(2l);
        p2.setName("wty");
        p2.setPTime(new Date());
        Participant p3 = new Participant();
        p3.setId(3l);
        p3.setName("lj");
        p3.setPTime(new Date());
        participants.add(p1);
        participants.add(p2);
        participants.add(p3);
        Collections.reverse(participants);
    }

    /**
     * Description: 复杂数据类型：瀑布流分页工具
     */
    @Test
    public void testGetPageSuccess()
    {
        Participant p4 = new Participant();
        p4.setId(4l);
        p4.setName("xiaoxiao");
        p4.setPTime(new Date());
        Participant p5 = new Participant();
        p5.setId(5l);
        p5.setName("shanling");
        p5.setPTime(new Date());
        Participant p6 = new Participant();
        p6.setId(6l);
        p6.setName("tingting");
        p6.setPTime(new Date());
        addParticipants(p4, p5, p6);
        System.out.println(participants);
    }

    public void addParticipants(Participant ... list)
    {
        //顺序
//        Collections.sort(participants);
        for (Participant participant : list) {
            participants.add(participant);
        }
        //逆序
        Collections.reverse(participants);//逆序
    }
}
