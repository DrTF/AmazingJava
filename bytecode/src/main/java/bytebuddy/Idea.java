package bytebuddy;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static java.util.concurrent.CompletableFuture.supplyAsync;

public class Idea {

    private static int state = 0;

    public static void main(final String[] args) throws ExecutionException, InterruptedException {
//        modifyStateBasedOnParameter(state);
//        modifyStateBasedOnStaticField();
        asyncExample();
    }

    // dropping frame within this method,
    // and executing again will print state = 2
    private static void modifyStateBasedOnStaticField()
    {
        state++;
        System.out.println("state = " + state);
    }

    // dropping frame from within this method,
    // and executing again will print state = 1
    private static void modifyStateBasedOnParameter(final int parameter)
    {
        state = parameter + 1;
        System.out.println("state = " + state);
    }


    private static void asyncExample() throws InterruptedException, ExecutionException
    {
        final CompletableFuture<String> future = supplyAsync(() -> "F").thenApplyAsync(Idea::append_oo);
        System.out.println(future.get());
    }

    private  static String append_oo(String str)
    {
        return str +"oo";
    }
}
