package joe.game.sf;


import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class ImageBank {
	
	private static HashMap<String, Image> images;
	
	private ImageBank(){}
	
	public static void init(){
		images = new HashMap<String, Image>();
	}
	
	public static boolean loadImage(String filename, String imageName){
		boolean loaded = false;
		try {
			images.put(imageName, ImageIO.read(new File(filename)));
			loaded = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return loaded;
	}
	
	public static Image getImage(String imageName){
		return images.get(imageName);
	}
}
