package newProperty.functional.lambda;

/*
* @date: 2016/12/2
* @author: lijl85
* @mail: ljldeepinit@163.com
* @description: 探索研究为什么匿名类访问方法内的局部变量必须声明为 final 类型的
* 背景: 匿名类一般被定义在一个方法内部, 用于隐式的实现一个接口, 并且返回一个接口类型的实例
*/
public class OuterClass {

    interface IInterface{
        public void function();
    }

    /*
    * @description: 编译后 localVar 会成为匿名类的局部成员:
    * 匿名类是一个闭包, 对创建它的上下文存在引用, 所以理所当然的可以访问创建它的方法的局部变量,
    * 这种想法是合理的, 但是技术上没有办法实现.
    *
    * 匿名内部类中使用的 localVar 相当于是局部变量 localVar 的一个 copy, 两个变量必须始终保持一致性,
    * 所以为了避免修改带来的不一致, 只有将变量设置成 final 类型的, 也是无奈之举, 只为保证两个不同变量的一致性.
    */
    public IInterface functionImpl(String localVar)
    {
//        String localVar = "abc";
        return new IInterface() {
            @Override
            public void function() {
                System.out.println(localVar);
            }
        };
    }

    /*
    * @description: 编译后的结果
    *
    */
//    package newProperty.functional.lambda;
//    import java.io.PrintStream;
//    class OuterClass$1
//            implements OuterClass.IInterface
//    {
//        OuterClass$1(OuterClass this$0, String paramString) {}
//        public void function()
//        {
//            System.out.println(this.val$localVar);
//        }
//    }

}
