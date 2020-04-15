import sun.misc.Unsafe;

import java.lang.reflect.Constructor;

public class TestUnsafe {

    class Test{
        private Long a;

        public Test(Long a) {
            this.a = 1L;
        }

        public Long getA() {
            return a;
        }
    }

    public static void main(String[] args) throws Throwable {

//        Field field = Unsafe.class.getDeclaredField("theUnsafe");
//        field.setAccessible(true);
//        Unsafe unsafe  = (Unsafe) field.get(null);
//
//        //1. initialization obj
//
//        Test o3 = (Test) unsafe.allocateInstance(Test.class);
//
//        System.out.println(o3.getA());

//        Unsafe unsafe = Unsafe.getUnsafe();

//        MethodHandles.Lookup lookup = MethodHandles.lookup();
//        MethodHandle handle = lookup.findStatic(Unsafe.class, "getUnsafe", MethodType.methodType(Unsafe.class));
//        Unsafe invoke = (Unsafe)handle.invoke();
//        System.out.println(invoke);


        Constructor<Unsafe> unsafeConstructor = Unsafe.class.getDeclaredConstructor();
        unsafeConstructor.setAccessible(true);
        Unsafe unsafe = unsafeConstructor.newInstance();

        System.out.println(unsafe);
    }
}
