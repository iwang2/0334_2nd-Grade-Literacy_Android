package com.example.demo.Controller;

import android.content.Intent;
import android.graphics.drawable.Drawable;
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

public class Quiz extends AppCompatActivity implements View.OnClickListener {
    ImageButton quizButton;
    ImageButton repeatButton;
    Set<String> wordBank = new HashSet<>(Arrays.asList(
            "scraper", "scratch", "scream", "screwdriver", "screws", "scribble", "scrub", "scrubs",
            "splash", "splat", "splatter", "splendid", "splendor", "splinter", "split", "splits",
            "sprain", "sprawl_lazy", "spray", "spread", "sprinkler", "sprinters", "sprout", "spruce",
            "straight", "straw", "streak", "street-sweeper", "string", "strings", "stripes", "strong", "structures",
            "knee", "kneel", "knit", "knives", "knock", "knot", "know", "knuckles",
            "wrap", "wreath", "wreck", "wrenches", "wriggle", "wrinkle", "write", "wrong",
            "ascend", "crescents", "descend", "muscles", "scene", "scent", "science", "scissors",
            "backpack", "bricklayer", "rocket", "sick", "snack", "thick", "trick", "wick",
            "birthday", "jay", "play", "ray",
            "caught",
            "chew", "crew_cut",
            "choice", "oink_oink",
            "cowboy",
            "feather", "spread", "weather",
            "oyster",
            "arm", "bare", "barn", "cardinal", "go_kart", "harp", "mare", "scare", "stars", "target",
            "dozer", "fern", "four_leaf_clover", "mermaid", "zipper",
            "bird", "birthday", "circle", "girl", "skirt",
            "porcupine", "work", "corn", "gator", "hornet", "mirror", "orca", "uniforms",
            "burn_flame", "burrito", "burro_donkey", "hamburger"
        ));

    Map<String, Set<String>> lessonToAnswers = new HashMap<String, Set<String>>() {{
        put("scr", new HashSet<>(Arrays.asList("scraper", "scratch", "scream", "screwdriver", "screws", "scribble", "scrub", "scrubs")));
        put("spl", new HashSet<>(Arrays.asList("splash", "splat", "splatter", "splendid", "splendor", "splinter", "split", "splits")));
        put("spr", new HashSet<>(Arrays.asList("sprain", "sprawl_lazy", "spray", "spread", "sprinkler", "sprinters", "sprout", "spruce")));
        put("str", new HashSet<>(Arrays.asList("straight", "straw", "streak", "street-sweeper", "string", "strings", "stripes", "strong", "structures")));
        put("kn", new HashSet<>(Arrays.asList("knee", "kneel", "knit", "knives", "knock", "knot", "know", "knuckles")));
        put("wr", new HashSet<>(Arrays.asList("wrap", "wreath", "wreck", "wrenches", "wriggle", "wrinkle", "write", "wrong")));
        put("sc", new HashSet<>(Arrays.asList("ascend", "crescents", "descend", "muscles", "scene", "scent", "science", "scissors")));
        put("ck", new HashSet<>(Arrays.asList("backpack", "bricklayer", "rocket", "sick", "snack", "thick", "trick", "wick")));
        put("ay", new HashSet<>(Arrays.asList("birthday", "jay", "play", "ray")));
        put("au", new HashSet<>(Arrays.asList("caught")));
        put("ew", new HashSet<>(Arrays.asList("chew", "crew_cut")));
        put("oi", new HashSet<>(Arrays.asList("choice", "oink_oink")));
        put("ow", new HashSet<>(Arrays.asList("cowboy")));
        put("ea", new HashSet<>(Arrays.asList("feather", "spread", "weather")));
        put("oy", new HashSet<>(Arrays.asList("oyster")));
        put("ar", new HashSet<>(Arrays.asList("arm", "bare", "barn", "cardinal", "go_kart", "harp", "mare", "scare", "stars", "target")));
        put("er", new HashSet<>(Arrays.asList("dozer", "fern", "four_leaf_clover", "mermaid", "zipper")));
        put("ir", new HashSet<>(Arrays.asList("bird", "birthday", "circle", "girl", "skirt")));
        put("or", new HashSet<>(Arrays.asList("porcupine", "work", "corn", "gator", "hornet", "mirror", "orca", "uniforms")));
        put("ur", new HashSet<>(Arrays.asList("burn_flame", "burrito", "burro_donkey", "hamburger")));
    }};

    int correctButtonId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz);
        TextView question = findViewById(R.id.question);
        Intent quizIntent = getIntent();
        buttonVisibility();
        if (Boolean.valueOf(quizIntent.getStringExtra("ifTopic"))) {
//            topic quiz
        } else {
//            lesson quiz
            String lessonName = quizIntent.getStringExtra("name");
            question.setText(lessonName);
            Set<String> answerList = lessonToAnswers.get(lessonName);
            Set<String> wordBankCopy = wordBank;
            wordBankCopy.removeAll(answerList);
            Set<String> wrongChoices = wordBankCopy;
            Random rand = new Random();
            String answer = (String) answerList.toArray()[rand.nextInt(answerList.size())];
            int[] buttonIds = new int[] {(R.id.choice1), (R.id.choice2), (R.id.choice3)};
            for (int id: buttonIds) {
                String randomWord = (String) wrongChoices.toArray()[rand.nextInt(wrongChoices.size())];
                ImageButton btn = findViewById(id);
                int imageRes = getResources().getIdentifier(String.format("@drawable/%s", randomWord), null, getPackageName());
//                btn.setImageDrawable(getResources().getDrawable(imageRes));
                btn.setImageResource(imageRes);
                wrongChoices.remove(randomWord);
            }
            //set the correct button's image
            correctButtonId = buttonIds[rand.nextInt(buttonIds.length)];
            ImageButton correctButton = findViewById(correctButtonId);
            int imageRes = getResources().getIdentifier(String.format("@drawable/%s", answer), null, getPackageName());
//            correctButton.setImageDrawable(getResources().getDrawable(imageRes));
            correctButton.setImageResource(imageRes);
        }
    }


    @Override
    public void onClick(View v) {
        TextView result = findViewById(R.id.result);
        if (v.getId() == correctButtonId) {
            result.setText("correct");
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
