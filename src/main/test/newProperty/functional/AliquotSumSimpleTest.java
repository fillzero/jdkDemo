package newProperty.functional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by lijl85 on 2016/11/22.
 */
public class AliquotSumSimpleTest {

    public AliquotSumSimple perfect = new AliquotSumSimple(28);//1, 2, 4, 7, 14: 真约数和 = 28 完美数
    public AliquotSumSimple abundant = new AliquotSumSimple(12);//1, 2, 3, 4, 6: 真约数和 = 16 过剩数
    public AliquotSumSimple deficient = new AliquotSumSimple(11);//1: 真约数和 = 1: 不足数

    @Test
    @DisplayName("判断是否是目标数的约数")
    public void isFactor() throws Exception {
        assertEquals(true, perfect.isFactor(14));
        assertNotEquals(true, perfect.isFactor(15));
    }

    @Test
    @DisplayName("获取目标数所有约数")
    public void getFactors() throws Exception {
        System.out.println(perfect.getFactors());
        System.out.println(abundant.getFactors());
        System.out.println(deficient.getFactors());
    }

    @Test
    @DisplayName("获取目标数真约数和")
    public void aliquotSum() throws Exception {
        assertEquals(28, perfect.aliquotSum());
        assertEquals(16, abundant.aliquotSum());
        assertEquals(1, deficient.aliquotSum());
    }

    @Test
    @DisplayName("判断是否是完美数")
    public void isPerfect() throws Exception {
        assertTrue(perfect.isPerfect());
        assertFalse(perfect.isAbundant());
        assertFalse(perfect.isDeficient());
    }

    @Test
    @DisplayName("判断是否是过剩数")
    public void isAbundant() throws Exception {
        assertTrue(abundant.isAbundant());
    }

    @Test
    @DisplayName("判断是否是不足数")
    public void isDeficient() throws Exception {
        assertTrue(deficient.isDeficient());
    }
}