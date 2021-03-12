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
import Model.Model;

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

    Map<String, Set<String>> lessonToAnswers = new HashMap<String, Set<String>>() {{
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
    }};

//    Map<String, Integer> coinsGet = new HashMap<String, Integer>() {{
//        put("scr", 0);
//        put("spl", 0);
//        put("spr", 0);
//        put("str", 0);
//        put("kn", 0);
//        put("wr", 0);
//        put("sc", 0);
//        put("ck", 0);
//        put("ay", 0);
////        put("au", 0);
//        put("ew", 0);
//        put("oi", 0);
////        put("ow", 0);
//        put("ea", 0);
//        put("oy", 0);
//        put("ar", 0);
//        put("er", 0);
//        put("ir", 0);
//        put("or", 0);
//        put("ur", 0);
//    }};

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
            Model.addCoins();
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
    public void onBank(View view) {
        Intent bank = new Intent(Quiz.this, PiggyBank.class);
        startActivity(bank);
    }

    public void buttonVisibility(){
        quizButton = findViewById(R.id.quiz_button);
        quizButton.setVisibility(View.VISIBLE);
        repeatButton = findViewById(R.id.repeat_button);
        repeatButton.setVisibility(View.VISIBLE);
    }
}
