package cn.tk.java.innerClass.selector;

/**
 * @author: lijl85
 * @date：2016年11月3日下午10:50:39
 * @description:内部类拥有外部类所有元素的访问权
 * 常用技巧: 外部类的方法返回内部类的引用, 内部类向上转型, 返回值类型是内部类实现的的接口
 * 
 * 目的: 用内部类机制实现简单迭代器 
 * 如果当前 Sequence 还有元素, 就继续迭代并且打印, Sequence 内部是 Object 数组
 * 
 * 总结: 用到了 "迭代器" 设计模式
 */
public class Sequence {

}
