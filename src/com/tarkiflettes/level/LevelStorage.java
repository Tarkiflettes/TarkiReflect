package com.tarkiflettes.level;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class LevelStorage {

	private List<Level> levels = new ArrayList<>();
	
	private File file = new File("pata.te");
			
	public LevelStorage() {
		
		file = new File("pata.te");
		try {

			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			levels = (List<Level>) ois.readObject();
			ois.close();
			
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		 
	}
	
	public List<Level> getlevels() {
		return levels;
	}

	public int getLevelCount() {
		return levels.size();
	}
	
	public Level getlevel(int index) {
		if (index<getLevelCount()) 
			return levels.get(index);
		else
			return levels.get(0);
	}
	public void addLevel(Level level) {
		
		levels.add(level);
		savefile();
		
	}
	public void removeLevel(int index) {

		if (index<getLevelCount()) {
			levels.remove(index);
			savefile();
		}
		
	}
	public void modifyLevel(int index, Level level) {
		if (index<getLevelCount())
			levels.set(index, level);
	}
	
	private void savefile() {
		try {
			
		    FileOutputStream fos = new FileOutputStream(file);
		    ObjectOutputStream oos = new ObjectOutputStream(fos);   
		    oos.writeObject(levels);
		    oos.close(); 
		    
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
