package newProperty;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Author: lijinlong
 * Mail: lijinlong3@jd.com
 * Date: 2017/11/23
 * Description: Stream 各种操作
 */
public class SteamDemoTest {

    /**
     * Description：Stream 创建
     *
     * 数组 --> Stream（stream() 方法）
     * 集合 --> Stream（stream() 方法）
     *
     * Collection.stream()
     * Stream.of(T... values)
     */
    @Test
    public void testCreate()
    {
        // 数组 --> Stream（IntStream、LongStream、DoubleStream 避免自动拆装箱）
        Stream<String> animal = Stream.of("dog", "fish", "cat");
        String[] animalArray = new String[]{"dog", "fish", "cat"};
        Stream<String> animal1 = Stream.of(animalArray);
        Stream<String> animal2 = Arrays.stream(animalArray);

        List<String> animalList = Arrays.asList("dog", "fish", "cat");
        Stream<String> animal3 = animalList.stream();

        IntStream range = IntStream.range(1, 3);
        IntStream intStream = IntStream.rangeClosed(1, 3);
        IntStream of = IntStream.of(new int[]{1, 2, 3});
    }

    /**
     * Description：Stream 转换成其它类型（注意一个流只能处理1次，处理完后不能重复使用）
     * Stream --> 数组（toArray）
     * Stream --> 集合（collect）
     */
    @Test
    public void testCollect()
    {
        // 转换为数组
        Stream<String> stream = Stream.of("dog", "fish", "cat");
        String[] animals = stream.toArray(String[]::new);

        // 转换为 Collection（ArrayList，HashSet）
        Stream<String> stream1 = Stream.of("dog", "fish", "cat");
        List<String> animal1 = stream1.collect(Collectors.toList());
        System.out.println(animal1);

        Stream<String> stream2 = Stream.of("dog", "fish", "cat");
        ArrayList<String> animal2 = stream2.collect(Collectors.toCollection(ArrayList::new));
        System.out.println(animal2);

        Stream<String> stream3 = Stream.of("dog", "fish", "cat");
        Set<String> animal3 = stream3.collect(Collectors.toSet());
        System.out.println(animal3);

        Stream<String> stream4 = Stream.of("dog", "fish", "cat");
        HashSet<String> animal4 = stream4.collect(Collectors.toCollection(HashSet::new));
        System.out.println(animal4);

        // 转换为 String
        Stream<String> stream5 = Stream.of("dog", "fish", "cat");
        String animal5 = stream5.collect(Collectors.joining()).toString();
        System.out.println(animal5);
    }

    /**
     * Description: Stream 操作
     * 中间操作
     * 最终操作
     * 短路操作
     * http://blog.csdn.net/u014646662/article/details/52261511
     * https://zhuanlan.zhihu.com/p/24915742
     */
    @Test
    public void testOperate()
    {
        Stream.of("dog", "fish", "cat")
                .map(String::toUpperCase)
                .skip(2)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    @Test
    public void testReduce()
    {
        Optional<Integer> reduce = Stream.of(1, 2, 3, 4, 5, 6)
                .filter(e -> e > 3)
                .reduce((a, b) -> a + b);
        System.out.println(reduce.get());

        Optional<LinkedList<String>> resultList = Stream.of("dog", "fish", "cat")
                .collect(Collectors.toCollection(LinkedList::new))
                .stream()
                .reduce((LinkedList<String> a, LinkedList<String> b) -> {
                    LinkedList<String> list = new LinkedList<>();
                    list.addAll(a);
                    list.addAll(b);
                    return list;
                });
        System.out.println(resultList.get());
    }
}
