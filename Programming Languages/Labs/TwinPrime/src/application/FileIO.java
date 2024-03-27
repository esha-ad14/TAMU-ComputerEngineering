/* FILE DESCRIPTION--
 * The file is the child class of TwinPrimes and grand child class of Prime. The purpose
 * of this file is to collect all the hexagonal crosses from TwinPrimes and write it to a
 * file called "results.txt". The user can also give a file_location in which the function, 
 * gatherHexagonalCrosses(), will create a the file if it doesn't already exist. If the user
 * doesn't have a preferred location, the default location is in "C:\Results" (defined in 
 * Driver class). The function can also create a new directory and a new file "results.txt"
 * within that directory.
 */

package application;

import java.util.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileIO extends TwinPrimes{
	
	// Attributes
	public String file_location;
	private List<int []> hexagonal_crosses;
	private static final String FILENAME = "results.txt";
	
	/*
	 *  Constructor. Calls super with n_pairs on TwinPrimes so that we can use the functions
	 * in our parent class.
	 */
	public FileIO(int n_pairs, String file_location) {
		super(n_pairs);
		this.file_location = file_location;		
	}
	
	/*
	 * The purpose of gatherHexagonalCrosses() is to find the hexagonal crosses from
	 * TwinPrimes and write it into a file. We write the hexagonal crosses to a file 
	 * called "results.txt". The user can also give a file_location in which the function, 
	 * gatherHexagonalCrosses(), will create a the file if it doesn't already exist. 
	 * If the user doesn't have a preferred location, the default location is in "C:\Results" 
	 * (defined in Driver class). In any case, the function can create a new directory 
	 * if it doesn't exist and the new "results.txt" file to write the hexagonal crosses to.
	 */
	public void gatherHexagonalCrosses() {
		
		findHexagonalCrosses();
		hexagonal_crosses = getHexagonalCrosses();
		
		String path = getPath(this.file_location);
		File temp = new File(path);
		if (!temp.exists()) {
			temp.getParentFile().mkdirs();
			try {
				temp.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		try {
			FileWriter fw = new FileWriter(path);
			for (int[] hc: hexagonal_crosses) {
				String pair = hc[0] + ", " + hc[1];
				fw.write(pair + System.lineSeparator());
			}
			fw.close();
			System.out.println("File was created successfully!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	
	/*
	 * This function adds a backslash to the end of the file_location if it does not
	 * already exist. This ensures that we can properly create the path to write to 
	 * the "results.txt" file.
	 */
	private static String getPath(String file_loc) {
		String path = "";
		if (file_loc.charAt(file_loc.length() - 1) == '\\') {
			path = file_loc + "" + FILENAME;
		} else {
			path = file_loc + "\\" + FILENAME;
		}
		return path;
		
	}
	
	/*
	 * This is a toString function that returns a string of the hexagonal crosses.
	 */
	@Override
	public String toString() {
		String str = "";
		for (int[] hc: hexagonal_crosses) {
			str += hc[0] + ", " + hc[1] + "\n";
		}
		str += "Complete!";
		return str;
	}
	
	

}
