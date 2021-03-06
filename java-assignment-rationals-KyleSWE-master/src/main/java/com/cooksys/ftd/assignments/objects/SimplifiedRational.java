package com.cooksys.ftd.assignments.objects;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class SimplifiedRational implements IRational {
	private int numer, denom;
    /**
     * Determines the greatest common denominator for the given values
     *
     * @param a the first value to consider
     * @param b the second value to consider
     * @return the greatest common denominator, or shared factor, of `a` and `b`
     * @throws IllegalArgumentException if a <= 0 or b < 0
     */
    public static int gcd(int a, int b) throws IllegalArgumentException {
    	if(a <= 0 || b < 0) {throw new IllegalArgumentException();}
    	while(b > 0)
        {
            int c = a % b;
            a = b;
            b = c;
        }
        return a;
    }
    

    /**
     * Simplifies the numerator and denominator of a rational value.
     * <p>
     * For example:
     * `simplify(10, 100) = [1, 10]`
     * or:
     * `simplify(0, 10) = [0, 1]`
     *
     * @param numerator the numerator of the rational value to simplify
     * @param denominator the denominator of the rational value to simplify
     * @return a two element array representation of the simplified numerator and denominator
     * @throws IllegalArgumentException if the given denominator is 0
     */
    public static int[] simplify(int numerator, int denominator) throws IllegalArgumentException {
        if(denominator == 0) {throw new IllegalArgumentException();}
        int[] newArray = new int[2];
        int d = gcd(Math.abs(denominator), Math.abs(denominator));
        numerator = numerator / d;
        denominator = denominator / d;
        newArray[0] = numerator;
        newArray[1] = denominator;
        return newArray;  
    }

    /**
     * Constructor for rational values of the type:
     * <p>
     * `numerator / denominator`
     * <p>
     * Simplification of numerator/denominator pair should occur in this method.
     * If the numerator is zero, no further simplification can be performed
     *
     * @param numerator the numerator of the rational value
     * @param denominator the denominator of the rational value
     * @throws IllegalArgumentException if the given denominator is 0
     */
    public SimplifiedRational(int numerator, int denominator) throws IllegalArgumentException {
    	 if(denominator == 0) {throw new IllegalArgumentException();}
    	 if(numerator == 0) {
    		 numer = numerator;
    		 denom = denominator;
    		 }
    	 int[] newArr;
    	 newArr = simplify(numerator, denominator);
    	 numer = newArr[0];
    	 denom = newArr[1];
    }

    /**
     * @return the numerator of this rational number
     */
    @Override
    public int getNumerator() {
        return numer;
    }

    /**
     * @return the denominator of this rational number
     */
    @Override
    public int getDenominator() {
        return denom;
    }

    /**
     * Specializable constructor to take advantage of shared code between Rational and SimplifiedRational
     * <p>
     * Essentially, this method allows us to implement most of IRational methods directly in the interface while
     * preserving the underlying type
     *
     * @param numerator   the numerator of the rational value to construct
     * @param denominator the denominator of the rational value to construct
     * @return the constructed rational value (specifically, a SimplifiedRational value)
     * @throws IllegalArgumentException if the given denominator is 0
     */
    @Override
    public SimplifiedRational construct(int numerator, int denominator) throws IllegalArgumentException {
    	if(denominator == 0) {throw new IllegalArgumentException();}
    	int[] simpArr = simplify(numerator, denominator);
        return new SimplifiedRational(simpArr[0], simpArr[1]);
    }

    /**
     * @param obj the object to check this against for equality
     * @return true if the given obj is a rational value and its
     * numerator and denominator are equal to this rational value's numerator and denominator,
     * false otherwise
     */
    @Override
    public boolean equals(Object obj){
    	return (obj instanceof SimplifiedRational &&
    			((SimplifiedRational)obj).getNumerator() == this.getNumerator() && 
    			((SimplifiedRational)obj).getNumerator() == this.getDenominator());
    	}

    /**
     * If this is positive, the string should be of the form `numerator/denominator`
     * <p>
     * If this is negative, the string should be of the form `-numerator/denominator`
     *
     * @return a string representation of this rational value
     */
    @Override
    public String toString() {
    	if((numer > 0 && denom > 0) || (numer < 0 && denom < 0) ) {
        return Math.abs(numer) +  "/" +  Math.abs(denom);
    }else {
    		return  "-" + numer +  "/" +  Math.abs(denom);
    	}
	
    }
    
    
    
    
    
    
    
    
}
