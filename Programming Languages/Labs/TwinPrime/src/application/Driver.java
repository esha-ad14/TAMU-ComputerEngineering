/* FILE DESCRIPTION--
 * The purpose of the Driver class is to gather user input from the GUI and
 * display the results using and instance of FileIO once the "generate" button
 * is clicked. 
 * 
 */
package application;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.event.ActionEvent;

public class Driver {
	
	@FXML
	private TextField field1;  
	@FXML
	private TextField field2;  
	@FXML
	private TextArea area1;   
	@FXML
	private Button button1;  
	
	// Attributes
	public int n_pairs;
	public String file_location;
	private static final String DEFAULT_LOC = "C:\\Results";
	private static final int DEFAULT_PAIRS = 10;
	
	/*
	 * This function collects the n_pairs and file_location from the text fields. It then
	 * creates a new instance of FileIO to gatherHexagonalCrosses() and get the toString()
	 * to write to the display area to display the results.
	 */
	public void generate(ActionEvent event) {
		
		area1.clear();
		area1.setText("Generating...");
		
		n_pairs = field1.getText().trim().isEmpty() ? 
				DEFAULT_PAIRS : Integer.parseInt(field1.getText());
		file_location = field2.getText().trim().isEmpty() ? 
				DEFAULT_LOC : field2.getText();
		
		FileIO file = new FileIO(n_pairs, file_location);
		file.gatherHexagonalCrosses();
		
		String result = file.toString();
		area1.setText(result);
		
		System.out.println("DONE!");
		
		
		
	}
	
	
}
