package cn.tk.java.faq;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

/**
 * Author: lijinlong
 * Mail: lijinlong3@jd.com
 * Date: 2017/5/8
 * Description:
 */
public class ParticipantComparable implements Comparator<Participant>{

    // 对象的排序方式[升、降]
    public static boolean sortASC = true;

    public ParticipantComparable(boolean sortASC) {
        this.sortASC = sortASC;
    }

    /**
     * Description:
     * 升序：从小到大，从早到晚
     * 降序：从大到小，从晚到早
     */
    @Override
    public int compare(Participant p1, Participant p2) {
        Long firstTime = p1.getPTime().getTime();
        Long secondTime = p2.getPTime().getTime();
        if (sortASC)
            if (firstTime > secondTime)
                return 1;
            else if (firstTime < secondTime)
                return -1;
            else
                return 0;
        else
            if (firstTime < secondTime)
                return 1;
            else if (firstTime > secondTime)
                return -1;
            else
                return 0;
    }
}
