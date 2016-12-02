package newProperty.functional.lambda;

import java.util.function.Consumer;

import static java.lang.System.*;

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
       * @description: 匿名类/Lambda 访问外部变量: 外部变量必须要声明成 final 类型的
       */
        void methodInFirstLevel(final int x) {

            // The following statement causes the compiler to generate
            // the error "local variables referenced from a lambda expression
            // must be final or effectively final" in statement A:
            //
            // x = 99;

            Consumer<Integer> myConsumer = (y) ->
            {
                y = 50;
                out.println("x = " + x);
                out.println("y = " + y);
                out.println("this.x = " + this.x);
                out.println("LambdaScopeTest.this.x = " + LambdaScopeTest.this.x);
            };
            myConsumer.accept(x);
        }

        /*
        * @description: 匿名类使用局部变量, x 的值不可以改变
        */
        void methodInFirstLevelAnony(final int x)
        {
            Consumer <Integer> anonyConsumer = new Consumer<Integer>() {
                @Override
                public void accept(Integer y) {
                    y = 60;
                    out.println("x = " + x);
                    out.println("y = " + y);
                    //out.println("this.x = " + this.x);//匿名内部类访问不到外部类的成员
                    out.println("LambdaScopeTest.this.x = " + LambdaScopeTest.this.x);
                }
            };
            anonyConsumer.accept(x);
        }
    }

    public static void main(String... args) {
        LambdaScopeTest st = new LambdaScopeTest();
        LambdaScopeTest.FirstLevel fl = st.new FirstLevel();
        fl.methodInFirstLevel(23);
        fl.methodInFirstLevelAnony(24);
    }
}
