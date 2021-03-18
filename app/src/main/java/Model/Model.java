package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Model {
    private static int coins = 0;
    public static void addCoins() {
        coins++;
    }
    public static int getCoins() {return coins;}
    private static Map<String, Integer> coinsGet = new HashMap<String, Integer>() {{
        put("c0", 0);
        put("c1", 0);
        put("g0", 0);
        put("g1", 0);
        put("g2", 0);
        put("scr", 0);
        put("spl", 0);
        put("spr", 0);
        put("str", 0);
        put("kn", 0);
        put("wr", 0);
        put("sc", 0);
        put("gh", 0);
        put("ay", 0);
//        put("au", new HashSet<>(Arrays.asList("caught")));
        put("ew", 0);
        put("oi", 0);
//        put("ow", new HashSet<>(Arrays.asList("cowboy")));
        put("ea", 0);
        put("oy", 0);
        put("ar0", 0);
        put("ar1", 0);
        put("er", 0);
        put("ir", 0);
        put("or0", 0);
        put("or1",0);
        put("ur", 0);
        put("a", 0);
        put("e", 0);
        put("i", 0);
        put("o", 0);
        put("u", 0);
    }};
    public static int getCoinsFromMap(String key) {
        return coinsGet.get(key);
    }
    public static void setCoinsFromMap(String key, int add) {
        coinsGet.put(key, coinsGet.get(key) + add);
    }

    public static Map<String, ArrayList<Integer>> puzzleEarned = new HashMap<String, ArrayList<Integer>>() {{
        put("c0", new ArrayList<>());
        put("c1", new ArrayList<>());
        put("g0", new ArrayList<>());
        put("g1", new ArrayList<>());
        put("g2", new ArrayList<>());

        put("scr", new ArrayList<>());
        put("spl", new ArrayList<>());
        put("spr", new ArrayList<>());
        put("str", new ArrayList<>());

        put("gh", new ArrayList<>());
        put("kn", new ArrayList<>());
        put("sc", new ArrayList<>());
        put("wr", new ArrayList<>());

        put("ai", new ArrayList<>());
        put("au", new ArrayList<>());
        put("aw", new ArrayList<>());
        put("ay", new ArrayList<>());
        put("ea0", new ArrayList<>());
        put("ea1", new ArrayList<>());
        put("ee", new ArrayList<>());
        put("ew", new ArrayList<>());
        put("oa", new ArrayList<>());
        put("oi", new ArrayList<>());
        put("oo0", new ArrayList<>());
        put("oo1", new ArrayList<>());
        put("ou", new ArrayList<>());
        put("ow0", new ArrayList<>());
        put("ow1", new ArrayList<>());
        put("oy", new ArrayList<>());

        put("ar0", new ArrayList<>());
        put("ar1", new ArrayList<>());
        put("er", new ArrayList<>());
        put("ir", new ArrayList<>());
        put("or0", new ArrayList<>());
        put("or1",new ArrayList<>());
        put("ur", new ArrayList<>());

        put("a", new ArrayList<>());
        put("e", new ArrayList<>());
        put("i", new ArrayList<>());
        put("o", new ArrayList<>());
        put("u", new ArrayList<>());
    }};
}
