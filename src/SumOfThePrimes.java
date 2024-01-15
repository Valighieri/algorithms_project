public class SumOfThePrimes {

    /*
     * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
     * Find the sum of all the primes below two million.
     *  */

    private final int limit;
    private int[] primes;
    private int nElems;

    public SumOfThePrimes(int limit) {
        this.limit = limit;
        primes = new int[limit/2];
        nElems = 0;
        fillPrimesArray();
    }

    private void fillPrimesArray(){
        for (int i = 2; i < limit; i++) {
            if (isPrime(i)){
                primes[nElems] = i;
                nElems++;
            }
        }
    }

    private boolean isPrime(int number){
        boolean isPrime = true;
        for (int j = 0; j < nElems; j++) {
            if (number % primes[j] == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }

    public void displayPrimesArray(){
        for (int i = 0; i < nElems; i++){
            System.out.print(primes[i] + " ");
        }
        System.out.println();
    }

    public long findPrimesSum(){
        long sum = 0;
        for (int i = 0; i < nElems; i++){
            sum += primes[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        SumOfThePrimes sum = new SumOfThePrimes(2_000_000);
//        sum.displayPrimesArray();
        System.out.println("Sum = " + sum.findPrimesSum());
    }

}
