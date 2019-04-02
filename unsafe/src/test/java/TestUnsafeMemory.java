import net.bramp.unsafe.UnsafeHelper;
import org.junit.Test;
import sun.misc.Unsafe;

import static org.junit.Assert.assertEquals;

public class TestUnsafeMemory {

    Unsafe unsafe = UnsafeHelper.getUnsafe();

    class DirectIntArray {

        private final static long INT_SIZE_IN_BYTES = 1;

        private final long startIndex;

        public DirectIntArray(long size) throws InterruptedException {
            startIndex = unsafe.allocateMemory(size * INT_SIZE_IN_BYTES);
            unsafe.setMemory(startIndex, size * INT_SIZE_IN_BYTES, (byte) 0);
            Thread.sleep(5000);
        }

        public void setValue(long index, int value) {
            unsafe.putInt(index(index), value);
        }

        public int getValue(long index) {
            return unsafe.getInt(index(index));
        }

        private long index(long offset) {
            return startIndex + offset * INT_SIZE_IN_BYTES;
        }

        public void destroy() {
            unsafe.freeMemory(startIndex);
        }
    }

    @Test
    public void testDirectIntArray() throws Exception {
        long maximum = Integer.MAX_VALUE + 1L;
        DirectIntArray directIntArray = new DirectIntArray(maximum);
        directIntArray.setValue(0L, 10);
        directIntArray.setValue(maximum, 20);
        assertEquals(10, directIntArray.getValue(0L));
        assertEquals(20, directIntArray.getValue(maximum));
        directIntArray.destroy();

    }

}
