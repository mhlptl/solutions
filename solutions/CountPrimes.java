package solutions;

/**
 * LEETCODE: Count Primes (204) [EASY]
 * 
 * TODO: need writeup
 */
public class CountPrimes {
	public int countPrimes(int n) {
    if(n <= 2) return 0;
    boolean[] isPrime = new boolean[n];
    
    int count = 0;
    
    for(int i = 2; i < n; i++) {
      if(isPrime[i] == false) {
        count++;
        for(int j = i; j < n; j+=i) {
          isPrime[j] = true;
        }
      }
    }
    return count;
  }
}
