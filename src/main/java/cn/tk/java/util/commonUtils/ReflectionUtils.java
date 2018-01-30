package cn.tk.java.util.commonUtils;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description
 */
@Slf4j
public class ReflectionUtils {
	/**
	 * 获取父类的方法类型
	 *
	 * @param clazz
	 *            类
	 * @param index
	 *            第index参数，从0开始
	 * @return 返回父类第index个泛型类型
	 */

	@SuppressWarnings("rawtypes")
	public static Class getSuperClassGenericType(final Class clazz,
												 final int index)
	{
		Type genType = clazz.getGenericSuperclass();
		if (!(genType instanceof ParameterizedType)) {
			return Object.class;
		}

		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();

		if (index >= params.length || index < 0) {
			return Object.class;
		}
		if (!(params[index] instanceof Class)) {
			return Object.class;
		}

		return (Class) params[index];
	}

	/**
	 * 获取父类的第一个方法类型
	 * 
	 * @param clazz
	 *            类
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static Class getSuperClassGenericType(final Class clazz) {
		return getSuperClassGenericType(clazz, 0);
	}

	/**
	 * 执行一个方法
	 * 
	 * @param className
	 *            类名
	 * @param methodName
	 *            方法名 可能是私有方法，或者父类方法
	 * @param args
	 *            参数
	 * @return
	 */
	public static Object invokeMethod(String className, String methodName,
			Object... args) throws ClassNotFoundException
	{
		Object obj = null;
		try {
			obj = Class.forName(className).newInstance();
			return invokeMethod(obj, methodName, args);
		} catch (InstantiationException e) {
			log.error("reflection error", e);
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			log.error("reflection error", e);
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 执行一个方法
	 * 
	 * @param obj
	 *            对象
	 * @param methodName
	 *            方法名 可能是私有方法，或者父类方法
	 * @param args
	 *            参数
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static Object invokeMethod(Object obj, String methodName,
			Object... args)
	{
		Class[] parameterTypes = new Class[args.length];
		for (int i = 0; i < parameterTypes.length; i++) {
			parameterTypes[i] = args[i].getClass();
		}

		Method method = getDeclaredMethod(obj.getClass(), methodName,
				parameterTypes);
		method.setAccessible(true);// 通过反射执行私有方法
		try {
			return method.invoke(obj, args);

		} catch (IllegalArgumentException e) {
			log.error("reflection error", e);
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			log.error("reflection error", e);
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			log.error("reflection error", e);
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取一个clazz的方法，包括父类的私有方法
	 * 
	 * @param className
	 *            全类名
	 * @param methodName
	 *            方法名
	 * @param parameterTypes
	 *            参数类型
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static Method getDeclaredMethod(String className, String methodName,
			Class... parameterTypes)
	{
		Class clazz;
		try {
			clazz = Class.forName(className);
			return getDeclaredMethod(clazz, methodName, parameterTypes);
		} catch (ClassNotFoundException e) {
			log.error("reflection error", e);
		}
		return null;
	}

	/**
	 * 获取一个clazz的方法，包括父类的私有方法
	 * 
	 * @param clazz
	 * @param methodName
	 * @param parameterTypes
	 * @return
	 */
	@SuppressWarnings(
		{ "rawtypes", "unchecked" })
	public static Method getDeclaredMethod(Class clazz, String methodName,
			Class... parameterTypes)
	{
		Method method = null;
		for (; clazz != Object.class; clazz = clazz.getSuperclass()) {
			try {
				method = clazz.getDeclaredMethod(methodName, parameterTypes);
			} catch (Exception e) {

			}
		}
		return method;
	}

	/**
	 * 获取一个类的特定的域
	 * 
	 * @param className
	 *            全类名
	 * @param fieldName
	 *            域名
	 * @return 域
	 */
	@SuppressWarnings("rawtypes")
	public static Field getDeclaredField(String className, String fieldName) {
		try {
			Class clazz = Class.forName(className);
			return getDeclaredField(clazz, fieldName);
		} catch (ClassNotFoundException e) {
			log.error("reflection error", e);
		}
		return null;
	}

	/**
	 * 获取一个类的所有域
	 * 
	 * @param clazz
	 * @return
	 */
	public static Field[] getDeclaredFields(final Class<?> clazz) {
		List<Field> fields = new ArrayList<Field>();
		for (Class<?> type = clazz; type != Object.class; type = type
				.getSuperclass())
		{
			fields.addAll(Arrays.asList(type.getDeclaredFields()));
		}
		return fields.toArray(new Field[fields.size()]);
	}

	/**
	 * 获取一个类的域
	 * 
	 * @param clazz
	 *            类
	 * @param fieldName
	 *            域名
	 * @return 域
	 */
	@SuppressWarnings("rawtypes")
	public static Field getDeclaredField(Class clazz, String fieldName) {
		Field field = null;
		for (; clazz != Object.class; clazz = clazz.getSuperclass()) {
			try {
				field = clazz.getDeclaredField(fieldName);
			} catch (Exception e) {
			}
		}
		return field;
	}

	/**
	 * @param className
	 *            全类名
	 * @param fieldName
	 *            域名
	 * @param val
	 *            域的属性值
	 */
	@SuppressWarnings("rawtypes")
	public static void setFieldValue(String className, String fieldName,
			Object val)
	{
		Class clazz;
		Object obj;
		try {
			clazz = Class.forName(className);
			obj = clazz.newInstance();
			setFieldValue(obj, fieldName, val);
		} catch (ClassNotFoundException e) {
			log.error("reflection error", e);
			e.printStackTrace();
		} catch (InstantiationException e) {
			log.error("reflection error", e);
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			log.error("reflection error", e);
			e.printStackTrace();
		}
	}

	/**
	 * @param obj
	 *            类的对象
	 * @param fieldName
	 *            域名
	 * @param val
	 *            域的属性值
	 */
	public static void setFieldValue(Object obj, String fieldName, Object val) {
		Field field = getDeclaredField(obj.getClass(), fieldName);
		try {
			setFieldValue(obj, field, val);
		} catch (IllegalArgumentException e) {
			log.error("reflection error", e);
		}
	}

	/**
	 * @param obj
	 *            类的对象
	 * @param field
	 *            域
	 * @param val
	 *            域的属性值
	 */
	public static void setFieldValue(Object obj, Field field, Object val) {
		field.setAccessible(true);
		try {
			field.set(obj, val);
		} catch (IllegalArgumentException e) {
			log.error("reflection error", e);
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			log.error("reflection error", e);
			e.printStackTrace();
		}
	}

	/**
	 * @param className
	 *            全类名
	 * @param fieldName
	 *            域名
	 * @return 域的属性值
	 */
	public static Object getFieldValue(String className, String fieldName) {
		Object obj;
		try {
			obj = Class.forName(className).newInstance();
			return getFieldValue(obj, fieldName);
		} catch (InstantiationException e) {
			log.error("reflection error", e);
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			log.error("reflection error", e);
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			log.error("reflection error", e);
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @param obj
	 *            类的对象
	 * @param fieldName
	 *            域名
	 * @return 域的属性值
	 */
	public static Object getFieldValue(Object obj, String fieldName) {
		Field field = getDeclaredField(obj.getClass(), fieldName);
		try {
			return getFieldValue(obj, field);
		} catch (IllegalArgumentException e) {
			log.error("reflection error", e);
		}
		return null;
	}

	/**
	 * @param obj
	 *            类的对象
	 * @param field
	 *            域
	 * @return 域的属性值
	 */
	public static Object getFieldValue(Object obj, Field field) {
		field.setAccessible(true);
		try {
			return field.get(obj);
		} catch (IllegalArgumentException e) {
			log.error("reflection error", e);
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			log.error("reflection error", e);
			e.printStackTrace();
		}
		return null;
	}

	public static Type getParameterUpperBound(int index, ParameterizedType type) {
		Type[] types = type.getActualTypeArguments();
		if (index < 0 || index >= types.length) {
			throw new IllegalArgumentException(
					"Index " + index + " not in range [0," + types.length + ") for " + type);
		}
		Type paramType = types[index];
		if (paramType instanceof WildcardType) {
			return ((WildcardType) paramType).getUpperBounds()[0];
		}
		return paramType;
	}

	/**
	 * Description：获取声明此参数化类型的类
	 */
	public static Class<?> getRawType(Type type) {
		if (type instanceof Class<?>) {
			// Type is a normal class.
			return (Class<?>) type;
		}
		if (type instanceof ParameterizedType) {
			ParameterizedType parameterizedType = (ParameterizedType) type;

			// I'm not exactly sure why getRawType() returns Type instead of Class. Neal isn't either but
			// suspects some pathological case related to nested classes exists.
			Type rawType = parameterizedType.getRawType();
			if (!(rawType instanceof Class)) throw new IllegalArgumentException();
			return (Class<?>) rawType;
		}
		if (type instanceof GenericArrayType) {
			Type componentType = ((GenericArrayType) type).getGenericComponentType();
			return Array.newInstance(getRawType(componentType), 0).getClass();
		}
		if (type instanceof TypeVariable) {
			// We could use the variable's bounds, but that won't work if there are multiple. Having a raw
			// type that's more general than necessary is okay.
			return Object.class;
		}
		if (type instanceof WildcardType) {
			return getRawType(((WildcardType) type).getUpperBounds()[0]);
		}

		throw new IllegalArgumentException("Expected a Class, ParameterizedType, or "
				+ "GenericArrayType, but <" + type + "> is of type " + type.getClass().getName());
	}
}
