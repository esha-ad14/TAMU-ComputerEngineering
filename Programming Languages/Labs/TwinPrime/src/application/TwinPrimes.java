/* FILE DESCRIPTION--
 * This file is TwinPrimes and is the child class of Prime and the parent class of FileIO. 
 * The purpose of this file is to find all the twin prime pairs and the hexagonal_crosses
 * for the requested number of pairs.
 */

package application;

import java.util.*;

public class TwinPrimes extends Prime{
	
	// Attributes
	public int N;  // the number of hexagonal crosses requested
	public List<int []>hexagonal_crosses;  // Complete list of hexagonal crosses
		
	/* 
	 * Constructor. Takes in as a parameter the number of hexagonal crosses requested.
	 * The super() allows us to use the public functions of the parent class: Prime.
	 */
	public TwinPrimes(int N) {
		super();
		this.N = N;
		this.hexagonal_crosses = new ArrayList<>();
	}
	
	/*
	 * The purpose of findHexagonalCrosses() is to populate the hexagonal_crosses list
	 * with valid hexagonal crosses. First, we use a hash map called twin_pairs to store
	 * the value in between the twin pairs as the key and the actual pair of twin primes 
	 * as the value (i.e. [4 : {3,5}, ...]). Although we don't use the twin pair primes, 
	 * it is convenient to have a key-value pair in the case we would want the actual twin
	 * prime pairs. Next, we use a while loop to go through all N pairs the user requested. 
	 * First, we findNextPrimePair from the Prime class. We then getNextPrimePair and extract
	 * the key. If the key is not equal to -1, we insert it into the dictionary. We then
	 * check if the keySet contains half of the current value of the key. If so, we add it
	 * to hexagonal_crosses and then decrement N. We set prev_prime and continue until N is
	 * equal to 0. 
	 */
	public void findHexagonalCrosses() {
		
		Map<Integer, int[]>twin_pairs = new HashMap<>();
		twin_pairs.put(4, new int[] {3, 5}); 
		int prev_prime = 5;
		
		while (this.N != 0) {
			findNextPrimePair(prev_prime);
			int[] next_prime_pair = getNextPrimePair();  // {first, second, (if twin prime) ? first + 1 : -1}
			int key = next_prime_pair[2];
			
			if (key != -1) {
				twin_pairs.put(key, new int[] {next_prime_pair[0], next_prime_pair[1]});
				if (twin_pairs.containsKey(key / 2)) {
					this.hexagonal_crosses.add(new int[] {key / 2, key});
					this.N--;
				}
			}
			prev_prime = next_prime_pair[1];
		}
	}
	
	/*
	 * This is a getter function that returns the list hexagonal_crosses.
	 */
	public List<int []> getHexagonalCrosses() {
		
		return hexagonal_crosses;
	}

}
