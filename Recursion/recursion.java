import java.io.PrintStream;

public class recursion {
    public static void main(String[] args) {
        String x = "javax";
        System.out.println(isPallindrome(x, 0, x.length()));
    }

    public static int factorial(int number) {
        if (number == 1 || number == 0) {
            return 1;
        }
        if (number < 0) {
            return 1;
        }
        return number * factorial(number - 1);
    }

    public static int fibonaci(int number) {
        if (number == 0) {
            return 0;
        }
        if (number == 1) {
            return 1;
        }
        return fibonaci(number - 1) + fibonaci(number - 2);
    }

    public static int sumOfNatural(int number) {
        if (number == 0) {
            return 0;
        }
        if (number == 1) {
            return 1;
        }
        return number + sumOfNatural(number - 1);
    }

    public static void oneToN(int number) {
        if (number == 1) {
            System.out.print(1 + "");
            return;
        }
        oneToN(number - 1);
        System.out.print(number);
    }

    public static void reverseAString(String value, int length) {
        if (length < 0) {
            return;
        }
        System.out.print(value.charAt(length));
        reverseAString(value, length - 1);
    }

    public static boolean palindrome(String value, int i, int length) {
        if (i >= length) {
            return true;
        }
        if (value.charAt(i) != value.charAt(length)) {
            return false;
        }
        return palindrome(value, i + 1, length - 1);
    }

    public static int binarySearch(int[] arr, int target, int start, int end) {
        if (start >= end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (arr[mid] == target) {
            return mid;
        }
        if (target < arr[mid]) {
            return binarySearch(arr, target, start, mid - 1);
        }
        return binarySearch(arr, target, mid + 1, end);
    }


    public static int powerNumber(int base, int power) {
        if (power == 0) {
            return 1;
        }

        return base * powerNumber(base, power - 1);
    }

    public static int sumOfDigits(int number, int index) {
        String value = String.valueOf(number);
        if (index >= value.length()) {
            return 0;
        }
        return Character.getNumericValue(value.charAt(index)) + sumOfDigits(number, index + 1);
    }

    public static int GCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return GCD(b, a % b);
    }

    public static int productofArray(int[] A, int N) {
        if (N == 0) {
            return 1;
        }
        return A[N - 1] * productofArray(A, N - 1);
    }

    public static String revString(String str, int n) {
        if (n == 0) {
            return "";
        }
        return String.valueOf(str.charAt(n - 1) + revString(str, n - 1));
    }

    public static boolean isPallindrome(String s, int i, int n) {
        if (i >= n) {
            return true;
        }
        if (s.charAt(i) != s.charAt(n - 1)) {
            return false;
        } else {
            return isPallindrome(s, i + 1, n - 1);
        }
    }
//    public class Exercise {
//        public boolean someRecursive(int[] arr, OddFunction odd) {
//
//        }
}