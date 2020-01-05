import org.junit.Test;

public class TestLoop {

    @Test
    public void test() throws InterruptedException {
        int i = 0;
        while (i < 3) {
            i++;
            System.out.println(i);
            Thread.sleep(1000L);
        }
        // 会一直执行。run 100%
        while (i < 4) ;
    }
}
