package au.edu.jcu.cp3406.foleyapp;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class UnitTest {
    @Test
    public void testAudioManager() {
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        AudioManager audioManager = new AudioManager(appContext);
        assertNotNull(Sound.CAT_MEOW);
        assertNotNull(Sound.COW_MOO);
        assertNotNull(Sound.DOG_BARK);
        assertNotNull(Sound.DUCK_QUACK);
        assertNotNull(Sound.ELEPHANT_TRUMPET);
        assertNotNull(Sound.FROG_CROAK);
        assertNotNull(Sound.GOOSE_CALL);
        assertNotNull(Sound.HAWK_CALL);
        assertNotNull(Sound.MOUNTAIN_LION_ROAR);
        assertNotNull(Sound.PIG_SNORT);
        assertNotNull(Sound.RATTLESNAKE_RATTLE);
        assertNotNull(Sound.ROOSTER_CROW);
    }
}