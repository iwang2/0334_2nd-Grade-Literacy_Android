package com.example.demo.Controller;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo.R;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import com.example.demo.Controller.Topic;

public class Quiz extends AppCompatActivity implements View.OnClickListener {
    ImageButton quizButton;
    ImageButton repeatButton;
    Set<String> wordBank = new HashSet<>(Arrays.asList(
//            need audio for "scribble", "splendor", "kneel", "wreath", "wriggle", "ascend", "descend", "muscles", "target",
            "scraper", "scratch", "scream", "screwdriver", "screws", "scrub", "scrubs",
            "splash", "splat", "splatter", "splendid", "splinter", "split", "splits",
            "sprain", "sprawl", "spray", "spread", "sprinkler", "sprinters", "sprout", "spruce",
            "straight", "straw", "streak", "street_sweeper", "string", "strings", "stripes", "strong", "structures",
            "knee", "knit", "knives", "knock", "knot", "know", "knuckles",
            "wrap", "wreck", "wrenches", "wrinkle", "write", "wrong",
            "crescents", "scene", "scent", "science", "scissors",
            "backpack", "bricklayer", "rocket", "sick", "snack", "thick", "trick", "wick",
            "birthday", "jay", "play", "ray",
//            "caught",
            "chew", "crew_cut",
            "choice", "oink_oink",
//            "cowboy",
            "feather", "spread", "weather",
            "oyster",
            "arm", "bare", "barn", "cardinal", "go_kart", "harp", "mare", "scare", "stars",
            "dozer", "fern", "clover", "mermaid", "zipper",
            "bird", "birthday", "circle", "girl", "skirt",
            "porcupine", "work", "corn", "gator", "hornet", "mirror", "orca", "uniforms",
            "burn", "burrito", "burro", "hamburger"
        ));

    Map<String, Set<String>> lessonToAnswers = new HashMap<String, Set<String>>() {
        {
            put("scr", new HashSet<>(Arrays.asList("scraper", "scratch", "scream", "screwdriver", "screws", "scrub", "scrubs")));
            put("spl", new HashSet<>(Arrays.asList("splash", "splat", "splatter", "splendid", "splinter", "split", "splits")));
            put("spr", new HashSet<>(Arrays.asList("sprain", "sprawl", "spray", "spread", "sprinkler", "sprinters", "sprout", "spruce")));
            put("str", new HashSet<>(Arrays.asList("straight", "straw", "streak", "street_sweeper", "string", "strings", "stripes", "strong", "structures")));
            put("kn", new HashSet<>(Arrays.asList("knee", "knit", "knives", "knock", "knot", "know", "knuckles")));
            put("wr", new HashSet<>(Arrays.asList("wrap", "wreck", "wrenches", "wrinkle", "write", "wrong")));
            put("sc", new HashSet<>(Arrays.asList("crescents", "scene", "scent", "science", "scissors")));
            put("ck", new HashSet<>(Arrays.asList("backpack", "bricklayer", "rocket", "sick", "snack", "thick", "trick", "wick")));
            put("ay", new HashSet<>(Arrays.asList("birthday", "jay", "play", "ray")));
//        put("au", new HashSet<>(Arrays.asList("caught")));
            put("ew", new HashSet<>(Arrays.asList("chew", "crew_cut")));
            put("oi", new HashSet<>(Arrays.asList("choice", "oink_oink")));
//        put("ow", new HashSet<>(Arrays.asList("cowboy")));
            put("ea", new HashSet<>(Arrays.asList("feather", "spread", "weather")));
            put("oy", new HashSet<>(Arrays.asList("oyster")));
            put("ar", new HashSet<>(Arrays.asList("arm", "bare", "barn", "cardinal", "go_kart", "harp", "mare", "scare", "stars")));
            put("er", new HashSet<>(Arrays.asList("dozer", "fern", "clover", "mermaid", "zipper")));
            put("ir", new HashSet<>(Arrays.asList("bird", "birthday", "circle", "girl", "skirt")));
            put("or", new HashSet<>(Arrays.asList("porcupine", "work", "corn", "gator", "hornet", "mirror", "orca", "uniforms")));
            put("ur", new HashSet<>(Arrays.asList("burn", "burrito", "burro", "hamburger")));
            put("c0", new HashSet<>(Arrays.asList("cake", "canary", "candy", "car", "cat", "cow", "cub", "cut")));
            put("c1", new HashSet<>(Arrays.asList("balance", "celery", "face", "ice", "sauce_pan", "tricycle", "unicycle")));
            put("g0", new HashSet<>(Arrays.asList("gate", "gazelle", "go_kart", "goal", "goat", "gold", "goose", "grapes")));
            put("g1", new HashSet<>(Arrays.asList("bug", "dig", "dog", "flag", "frog", "hog", "plug", "wig")));
            put("g2", new HashSet<>(Arrays.asList("fridge", "gingerbread_man", "giraffe", "hedge_clippers", "syringe")));
            put("a", new HashSet<>(Arrays.asList("afraid", "canoe", "gazelle", "oval", "panda", "sofa", "tuba", "zebra")));
            put("e", new HashSet<>(Arrays.asList("camel", "garden", "kitten", "mittens", "oven", "piglet", "rocket", "shovel")));
            put("i", new HashSet<>(Arrays.asList("artist", "gossip", "muffins_", "nostril", "pencil", "rabbit", "robin", "tennis")));
            put("o", new HashSet<>(Arrays.asList("glove", "lion", "love", "monkey", "mother", "oven", "shovel", "wagon")));
            put("u", new HashSet<>(Arrays.asList("brush", "bucket", "bug", "bus", "cut", "jump", "muzzle", "trunk")));
            put("ai", new HashSet<>(Arrays.asList("afraid", "mermaid", "nail", "paint", "rainbow", "sail", "snail", "tail")));
            put("ea_long", new HashSet<>(Arrays.asList("beach", "beagle", "beak", "beaver", "eat", "leaf", "read", "steal")));
            put("ee", new HashSet<>(Arrays.asList("bee", "cheek", "feet", "freeze", "geese", "jeep", "seed", "sheep", "tree")));
            put("oa", new HashSet<>(Arrays.asList("boat", "coat", "float", "foal", "goat", "soap", "toad", "toaster")));
            put("oo0", new HashSet<>(Arrays.asList("boots", "broom", "goose", "moon", "moose", "spoon", "stool", "tools", "tooth", "zoo")));
            put("oo1", new HashSet<>(Arrays.asList("bigfoot", "book", "cook", "cookies", "foot", "football", "hoodie", "look", "wood")));
        }
    };
    int correctButtonId;
    boolean isTopic;
    String lastTopicName;
    String lastLessonName;
//    private SoundPool soundPool;
//    private int sound1;
    MediaPlayer mp1;
    private int numSoundsLoaded = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz);
        TextView question = findViewById(R.id.question);
        Intent quizIntent = getIntent();
        buttonVisibility();
        Random rand = new Random();
        String lessonName;
        if (Boolean.valueOf(quizIntent.getStringExtra("ifTopic"))) {
//            topic quiz
            String topicName = quizIntent.getStringExtra("name");
            lastTopicName = topicName;
            lessonName = Topic.topicToLesson.get(topicName)[rand.nextInt(Topic.topicToLesson.get(topicName).length)];
            isTopic = true;
        } else {
//            lesson quiz
            lessonName = quizIntent.getStringExtra("name");
            lastLessonName = lessonName;
            isTopic = false;
        }
        question.setText(lessonName);
        Set<String> answerList = lessonToAnswers.get(lessonName);
        Set<String> wordBankCopy = wordBank;
        for (String answer: answerList) {
            wordBankCopy.remove(answer);
        }
        Set<String> wrongChoices = wordBankCopy;
        String answer = (String) answerList.toArray()[rand.nextInt(answerList.size())];
        int[] buttonIds = new int[] {(R.id.choice1), (R.id.choice2), (R.id.choice3)};
        String[] choices = new String[3];
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

        mp1 = MediaPlayer.create(this, getResources().getIdentifier(String.format("@raw/%s", choices[0]), null, getPackageName()));
        mp1.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mp1.setLooping(false);
        mp1.start();

//        mp1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//            @Override
//            public void onCompletion(MediaPlayer mp) {
//                mp2.start();
//            }
//        });
//        mp2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//            @Override
//            public void onCompletion(MediaPlayer mp) {
//                mp3.start();
//            }
//        });
//        mp3.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//            @Override
//            public void onCompletion(MediaPlayer mp) {
//                mp1.start();
//            }
//        });

//        soundPool = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            soundPool = new SoundPool.Builder()
//                    .setMaxStreams(3)
//                    .build();
//        } else {
//            soundPool = new SoundPool(3, AudioManager.STREAM_MUSIC, 1);
//        }
//        soundPool.setOnLoadCompleteListener(this);
//        //play audio
//        sound1 = soundPool.load(Quiz.this, getResources().getIdentifier(String.format("@raw/%s", choices[0]), null, getPackageName()), 1);
////        player2 = MediaPlayer.create(Quiz.this, getResources().getIdentifier(String.format("@raw/%s", choices[1]), null, getPackageName()));
////        player3 = MediaPlayer.create(Quiz.this, getResources().getIdentifier(String.format("@raw/%s", choices[2]), null, getPackageName()));
////        player1.start();
//
////        soundPool.play(sound1, 1, 1, 0, 0, 1);
//        while (numSoundsLoaded < 1) {}
//        soundPool.play(sound1,1, 1, 0, 0, 1);
}

//    @Override
//    public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
//        numSoundsLoaded++;
//    }

    @Override
    public void onClick(View v) {
        TextView result = findViewById(R.id.result);
        if (v.getId() == correctButtonId) {
            result.setText("correct");
            Intent quizIntent = new Intent(Quiz.this, Quiz.class);
            if (isTopic) {
                quizIntent.putExtra("ifTopic", "true");
                quizIntent.putExtra("name", lastTopicName);
            } else {
                quizIntent.putExtra("ifTopic", "false");
                quizIntent.putExtra("name", lastLessonName);
            }
            mp1.release();
            mp1 = null;
            startActivity(quizIntent);
        } else {
            result.setText("incorrect");
        }
    }

    public void onHome(View view) {
        Intent home = new Intent(Quiz.this, MainActivity.class);
        startActivity(home);
    }
    public void onBack(View view) { onBackPressed(); }

    public void buttonVisibility(){
        quizButton = findViewById(R.id.quiz_button);
        quizButton.setVisibility(View.VISIBLE);
        repeatButton = findViewById(R.id.repeat_button);
        repeatButton.setVisibility(View.VISIBLE);
    }
}
