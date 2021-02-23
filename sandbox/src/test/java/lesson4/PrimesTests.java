package lesson4;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PrimesTests {
  @Test
  public void testPrimes() {
    Assert.assertTrue(Primes.isPrimes(Integer.MAX_VALUE));
  }

  @Test
  public void testNotPrimes() {
    Assert.assertFalse(Primes.isPrimes(Integer.MAX_VALUE - 2));
  }

  @Test(enabled = false)
  public void testPrimesLong() {
    long n = Integer.MAX_VALUE;
    Assert.assertTrue(Primes.isPrimes(n));
  }

  @Test
  public void testNotPrimesLong() {
    Assert.assertFalse(Primes.isPrimes(Integer.MAX_VALUE - 2));
  }
}
