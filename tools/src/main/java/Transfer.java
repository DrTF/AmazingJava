import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.zip.GZIPInputStream;

public class Transfer {
    public static void main(String[] args) throws IOException {

        URL url = new URL("https://dataplus.cn.miaozhen.com/download//analysis/output/11249/11249-4124-behavior.csv.gz");
        File destination = new File("d://a.gz");
        FileUtils.copyURLToFile(url, destination);
    }
}
