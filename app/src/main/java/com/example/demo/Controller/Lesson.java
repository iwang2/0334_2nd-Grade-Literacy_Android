package com.example.demo.Controller;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.SoundPool;
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
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class Lesson extends AppCompatActivity {
    ImageButton quizButton;
    ImageButton repeatButton;
    String lessonNameString;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lesson);
        TextView lessonName = (TextView) findViewById(R.id.lesson_title);
        Intent lessonIntent = getIntent();
        lessonNameString = lessonIntent.getStringExtra("lessonName");
        lessonName.setText(lessonNameString);

        String[] examples = lessonToExamples.get(lessonIntent.getStringExtra("lessonName"));
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
            imageRes = getResources().getIdentifier(String.format("@drawable/%s", answer), null, getPackageName());
            exampleImage.setImageResource(imageRes);
            exampleDescription.setText(answer);
        }
        buttonVisibility();
        List<Integer>  soundsList= lessonSounds(lessonNameString);
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
        //Hard and Soft c & g
        if(lessonNameString.equals("c")) {
            soundsList = Arrays.asList(R.raw.cat,R.raw.canary,R.raw.cake);
        } // Still Needed: c2,g,g1,g2
        //Beginning 3 Letter Blends
        else if(lessonNameString.equals("scr")) {
            soundsList = Arrays.asList(R.raw.scrub,R.raw.scratch,R.raw.scream);
        }else if(lessonNameString.equals("spl")) {
            soundsList = Arrays.asList(R.raw.split,R.raw.splat,R.raw.splash);
        }else if(lessonNameString.equals("spr")) {
            soundsList = Arrays.asList(R.raw.spread,R.raw.spruce,R.raw.sprain);
        }else if(lessonNameString.equals("str")) {
            soundsList = Arrays.asList(R.raw.strong,R.raw.straw,R.raw.string);
        }
        //Silent
        else if(lessonNameString.equals("gh")) {
            soundsList = Arrays.asList(R.raw.high,R.raw.right,R.raw.eight);
        }else if(lessonNameString.equals("kn")) {
            soundsList = Arrays.asList(R.raw.knot,R.raw.knee,R.raw.knit);
        }else if(lessonNameString.equals("sc")) {
            soundsList = Arrays.asList(R.raw.scent,R.raw.scene,R.raw.science);
        }else if(lessonNameString.equals("wr")) {
            soundsList = Arrays.asList(R.raw.wrap,R.raw.write,R.raw.wrong);
        }
        //Pairs
        else if(lessonNameString.equals("ai")) {
            soundsList = Arrays.asList(R.raw.tail,R.raw.nail,R.raw.rainbow);
        }else if(lessonNameString.equals("au")) {
            soundsList = Arrays.asList(R.raw.haul,R.raw.gauze,R.raw.faucet);
        }else if(lessonNameString.equals("aw")) {
            soundsList = Arrays.asList(R.raw.saw,R.raw.hawk,R.raw.paws);
        }else if(lessonNameString.equals("ay")) {
            soundsList = Arrays.asList(R.raw.jay,R.raw.ray,R.raw.play);
        }else if(lessonNameString.equals("ee")) {
            soundsList = Arrays.asList(R.raw.bee,R.raw.tree,R.raw.jeep);
        }else if(lessonNameString.equals("ew")) {
            soundsList = Arrays.asList(R.raw.flew,R.raw.blew,R.raw.chew);
        }else if(lessonNameString.equals("oa")) {
            soundsList = Arrays.asList(R.raw.goat,R.raw.boat,R.raw.coat);
        }else if(lessonNameString.equals("oi")) {
            soundsList = Arrays.asList(R.raw.coin,R.raw.point,R.raw.choice);
        }else if(lessonNameString.equals("oo")) {
            soundsList = Arrays.asList(R.raw.zoo,R.raw.moon); // Add Hoof
        }else if(lessonNameString.equals("ou")) {
            soundsList = Arrays.asList(R.raw.house,R.raw.mouth, R.raw.proud);
        }else if(lessonNameString.equals("ow")) {
            soundsList = Arrays.asList(R.raw.blow,R.raw.snow, R.raw.throw1);
        }else if(lessonNameString.equals("oy")) {
            soundsList = Arrays.asList(R.raw.boy,R.raw.toys, R.raw.oyster);
        }//Still Needed: ea,ea1,oo1,ow1
        //With R
        else if(lessonNameString.equals("ar")) {
            soundsList = Arrays.asList(R.raw.arm,R.raw.stars, R.raw.barn);
        }else if(lessonNameString.equals("er")) {
            soundsList = Arrays.asList(R.raw.fern,R.raw.zipper);// ADD Tiger
        }else if(lessonNameString.equals("ir")) {
            soundsList = Arrays.asList(R.raw.bird,R.raw.girl); // ADD Shirt
        }else if(lessonNameString.equals("or")) {
            soundsList = Arrays.asList(R.raw.corn,R.raw.orca); //ADD Horns
        }else if(lessonNameString.equals("ur")) {
            soundsList = Arrays.asList(R.raw.burn); //ADD Surf/Nurse
        }//Still Needed: ar1, or1
        //SCHWAS
        else if(lessonNameString.equals("a")) {
            soundsList = Arrays.asList(R.raw.sofa,R.raw.zebra, R.raw.afraid);
        }else if(lessonNameString.equals("e")) {
            soundsList = Arrays.asList(R.raw.camel,R.raw.oven, R.raw.kitten);
        }else if(lessonNameString.equals("i")) {
            soundsList = Arrays.asList(R.raw.rabbit,R.raw.pencil, R.raw.robin);
        }else if(lessonNameString.equals("o")) {
            soundsList = Arrays.asList(R.raw.lion,R.raw.oven,R.raw.wagon);
        } else if(lessonNameString.equals("u")) {
            soundsList = Arrays.asList(R.raw.bug,R.raw.bus, R.raw.cut);
        }
        return soundsList;
    }

    Map<String, String[]> lessonToExamples= new HashMap<String, String[]>() {{
        put("c", new String[] {"cat", "canary", "cake"});

        //put("c", new String[] {"celery", "face", "balance"});
        put("g", new String[] {"goose", "goat", "gold"});
        //put("g", new String[] {"frog", "plug", "bug"});
        //put("g", new String[] {"giraffe", "gingerbread man", "fridge"});

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
        put("ea", new String[] {"eat", "beak", "leaf"});
        //put("ea", new String[] {"head", "bear", "pears"});
        put("ee", new String[] {"bee", "tree", "jeep"});
        put("ew", new String[] {"flew", "blew", "chew"});
        put("oa", new String[] {"goat", "boat", "coat"});
        put("oi", new String[] {"coin", "point", "choice"});
        put("oo", new String[] {"zoo", "moon", "hoof"});
        //put("oo", new String[] {"cook", "woof", "foot"});
        put("ou", new String[] {"house", "mouth", "proud"});
        put("ow", new String[] {"blow", "snow", "throw"});
        //put("ow", new String[] {"owl", "cow", "town"});
        put("oy", new String[] {"boy", "toys", "oyster"});

        put("ar", new String[] {"arm", "stars", "barn"});
        //put("ar", new String[] {"bare", "mare", "hare"});
        put("er", new String[] {"fern", "tiger", "zipper"});
        put("ir", new String[] {"bird", "girl", "shirt"});
        put("or", new String[] {"corn", "horns", "orca"});
        //put("or", new String[] {"work", "worms", "tractor"});
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
    public void onBack(View view) { onBackPressed(); }

    public void buttonVisibility(){
        quizButton = findViewById(R.id.quiz_button);
        quizButton.setVisibility(View.VISIBLE);
        repeatButton = findViewById(R.id.repeat_button);
        repeatButton.setVisibility(View.VISIBLE);
    }

    public void onQuiz(View view) {
        Intent quizIntent = new Intent(Lesson.this, Quiz.class);
        quizIntent.putExtra("ifTopic", "false");
        quizIntent.putExtra("name", lessonNameString);
        startActivity(quizIntent);
    }
}
