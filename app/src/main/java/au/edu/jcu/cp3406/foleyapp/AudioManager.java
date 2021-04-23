package au.edu.jcu.cp3406.foleyapp;

import android.content.Context;
import android.media.SoundPool;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;

// This code demonstrates one way to load several sounds
// into a sound pool. Each sound has a unique sampleId.
// SampleId's are not the same as the raw resource ids

public class AudioManager implements SoundPool.OnLoadCompleteListener {
    private final Map<Sound, Integer> soundIds;
    private final SoundPool pool;
    private int loadId;
    private boolean ready;

    AudioManager(Context context) {
        soundIds = new HashMap<>();
        pool = new SoundPool(4, android.media.AudioManager.STREAM_MUSIC, 0);
        pool.setOnLoadCompleteListener(this);

        // load order matches Sound's declaration order
        pool.load(context, R.raw.cat_meow, 0);
        pool.load(context, R.raw.cow_moo, 0);
        pool.load(context, R.raw.dog_bark, 0);
        pool.load(context, R.raw.duck_quack, 0);
        pool.load(context, R.raw.elephant_trumpet, 0);
        pool.load(context, R.raw.frog_croak, 0);
        pool.load(context, R.raw.goose_call, 0);
        pool.load(context, R.raw.hawk_call, 0);
        pool.load(context, R.raw.mountain_lion_roar, 0);
        pool.load(context, R.raw.pig_snort, 0);
        pool.load(context, R.raw.rattlesnake_rattle, 0);
        pool.load(context, R.raw.rooster_crow, 0);
    }

    @Override
    public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
        this.ready = status == 0;

        // Each time a load finishes, the next loadId
        // is used to determine which enum value to use
        Sound sound = Sound.values()[loadId++];
        Log.i("AudioManager", "loaded sound: " + sound);
        soundIds.put(sound, sampleId);
    }

    boolean isReady() {
        return ready;
    }

    void play(Sound sound) {
        Integer id = soundIds.get(sound);
        if (id != null) {
            pool.play(id, 1, 1, 1, 0, 1);
        }
    }
}