package com.example.demo.Controller;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.demo.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Lesson extends AppCompatActivity {
    ImageButton quizButton;
    ImageButton repeatButton;
    String lessonNameString;
    private View view;
    List<Integer> soundsList;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lesson);
        TextView lessonName = (TextView) findViewById(R.id.lesson_title);
        Intent lessonIntent = getIntent();
        lessonNameString = lessonIntent.getStringExtra("lessonName");
        soundsList = lessonSounds(lessonNameString);
        String trimmedLessonName = lessonNameString;
        if (Character.isDigit(lessonNameString.toCharArray()[lessonNameString.length()-1])) {
            trimmedLessonName = lessonNameString.substring(0, lessonNameString.length()-1);
        }
        lessonName.setText(trimmedLessonName);

        String[] examples = lessonToExamples.get(lessonNameString);
        ImageView exampleImage;
        TextView exampleDescription;
        int imageRes;
        String answer;
        int[] imagesId = new int[] {R.id.imageLeft, R.id.imageMid, R.id.imageRight};
        int[] descriptionId = new int[] {R.id.myImageViewTextLeft, R.id.myImageViewTextMid, R.id.myImageViewTextRight};
        for (int i = 0; i < 3; i++) {
            exampleImage = (ImageView) findViewById(imagesId[i]);
            exampleDescription = (TextView) findViewById(descriptionId[i]);
            answer = examples[i];
            if (answer == "gingerbread man") answer = "gingerbread_man";
            if (answer == "throw") answer = "throw_";
            imageRes = getResources().getIdentifier(String.format("@drawable/%s", answer), null, getPackageName());
            exampleImage.setImageResource(imageRes);
            exampleDescription.setText(examples[i]);
        }
        buttonVisibility();
        new Handler().postDelayed(() -> playSound(soundsList), 1000);
    }

    public void playSound(List<Integer> soundsList){
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), soundsList.get(0));
        mp.start();
        mp.setOnCompletionListener(mp1 -> {
            mp1.release();
            mp1 = MediaPlayer.create(getApplicationContext(), soundsList.get(1));
            mp1.start();
            mp1.setOnCompletionListener(mp2 -> {
                mp2.release();
                mp2 = MediaPlayer.create(getApplicationContext(), soundsList.get(2));
                mp2.start();
                mp2.setOnCompletionListener(MediaPlayer::release);
            });
        });
    }

    public List<Integer> lessonSounds(String lessonNameString){
        List<Integer> soundsList = new ArrayList<>();
        switch (lessonNameString) {
            case "c0": soundsList = Arrays.asList(R.raw.cat, R.raw.canary, R.raw.cake);
                break;
            case "c1": soundsList = Arrays.asList(R.raw.celery, R.raw.face, R.raw.balance);
                break;
            case "g0": soundsList = Arrays.asList(R.raw.goose, R.raw.goat, R.raw.gold);
                break;
            case "g1": soundsList = Arrays.asList(R.raw.frog, R.raw.plug, R.raw.bug);
                break;
            case "g2": soundsList = Arrays.asList(R.raw.giraffe, R.raw.gingerbread_man, R.raw.fridge);
                break;

            case "scr": soundsList = Arrays.asList(R.raw.scrub, R.raw.scratch, R.raw.scream);
                break;
            case "spl": soundsList = Arrays.asList(R.raw.split, R.raw.splat, R.raw.splash);
                break;
            case "spr": soundsList = Arrays.asList(R.raw.spread, R.raw.spruce, R.raw.sprain);
                break;
            case "str": soundsList = Arrays.asList(R.raw.strong, R.raw.straw, R.raw.string);
                break;

            case "gh": soundsList = Arrays.asList(R.raw.high, R.raw.right, R.raw.eight);
                break;
            case "kn": soundsList = Arrays.asList(R.raw.knot, R.raw.knee, R.raw.knit);
                break;
            case "sc": soundsList = Arrays.asList(R.raw.scent, R.raw.scene, R.raw.science);
                break;
            case "wr": soundsList = Arrays.asList(R.raw.wrap, R.raw.write, R.raw.wrong);
                break;

            case "ai": soundsList = Arrays.asList(R.raw.tail, R.raw.nail, R.raw.rainbow);
                break;
            case "au": soundsList = Arrays.asList(R.raw.haul, R.raw.gauze, R.raw.faucet);
                break;
            case "aw": soundsList = Arrays.asList(R.raw.saw, R.raw.hawk, R.raw.paws);
                break;
            case "ay": soundsList = Arrays.asList(R.raw.jay, R.raw.ray, R.raw.play);
                break;
            case "ea0": soundsList = Arrays.asList(R.raw.eat, R.raw.beak, R.raw.leaf);
                break;
            case "ea1": soundsList = Arrays.asList(R.raw.head, R.raw.bear, R.raw.pear);
                break;
            case "ee": soundsList = Arrays.asList(R.raw.bee, R.raw.tree, R.raw.jeep);
                break;
            case "ew": soundsList = Arrays.asList(R.raw.flew, R.raw.blew, R.raw.chew);
                break;
            case "oa": soundsList = Arrays.asList(R.raw.goat, R.raw.boat, R.raw.coat);
                break;
            case "oi": soundsList = Arrays.asList(R.raw.coin, R.raw.point, R.raw.choice);
                break;
            case "oo0": soundsList = Arrays.asList(R.raw.zoo, R.raw.moon, R.raw.hoof);
                break;
            case "oo1": soundsList = Arrays.asList(R.raw.cook, R.raw.wood, R.raw.foot);
                break;
            case "ou": soundsList = Arrays.asList(R.raw.house, R.raw.mouth, R.raw.proud);
                break;
            case "ow0": soundsList = Arrays.asList(R.raw.blow, R.raw.snow, R.raw.throw_);
                break;
            case "ow1": soundsList = Arrays.asList(R.raw.owl, R.raw.cow, R.raw.town);
                break;
            case "oy": soundsList = Arrays.asList(R.raw.boy, R.raw.toys, R.raw.oyster);
                break;

            case "ar0": soundsList = Arrays.asList(R.raw.arm, R.raw.stars, R.raw.barn);
                break;
            case "ar1": soundsList = Arrays.asList(R.raw.bare, R.raw.mare, R.raw.hare);
                break;
            case "er": soundsList = Arrays.asList(R.raw.fern, R.raw.zipper, R.raw.tiger);
                break;
            case "ir": soundsList = Arrays.asList(R.raw.bird, R.raw.girl,R.raw.shirt);
                break;
            case "or0": soundsList = Arrays.asList(R.raw.corn, R.raw.orca, R.raw.horns);
                break;
            case "or1": soundsList = Arrays.asList(R.raw.work, R.raw.worms,R.raw.tractor);
                break;
            case "ur": soundsList = Arrays.asList(R.raw.burn,R.raw.surf, R.raw.nurse);
                break;

            case "a": soundsList = Arrays.asList(R.raw.sofa, R.raw.zebra, R.raw.afraid);
                break;
            case "e": soundsList = Arrays.asList(R.raw.camel, R.raw.oven, R.raw.kitten);
                break;
            case "i": soundsList = Arrays.asList(R.raw.rabbit, R.raw.pencil, R.raw.robin);
                break;
            case "o": soundsList = Arrays.asList(R.raw.lion, R.raw.oven, R.raw.wagon);
                break;
            case "u": soundsList = Arrays.asList(R.raw.bug, R.raw.bus, R.raw.cut);
                break;
        }
        return soundsList;

    }

    Map<String, String[]> lessonToExamples= new HashMap<String, String[]>() {{
        put("c0", new String[] {"cat", "canary", "cake"});
        put("c1", new String[] {"celery", "face", "balance"});
        put("g0", new String[] {"goose", "goat", "gold"});
        put("g1", new String[] {"frog", "plug", "bug"});
        put("g2", new String[] {"giraffe", "gingerbread man", "fridge"});

        put("scr", new String[] {"scrub", "scratch", "scream"});
        put("spl", new String[] {"split", "splat", "splash"});
        put("spr", new String[] {"spread", "spruce", "sprain"});
        put("str", new String[] {"strong", "straw", "string"});

        put("gh", new String[] {"high", "right", "eight"});
        put("kn", new String[] {"knot", "knee", "knit"});
        put("sc", new String[] {"scent", "scene", "science"});
        put("wr", new String[] {"wrap", "write", "wrong"});

        put("ai", new String[] {"tail", "nail", "rainbow"});
        put("au", new String[] {"haul", "gauze", "faucet"});
        put("aw", new String[] {"saw", "hawk", "paws"});
        put("ay", new String[] {"jay", "ray", "play"});
        put("ea0", new String[] {"eat", "beak", "leaf"});
        put("ea1", new String[] {"head", "bear", "pears"});
        put("ee", new String[] {"bee", "tree", "jeep"});
        put("ew", new String[] {"flew", "blew", "chew"});
        put("oa", new String[] {"goat", "boat", "coat"});
        put("oi", new String[] {"coin", "point", "choice"});
        put("oo0", new String[] {"zoo", "moon", "hoof"});
        put("oo1", new String[] {"cook", "wood", "foot"});
        put("ou", new String[] {"house", "mouth", "proud"});
        put("ow0", new String[] {"blow", "snow", "throw"});
        put("ow1", new String[] {"owl", "cow", "town"});
        put("oy", new String[] {"boy", "toys", "oyster"});

        put("ar0", new String[] {"arm", "stars", "barn"});
        put("ar1", new String[] {"bare", "mare", "hare"});
        put("er", new String[] {"fern", "tiger", "zipper"});
        put("ir", new String[] {"bird", "girl", "shirt"});
        put("or0", new String[] {"corn", "horns", "orca"});
        put("or1", new String[] {"work", "worms", "tractor"});
        put("ur", new String[] {"burn", "surf", "nurse"});

        put("a", new String[] {"sofa", "zebra", "afraid"});
        put("e", new String[] {"camel", "oven", "kitten"});
        put("i", new String[] {"rabbit", "pencil", "robin"});
        put("o", new String[] {"lion", "oven", "wagon"});
        put("u", new String[] {"bug", "bus", "cut"});

    }};

    public void onHome(View view) {
        Intent home = new Intent(Lesson.this, MainActivity.class);
        startActivity(home);
    }

    public void onBack(View view) {
        Intent topic = new Intent(Lesson.this, Topic.class);
        Intent previous = getIntent();
        topic.putExtra("topicName", previous.getStringExtra("topicName"));
        startActivity(topic);
    }

    public void onPrev(View view) {
        Intent lessonIntent = getIntent();
        int position = lessonIntent.getIntExtra("position", 0);
        String[] lessons = lessonIntent.getStringArrayExtra("lessons");
        lessonNameString = position > 0 ? lessons[--position] : lessons[position];
        lessonIntent.putExtra("lessonName", lessonNameString);
        lessonIntent.putExtra("position", position);
        startActivity(lessonIntent);
    }

    public void onNext(View view) {

        Intent lessonIntent = getIntent();
        int position = lessonIntent.getIntExtra("position", 0);
        String[] lessons = lessonIntent.getStringArrayExtra("lessons");
        lessonNameString = position < lessons.length-1 ? lessons[++position] : lessons[position];
        lessonIntent.putExtra("lessonName", lessonNameString);
        lessonIntent.putExtra("position", position);
        startActivity(lessonIntent);
    }


    public void buttonVisibility(){
        quizButton = findViewById(R.id.quiz_button);
        quizButton.setVisibility(View.VISIBLE);
        repeatButton = findViewById(R.id.repeat_button);
        repeatButton.setVisibility(View.VISIBLE);
    }

    public void onRepeat(View view){
        playSound(soundsList);
    }

    public void onQuiz(View view) {
        Intent quizIntent = new Intent(Lesson.this, Quiz.class);
        quizIntent.putExtra("ifTopic", "false");
        quizIntent.putExtra("name", lessonNameString);
        startActivity(quizIntent);
    }
    public void onBank(View view) {
        Intent bank = new Intent(Lesson.this, PiggyBank.class);
        startActivity(bank);
    }

    public void onPuzzle(View view) {
        Intent intent = new Intent(getApplicationContext(), PuzzleList.class);
        startActivity(intent);
    }

}
