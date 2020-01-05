package defaultInterface;

public interface ITest_2 {

    static void test(){
        System.out.println("static test2");
    }

    int a = 2;

    default void testDefault(){
        System.out.println("test default2");
    }

}
