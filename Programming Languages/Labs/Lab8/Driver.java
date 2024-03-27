import java.util.*;
public class Driver {

	public static void main(String[] args) {

		// %%%%%%%%%%%%%%%%%%%% QUESTION 2 %%%%%%%%%%%%%%%%%%%%%%%
		int curve = -1;
		float grade = (float) -0.0;
		// Create the Scanner code to gather a float and an integer using the variables already created
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the grade you received: ");
		grade = sc.nextFloat(); // code here
		System.out.println("Please enter the curve percentage you will receive: (example 5%) ");
		curve = sc.nextInt();// code here
		// just for a hint for the integer (Integer) portion, try below:
		// https://docs.oracle.com/javase/8/docs/api/?java/lang/Integer.html
		System.out.println("Here are the values collected");
		System.out.println("Grade Received: " + grade + ", Curve Received: " + curve); // Display both values collected using a System.out.println
		// %%%%%%%%%%%%%%%%%%%% QUESTION 2 %%%%%%%%%%%%%%%%%%%%%%%
		


		// %%%%%%%%%%%%%%%%%%%% QUESTION 3 %%%%%%%%%%%%%%%%%%%%%%%
		// Using the variables and the new values received (curve and grade), call the curvedGrade  
		// (first one) function from here and display the results the function returns here
		// 1. fix the curvedGrade function below. Remember, if you get a 90, with 10% curve, you now have a 99%
		float finalGrade = curvedGrade(grade, curve);// 2. call function
		System.out.println("The final grade after the curve is " + finalGrade);// 3. display result			
		// %%%%%%%%%%%%%%%%%%%% QUESTION 3 %%%%%%%%%%%%%%%%%%%%%%%
		


		// %%%%%%%%%%%%%%%%%%%% QUESTION 4 %%%%%%%%%%%%%%%%%%%%%%%
		Student stu1 = new Student("Esha", "Adhawade", 90); // Create instance of a Student here
		curvedGrade(stu1, 10); // call and pass STUDENT and a curved value to curvedGrade (second one) function
		System.out.println(stu1.getfirstName() + " " + stu1.getlastName() + " " + stu1.getscore()); // display the new results ONLY using the "get" Student class functions
		System.out.println(stu1);// display the new results ONLY using the "toString" Student class functions
		// %%%%%%%%%%%%%%%%%%%% QUESTION 4 %%%%%%%%%%%%%%%%%%%%%%%
		


		// %%%%%%%%%%%%%%%%%%%% QUESTION 5 %%%%%%%%%%%%%%%%%%%%%%%
		int value1 = 23;
		float value2 = (float) 23.5;
		String value3 = "Lupoli";
		int [] value4 = {2,3,4,5};
		passingExercise(value1, value2, value3, value4); // using the values directly above, call the passingExercise function
		System.out.println("Here is the resulting value for value1->" + value1);
		System.out.println("Here is the resulting value for value2->" + value2);
		System.out.println("Here is the resulting value for value3->" + value3);
		System.out.println("Here is the resulting value for value4->" + value4);
		// notice the displays below. Which values were changed by the function??
		System.out.println("Here is the resulting value for value4[0]->" + value4[0]);
		System.out.println("We can see that passingExercise changed value4 at index 0");
		// %%%%%%%%%%%%%%%%%%%% QUESTION 5 %%%%%%%%%%%%%%%%%%%%%%%
		
		
		System.out.println("Program complete.");
	}
	
	public static float curvedGrade(float thisGrade, int percentCurve)
	{
		float result = 0; // default value
		// create the code to get this function to truely work
		result = thisGrade + (thisGrade * ((float)percentCurve/100));	
		return result;
	}

	public static void curvedGrade(Student thisStudent, int percentCurve)
	{
		// reset value WITHIN the Student instance to new curved grade!!
		thisStudent.setscore(curvedGrade(thisStudent.getscore(), percentCurve));
	}
	
	public static void passingExercise(int x, float y, String z, int [] array)
	{
		x = x * 10;
		y = y * 10;
		z += 'Z';
		array[0] = -23;
	}

}