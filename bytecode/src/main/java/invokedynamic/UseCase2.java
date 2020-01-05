package invokedynamic;

import java.lang.invoke.ConstantCallSite;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class UseCase2 {
    String value;
    void print(String x) {
        System.out.println(x);
    }

    public static void main(String[] args) throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();

        MethodHandle fieldHandle = lookup.findSetter(UseCase2.class, "value", String.class);
        MethodType methodType = MethodType.methodType(void.class, new Class<?>[] {String.class});
        MethodHandle methodHandle = lookup.findVirtual(UseCase2.class, "print", methodType);

        UseCase2 case2 = new UseCase2();

        methodHandle.invokeExact(case2,"1");

    }
}
