package Week4;

/**
 * Count the number of primes.
 *
 * @author Jeffrey Chan, RMIT
 */
public class CountPrimes
{
    public static int countPrimes(int n) {
        int count = 0;

        // loop from n to 2, and try each subsequent i as a prime
        for (int i = n; i > 1; i--) {
            boolean np = false;
            for (int j = 2; j < i; j++) {
                // test if prime
                if (i % j == 0) {
                    np = true;
                    break;
                }

                // increment prime count
                if (!np) {
                    count++;
                }
            }
        } // end of outer for loop

        return count;
    } // end of countPrimes()


    public static void main(String[] args) {
        // set to 40000, can be anything you like
        int n = 40000;

        long startTime = System.nanoTime();
        CountPrimes.countPrimes(n);
        long endTime = System.nanoTime();

        System.out.println("time taken = " + ((double)(endTime - startTime)) / Math.pow(10, 9) + " sec");
    } // end of main()

} // end of class CountPrimes

