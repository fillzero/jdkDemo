package cn.tk.java.algorithm.frequency;

import cn.tk.java.algorithm.frequency.FrequencyCounter;
import org.junit.Test;

/**
 * Created by Administrator on 2017/3/5 0005.
 */
public class FrequencyCounterTest {
    @Test
    public void getMax() throws Exception {
        String filePath = "src/main/test/cn/tk/java/algorithm/frequency/frequency.txt";
        FrequencyCounter counter = new FrequencyCounter();
        System.out.println(counter.getMax(filePath));
    }
}