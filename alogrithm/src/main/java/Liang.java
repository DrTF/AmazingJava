import org.apache.commons.collections4.MapUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Liang {
    public static void main(String[] args) {
        Map<String, String> orgIds = new HashMap(){{
            put("a","a");
            put("b","b");
            put("c","c");
            put("d","d");
            put("e","a");
        }};
        Map<String, Integer> map = new TreeMap<>();
        for (Map.Entry<String,String> entry : orgIds.entrySet()){
             map.merge(entry.getValue(), 1, (a, b) -> a+b);
        }
        MapUtils.debugPrint(System.out,null,map);
    }
}
