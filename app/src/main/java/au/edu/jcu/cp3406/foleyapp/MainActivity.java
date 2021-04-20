package au.edu.jcu.cp3406.foleyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private AudioManager audioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        audioManager = new AudioManager(this);

        final TextView info = findViewById(R.id.info);
        Button smallAnimalsButton = findViewById(R.id.smallAnimalsButton);
        Button mediumAnimalsButton = findViewById(R.id.mediumAnimalsButton);
        Button largeAnimalsButton = findViewById(R.id.largeAnimalsButton);
    }

    public void imageClicked(View button) {
        if (audioManager.isReady()) {
            int buttonClickedID = button.getId();
            Sound sound = getSound(buttonClickedID);
            Locale locale = Locale.getDefault();
            String confirmation = String.format(locale, "Playing \"%s\"", sound.toString());
            Toast.makeText(MainActivity.this, confirmation, Toast.LENGTH_SHORT).show();
            audioManager.play(sound);
        }
    }

    private Sound getSound(int buttonClickedID) {
        if (buttonClickedID == R.id.smallAnimalsButton) {
            Random random = new Random();
            int value = random.nextInt(Sound.values().length);
            switch (value) {
                case 0:
                    return Sound.CAT_MEOW;
                case 1:
                    return Sound.COW_MOO;
                default:
                    return Sound.DOG_BARK;
            }
        }
        return Sound.ELEPHANT_TRUMPET;
    }

    public void categorySelected(View buttonPressedView) {
        Intent intent = new Intent(this, SoundSelectorActivity.class);
        intent.putExtra("categorySelected", buttonPressedView.getId());
        startActivity(intent);
    }
}