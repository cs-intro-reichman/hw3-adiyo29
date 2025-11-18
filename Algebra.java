// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	  // System.out.println(plus(2,3)); // 5
	  // System.out.println(plus(0,3)); // 3
	  // System.out.println(plus(2,0)); //2
	  // System.out.println(plus(2,-3)); // -1
	  // System.out.println(plus(-2,-3));    // -5
	  // System.out.println(minus(7,2));  // 5
   	//	System.out.println(minus(2,7));  // -5
 	//	 System.out.println(minus(1,-5)); // 6
	//	 System.out.println(minus(-3,4)); // -7
	//	System.out.println(times(-3,4));  // -12
	//	System.out.println(times(3,4));  // 12
	System.out.println(times(-3,-4));  // 12
		System.out.println(times(3,-4));  // -12
   		//System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		//System.out.println(pow(5,3));      // 125
   		//System.out.println(pow(3,5)); // 81*3
		//System.out.println(pow(-5,2)); // 25
		//System.out.println(pow(-5,3)); // -125
		//System.out.println(pow(5,3)); // 125
		//System.out.println(pow(-5,0)); //1
		//System.out.println(pow(5,0)); //1
		//System.out.println(pow(5,2));    //
		//System.out.println(pow(0, 0));
   		//System.out.println(div(12,3));   // 12 / 3    
   		//System.out.println(div(5,5));    // 5 / 5  
   		//System.out.println(div(25,7));
		//System.out.println(div(0,5));
		//System.out.println(div(0,0));
		//System.out.println(div(-5,3)); // -1
		//System.out.println(div(-10,2)); // -4
		//System.out.println(div(-20,7)); // -2
		//System.out.println(div(-21,7)); // -3
		//System.out.println(mod(-5,3));
		//System.out.println(-5%3);
		//System.out.println(-10%2);
		//System.out.println(mod(-10,2));
		//System.out.println(mod(-20,7));
		//System.out.println(-20%7);
		//System.out.println(mod(-21,7));   // 25 / 7
   		//System.out.println(mod(25,7)); 
		//System.out.println(mod(-10,2));
		//System.out.println(mod(-20,7));
		//System.out.println(mod(-21,7));
   		//System.out.println(mod(120,6));  // 120 % 6    



		

		
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
			if (x2 > 0){ 
				while (x2 != 0) {
					x1++;
					x2--;
					}
				}
			else {
				while (x2 != 0) {
					x1--;
					x2++;
					}

			}
					return x1;

			}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
			if (x2 > 0){ 
				while (x2 != 0) {
					x1--;
					x2--;
					}
				}
			else {
				while (x2 != 0) {
					x1++;
					x2++;
					}

			}
					return x1;

			}

			// 3 * 5
			// 3 * -5 = -

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int result = 0;
		if( x1 > 0 ){
			if(x2>0){
				while( x2!= 0){
					result = plus(result, x1);
					x2--;
				}
			}
			else {			
				while(x1!=0){
					result = plus(result, x2);
					x1--;

				}
			}
				
			}
		else{     					// if X1 < 0, then check for X2 and calculate the times function
			if(x2>0){
				while( x2!= 0){
					result = plus(x1,result);
					x2--;

				}
			}
			else {					// both of the virable are negative, result is positive.
				
				while(x1!=0){
					result = minus(result, x2);
					x1++;

				}
			}

		}	
		return result;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int result = 1;

		if(n==0){
			return 1;
		}
		else{
			int count = n;
			while (count > 0){
				result = times(result, x);
				count--;
			}
		}
		return result;
		}
	
 // 5 / 3 = 1
 // 5 / -3 = -1
 // -5 / 3 = -1
 // -5 / -3 = 1

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		if (x2==0) return 0;
		else{

			boolean isOneg = x1 < 0; // if X1 (o) is negative its true
			boolean isTneg = x2 < 0; // is X2-T is negative its true
			boolean resultSymNeg = isOneg != isTneg; // returns true if one is negative and one is positive.

			int absX1 = isOneg ? minus(0, x1) : x1;
        	int absX2 = isTneg ? minus(0, x2) : x2;
			int counter = 0; // this will hold for me how many times x2 is part of x1		
			while (absX1 >= absX2) {
				counter++;
				absX1 = minus(absX1, absX2);				
			}

			if(resultSymNeg) return (minus(0, counter));
			else return counter;
		
	}
		
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		if(x2 == 0) return 0;
		else{
		int mod = 0;
		int amount = times(div(x1, x2),x2); // this will hold the closest number that divided in X1. if x1 is 16 and x2 is 5, it will hold 15.
		mod = minus(x1, amount);
				return mod;

		}
	}

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		if ( x == 0 || x == 1) return x;
		int g = 1;
		int sqrtA = times(g, g);
		int nextSqrt = sqrtA;
		int nextG = 1;
		while (sqrtA < x){
			sqrtA = nextSqrt;
			g = nextG;
			nextG = plus(g, 1); 
			nextSqrt = times(nextG, nextG);
			if (nextSqrt > x) return g;			 
		
		}
		return g;
	}	  	  
}