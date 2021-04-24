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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void categorySelected(View buttonPressedView) {
        Intent intent = new Intent(this, SoundSelectorActivity.class);
        intent.putExtra("categorySelected", buttonPressedView.getId());
        startActivity(intent);
    }
}