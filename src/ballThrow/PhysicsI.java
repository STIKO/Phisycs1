package ballThrow;
import java.util.Scanner;
import java.lang.*;

public class PhysicsI
{
	
	static float equPlus;
	static float equMinus;
	public static void main(String[] args) 
	{
		//My place

		
		//For try
	    
		final String fregExp = "([+]|-)?(([0-9]+[.]?[0-9]*)|([0-9]*[.]?[0-9]+))?";
		Boolean done = false;
		while (!done) 
		{
				
			Scanner input = new Scanner (System.in);
			System.out.println("How many balls? (1 OR 2): ");
			int bN = new Integer (input.nextInt());
			if (bN == 1) 
			{
				String bC;
				boolean check = false;
				do
				{
				System.out.println("Was the ball thrown or dropped?: ");
				bC = new String (input.next());
				if (bC.equalsIgnoreCase("thrown") || bC.equalsIgnoreCase("dropped")) {
					check = false;
				}else
				{
					check = true;
					System.out.println('"' + bC + '"' + " could not be understood. Please try again!");
				}
				}while(check);
				
				//Calculation when the ball dropped
				if (bC.equalsIgnoreCase("dropped"))
				{
					boolean dCorrect = true;
					String xi;
					String x;
					String v;
					do
					{
						System.out.println("Enter the height the ball was dropped from (x for unknown): ");
						xi = new String (input.next());
						if (isInput(xi)) 
						{
							dCorrect = true;	//Ends the input check
						}else 
						{
							System.out.println("The height must be a numeric value!");
							dCorrect = false;
						}
					}while (!dCorrect);
					do
					{
						System.out.println("Enter the final position (x for unknown): ");
						x = new String (input.next());
						if (isInput(x)) 
						{
							if (x.matches(fregExp) && xi.matches(fregExp)) 
							{
								float xinit = Float.parseFloat(xi);
								float xf = Float.parseFloat(x);
								if (xf > xinit) {
									System.out.println("The final position can NOT be greater than initial position!");
									dCorrect = false;
								}else
								{
									dCorrect = true;
								}
							}else
							{
								dCorrect = true;	//Ends the input check
							}
						}else 
						{
							System.out.println("The final position must be a numeric value!");
							dCorrect = false;
						}
					}while (!dCorrect);
					do
					{
						System.out.println("Enter the final velocity (x for unknown): ");
						v = new String (input.next());
						if (isInput(v)) 
						{
							dCorrect = true;	//Ends the input check
						}else 
						{
							System.out.println("The final velocity must be a numeric value!");
							dCorrect = false;
						}
					}while (!dCorrect);
					Drop.drop(xi, x, v);//Calling the drop method line 147

				} //The end of dropped ball
				//Calculation when the ball is thrown
				else if (bC.equalsIgnoreCase("thrown")) 
				{
					boolean uD = false;
					String thrown;
					do
					{
					System.out.println("Was the ball thrown upward or downward: ");
					thrown = new String (input.next());
					if (!(thrown.equalsIgnoreCase("upward")) && !(thrown.equalsIgnoreCase("downward"))) {
						System.out.println("Not a valid entry!");
						uD = false;
					}else
					{
						uD = true;
					}
					}while (!uD);
					if (thrown.equalsIgnoreCase("upward"))	//calculation when the ball thrown upward
					{	
						boolean correct = false;
						String height;
						do
						{
							System.out.println("From what height was the ball thrown upward? (x for unknown): ");
							System.out.println("Hint: if it's starts from the ground, enter 0: ");
							height = new String (input.next());
							if (!isInput(height)) 
							{
								System.out.println("The height entered is not a numeric value!");
								correct = false;
							}else
							{
							correct = true;
							}
						
						}while (!correct);
						String fP;
						do
						{
							System.out.println("Enter the final position (x for unknown): ");
							fP = new String(input.next());
							if (!isInput (fP)) 
							{
								System.out.println("You have entered a wrong formt!");
								correct = false;
							}else
							{
								correct = true;
							}
						}while (!correct);
						String vi;
						do
						{
							System.out.println("Enter the initial velocity (x for unknown): ");
							vi = new String(input.next());
							if (!isInput (vi)) 
							{
								System.out.println("You have entered a wrong formt!");
								correct = false;
							}else
							{
								correct = true;
							}
						}while (!correct);
						String v;
						do
						{
							System.out.println("Enter the final velocity (x for unknown): ");
							System.out.println("Enter 0 if it reaches the maximum height! ");
							v = new String(input.next());
							if (!isInput (v)) 
							{
								System.out.println("You have entered a wrong formt!");
								correct = false;
							}else
							{
								correct = true;
							}
						}while (!correct);
						
						String returned = ThrownUp.thrownU(vi, v, height, fP);
						
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					}else if (thrown.equalsIgnoreCase("downward")) 	//Thrown downward
					{
						
						boolean correct = false;
						String xi;
						do
						{
							System.out.println("From what height was the ball thrown downward? (x for unknown): ");
							xi = new String (input.next());
							if (!isInput(xi)) 
							{
								System.out.println("The height entered is not a numeric value!");
								correct = false;
							}else
							{
							correct = true;
							}
						
						}while (!correct);
						String x;
						do
						{
							System.out.println("Enter the final position (x for unknown): ");
							x = new String(input.next());
							if (!isInput (x)) 
							{
								System.out.println("You have entered a wrong formt!");
								correct = false;
							}else
							{
								if (x.matches(fregExp) && xi.matches(fregExp))
								{
									float xf = Float.parseFloat(x);
									float xinit = Float.parseFloat(xi);
									if (xf > xinit) 
									{
										System.out.println("The final position can NOT be greater than initial position! ");
										correct = false;
									}else
									{
										correct = true;
									}
									
								}else
								{
									correct = true;
								}
							}
						}while (!correct);
						String vi;
						do
						{
							System.out.println("Enter the initial velocity (x for unknown): ");
							vi = new String(input.next());
							if (!isInput (vi)) 
							{
								System.out.println("You have entered a wrong formt!");
								correct = false;
							}else
							{
								//The initial velocity for thrown down always negative, if it's not this will convert to negative
								if (!(vi.equalsIgnoreCase("x"))) {
									float negativ = Float.parseFloat(vi);
									if (negativ > 0) {
										float convert = new Float (-1 * negativ);
										vi = Float.toString(convert);
									}
								}
								correct = true;
							}
						}while (!correct);
						String v;
						do
						{
							System.out.println("Enter the final velocity (x for unknown): ");
							v = new String(input.next());
							if (!isInput (v)) 
							{
								System.out.println("You have entered a wrong formt!");
								correct = false;
							}else
							{
								//The final velocity for thrown down always negative, if it's not this will convert to negative
								if (!(v.equalsIgnoreCase("x"))) 
								{
									float negativ = Float.parseFloat(v);
									if (negativ > 0) {
										float convert = new Float (-1 * negativ);
										v = Float.toString(convert);
										
									}
								}
								if (v.matches(fregExp) && vi.matches(fregExp))
								{
									float vf = Float.parseFloat(v);
									float vinit = Float.parseFloat(vi);
									if (vf > vinit) {
										System.out.println("The final velocity MUST be greater than initial velocity in the negative direction!");
										correct = false;
									}else
									{
										correct = true;
									}
								}else
								{
									correct = true;
								}
							}
						}while (!correct);
						
						ThrownDown.thrownD(vi, v, xi, x);
						
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					}else	//If the user input is something other than thrown or dropped
					{
					System.out.println("Not valid entry!");
					}
				}
			}
			//2 balls option
			else{
				System.out.println("This option is underdevelopment.");
			}
			//asks the user if he wants to start the process again
			String repeat;	
			boolean correct = true;
			do
			{
				System.out.println("");
				System.out.println("Do you want to start over? y/n: ");
				repeat = new String (input.next());
				if (repeat.equalsIgnoreCase("n")) {
					done = true;
					correct = true;
				}else if (repeat.equalsIgnoreCase("y")) {
					done = false;
					correct = true;
				}else{
					System.out.println("Not valid entry! y for yes, n for no");
					correct = false;
				}
			}while (!correct);
			
		} //while loop
		

	}
	
	//Methods/////////////////////////////////////////////////////////////////////
	
	
	private static boolean isInput (String n)	//Checks if the input a numeric or x 
		{
			String inp = n;
			if (inp.equalsIgnoreCase("x")) return true;
			else if (inp.matches("([+]|-)?(([0-9]+[.]?[0-9]*)|([0-9]*[.]?[0-9]+))?")) return true;
				
			return false;
		}
	//end methods////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//Quadratic formula
	private static float quadratic(float a, float b, float c)
	{
		float sqrt = new Float (Math.sqrt(Math.pow(b, 2) - 4 * a * c));
		equPlus = new Float (((0 - b) + sqrt) / (2 * a));
		equMinus = new Float (((0 - b) - sqrt) / (2 * a));
		return equPlus;
	}

}

