package invokedynamic;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class UseCase {

    static int count(String name) {
        return name.length();
    }

    public static void main(String[] args) {
        // 明确方法签名： 返回值类型, 参数类型
        MethodType methodType = MethodType.methodType(int.class, new Class[]{String.class});
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodHandle methodHandle = null;
        try {
            // class,  method , methodType
            methodHandle = lookup.findStatic(UseCase.class, "count", methodType);
        } catch (NoSuchMethodException | IllegalAccessException e) {
            e.printStackTrace();
        }
        try {
            // 1. 参数类型不一致, java.lang.invoke.WrongMethodTypeException: expected (String)int but found (int)int
            //int hulj = (int) methodHandle.invokeExact(1234);

            // 2. 返回值不一致, java.lang.invoke.WrongMethodTypeException: expected (String)int but found (String)String
            //String hulj =  (String) methodHandle.invokeExact("1234");

            //3. 也不行
            //Integer hulj = (Integer) methodHandle.invokeExact("1234");
            //4.
            //int hulj = (int) methodHandle.invokeExact((Object)"1234");
            //5.
            //int hulj = (Integer) methodHandle.invokeExact("1234");

            int hulj = (int) methodHandle.invokeExact("1234");
            // true
            System.out.println(hulj);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
