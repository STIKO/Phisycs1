package ballThrow;


public class Drop {
	public static void drop(String xi, String x, String v)
		{	//Drop Method
			final String fregExp = "([+]|-)?(([0-9]+[.]?[0-9]*)|([0-9]*[.]?[0-9]+))?";
			float g = new Float (-9.8);
			if (xi.matches(fregExp) && x.equalsIgnoreCase("x") && v.equalsIgnoreCase("x")) 
			{
				float height =  Float.parseFloat(xi);
				float oper = new Float (2 * g * (0 - height));
				float sqrt = new Float (Math.sqrt(oper));
				float vilo = new Float (sqrt - 2 * sqrt);
				System.out.printf("A) The velocity when the ball hits the ground is: %.3f m/s. ", vilo);
				float time = new Float (vilo / g);
				System.out.printf("After %.3f s", time );
			}else if (xi.equalsIgnoreCase("x") && x.matches(fregExp) && v.matches(fregExp)) 
			{
				float xF = Float.parseFloat(x);
				float vF = Float.parseFloat(v);
				float result = new Float( (0-Math.pow(vF, 2) + 2 * g * xF) / (2 * g) );
				System.out.printf("A) The ball was dropped from a height of %.3f m. ", result);
				
			}else if (xi.matches(fregExp) && x.equalsIgnoreCase("x") && v.matches(fregExp)) {
				float vF = Float.parseFloat(v);
				float xInit = Float.parseFloat(xi);
				float result = new Float( (Math.pow(vF, 2) + 2 * g * xInit) / (2 * g) );
				System.out.printf("A) The ball will have a velocity of '" + vF + "' at height %.3f m. ", result);
				
			}else
			{
				System.out.println("Not enough information! ");
			}
			
		}
}