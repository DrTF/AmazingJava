public class TestSync {


    private Object object = new Object();

    private void testObj(){
        synchronized (object){
            System.out.println(1);
        }
    }


    private byte[] bytes = {0};
    private void testByte(){
        synchronized (bytes){
            System.out.println(2);
        }
    }

    public static void main(String[] args) {
        System.out.println(1);
    }
}
