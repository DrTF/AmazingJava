public class CharTets {



    interface B {
        void b();
        void bb();
    }

    private static void test(){

        class A implements B {
            void a(){
                System.out.println(123);
            }

            @Override
            public void b() {
                System.out.println("a");
            }

            @Override
            public void bb() {
                System.out.println("aa");
            }
        }

       B b = new B() {
           @Override
           public void b() {
               System.out.println("b");
           }

           @Override
           public void bb() {
               System.out.println("bb");

           }
       };

//        b.b();
    }


    public static void main(String[] args) {


        System.out.println(1|1021|3);
    }
}
