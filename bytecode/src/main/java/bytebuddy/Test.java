package bytebuddy;

public class Test {
    public static void main(String[] args) {
        try {
            int a = 2 / 0;

            System.out.println("1");
        }catch (Exception e){
            System.out.println("11");

        }finally {
            System.out.println("111");
        }
    }
}
