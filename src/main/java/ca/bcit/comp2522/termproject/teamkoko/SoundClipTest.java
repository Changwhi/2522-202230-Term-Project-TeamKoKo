package ca.bcit.comp2522.termproject.teamkoko;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

/**
 * Play music.
 * @author Changhwi Oh
 * @version 1.0.0
 */
public class SoundClipTest {
    /**
     * Plays music.
     */
    public void playSong() {
        try {
            // Open an audio input stream.
            URL url = this.getClass().getClassLoader().getResource("squid.wav");
            assert url != null;
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
            // Get a sound clip resource.
            Clip clip = AudioSystem.getClip();
            // Open audio clip and load samples from the audio input stream.
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    /**
     * Stops music.
     */
    public void stopSong() {
        try {
            // Open an audio input stream.
            URL url = this.getClass().getClassLoader().getResource("gameover.wav");
            assert url != null;
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
            // Get a sound clip resource.
            Clip clip = AudioSystem.getClip();
            // Open audio clip and load samples from the audio input stream.
            clip.open(audioIn);
            clip.stop();

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    }

