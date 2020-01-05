package juejin;

import com.google.common.collect.MapMaker;

public class TestFor {
    class Test {
        int anInt = 0;
    }

    public static int[] numbers = new int[]{1, 2, 3};

    public static void main(String[] args) {
//        for (int number : numbers) {
//            System.out.println(number);
//        }
        System.out.println(System.nanoTime());
        System.out.println((long)-999999999/1000000);


        System.out.println(normalizeTicksPerWheel(13));
        System.out.println(normalizeTicksPerWheel(9));
        System.out.println(normalizeTicksPerWheel(129));
        System.out.println(normalizeTicksPerWheel(128));
        System.out.println(normalizeTicksPerWheel(256));

//        new MapMaker().concurrencyLevel(1).makeMap()
    }

    private static int normalizeTicksPerWheel(int ticksPerWheel) {
        int normalizedTicksPerWheel = 1;
        while (normalizedTicksPerWheel < ticksPerWheel) {
            normalizedTicksPerWheel <<= 1;
        }
        return normalizedTicksPerWheel;
    }
}
