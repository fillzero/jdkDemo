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

    // 泛型定义通用的工具
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

    // 实例化工具（参数化泛型）
    public class UserDao extends BaseDao<User>{

    }

    // 实例化工具（未参数化泛型）
    public class ProductDao extends BaseDao{

    }

    public void test()
    {
        UserDao userDao = new UserDao();
        User user = userDao.get();
    }

    /*
     * @description: 实现泛型参数化
     */
    @Test
    public void testUserDao(){
        // 获取带参数化信息的父类 BaseDao<User>（UserDao 等价于 BaseDao<User>）
        // 这一步定义完成了实例化，通过反射可以获取到 BaseDao 的实例化参数
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

    @Test
    public void testGenericDeclaration()
    {
        // 获取带参数化信息的父类 BaseDao<User>
        final Type genericSuperclass = UserDao.class.getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType)genericSuperclass;

        // 获取声明此参数化类型的类（父类）
        final Type rawType = parameterizedType.getRawType();

        // 获取声明此参数化类型的类的参数
        final Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();

        System.out.println(rawType);
        System.out.println(actualTypeArguments);
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
