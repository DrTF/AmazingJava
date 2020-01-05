import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestCF {

    public static void main(String[] args) {

        ExecutorService e = Executors.newSingleThreadExecutor(r -> new Thread(r, "dead-pool"));
        CompletableFuture<Integer> f = CompletableFuture.supplyAsync(() -> {
            System.out.println("1: " + Thread.currentThread().getName());
            return 42;
        }, e);

        CompletableFuture<String> f2 = f.thenApplyAsync(i -> {
            try {
                Thread.sleep(10_000);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            System.out.println("2: " +Thread.currentThread().getName());
            return i.toString();
        },e);

        CompletableFuture<String> f3 = f.thenApplyAsync(i -> {
            System.out.println("3: " +Thread.currentThread().getName());
            return i.toString();
        });

        System.out.println("hhhhhhh");
//        CompletableFuture<String> f2 = f.thenApplyAsync(i -> {
//            try {
//                Thread.sleep(10_000);
//            } catch (InterruptedException e1) {
//                e1.printStackTrace();
//            }
//            System.out.println("2: " +Thread.currentThread().getName());
//            return i.toString();
//        });
//

    }
}
