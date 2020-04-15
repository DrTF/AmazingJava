import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Stream;

public class AmazingJDKStream {



}

/***
 *
 *   stream error handle
 */
class Utils{

    private Stream<Double> buildStream() {
        return new Random().doubles().boxed();
    }

    private Double expensiveComputation(Double input) {
        if (input > 0.8) throw new RuntimeException("Data processing exception");
        return input / 2;
    }

    public Stream<Double> stream() {
        ArrayList<Object> list = new ArrayList<>();
        return buildStream().map(this::expensiveComputation).onClose(()-> System.out.println("Releasing resources…"));
    }

}
