package Model;


import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Model {
    private static int coins = 0;
    public static void addCoins(int add) {
        coins = coins + add;
    }
    public static int getCoins() {return coins;}
    public static void visit(String lesson) {visited.put(lesson, true);}
    public static boolean visited(String lesson) {return visited.get(lesson);}

    public static int getGoldStarCount(String lesson) {return stars.get(lesson)[0];}
    public static int getSilverStarCount(String lesson) {return stars.get(lesson)[1];}
    public static void addGoldStar(String lesson) {
        if (stars.get(lesson)[1] > 0) {
            stars.get(lesson)[1]--;
            stars.get(lesson)[0]++;
        } else {
            stars.get(lesson)[0]++;
        }
    }
    public static void toSilverStar(String lesson) {
        if (stars.get(lesson)[0] != 0) {
            stars.get(lesson)[1] = stars.get(lesson)[0];
            stars.get(lesson)[0] = 0;
        }
    }

    public static void setGoldStar(String lesson, int amount) {
        stars.get(lesson)[0] = amount;
    }
    public static void setSilverStar(String lesson, int amount) {
        stars.get(lesson)[1] = amount;
    }

    private static Map<String, Boolean> visited = new HashMap<String, Boolean>() {{
        put("c0", false);
        put("c1", false);
        put("g0", false);
        put("g1", false);
        put("g2", false);

        put("scr", false);
        put("spl", false);
        put("spr", false);
        put("str", false);

        put("gh", false);
        put("kn", false);
        put("sc", false);
        put("wr", false);

        put("ai", false);
        put("au", false);
        put("aw", false);
        put("ay", false);
        put("ea0", false);
        put("ea1", false);
        put("ee", false);
        put("ew", false);
        put("oa", false);
        put("oi", false);
        put("oo0", false);
        put("oo1", false);
        put("ou", false);
        put("ow0", false);
        put("ow1", false);
        put("oy", false);

        put("ar0", false);
        put("ar1", false);
        put("er", false);
        put("ir", false);
        put("or0", false);
        put("or1", false);
        put("ur", false);

        put("a", false);
        put("e", false);
        put("i", false);
        put("o", false);
        put("u", false);
    }};

    private static Map<String, int[]> stars = new HashMap<String, int[]>() {{
        put("c0", new int[2]);
        put("c1", new int[2]);
        put("g0", new int[2]);
        put("g1", new int[2]);
        put("g2", new int[2]);

        put("scr", new int[2]);
        put("spl", new int[2]);
        put("spr", new int[2]);
        put("str", new int[2]);

        put("gh", new int[2]);
        put("kn", new int[2]);
        put("sc", new int[2]);
        put("wr", new int[2]);

        put("ai", new int[2]);
        put("au", new int[2]);
        put("aw", new int[2]);
        put("ay", new int[2]);
        put("ea0", new int[2]);
        put("ea1", new int[2]);
        put("ee", new int[2]);
        put("ew", new int[2]);
        put("oa", new int[2]);
        put("oi", new int[2]);
        put("oo0", new int[2]);
        put("oo1", new int[2]);
        put("ou", new int[2]);
        put("ow0", new int[2]);
        put("ow1", new int[2]);
        put("oy", new int[2]);

        put("ar0", new int[2]);
        put("ar1", new int[2]);
        put("er", new int[2]);
        put("ir", new int[2]);
        put("or0", new int[2]);
        put("or1",new int[2]);
        put("ur", new int[2]);

        put("a", new int[2]);
        put("e", new int[2]);
        put("i", new int[2]);
        put("o", new int[2]);
        put("u", new int[2]);
    }};


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

        put("ai", 0);
        put("au", 0);
        put("aw", 0);
        put("ay", 0);
        put("ea0", 0);
        put("ea1", 0);
        put("ee", 0);
        put("ew", 0);
        put("oa", 0);
        put("oi", 0);
        put("oo0", 0);
        put("oo1", 0);
        put("ou", 0);
        put("ow0", 0);
        put("ow1", 0);
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
