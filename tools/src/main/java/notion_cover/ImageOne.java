package notion_cover;

import sun.swing.SwingUtilities2;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImageOne {


    public static int getLength(String text) {
        int length = 0;
        for (int i = 0; i < text.length(); i++) {
            if (new String(text.charAt(i) + "").getBytes().length > 1) {
                length += 2;
            } else {
                length += 1;
            }
        }
        return length / 2;
    }

    public static String TextToPic(String text, int width, int height,int fontSize) {
        try {
            String filepath = "C:\\Users\\10200\\Desktop\\Notion Cover\\" + text + ".png";
            File file = new File(filepath);
            System.out.println("topic=" + text);
            System.out.println("path=" + filepath);
            Font font = new Font("微软雅黑", Font.CENTER_BASELINE, fontSize);
            BufferedImage bi = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);
            Graphics2D g2 = (Graphics2D) bi.getGraphics();
            g2.setBackground(ColorHelper.generateColor());
            g2.clearRect(0, 0, width, height);
            g2.setFont(font);
            g2.setPaint(Color.BLACK);
            g2.setColor(Color.BLACK);
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,0.2f));
            g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            printString(g2, text, (width - (text.length() * fontSize)) / 2 ,(height - fontSize) / 2 + 40, fontSize);
            g2.dispose();
            ImageIO.write(bi, "png", file);
            return "image" + text + ".png";

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    private static void printString(Graphics2D g2d, String str, int x, int y,int fontSize) {
        FontMetrics metrics = SwingUtilities2.getFontMetrics(null,g2d.getFont());
        for (char ca : str.toCharArray()) {
            int px = metrics.stringWidth("" + ca);
            g2d.drawString("" + ca, x + (fontSize - px) / 2, y);
            x += fontSize;
        }
    }

    public static void main(String[] args){
        String title = null != args && args.length > 0 ?  args[0] : "default";
        TextToPic(title, 1500, 500, 80);

        System.out.println("used with: java -jar tools.jar \"${title}\" ");
    }

}
