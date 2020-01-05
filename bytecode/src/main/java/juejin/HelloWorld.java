package juejin;

public class HelloWorld {

    private static int test(){
        int x = 0;
        try {
            return x;
        }finally {
            x=2;
            return x;
        }
    }

    public static void main(String[] args) {
        Runtime.getRuntime().traceMethodCalls(true);
        Runtime.getRuntime().halt(1);
        System.out.println(test());
        System.out.println("Hello World");
    }
}
