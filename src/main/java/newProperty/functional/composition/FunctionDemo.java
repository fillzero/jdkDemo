package newProperty.functional.composition;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Author: lijinlong
 * Mail: lijinlong3@jd.com
 * Date: 2018/1/19
 * Description:
 */
public class FunctionDemo
{
    @Test
    public void testFunction()
    {
        ArrayList<String> list = Lists.newArrayList("lijinlong_1", "quyuexin_2", "zhaoxiaoyong_3");

        list.stream()
                .map(this::nameClean)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    /**
     * Description：执行顺序：compose(before) > apply > andThen(after)
     */
    @Test
    public void testSimpleFunction()
    {
        Function<Integer, Integer> multiply = e -> e * 2;
        Function<Integer, Integer> squared = e -> e * e;
        // compose： (4 ^ 4) * 2（compose 在 apply 前面执行）==> 32
        System.out.println(multiply.compose(squared).apply(4));

        // andThen：(4 * 2) ^ 4（andThen 在 apply 后面执行）==> 64
        System.out.println(multiply.andThen(squared).apply(4));

        // ((4 ^ 4) * 2) ^ ((4 ^ 4) * 2) = 1024
        System.out.println(multiply
                .andThen(squared)
                .compose(squared)
                .apply(4));
    }

    public String nameClean(String originName)
    {
        Function<String, String> nameFilter = name -> name.substring(0, name.indexOf("_"));
        Function<String, String> nameConverter = name -> "3C文旅-".concat(name);
        return nameFilter.compose(nameConverter).apply(originName);
    }
}
