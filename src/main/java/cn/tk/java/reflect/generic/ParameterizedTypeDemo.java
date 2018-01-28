package cn.tk.java.reflect.generic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/*
 *@date: 2018/1/28 0028
 *@author: lijl85
 *@mail: ljldeepinit@163.com
 *@description: 用于判断泛型是否被参数化了，如果参数化了可以拿到真正的参数
 */
public class ParameterizedTypeDemo {

    @NoArgsConstructor
    public class BaseDao<T>
    {
        public T get(){
            return null;
        }
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class User{
        private String name;
        private int age;
    }

    public class UserDao extends BaseDao<User>{

    }

    public class ProductDao extends BaseDao{

    }

    /*
     * @description: 实现泛型参数化
     */
    @Test
    public void testUserDao(){
        // 获取带参数化信息的父类 BaseDao<User>
        final Type genericSuperclass = UserDao.class.getGenericSuperclass();

        // 获取父类 BaseDao
        final Class<?> superclass = UserDao.class.getSuperclass();
        System.out.println(genericSuperclass);
        System.out.println(superclass);

        // ParameterizedType：判断是否是参数化类型（即判断父类泛型是否被实例化），getActualTypeArguments 获取所有泛型参数数组
        if (genericSuperclass instanceof ParameterizedType)
        {
            printGenericArguments((ParameterizedType) genericSuperclass);
        }
    }

    /*
    * @description: 泛型未参数化
    */
    @Test
    public void testProductDao(){
        // 获取带参数化信息的父类 BaseDao<User>
        final Type genericProductSuperClass = ProductDao.class.getGenericSuperclass();

        // 获取父类 BaseDao
        final Class<?> superclass = ProductDao.class.getSuperclass();
        System.out.println(genericProductSuperClass);
        System.out.println(superclass);

        // ParameterizedType：判断是否是参数化类型（即判断父类泛型是否被实例化），getActualTypeArguments 获取所有泛型参数数组
        if (genericProductSuperClass instanceof ParameterizedType)
        {
            printGenericArguments((ParameterizedType) genericProductSuperClass);
        }
    }

    /*
    * @description: 打印所有实例化的泛型参数
    */
    private void printGenericArguments(ParameterizedType genericProductSuperClass) {
        ParameterizedType parameterizedType = genericProductSuperClass;
        final Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        for (Type actualTypeArgument : actualTypeArguments) {
            System.out.println(actualTypeArgument);
        }
    }
}
