package ballThrow;


public class ThrownUp {
	/************************************************************************************/
		//Checks the input parameters and does the math based on the given parameters and this method returns a string "result"
		//(v^2)=vinit^(2)+2a(x-xinit)
		public static String thrownU(String vi, String v, String xi, String x)	
		{
			float g = new Float (-9.8);
			final String fregExp = "([+]|-)?(([0-9]+[.]?[0-9]*)|([0-9]*[.]?[0-9]+))?";
			if (xi.equalsIgnoreCase("x") && x.equalsIgnoreCase("x") && v.matches(fregExp) && vi.matches(fregExp)) 
			{
				float vInit = Float.parseFloat(vi);
				float vF = Float.parseFloat(v);
				float displacement = new Float ((Math.pow(vF, 2) - Math.pow(vInit, 2))/(2 * g));
				//String disS = Float.toString(displacement);
				System.out.println(displacement);
				if (Double.isNaN(displacement)) {
					System.out.println("There is something wrong, please check your enteries and try again!");
				}else
				{
				System.out.print("The displacement is: " + displacement);
				}
			}else if ((vi.matches(fregExp) && xi.matches(fregExp) && x.equalsIgnoreCase("x") && v.equalsIgnoreCase("x")) || 
					(vi.matches(fregExp) && xi.matches(fregExp) && v.matches(fregExp) && x.equalsIgnoreCase("x")))
			{
				if (v.equalsIgnoreCase("x")) 
				{
					float fV = 0;
					float xInit = Float.parseFloat(xi);
					float vInit = Float.parseFloat(vi);
					float maxHeight = new Float (xInit + ( (fV - Math.pow(vInit, 2)) / (2 * g) ));
					if (Double.isNaN(maxHeight)) {
						System.out.println("There is something wrong, please check your enteries and try again!");
					}else
					{
					System.out.printf("A) The ball reaches its maximum height at %.3f m. ", maxHeight);
					System.out.println("");
					}
					//Velocity when the ball hits the ground
					float displ = new Float(0 - xInit);
					float oper = new Float(Math.sqrt(Math.pow(vInit, 2) + (2 * g) * displ));
					if (Double.isNaN(oper)) {
						System.out.println("There is something wrong, please check your enteries and try again!");
					}else
					{
					System.out.printf("B) The velocity when the ball hits the ground is - %.3f m/s. ", oper);
					}
	
				}else if (v.matches(fregExp)) 
				{
					float vF = Float.parseFloat(v);
					float xInit = Float.parseFloat(xi);
					float vInit = Float.parseFloat(vi);
					float maxHeight = new Float ( (Math.pow(vF, 2) - Math.pow(vInit, 2) + 2 * g * xInit) / (2 * g) );
					System.out.print("At velocity " + vF + " m/s. The ball reaches the height of " + maxHeight + "m");
				}
			}else if (xi.matches(fregExp) && x.matches(fregExp) && vi.matches(fregExp) && v.equalsIgnoreCase("x")) 
			{
				float vInit = Float.parseFloat(vi);
				float xInit = Float.parseFloat(xi);
				float xF = Float.parseFloat(x);
				float equa = new Float ( Math.pow(vInit, 2) + (2 * g) * (xF - xInit) );
				float vF = new Float (Math.sqrt(equa));
				if (Double.isNaN(vF)) {
					System.out.println("There is something wrong, please check your enteries and try again!");
				}else
				{
					if (xF < xInit) {
						vF = (-1 * vF);
						System.out.printf("The velocity at position " + xF + " is  %.3f m/s. ", vF);
					}else
					{
						System.out.printf("The velocity at position " + xF + " is %.3f m/s. ", vF);
					}
				}
				
			}else if (xi.matches(fregExp) && x.matches(fregExp) && v.equalsIgnoreCase("x") && vi.equalsIgnoreCase("x") ||
					xi.matches(fregExp) && x.matches(fregExp) && v.matches(fregExp) && vi.equalsIgnoreCase("x")) 
			{
				float vF;
				if (v.equalsIgnoreCase("x")) {
					vF = 0;
				}else
				{
					vF = Float.parseFloat(v);
				}
				float xInit = Float.parseFloat(xi);
				float xF = Float.parseFloat(x);
				float equa = new Float ( Math.sqrt((Math.pow(vF, 2) - (2 * g) * (xF - xInit))) );
				if (Double.isNaN(equa)) {
					System.out.println("There is something wrong, please check your enteries and try again!");
				}else
				{
				System.out.printf("A) The initial velocity of the ball was %.3f m/s.", equa);
				}
			}else if (x.matches(fregExp) && vi.matches(fregExp) && v.matches(fregExp) && xi.equalsIgnoreCase("x")) {
				float xF = Float.parseFloat(x);
				float vF = Float.parseFloat(v);
				float vInit = Float.parseFloat(vi);
				float xInit = new Float ( (Math.pow(vInit, 2) - Math.pow(vF, 2) + 2 * g * xF) / (2 * g) );
				if (Double.isNaN(xInit)) {
					System.out.println("There is something wrong, please check your enteries and try again!");
				}else
				{
					System.out.println("The ball was thrown from a height of " + xInit + " m.");

				}
				
			}else
			{
				System.out.println("Not enough information given or may be something wrong. Please check your enteries!"); 
			}
			return null;
			
		}
}