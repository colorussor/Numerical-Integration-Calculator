import java.util.Scanner;
public class Numerical_Integration {

	//The following method will solve using the midpoint rule
	public static double midpoint(double a, double b, double c, double d, double e, double f, double n, double star, double end, double dx) {
		double sum = 0;
		double xsum = 0;
		double temp = 0;
		for(double i=star; i<end; i+=dx) {
			xsum = ((i)+(i+dx))/(2);
			sum = ((a)*Math.pow(xsum, 5))+((b)*Math.pow(xsum, 4))+((c)*Math.pow(xsum, 3))+((d)*Math.pow(xsum, 2))+((e)*(xsum))+(f);
			temp = temp + sum;
		}
		return temp*dx;
	}
	//The following method will solve using the trapezoidal rule.
	public static double trapezoidal(double a, double b, double c, double d, double e, double f, double n, double star, double end, double dx) {
		double trapsum = 0;
		double traptemp = 0;
		for(double i=star; i<end; i+=dx) {
			if (i==star) {
				trapsum = ((a)*Math.pow(i, 5))+((b)*Math.pow(i, 4))+((c)*Math.pow(i, 3))+((d)*Math.pow(i, 2))+((e)*(i))+(f);
			}else {
				trapsum = (2)*(((a)*Math.pow(i, 5))+((b)*Math.pow(i, 4))+((c)*Math.pow(i, 3))+((d)*Math.pow(i, 2))+((e)*(i))+(f));
			}
			
			traptemp = traptemp + trapsum;
		}
		double lastval = 0;
		lastval = ((a)*Math.pow(end, 5))+((b)*Math.pow(end, 4))+((c)*Math.pow(end, 3))+((d)*Math.pow(end, 2))+((e)*(end))+(f);
		return ((traptemp + lastval)*(dx/2));
	}
	
	//The following method will solve using the Simpsons method
	public static double simpsons(double mid, double trapezoid) {
		double sim = ((2)*(mid) + (trapezoid))/(3);
		return sim;
	}
	//The following method will solve using the Fundamental Theorem of Calculus 
	public static double fundamental(double a, double b, double c, double d, double e, double f, double star, double end) {
		double endsum = ((a*Math.pow(end, 6))/(6))+((b*Math.pow(end, 5))/(5))+((c*Math.pow(end, 4))/(4))+((d*Math.pow(end, 3))/(3))+((e*Math.pow(end, 2))/(2))+f*end;
		double starsum = ((a*Math.pow(star, 6))/(6))+((b*Math.pow(star, 5))/(5))+((c*Math.pow(star, 4))/(4))+((d*Math.pow(star, 3))/(3))+((e*Math.pow(star, 2))/(2))+f*star;
		
		return endsum - starsum;
	}
	//The following method will calculate the percent error for each of the methods above 
	public static double percenterror(double foc, double method) {
		return Math.abs(((foc-method)/((foc)+(method/2)))) * 100;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		//This sets all the value for the equations to zero, which is a common programming practce
		double a, b, c, d, e, f, n, start, end = 0;
		
		//The following lines ask the user for the inputs used in the calculator
		System.out.printf("Enter the starting limit of integration: ");
		//Stores the starting limit of integration
		start = input.nextDouble();
		System.out.printf("Enter the ending limit of integration: ");
		//Stores the ending limit of integration
		end = input.nextDouble();
		System.out.printf("Enter the number of sub intervals, n: ");
		//Stores the n value
		n = input.nextDouble();
		System.out.printf("Enter coefficients for the 5th degree polynomial ");
		System.out.printf("Ax^5 + Bx^4 + Cx^3 + Dx^2 + Ex + F%n");
		System.out.printf("Separate by a space: ");
		
		//Stores all the values for a-f
		a = input.nextDouble();
		b = input.nextDouble();
		c = input.nextDouble();
		d = input.nextDouble();
		e = input.nextDouble();
		f = input.nextDouble();

		//Calculates and stores DeltaX
		double deltX = 0;
		//deltX = n;
		deltX = (end-start)/(n);
		
		//The following lines are used for calling methods in order to make calculations.
		double mid = midpoint(a, b, c, d, e, f , n, start, end, deltX);
		double trapezoid = trapezoidal(a, b, c, d, e, f , n, start, end, deltX);
		double simpson = simpsons(mid, trapezoid);
		double fund = fundamental(a, b, c, d, e, f , start, end);
		double percentmid = percenterror(fund, mid);
		double percenttrapezoid = percenterror(fund, trapezoid);
		double percentsimpsons = percenterror(fund, simpson);
		
		//The following lines are for making the print statements in the console 
		System.out.printf("%nArea, with Fundamental Theorem of Calculus:  %.8f%n%n", fund);
		System.out.printf("Midpoint: %.8f%n",mid);
		System.out.printf("Percent Error Midpoint: %.10f%n%n", percentmid);
		System.out.printf("Trapezoidal: %.8f%n", trapezoid);
		System.out.printf("Percent Error Trapezoid: %.10f%n%n", percenttrapezoid);
		System.out.printf("Simpsons: %.8f%n", simpson);
		System.out.printf("Percent Error Simpsons: %.10f%n%n", percentsimpsons);
		System.out.println(System.getProperty("java.runtime.version"));

	}

}
