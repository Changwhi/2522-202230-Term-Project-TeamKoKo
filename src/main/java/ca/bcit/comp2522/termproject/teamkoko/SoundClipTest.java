package ca.bcit.comp2522.termproject.teamkoko;

import javax.sound.sampled.*;
import javax.swing.*;
import java.io.IOException;
import java.net.URL;

//extends JFrame
public class SoundClipTest {

    private Clip clip;

    public SoundClipTest() {
        try {
            // Open an audio input stream.
            URL url = this.getClass().getClassLoader().getResource("PinkSoldier.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
            // Get a sound clip resource.
            clip = AudioSystem.getClip();
            // Open audio clip and load samples from the audio input stream.
            clip.open(audioIn);

        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void playSong() {
        clip.start();
    }

    public void stopSong() {
        clip.stop();
    }
}
