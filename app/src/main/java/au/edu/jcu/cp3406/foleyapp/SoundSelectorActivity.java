package au.edu.jcu.cp3406.foleyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Locale;
import java.util.Random;

public class SoundSelectorActivity extends AppCompatActivity {
    private int categorySelectedID;
    private AudioManager audioManager;
    private int height;
    private int width;

    private enum Quadrant {TOP_LEFT, TOP_RIGHT, BOTTOM_LEFT, BOTTOM_RIGHT}

    private Quadrant quadrantSelected;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_selector);

        audioManager = new AudioManager(this);

        Intent intent = getIntent();
        categorySelectedID = intent.getIntExtra("categorySelected", R.id.mediumAnimalsButton);

        ImageView image01 = findViewById(R.id.image01);
        ImageView image02 = findViewById(R.id.image02);
        ImageView image03 = findViewById(R.id.image03);
        ImageView image04 = findViewById(R.id.image04);

        if (categorySelectedID == R.id.smallAnimalsButton) {
            // Set Small Images
            image01.setImageResource(R.drawable.frog);
            image02.setImageResource(R.drawable.hawk);
            image03.setImageResource(R.drawable.snake);
            image04.setImageResource(R.drawable.rooster);
        } else if (categorySelectedID == R.id.mediumAnimalsButton) {
            // Set Medium Images
            image01.setImageResource(R.drawable.dog);
            image02.setImageResource(R.drawable.cat);
            image03.setImageResource(R.drawable.goose);
            image04.setImageResource(R.drawable.duck);
        } else {
            // Set Large Images
            image01.setImageResource(R.drawable.cow);
            image02.setImageResource(R.drawable.elephant);
            image03.setImageResource(R.drawable.pig);
            image04.setImageResource(R.drawable.lion);
        }

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        height = displayMetrics.heightPixels;
        width = displayMetrics.widthPixels;
        Log.i("SoundSelector", "Screen Size: " + height);
        Log.i("SoundSelector", "Screen Size: " + width);
    }

    public void imageClicked() {
        if (audioManager.isReady()) {
            Sound sound = getSound();
            Log.i("AudioManager", "Sound Played: " + sound);
            audioManager.play(sound);
        }
    }


    private Sound getSound() {
        if (categorySelectedID == R.id.smallAnimalsButton) {
            if (quadrantSelected == Quadrant.TOP_LEFT) {
                return Sound.FROG_CROAK;
            } else if (quadrantSelected == Quadrant.TOP_RIGHT) {
                return Sound.HAWK_CALL;
            } else if (quadrantSelected == Quadrant.BOTTOM_LEFT) {
                return Sound.RATTLESNAKE_RATTLE;
            } else if (quadrantSelected == Quadrant.BOTTOM_RIGHT) {
                return Sound.ROOSTER_CROW;
            }
        } else if (categorySelectedID == R.id.mediumAnimalsButton) {
            if (quadrantSelected == Quadrant.TOP_LEFT) {
                return Sound.DOG_BARK;
            } else if (quadrantSelected == Quadrant.TOP_RIGHT) {
                return Sound.COW_MOO;
            } else if (quadrantSelected == Quadrant.BOTTOM_LEFT) {
                return Sound.GOOSE_CALL;
            } else if (quadrantSelected == Quadrant.BOTTOM_RIGHT) {
                return Sound.DUCK_QUACK;
            }
        } else {
            if (quadrantSelected == Quadrant.TOP_LEFT) {
                return Sound.COW_MOO;
            } else if (quadrantSelected == Quadrant.TOP_RIGHT) {
                return Sound.ELEPHANT_TRUMPET;
            } else if (quadrantSelected == Quadrant.BOTTOM_LEFT) {
                return Sound.PIG_SNORT;
            } else if (quadrantSelected == Quadrant.BOTTOM_RIGHT) {
                return Sound.MOUNTAIN_LION_ROAR;
            }
        }
        return Sound.ELEPHANT_TRUMPET;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i("SoundSelector", "Touch Registered x: " + x);
                Log.i("SoundSelector", "Touch Registered y: " + y);
                if ((y < height / 2) && (x < width / 2)) {
                    Log.i("SoundSelector", "Top Left");
                    Log.i("SoundSelector", "-----------");
                    quadrantSelected = Quadrant.TOP_LEFT;
                } else if ((y > height / 2) && (x < width / 2)) {
                    Log.i("SoundSelector", "Bottom Left");
                    Log.i("SoundSelector", "-----------");
                    quadrantSelected = Quadrant.BOTTOM_LEFT;
                } else if ((y < height / 2) && (x > width / 2)) {
                    Log.i("SoundSelector", "Top Right");
                    Log.i("SoundSelector", "-----------");
                    quadrantSelected = Quadrant.TOP_RIGHT;
                } else {
                    Log.i("SoundSelector", "Bottom Right");
                    Log.i("SoundSelector", "-----------");
                    quadrantSelected = Quadrant.BOTTOM_RIGHT;
                }
                break;
            case MotionEvent.ACTION_MOVE:
            case MotionEvent.ACTION_UP:
        }
        imageClicked();
        return false;
    }
}