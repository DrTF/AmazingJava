package invokedynamic;

import java.lang.invoke.MethodHandles;

public class Example {
    void doSomeThing(){
        /**
         *  1. methodHandle 不能直接实例化, 需要借助lookup() 工厂方法
         *
         *  2. lookup() 会创建security context, 确保
         *      - lookup实例只能加载调用lookup()的类的本地方法
         *      , 如 lookupVisitable()
         *      - 不能调用当前class以外的方法
         *
         */
        MethodHandles.Lookup lookup = MethodHandles.lookup();
    }

    void lookUpVisible(){
        //
    }
}
