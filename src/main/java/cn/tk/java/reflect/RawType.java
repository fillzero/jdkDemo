package cn.tk.java.reflect;

import cn.tk.java.util.commonUtils.ReflectionUtils;
import com.google.common.collect.ImmutableMap;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;
import java.util.function.Predicate;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Author: lijinlong
 * Mail: lijinlong3@jd.com
 * Date: 2018/1/30
 * Description: 获取父类的参数化类型，获取方法入参的实际参数等等。
 */
public class RawType {

    public class Generic<T> {

        /**
         * Description：解析父类的泛型
         * 获取真正的参数化类型
         * 获取 String
         * 获取 List
         */
        @SneakyThrows
        public T printType(T name) {
            Type superClassType = this.getClass().getGenericSuperclass();
            ParameterizedType parameterizedType = (ParameterizedType) superClassType;
            Type argumentType = ReflectionUtils.getParameterUpperBound(0, parameterizedType);

            // 复合类型单独处理（List，Map等）
            if (argumentType instanceof ParameterizedType) {
                argumentType = ReflectionUtils.getRawType(argumentType);
            }

            if (Class.forName(argumentType.getTypeName()).isAssignableFrom(String.class)) {
                System.out.println("我是一个字符串");
            }

            if (Class.forName(argumentType.getTypeName()).isAssignableFrom(List.class)) {
                System.out.println("我是一个链表");
            }

            if (argumentType.getTypeName().equals("java.lang.String")) {
                System.out.println("我是一个字符串");
            }

            if (argumentType.getTypeName().equals("java.util.List")) {
                System.out.println("我是一个链表");
            }

            return name;
        }

        /**
         * Description：打印当前方法名
         */
        public T printGenericMethod(T name)
        {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            String currentMethodName = stackTrace[1].getMethodName();
            Method[] genericMethods = this.getClass().getSuperclass().getDeclaredMethods();
            Method currentMethod = getCurrentMethod(currentMethodName, genericMethods);
            System.out.println(currentMethod.getName());
            return name;
        }

        /**
         * Description：解析父类方法上的泛型参数，即解析 name 的真正类型
         */
        @SneakyThrows
        public T resolveGenericMethod(T name)
        {
            Type nameType = name.getClass();
            if (Class.forName(nameType.getTypeName()).isAssignableFrom(String.class))
                System.out.println("我是一个字符串： " + nameType);

            if (Class.forName(nameType.getTypeName()).isAssignableFrom(ArrayList.class))
                System.out.println("我是一个链表： " + nameType);

            if (name instanceof String)
                System.out.println("我是一个字符串： " + nameType);

            if (name instanceof List)
                System.out.println("我是一个链表： " + nameType);

            if (name instanceof Map)
                System.out.println("我是一个哈希表： " + nameType);
            return name;
        }
    }

    public class InstanceString extends Generic<String> {

    }

    public class InstanceList extends Generic<List<String>> {

    }

    public class InstanceMap extends Generic<Map<String, String>> {

    }

    /**
     * Description：
     */
    @Test
    public void testGenericClass()
    {
        InstanceString stringInstance = new InstanceString();
        stringInstance.printType("name");

        List<String> list = new ArrayList<>();
        list.add("lijinlong");
        InstanceList listInstance = new InstanceList();
        listInstance.printType(list);
    }

    @Test
    public void printGenericMethod()
    {
        InstanceString stringInstance = new InstanceString();
        String string = "name";
        stringInstance.printGenericMethod(string);
    }

    @Test
    public void resolveGenericMethod()
    {
        InstanceString stringInstance = new InstanceString();
        String string = "name";
        stringInstance.resolveGenericMethod(string);

        InstanceList listInstance = new InstanceList();
        List<String> list = Arrays.asList("lijinlong", "quyuexin");
        listInstance.resolveGenericMethod(list);

        InstanceMap mapInstance = new InstanceMap();
        ImmutableMap<String, String> map = ImmutableMap.of("name", "lijinlong");
        mapInstance.resolveGenericMethod(map);
    }

    private Method getCurrentMethod(String currentMethodName, Method[] genericMethods) {
        for (Method declaredMethod : genericMethods) {
            if (currentMethodName.equals(declaredMethod.getName()))
                return declaredMethod;
        }
        return null;
    }

    /**
     * Description：
     * 链表、map、字符串、基础数据类型、自定义对象非空校验
     */
    @Test
    public void testPredicate()
    {
        Predicate listPredicate = (obj) -> !CollectionUtils.isEmpty((Collection<?>) obj);

        Predicate mapPredicate = (obj) -> !CollectionUtils.isEmpty((Map<?, ?>) obj);

        Predicate primitivePredicate = (obj) -> obj != null;

        Predicate stringPredicate = (obj) -> StringUtils.isNotEmpty((String) obj);

        Predicate customPredicate = (obj) -> obj != null;

        List<String> list = Arrays.asList("lijinlong", "quyuexin");
        List emptyList = new ArrayList();
        assertTrue(listPredicate.test(list));
        assertFalse(listPredicate.test(emptyList));

        ImmutableMap<String, String> map = ImmutableMap.of("name", "lijinlong");
        ImmutableMap<Object, Object> emptyMap = ImmutableMap.of();
        assertTrue(mapPredicate.test(map));
        assertFalse(mapPredicate.test(emptyMap));

        Long longValue = new Long(10);
        Long nullLong = null;
        assertTrue(primitivePredicate.test(longValue));
        assertFalse(primitivePredicate.test(nullLong));
        Integer integerValue = new Integer(10);
        Integer nullInteger = null;
        assertTrue(primitivePredicate.test(integerValue));
        assertFalse(primitivePredicate.test(nullInteger));

        String string = "lijinlong";
        String emptyString = "";
        String nullString = null;
        assertTrue(stringPredicate.test(string));
        assertFalse(stringPredicate.test(emptyString));
        assertFalse(stringPredicate.test(nullString));

        Person person = new Person();
        person.setName("lijinlong");
        person.setAge(18);
        Person nullPerson = null;
        assertTrue(customPredicate.test(person));
        assertFalse(customPredicate.test(nullPerson));
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class Person{
        private String name;
        private int age;
    }
}
