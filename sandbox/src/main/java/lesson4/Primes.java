package lesson4;

public class Primes {
  public static boolean isPrimes(int n) {
    for (int i = 2; i < n; i = i + 1) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }
}
