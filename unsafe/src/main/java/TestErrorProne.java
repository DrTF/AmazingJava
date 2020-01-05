import java.lang.invoke.MethodHandles;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class TestErrorProne {

    public static void main(String[] args) {

        Set<Short> s = new HashSet<>();
        for (short i = 0; i < 100; i++) {
            s.add(i);
            s.remove(i - 1);
        }
        System.out.println(s.size());

//        AtomicReferenceFieldUpdater

//        MethodHandles.lookup().findVirtual()

    }
}
