package ballThrow;


public class ThrownDown {
	//Thrown Downward
	public static String thrownD(String vi, String v, String xi, String x) 
	{
		float g = new Float (-9.8);
		final String fregExp = "([+]|-)?(([0-9]+[.]?[0-9]*)|([0-9]*[.]?[0-9]+))?";
		if (xi.equalsIgnoreCase("x") && x.equalsIgnoreCase("x") && v.matches(fregExp) && vi.matches(fregExp)) //the x represents the unknown
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
			System.out.println("The displacement is: " + displacement);
			}
			//calculates final velocity
		}else if ((vi.matches(fregExp) && xi.matches(fregExp) && x.equalsIgnoreCase("x") && v.equalsIgnoreCase("x")) || 
				(vi.matches(fregExp) && xi.matches(fregExp) && x.matches(fregExp) && v.equalsIgnoreCase("x")))
		{
			String out = new String("");
			float xF = 0;
			float xInit = Float.parseFloat(xi);
			float vInit = Float.parseFloat(vi);
			
			if (x.equalsIgnoreCase("x")) 
			{
				xF = 0;
				out = "A) The ball hits the ground with a velocity of %.3f m/s. ";
			}else if (x.matches(fregExp)) 
			{
				xF = Float.parseFloat(x);
				out = "A) At height " + x + " the velocity is %.3f m/s.";
			}
			
				float vF = new Float (Math.sqrt(Math.pow(vInit, 2) + 2 * g * (xF - xInit)) );
				if (Double.isNaN(vF)) {
					System.out.println("There is something wrong, please check your enteries and try again!");
				}else
				{
					System.out.printf(out, vF);
				}
				//calculates for final position
		}else if (xi.matches(fregExp) && v.matches(fregExp) && vi.matches(fregExp) && x.equalsIgnoreCase("x")) 
		{
			float vInit = Float.parseFloat(vi);
			float xInit = Float.parseFloat(xi);
			float vF = Float.parseFloat(v);
			float xF = new Float ( (Math.pow(vF, 2) - Math.pow(vInit, 2) + 2 * g * xInit) / (2 * g) );
			if (Double.isNaN(xF)) {
				System.out.println("There is something wrong, please check your enteries and try again!");
			}else
			{
				System.out.printf("The ball has a velocity of " + vF + " at %.3f m. ", xF);
			}
			//calculation to find the initial height
		}else if (x.matches(fregExp) && vi.matches(fregExp) && v.matches(fregExp) && xi.equalsIgnoreCase("x")) {
			float xF = Float.parseFloat(x);
			float vF = Float.parseFloat(v);
			float vInit = Float.parseFloat(vi);
			float xInit = new Float ( (Math.pow(vInit, 2) - Math.pow(vF, 2) + 2 * g * xF) / (2 * g) );
			if (Double.isNaN(xInit)) {
				System.out.println("There is something wrong, please check your enteries and try again!");
			}else
			{
				System.out.println("A) The initial position of the ball was " + xInit + " m.");

			}
			
		}else
		{
			System.out.println("Not enough information given or may be something wrong. Please check your enteries!"); 
		}
		return null;
	}
}