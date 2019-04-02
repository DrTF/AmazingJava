import net.bramp.unsafe.UnsafeHelper;
import org.junit.Test;
import sun.reflect.ReflectionFactory;

import java.lang.reflect.Constructor;

import static org.junit.Assert.assertEquals;

public class TestUnsafe {

    class ClassWithExpensiveConstructor {

        private final int value;

        private ClassWithExpensiveConstructor() {
            value = doExpensiveLookup();
        }

        private int doExpensiveLookup() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1;
        }

        public int getValue() {
            return value;
        }
    }


    @Test
    public void testObjectCreation() throws Exception {
        ClassWithExpensiveConstructor instance = (ClassWithExpensiveConstructor)
                UnsafeHelper.getUnsafe().allocateInstance(ClassWithExpensiveConstructor.class);
        assertEquals(0, instance.getValue());
    }

    @Test
    public void testReflectionFactory() throws Exception {
        @SuppressWarnings("unchecked")
        Constructor<ClassWithExpensiveConstructor> silentConstructor = (Constructor<ClassWithExpensiveConstructor>) ReflectionFactory.getReflectionFactory()
                .newConstructorForSerialization(ClassWithExpensiveConstructor.class, Object.class.getConstructor());
        silentConstructor.setAccessible(true);
        assertEquals(0, silentConstructor.newInstance().getValue());
    }


    public static class OtherClass {

        private final int value;
        private final int unknownValue;

        private OtherClass() {
            System.out.println("test");
            this.value = 10;
            this.unknownValue = 20;
        }
    }

    @Test
    public void testStrangeReflectionFactory() throws Exception {
        @SuppressWarnings("unchecked")
        Constructor<ClassWithExpensiveConstructor> silentConstructor = (Constructor<ClassWithExpensiveConstructor>) ReflectionFactory.getReflectionFactory()
                .newConstructorForSerialization(ClassWithExpensiveConstructor.class,
                        OtherClass.class.getDeclaredConstructor());
        silentConstructor.setAccessible(true);
        ClassWithExpensiveConstructor instance = silentConstructor.newInstance();
        assertEquals(10, instance.getValue());
        assertEquals(ClassWithExpensiveConstructor.class, instance.getClass());
        assertEquals(Object.class, instance.getClass().getSuperclass());
    }

}
