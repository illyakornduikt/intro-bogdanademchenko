package main;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;

public class Sound {
    Clip clip;
    URL soundURL[] = new URL[30];

    public Sound(){
        try {
            soundURL[0] = Paths.get("res/sounds/BlueBoyAdventure.wav").toUri().toURL();
            soundURL[1] = Paths.get("res/sounds/coin.wav").toUri().toURL();
            soundURL[2] = Paths.get("res/sounds/powerup.wav").toUri().toURL();
            soundURL[3] = Paths.get("res/sounds/unlock.wav").toUri().toURL();
            soundURL[4] = Paths.get("res/sounds/fanfare.wav").toUri().toURL();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
    public void setFile(int i){
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void play(){
        clip.start();
    }
    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop(){
        clip.stop();
    }
}