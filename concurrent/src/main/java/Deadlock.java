import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Deadlock {

    static final Predicate<String> test = s -> s.length() > 1;

    static class Never {
        static final List<String> list = List.of("a", "aa", "aaa");
        static final long count = list.parallelStream()
                .filter(test)
                .count();
    }


    public static void main(String[] args) {
        System.out.println(Never.count);
        List<Integer> a = new ArrayList<>(), b = a;
        System.out.println(b);
    }
}
