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
import android.widget.ImageView;
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

public class CompletedPuzzle extends AppCompatActivity {


    Map<String, String> poemBank = new HashMap<String, String>() {{
        put("scr", "Scraper asked Screwdriver,\n" +
                "“What do you do?”\n" +
                "Screwdriver said, “I screw screws.\n" +
                "What do you do?”\n" +
                "“I scratch off bumpy screw heads, \n" +
                "Scrape rough surfaces clean.”\n" +
                "“Scram!” screamed the screw heads.\n" +
                "“Scraping screw heads is mean!”\n");
        put("spl", "Squirrel fell splat on a split stick,\n" +
                "Quick spluttered out, “Oh no!\n" +
                "Then splashed down in a birdbath\n" +
                "splattered water to and fro,\n" +
                "Howled “A splinter’s in my forepaw!”\n" +
                "And displayed his sore, sore toe.\n");
        put("spr", "A spry old sprinter raced ahead\n" +
                "But got stung by a bee,\n" +
                "Slipped on some slippery sprinkler spray,\n" +
                "Crashed through a rough spruce tree,\t\t\n" +
                "Fell sprawling down and loudly howled,\n" +
                "“I won! — but sprained my knee!”\n");
        put("str", "Street sweeper swept the street,\n" +
                "Cleaned straw, string, like a dream,\n" +
                "Then gobbled down his favorite treat,\n" +
                "Sweet strawberry ice cream!\n");
        put("kn", "Do you know just what I am?\n" +
                "I help you with your bread and jam.\n" +
                "My thin back could knock your knuckles.\n" +
                "I’m made of stuff like knobs and buckles.\n" +
                "I am long and light and lean.\n" +
                "You should always keep me clean.\n" +
                "Kept in drawers by every housewife.\n" +
                "You know me well.  I’m a —\n");
        put("wr", "A thing that you can give, but must keep\n" +
                "Perfectly, or lose it. Don’t dream it’s cheap.  \n" +
                "Right and wrong in this are precious. Write\n" +
                "Or speak it truthfully with all your might.\n" +
                "Make it with care, or wreck a friendship.\n" +
                "If you wriggle out—it’s a guilt trip. \n" +
                "So wrap your mind around it: Be true.\n" +
                "Each first letter in this rhyme is a clue.\n");
        put("sc", "Science fascinated Gene,\n" +
                "Who wondered, Does a skunky scent\n" +
                "Stink more at night?  A crescent \n" +
                "Moon just dimly lit the scene.\n");
        put("gh", "Read the riddle — find the kind of band,\n" +
                "Unlikely to play music, that can show eight\n" +
                "Bright colors, even more, be short, expand,\n" +
                "Be doughnut round or arrow straight;\n" +
                "Each when tight flies high.  To understand,\n" +
                "Read each line’s first letter.  Concentrate.\n");
        put("c0", "Little Robin Redbreast sat upon a tree,\n" +
                "Up went the Kitty-Cat, and down went he,\n" +
                "Down came Kitty-Cat, away Robin ran,\n" +
                "Says little Robin Redbreast:\n" +
                "\"Catch me if you can!\"");
        put("c1", "Celery, lettuce, and rice aren’t my dream, \n" +
                "But you scream, I scream, we all scream for ice cream!\n");
        put("g0", "As I was going up Primrose Hill,\n" +
                "Primrose Hill was dirty,\n" +
                "There I met a pretty girl,\n" +
                "And she gave me a curtsey.\n" +
                "\n" +
                "Little girl, pretty girl,\n" +
                "Blessings be upon you,\n" +
                "If I had half-a-dollar a day,\n" +
                "I’d spend it all on you.");
        put("g1", "To market, to market,\n" +
                "To buy a fat pig,\n" +
                "Home again, home again,\n" +
                "Jiggety jig.\n" +
                "\n" +
                "To market, to market,\n" +
                "To buy a fat hog,\n" +
                "Home again, home again,\n" +
                "Jiggety jog.\n");
        put("g2", "Georgie Porgie, pudding and pie,\n" +
                "Kissed the girls and made them cry.\n" +
                "When the boys came out to play,\n" +
                "Georgie Porgie ran away.");
        put("ai", "Rain, rain, go to Spain,\n" +
                "Never come back again.\n" +
                "Rain, rain, go away,\n" +
                "Come again another day.\n" +
                "Little Johny wants to play.\n");
        put("au", "Little Polly Flinders\n" +
                "Sat among the cinders,\n" +
                "Warming her pretty little toes.\n" +
                "Her mother came and caught her,\n" +
                "Whipped her little daughter\n" +
                "For spoiling her nice new clothes.\n");
        put("aw", "See saw, Margery Daw,\n" +
                "Jacky shall have a new master.\n" +
                "Jacky will earn just a penny a day,\n" +
                "Because he will work no faster.\n");
        put("ay", "How many days has my baby to play?\n" +
                "Saturday, Sunday, Monday,\n" +
                "Tuesday, Wednesday, Thursday, Friday,\n" +
                "Saturday, Sunday, Monday.");
        put("ea1", "The best story Dad ever read\n" +
                "Told how this gingerbread\n" +
                "Cookie fled from the grandma, how \n" +
                "The grandad, cat, dog, horse, cow,\n" +
                "And boy chased him through a meadow\n" +
                "Till this sly fox said, “Hello.”\n" +
                "Pretending to be pleasant, nice.\n" +
                "The cookie didn’t know the price\n" +
                " \n" +
                "He’d pay for smarting off.  Instead,\n" +
                "He should have used his head,\n" +
                "Not brag, ‘Run, run, fast as you can,\n" +
                "You can’t catch me, I’m the Gingerbread Man!’\n");
        put("ea0", "Jack Sprat would eat no fat,\n" +
                "His wife would eat no lean,\n" +
                "And so between the two of them,\n" +
                "They licked the platter clean.");
        put("ar0", "Twinkle, twinkle, little star,\n" +
                "How I wonder what you are.\n" +
                "Up above the world so high,\n" +
                "Like a diamond in the sky.");
        put("ar1", "Parrot said to Miss Canary,\n" +
                "“Come with me–leave this cage.\n" +
                "We’ll fly far off, then we’ll marry,\n" +
                "Join the circus, star on stage.”\n" +
                "\n" +
                "“I can’t. It’s all too scary!”\n" +
                "She declared, “It sounds too strange.”\n" +
                "“I bared my heart, will carry\n" +
                "You quite safely. Don’t fear change.”\n" +
                "\n" +
                "“I don’t dare,” she sighed. “I’m wary.\n" +
                "Can you love me through the bars?”\n" +
                "“I do,” he said. “I will.” There he\n" +
                "Kissed her–till both saw stars.");
        put("er", "Peter, Peter, pumpkin eater,\n" +
                "Had a wife and couldn't keep her,\n" +
                "He put her in a pumpkin shell,\n" +
                "And then he kept her very well.");
        put("ir", "On her birthday the girl\n" +
                "Whirled her pearls, swirled her skirt,\n" +
                "Gave her shirt tail a twirl,\n" +
                "Stirred her toe in the dirt,\n" +
                "Until, so I heard,\n" +
                "She looked just like a bird!");
        put("or0", "Little Jack Horner,\n" +
                "Sat in a corner,\n" +
                "Eating a Christmas pie,\n" +
                "He put in his thumb,\n" +
                "And pulled out a plum,\n" +
                "And said: \"What a good boy am I!\"\n");
        put("or1", "Jim tried art, but couldn’t color,\n" +
                "Tried music–singing didn’t work,\n" +
                "His dancing?  Duller and duller.\n" +
                "His golf coach quit, called him a jerk.\n" +
                "He got laughed off as an actor.\n" +
                "But didn’t fear dirt, loved fresh air,\n" +
                "Began to farm worms with a tractor.\n" +
                "Now he’s a famous millionaire!");
        put("a", "Around the bush, Willie,\n" +
                "Around the bee hive.\n" +
                "Around the bush, Willie,\n" +
                "I'll meet you alive.\n");
        put("e", "The elephant wanted to cheat on her diet\n" +
                "Found one golden cookie in the warm oven,\n" +
                "One in the garden, two in a torn pocket,\n" +
                "Three hid in the kitchen, that made seven,\n" +
                "Bought two at the market, spied one in a basket,\n" +
                "Plus one she kept frozen, that was eleven,\n" +
                "And one from her locket, made twelve, a full dozen\n" +
                "When she started to eat them it felt like pure heaven!\n");
        put("i", "Oh, do you know the muffin-man,\n" +
                "The muffin-man, the muffin-man?\n" +
                "Do you know the muffin-man\n" +
                "Who lives in Drury Lane?\n" +
                "\n" +
                "Yes, I know the muffin-man,\n" +
                "The muffin-man, the muffin-man.\n" +
                "Yes, I know the muffin-man\n" +
                "Who lives in Drury Lane.");
        put("o", "He loves me.\n" +
                "He doesn't!\n" +
                "He'll have me.\n" +
                "He won't!\n" +
                "\n" +
                "He would if he could,\n" +
                "But he can't, so he won't!");
        put("u", "Rub a dub dub\n" +
                "Three men in a tub,\n" +
                "And who do you think they be?");

    }};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.completedpuzzle);
        TextView poem = findViewById(R.id.poemtext);
        ImageView puzzle = findViewById(R.id.completedpuzzle);
        Intent lessonIntent = getIntent();
        String lessonName = lessonIntent.getStringExtra("lessonName");
        poem.setText(poemBank.get(lessonName));
        int res = getResources().getIdentifier(String.format("@drawable/%s_composite", lessonName), null, getPackageName());
        if (res != 0) {
            puzzle.setImageResource(res);
        } else {
            puzzle.setImageResource(getResources().getIdentifier(String.format("@drawable/generic_composite"), null, getPackageName()));
        }
    }

    public void onHome(View view) {
        Intent home = new Intent(CompletedPuzzle.this, MainActivity.class);
        startActivity(home);
    }
    public void onBack(View view) { onBackPressed(); }

    public void onBank(View view) {
        Intent bank = new Intent(CompletedPuzzle.this, PiggyBank.class);
        startActivity(bank);
    }

    public void onPuzzle(View view) {
        Intent intent = new Intent(getApplicationContext(), PuzzleList.class);
        startActivity(intent);
    }
}
