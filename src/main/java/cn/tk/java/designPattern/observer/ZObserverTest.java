package cn.tk.java.designPattern.observer;

import cn.tk.java.designPattern.observer.*;
import org.junit.Test;

/*
* @author: lijinlong
* @mail: lijinlong3@jd.com
* @date: 2017/4/1
* @description: 观察者模式单元测试
* 场景：一个老板（Jack），三个员工（Amy, Sam, LiLi），老板通知员工开会，员工分别表达很快就到了。
* 目标知道自己有多少个观察者，而观察者之间互相不知道彼此的存在，而且目标仅仅知道自己有一系列的观察者，
* 具体的观察者属于哪一个类，目标并不清楚。
*
* 可以用一个 Hash 表存储目标和观察表之间一对多的关系，当然也存在多对多的关系，一个观察者可能关注了多个目标。
**/
public class ZObserverTest {

    /*
    * @description: 一个 Subject，多个 Observer, 发出一个消息，每个 Observer 都可以根据消息的内容作出不一样的事情。
    */
    @Test
    public void testNotify()
    {
        Boss boss = new Jack();
        Staff amy = new Amy();
        Staff sam = new Sam();
        Staff lili = new LiLi();
        boss.employ(amy);
        boss.employ(sam);
        boss.employ(lili);
        boss.fire(amy);
        boss.haveAMeeting("C230 极光");
    }
}
