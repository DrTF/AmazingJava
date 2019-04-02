package notion_cover;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.apache.commons.io.IOUtils;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class ColorHelper {

    @Getter
    @Setter
    @Accessors(chain = true)
    static class RGB {
        @JSONField(name = "red")
        int red;
        @JSONField(name = "green")
        int green;
        @JSONField(name = "blue")
        int blue;
    }

    static List<RGB> list = new ArrayList<RGB>();

    static {
        try {
            FileInputStream stream = new FileInputStream("D:\\github\\AmazingJava\\tools\\src\\main\\resources\\palette.json");
            String jsonString = IOUtils.toString(stream, "utf-8");
            JSONObject jsonObject = JSON.parseObject(jsonString);
            JSONArray colors = jsonObject.getJSONArray("colors");
            for (int i = 0; i < colors.size(); i++) {
                RGB rgba = colors.getObject(i, RGB.class);
                list.add(rgba);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Color generateColor() {
        Collections.shuffle(list);
        RGB rgba = list.get(0);
        return new Color(rgba.getRed(), rgba.getGreen(), rgba.getBlue());
    }
}
