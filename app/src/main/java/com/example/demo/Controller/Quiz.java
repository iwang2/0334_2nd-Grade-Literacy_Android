package com.example.demo.Controller;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import Model.Model;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import com.example.demo.Controller.Topic;

public class Quiz extends AppCompatActivity implements View.OnClickListener {
    ImageButton quizButton;
    ImageButton repeatButton;
    Set<String> wordBank = new HashSet<>(Arrays.asList(
//            need audio for "scribble", "splendor", "kneel", "wreath", "wriggle", "ascend", "descend", "muscles", "target",
            "cake", "canary", "candy", "car", "cat", "cow", "cub", "cut",
            "balance", "celery", "face", "ice", "sauce_pan", "tricycle", "unicycle",
            "gate", "gazelle", "go_kart", "goal", "goat", "gold", "goose", "grapes",
            "bug", "dig", "dog", "flag", "frog", "hog", "plug", "wig",
            "fridge", "gingerbread_man", "giraffe", "hedge_clippers", "syringe",

            "scraper", "scratch", "scream", "screwdriver", "screws", "scrub", "scrubs",
            "splash", "splat", "splatter", "splendid", "splinter", "split", "splits",
            "sprain", "sprawl", "spray", "spread", "sprinkler", "sprinters", "sprout", "spruce",
            "straight", "straw", "streak", "street_sweeper", "string", "strings", "stripes", "strong", "structures",

            "eight", "flight", "high", "nightgown", "right", "sleigh", "straight", "tight",
            "knee", "knit", "knives", "knock", "knot", "know", "knuckles",
            "crescents", "scene", "scent", "science", "scissors",
            "wrap", "wreck", "wrenches", "wrinkle", "write", "wrong",

            "afraid", "mermaid", "nail", "paint", "rainbow", "sail", "snail", "tail",
            "caught", "haul", "gauze", "faucet",
            "saw", "hawk", "paws",
            "birthday", "jay", "play", "ray",
            "beach", "beagle", "beak", "beaver", "eat", "leaf", "read", "steal",
            "feather", "spread", "weather",
            "bee", "cheek", "feet", "freeze", "geese", "jeep", "seed", "sheep", "tree",
            "chew", "crew_cut", "flew", "blew",
            "boat", "coat", "float_", "foal", "goat", "soap", "toad", "toaster",
            "choice", "oink_oink", "coin", "point", "choice",
            "boots", "broom", "goose", "moon", "moose", "spoon", "stool", "tools", "tooth", "zoo",
            "bigfoot", "book", "cook", "cookies", "foot", "football", "hoodie", "look", "wood",
            "house", "mouth", "proud",
            "blow", "snow", "throw_",
            "owl", "cow", "town",
            "boy", "toys", "oyster",

            "arm", "barn", "cardinal", "go_kart", "harp", "stars",
            "bare", "mare", "scare", "hare",
            "dozer", "fern", "clover", "mermaid", "zipper",
            "bird", "birthday", "circle", "girl", "skirt",
            "porcupine", "corn", "hornet", "orca", "uniforms",
            "work", "gator", "mirror",
            "burn", "burrito", "burro", "hamburger",

            "afraid", "canoe", "gazelle", "oval", "panda", "sofa", "tuba", "zebra",
            "camel", "garden", "kitten", "mittens", "oven", "piglet", "rocket", "shovel",
            "artist", "gossip", "muffins_", "nostril", "pencil", "rabbit", "robin", "tennis",
            "glove", "lion", "love", "monkey", "mother", "oven", "shovel", "wagon",
            "brush", "bucket", "bug", "bus", "cut", "jump", "muzzle", "trunk"
        ));

    Map<String, Set<String>> lessonToAnswers = new HashMap<String, Set<String>>() {{
        put("c0", new HashSet<>(Arrays.asList("cake", "canary", "candy", "car", "cat", "cow", "cub", "cut")));
        put("c1", new HashSet<>(Arrays.asList("balance", "celery", "face", "ice", "sauce_pan", "tricycle", "unicycle")));
        put("g0", new HashSet<>(Arrays.asList("gate", "gazelle", "go_kart", "goal", "goat", "gold", "goose", "grapes")));
        put("g1", new HashSet<>(Arrays.asList("bug", "dig", "dog", "flag", "frog", "hog", "plug", "wig")));
        put("g2", new HashSet<>(Arrays.asList("fridge", "gingerbread_man", "giraffe", "hedge_clippers", "syringe")));

        put("scr", new HashSet<>(Arrays.asList("scraper", "scratch", "scream", "screwdriver", "screws", "scrub", "scrubs")));
        put("spl", new HashSet<>(Arrays.asList("splash", "splat", "splatter", "splendid", "splinter", "split", "splits")));
        put("spr", new HashSet<>(Arrays.asList("sprain", "sprawl", "spray", "spread", "sprinkler", "sprinters", "sprout", "spruce")));
        put("str", new HashSet<>(Arrays.asList("straight", "straw", "streak", "street_sweeper", "string", "strings", "stripes", "strong", "structures")));

        put("gh", new HashSet<>(Arrays.asList("eight", "flight", "high", "nightgown", "right", "sleigh", "straight", "tight")));
        put("kn", new HashSet<>(Arrays.asList("knee", "knit", "knives", "knock", "knot", "know", "knuckles")));
        put("sc", new HashSet<>(Arrays.asList("crescents", "scene", "scent", "science", "scissors")));
        put("wr", new HashSet<>(Arrays.asList("wrap", "wreck", "wrenches", "wrinkle", "write", "wrong")));

        put("ai", new HashSet<>(Arrays.asList("afraid", "mermaid", "nail", "paint", "rainbow", "sail", "snail", "tail")));
        put("au", new HashSet<>(Arrays.asList("caught", "haul", "gauze", "faucet")));
        put("aw", new HashSet<>(Arrays.asList("saw", "hawk", "paws")));
        put("ay", new HashSet<>(Arrays.asList("birthday", "jay", "play", "ray")));
        put("ea0", new HashSet<>(Arrays.asList("beach", "beagle", "beak", "beaver", "eat", "leaf", "read", "steal")));
        put("ea1", new HashSet<>(Arrays.asList("feather", "spread", "weather")));
        put("ee", new HashSet<>(Arrays.asList("bee", "cheek", "feet", "freeze", "geese", "jeep", "seed", "sheep", "tree")));
        put("ew", new HashSet<>(Arrays.asList("chew", "crew_cut", "flew", "blew")));
        put("oa", new HashSet<>(Arrays.asList("boat", "coat", "float_", "foal", "goat", "soap", "toad", "toaster")));
        put("oi", new HashSet<>(Arrays.asList("choice", "oink_oink", "coin", "point", "choice")));
        put("oo0", new HashSet<>(Arrays.asList("boots", "broom", "goose", "moon", "moose", "spoon", "stool", "tools", "tooth", "zoo")));
        put("oo1", new HashSet<>(Arrays.asList("bigfoot", "book", "cook", "cookies", "foot", "football", "hoodie", "look", "wood")));
        put("ou", new HashSet<>(Arrays.asList("house", "mouth", "proud")));
        put("ow0", new HashSet<>(Arrays.asList("blow", "snow", "throw_")));
        put("ow1", new HashSet<>(Arrays.asList("owl", "cow", "town")));
        put("oy", new HashSet<>(Arrays.asList("boy", "toys", "oyster")));

        put("ar0", new HashSet<>(Arrays.asList("arm", "barn", "cardinal", "go_kart", "harp", "stars")));
        put("ar1", new HashSet<>(Arrays.asList("bare", "mare", "scare", "hare")));
        put("er", new HashSet<>(Arrays.asList("dozer", "fern", "clover", "mermaid", "zipper")));
        put("ir", new HashSet<>(Arrays.asList("bird", "birthday", "circle", "girl", "skirt")));
        put("or0", new HashSet<>(Arrays.asList("porcupine", "corn", "hornet", "orca", "uniforms")));
        put("or1", new HashSet<>(Arrays.asList("work", "gator", "mirror")));
        put("ur", new HashSet<>(Arrays.asList("burn", "burrito", "burro", "hamburger")));

        put("a", new HashSet<>(Arrays.asList("afraid", "canoe", "gazelle", "oval", "panda", "sofa", "tuba", "zebra")));
        put("e", new HashSet<>(Arrays.asList("camel", "garden", "kitten", "mittens", "oven", "piglet", "rocket", "shovel")));
        put("i", new HashSet<>(Arrays.asList("artist", "gossip", "muffins_", "nostril", "pencil", "rabbit", "robin", "tennis")));
        put("o", new HashSet<>(Arrays.asList("glove", "lion", "love", "monkey", "mother", "oven", "shovel", "wagon")));
        put("u", new HashSet<>(Arrays.asList("brush", "bucket", "bug", "bus", "cut", "jump", "muzzle", "trunk")));
    }};


    int correctButtonId;
    int attempts = 0;
    boolean isTopic;
    String lessonName;
    String lastTopicName;
    String[] choices;
    LayerDrawable ld;
    Random rand;
    boolean isTouchable;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz);
        TextView question = findViewById(R.id.question);
        Intent quizIntent = getIntent();
        buttonVisibility();
        rand = new Random();
        if (Boolean.valueOf(quizIntent.getStringExtra("ifTopic"))) {
//            topic quiz
            String topicName = quizIntent.getStringExtra("name");
            lastTopicName = topicName;
            lessonName = Topic.topicToLesson.get(topicName)[rand.nextInt(Topic.topicToLesson.get(topicName).length)];
            isTopic = true;
        } else {
//            lesson quiz
            lessonName = quizIntent.getStringExtra("name");
            isTopic = false;
        }
        String trimmedLessonName = lessonName;
        if (Character.isDigit(lessonName.toCharArray()[lessonName.length()-1])) {
            trimmedLessonName = lessonName.substring(0, lessonName.length()-1);
        }
        question.setText(trimmedLessonName);
        Set<String> answerList = lessonToAnswers.get(lessonName);
        Set<String> wordBankCopy = wordBank;
        for (String answer : answerList) {
            wordBankCopy.remove(answer);
        }
        Set<String> wrongChoices = wordBankCopy;
        String answer = (String) answerList.toArray()[rand.nextInt(answerList.size())];
        int[] buttonIds = new int[]{(R.id.choice1), (R.id.choice2), (R.id.choice3)};
        choices = new String[3];
        for (int i = 0; i < 3; i++) {
            String randomWord = (String) wrongChoices.toArray()[rand.nextInt(wrongChoices.size())];
            choices[i] = randomWord;
            ImageButton btn = findViewById(buttonIds[i]);
            int imageRes = getResources().getIdentifier(String.format("@drawable/%s", randomWord), null, getPackageName());
            btn.setImageResource(imageRes);
            wrongChoices.remove(randomWord);
        }
        //set the correct button's image
        int randCorrect = rand.nextInt(buttonIds.length);
        choices[randCorrect] = answer;
        correctButtonId = buttonIds[randCorrect];
        ImageButton correctButton = findViewById(correctButtonId);
        int imageRes = getResources().getIdentifier(String.format("@drawable/%s", answer), null, getPackageName());
        correctButton.setImageResource(imageRes);


        //load all imageRes
        if (lessonName.equals("spr") || lessonName.equals("spl") || lessonName.equals("str")) {
            ImageView p = findViewById(R.id.puzzle);
            ArrayList<Integer> al = Model.puzzleEarned.get(lessonName);
            if (al.size() == 12) {
                p.setImageResource(getResources().getIdentifier(String.format("@drawable/%s_composite", lessonName), null, getPackageName()));
                boolean visited = Model.visited(lessonName);
                if (!visited) {
                    Intent completedPz = new Intent(Quiz.this, CompletedPuzzle.class);
                    completedPz.putExtra("lessonName", lessonName);
                    Model.visit(lessonName);
                    startActivity(completedPz);
                }

                p.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent completedPz = new Intent(Quiz.this, CompletedPuzzle.class);
                        completedPz.putExtra("lessonName", lessonName);
                        startActivity(completedPz);
                    }
                });
            } else {
                List<Drawable> puzzles = new ArrayList<>();
                for (int row = 0; row < 4; row++) {
                    for (int col = 0; col < 3; col++) {
                        String filename = String.format("@drawable/%s%d%d", lessonName, row, col);
                        System.out.println(filename);
                        Drawable d = getResources().getDrawable(getResources().getIdentifier(filename, null, getPackageName()));
                        d.setAlpha(0);
                        puzzles.add(d);
                    }
                }
                Drawable[] drawables = new Drawable[12];
                drawables = puzzles.toArray(drawables);
                ld = new LayerDrawable(drawables);

                p.setImageDrawable(ld);
                //load the earned puzzle
                for (int puzzle : al) {
                    ld.getDrawable(puzzle).setAlpha(255);
                }
            }

            int goldStarCount = Model.getGoldStarCount(lessonName);
            int silverStarCount = Model.getSilverStarCount(lessonName);
            ImageView s0 = findViewById(R.id.star0);
            ImageView s1 = findViewById(R.id.star1);
            ImageView s2 = findViewById(R.id.star2);
            ImageView s3 = findViewById(R.id.star3);
            ImageView s4 = findViewById(R.id.star4);
            ImageView[] arr = {s0, s1, s2, s3, s4};

            for (int i = 0; i < goldStarCount+silverStarCount; i++) {
                if (i < goldStarCount) {
                    arr[i].setImageResource(getResources().getIdentifier("@drawable/gold_star", null, getPackageName()));
                } else {
                    arr[i].setImageResource(getResources().getIdentifier("@drawable/silver_star", null, getPackageName()));
                }
            }
        }

        playSound(choices);
    }

    public void playSound(String[] choices){
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), getResources().getIdentifier(String.format("@raw/%s_phoneme", lessonName), null, getPackageName()));
        mp.start();
        mp.setOnCompletionListener(mp1 -> {
            mp1.release();
            mp1 = MediaPlayer.create(getApplicationContext(), getResources().getIdentifier(String.format("@raw/%s", choices[0]), null, getPackageName()));
            mp1.start();
            mp1.setOnCompletionListener(mp2 -> {
                mp2.release();
                mp2 = MediaPlayer.create(getApplicationContext(), getResources().getIdentifier(String.format("@raw/%s", choices[1]), null, getPackageName()));
                mp2.start();
                mp2.setOnCompletionListener(mp3 -> {
                    mp3.release();
                    mp3 = MediaPlayer.create(getApplicationContext(), getResources().getIdentifier(String.format("@raw/%s", choices[2]), null, getPackageName()));
                    mp3.start();
                    mp3.setOnCompletionListener(MediaPlayer::release);
                });
            });
        });
    }

    @Override
    public void onClick(View v) {
//        TextView result = findViewById(R.id.result);
        if (v.getId() == correctButtonId) {
//            result.setText("correct");
            ArrayList<Integer> al = Model.puzzleEarned.get(lessonName);
            int goldStarCount = Model.getGoldStarCount(lessonName);
            if (attempts == 0) {
                if (Model.getCoinsFromMap(lessonName) < 10) {
                    if (Model.getCoinsFromMap(lessonName) == 9) {
                        Model.addCoins(1);
                        Model.setCoinsFromMap(lessonName, 1);
                    } else {
                        Model.addCoins(2);
                        Model.setCoinsFromMap(lessonName, 2);
                    }
                }
                if (al.size() < 12) {
                    al.add(randomPuzzle());
                    if (al.size() < 12) {
                        al.add(randomPuzzle());
                    }
                }
                if (goldStarCount < 5) {
                    Model.addGoldStar(lessonName);
                }
            } else if (attempts == 1) {
                if (Model.getCoinsFromMap(lessonName) < 10) {
                    Model.addCoins(1);
                    Model.setCoinsFromMap(lessonName, 1);
                }
                if (al.size() < 12) {
                    al.add(randomPuzzle());
                }
                Model.toSilverStar(lessonName);
            }
            nextQuestion();
        } else {
            attempts++;
            if (attempts == 1) {
                ImageButton wrongButton = findViewById(v.getId());
                wrongButton.setVisibility(View.INVISIBLE);
            } else if (attempts == 2) {
                Model.toSilverStar(lessonName);
                nextQuestion();
            }
//            result.setText("incorrect");
        }
    }

    private int randomPuzzle() {
        int r = rand.nextInt(12);
        while (Model.puzzleEarned.get(lessonName).contains(r)) {
            r = rand.nextInt(12);
        }
        if (lessonName.equals("spr") || lessonName.equals("spl") || lessonName.equals("str")) {
            ld.getDrawable(r).setAlpha(255);
        }
        return r;
    }

    public void nextQuestion() {
        Intent quizIntent = new Intent(Quiz.this, Quiz.class);
        if (isTopic) {
            quizIntent.putExtra("ifTopic", "true");
            quizIntent.putExtra("name", lastTopicName);
        } else {
            quizIntent.putExtra("ifTopic", "false");
            quizIntent.putExtra("name", lessonName);
        }
        startActivity(quizIntent);
    }

    public void onHome(View view) {
        Intent home = new Intent(Quiz.this, MainActivity.class);
        startActivity(home);
    }
    public void onBack(View view) { onBackPressed(); }

    public void onRepeat(View view){
        playSound(choices);
    }

    public void onBank(View view) {
        Intent bank = new Intent(Quiz.this, PiggyBank.class);
        startActivity(bank);
    }

    public void buttonVisibility(){
        quizButton = findViewById(R.id.quiz_button);
        quizButton.setVisibility(View.INVISIBLE);
        repeatButton = findViewById(R.id.repeat_button);
        repeatButton.setVisibility(View.VISIBLE);
    }
}
