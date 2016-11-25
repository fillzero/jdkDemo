package cn.tk.java.util.commonUtils.idgenerator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * Created by lijl85 on 2016/11/25.
 */
public class CustomIdGeneratorTest {

    @Test
    @DisplayName("比较同一个人是否会生成相同的 customerId")
    public void customHashCode() throws Exception {
        long lijl = CustomIdGenerator.hashCode("李晋龙", "01", "150206201611226512");
        long lijl2 = CustomIdGenerator.hashCode("李晋龙", "01", "150206201611226512");
        long wangwc = CustomIdGenerator.hashCode("王文超", "01", "150206201111226512");
        assertEquals(lijl, lijl2);
        assertNotEquals(lijl, wangwc);
    }

    @Test
    @DisplayName("打印生成的 customerId")
    public void printCustomId()
    {
        long lijl = CustomIdGenerator.hashCode("李晋龙", "01", "150206201611226512");
        long lijl2 = CustomIdGenerator.hashCode("李晋龙", "01", "150206201611226512");
        long wangwc = CustomIdGenerator.hashCode("王文超", "01", "150206201111226512");
        System.out.println(lijl);
        System.out.println(lijl2);
        System.out.println(wangwc);
    }
}