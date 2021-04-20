package au.edu.jcu.cp3406.foleyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SoundSelectorActivity extends AppCompatActivity {
    private int categorySelectedID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_selector);

        Intent intent = getIntent();
        categorySelectedID = intent.getIntExtra("categorySelected", R.id.mediumAnimalsButton);

    }

}