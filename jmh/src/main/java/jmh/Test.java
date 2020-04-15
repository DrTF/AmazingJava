package jmh;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.infra.Blackhole;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class Test {

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.MINUTES)
    public void test(Blackhole blackhole){
        int a = 1;
        int b = 2;
        int sum = a + b;

        blackhole.consume(sum);
    }


    public Iterator hh(){

        class HH implements Iterator {
            public boolean hasNext() {
                return false;
            }

            public Object next() {
                return null;
            }

            public void remove() {

            }

        }

        return new HH();
    }

}
