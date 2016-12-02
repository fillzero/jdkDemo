package newProperty.functional.lambda;

import java.util.function.Consumer;

/*
* @date: 2016/12/2
* @author: lijl85
* @mail: ljldeepinit@163.com
* @description: Lambda 表达式访问内部变量
*/
public class LambdaScopeTest {

    public int x = 0;

    class FirstLevel {

        public int x = 1;

        /*
        * @description: x 不允许修改, 默认为 final 类型的, 内部类方法访问外部类局部变量, 必须为 final 类型的
        */
        void methodInFirstLevel(final int x) {

            // The following statement causes the compiler to generate
            // the error "local variables referenced from a lambda expression
            // must be final or effectively final" in statement A:
            //
            // x = 99;

            Consumer<Integer> myConsumer = (y) ->
            {
                y = 100;
                System.out.println("x = " + x); // 内部类局部变量
                System.out.println("y = " + y);//
                System.out.println("this.x = " + this.x);//内部类全局变量
                System.out.println("LambdaScopeTest.this.x = " + LambdaScopeTest.this.x);//外部类全局变量
            };

            myConsumer.accept(x);

        }
    }

    public static void main(String... args) {
        LambdaScopeTest st = new LambdaScopeTest();
        LambdaScopeTest.FirstLevel fl = st.new FirstLevel();
        fl.methodInFirstLevel(23);
    }
}
