/* FILE DESCRIPTION--
 * This is the Prime class. It is the parent class to TwinPrimes and the grandparent of 
 * the FileIO class. The purpose of this class is to find the next pair of primes given 
 * the previous prime. It achieves this through the function findNextPrimePair(). The 
 * child classes can access the next_prime_pair array through the getter function, 
 * getNextPrimePair().
 * 
 */

package application;

public class Prime {
	
	// Attributes
	public int[] next_prime_pair;
	
	// Constructor. Prime class never takes in attributes/parameters.
	public Prime() {
		this.next_prime_pair = new int[3];
	}
	
	/*
	 * Consider the previous prime pair was {3, 5}. The function findNextPrimePair() uses the 
	 * larger of the previous pair as the previous prime number.It then uses this number to find 
	 * the next prime number (i.e. 7). It then continues to find the prime number after that 
	 * (i.e. 11). The array next_prime_pair is populated with these two numbers (i.e. {7, 11, _}). 
	 * The third spot in next_prime_pair is to indicate whether or not it is a twin prime pair.
	 * If the difference between the pair is 2, it then puts the first prime number plus 1 as the
	 * number between the twin prime. Otherwise, it puts -1, indicating it is not a twin prime.
	 */
	public void findNextPrimePair(int prev_prime) {
		
		int n = prev_prime;
		int idx = 0;
		while (idx < 2) {
			if (isPrime(n)) {
				this.next_prime_pair[idx] = n;
				idx++;
			}
			n++;
		}
		if (this.next_prime_pair[1] - this.next_prime_pair[0] == 2) {
			this.next_prime_pair[idx] = this.next_prime_pair[0] + 1;
		} else {
			this.next_prime_pair[idx] = -1;
		}
	}
	
	/*
	 * This is a helper function for findNextPrimePair(). Given a number this returns 
	 * whether or not the number is prime using a simple algorithm. If, for any number
	 * i in [2, num-1], the num is divisible by i, it is prime since it is not only 
	 * divisible by 1 and the num itself.
	 */
	private static boolean isPrime(int num) {
		
		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	/*
	 * This getter function returns the next_prime_pair.
	 */
	public int[] getNextPrimePair() {
		
		return this.next_prime_pair;
	}
	
	

}
