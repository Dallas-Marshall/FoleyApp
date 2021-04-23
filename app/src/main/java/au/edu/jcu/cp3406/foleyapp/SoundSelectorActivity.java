package au.edu.jcu.cp3406.foleyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Locale;
import java.util.Random;

public class SoundSelectorActivity extends AppCompatActivity {
    private int categorySelectedID;
    private ImageView image01;
    private ImageView image02;
    private ImageView image03;
    private ImageView image04;
    private AudioManager audioManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_selector);

        audioManager = new AudioManager(this);

        Intent intent = getIntent();
        categorySelectedID = intent.getIntExtra("categorySelected", R.id.mediumAnimalsButton);

        image01 = findViewById(R.id.image01);
        image02 = findViewById(R.id.image02);
        image03 = findViewById(R.id.image03);
        image04 = findViewById(R.id.image04);

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

    }

    public void imageClicked(View image) {
        if (audioManager.isReady()) {
            Sound sound = getSound(image.getId());
            Log.i("AudioManager", "Sound Played: " + sound);
            audioManager.play(sound);
        }
    }


    private Sound getSound(int imageClickedID) {
        if (categorySelectedID == R.id.smallAnimalsButton) {
            if (imageClickedID == R.id.image01) {
                return Sound.FROG_CROAK;
            } else if (imageClickedID == R.id.image02) {
                return Sound.HAWK_CALL;
            } else if (imageClickedID == R.id.image03) {
                return Sound.RATTLESNAKE_RATTLE;
            } else if (imageClickedID == R.id.image04) {
                return Sound.ROOSTER_CROW;
            }
        } else if (categorySelectedID == R.id.mediumAnimalsButton) {
            if (imageClickedID == R.id.image01) {
                return Sound.DOG_BARK;
            } else if (imageClickedID == R.id.image02) {
                return Sound.CAT_MEOW;
            } else if (imageClickedID == R.id.image03) {
                return Sound.GOOSE_CALL;
            } else if (imageClickedID == R.id.image04) {
                return Sound.DUCK_QUACK;
            }
        } else {
            if (imageClickedID == R.id.image01) {
                return Sound.COW_MOO;
            } else if (imageClickedID == R.id.image02) {
                return Sound.ELEPHANT_TRUMPET;
            } else if (imageClickedID == R.id.image03) {
                return Sound.PIG_SNORT;
            } else if (imageClickedID == R.id.image04) {
                return Sound.MOUNTAIN_LION_ROAR;
            }
        }
        return Sound.ELEPHANT_TRUMPET;
    }
}