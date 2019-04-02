import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;

public class TestUrl {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        HashSet set = new HashSet();
        set.add(new URL("http://google.com"));
        System.out.println(set.contains(new URL("http://google.com")));
        Thread.sleep(60000);
        System.out.println(set.contains(new URL("http://google.com")));
    }
}
