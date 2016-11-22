package newProperty.functional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by Administrator on 2016/11/22.
 */
public class AliquotSumFuncTest {

    public AliquotSumFunc perfect = new AliquotSumFunc();//1, 2, 4, 7, 14: 真约数和 = 28 完美数
    public AliquotSumFunc abundant = new AliquotSumFunc();//1, 2, 3, 4, 6: 真约数和 = 16 过剩数
    public AliquotSumFunc deficient = new AliquotSumFunc();//1: 真约数和 = 1: 不足数


    @Test
    @DisplayName("获取目标数真约数和")
    public void aliquotSum() throws Exception {
        assertEquals(28, perfect.aliquotSum(28));
        assertEquals(16, abundant.aliquotSum(12));
        assertEquals(1, deficient.aliquotSum(11));
    }

    @Test
    @DisplayName("判断是否是完美数")
    public void isPerfect() throws Exception {
        assertTrue(perfect.isPerfect(28));
        assertFalse(perfect.isAbundant(28));
        assertFalse(perfect.isDeficient(28));
    }

    @Test
    @DisplayName("判断是否是过剩数")
    public void isAbundant() throws Exception {
        assertTrue(abundant.isAbundant(12));
    }

    @Test
    @DisplayName("判断是否是不足数")
    public void isDeficient() throws Exception {
        assertTrue(deficient.isDeficient(11));
    }
}