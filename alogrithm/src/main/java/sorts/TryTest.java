package sorts;

import java.io.*;

public class TryTest {

    private void a(){
        try {
            BufferedInputStream stream = new BufferedInputStream(new FileInputStream("123.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void b(){
        try(BufferedInputStream stream = new BufferedInputStream(new FileInputStream("123.txt"))){

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }
}
