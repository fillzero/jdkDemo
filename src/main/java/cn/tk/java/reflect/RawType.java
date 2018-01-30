package cn.tk.java.reflect;

import cn.tk.java.util.commonUtils.ReflectionUtils;
import lombok.SneakyThrows;
import org.apache.poi.ss.formula.functions.T;
import org.junit.Test;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: lijinlong
 * Mail: lijinlong3@jd.com
 * Date: 2018/1/30
 * Description:
 */
public class RawType {

    public class Generic<T> {

        /**
         * Description：获取真正的参数化类型
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
    }

    public class InstanceString extends Generic<String> {

    }

    public class InstanceList extends Generic<List<String>> {

    }

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
    public void testGenericMethod()
    {
        InstanceString stringInstance = new InstanceString();
        Method[] declaredMethods = stringInstance.getClass().getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod.getName());
        }

        Method method = ReflectionUtils.getDeclaredMethod(stringInstance.getClass(), "printType", String.class);
        Type[] argumentTypes = method.getGenericParameterTypes();
        for (Type argumentType : argumentTypes) {
            if (argumentType instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) argumentType;
                Type parameterUpperBound = ReflectionUtils.getParameterUpperBound(0, parameterizedType);

                System.out.println(parameterUpperBound);
            }
        }
    }
}
