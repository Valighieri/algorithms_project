
public class Palindrome {

    /*
     * A palindromic number reads the same both ways. The largest palindrome made
     * from the product of two 2-digit numbers is 9009 (91 * 99). Find the largest
     * palindrome made from the product of two 3-digit numbers.
     * */

    private final int max;
    private final int min;

    public Palindrome(int digitAmount) {
        this.min = pow(10, digitAmount - 1);
        this.max = pow(10, digitAmount) - 1;
    }

    private int pow(int value, int powValue) {
        int result = 1;
        for (int i = 1; i <= powValue; i++) {
            result = result * value;
        }
        return result;
    }

    private boolean isPalindrome(int product) {
        String str = String.valueOf(product);
        String begin = str.substring(0, str.length() / 2);
        String end;

        if (str.length() % 2 == 0) {
            end = str.substring(str.length() / 2);
        } else {
            end = str.substring(str.length() / 2 + 1);
        }

        String reverseEnd = String.valueOf(new StringBuilder(end).reverse());
        return reverseEnd.equals(begin);
    }

    public int findBiggestPalindrome() {
        int biggestPalindrome = 0;
        int product;

        for (int i = max; i >= min; i--) {
            for (int j = i; j >= min; j--) {
                product = i * j;
                if (product <= biggestPalindrome) break;
                if (isPalindrome(product)) biggestPalindrome = product;
            }
        }
        return biggestPalindrome;
    }


    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome(2);
        System.out.println(
                palindrome.findBiggestPalindrome()
        );

    }


}


