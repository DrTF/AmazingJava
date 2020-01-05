package defaultInterface;

public interface ITest_1 {

    static void test(){
        System.out.println("static test1");
    }

    int a = 1;

    default void testDefault(){
        System.out.println("test default1");
    }

}
