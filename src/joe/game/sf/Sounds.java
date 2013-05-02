package joe.game.sf;

import java.io.IOException;
import java.util.HashMap;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sounds {
	
	public static HashMap<String, Clip> clips;
	
	public static void init(){
		clips = new HashMap<String, Clip>();
	}
	
	/**
	 * loads a sound into the clips HashMap with the key soundName
	 * @param filename
	 * @param soundName
	 * @return
	 */
	public static boolean loadSound(String filename, String soundName){
		boolean loaded = false;
		try {
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(Sounds.class.getResource(filename));
			Clip clip = AudioSystem.getClip();
			clip.open(audioIn);
			clips.put(soundName, clip);
			loaded = true;
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return loaded;
	}
	
	public static void playSound(String soundName){
		clips.get(soundName).setFramePosition(0);
		clips.get(soundName).start();
	}
	
	public static void stopSound(String soundName){
		clips.get(soundName).stop();
		clips.get(soundName).setFramePosition(0);
	}
	
	public static void loopSound(String soundName){
		clips.get(soundName).setFramePosition(0);
		clips.get(soundName).loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	public static void setVolume(float value){
		for(int i=0; i<clips.size(); i++){
			FloatControl volume = ((FloatControl) clips.get(i).getControl(FloatControl.Type.MASTER_GAIN));
			volume.setValue(value);
		}
	}
}
