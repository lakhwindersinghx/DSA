public class recursion {
    public static void main(String[] args) {
        System.out.println(GCD(7, 28));
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

    public static int binarySearch(int[] arr, int target, int length) {
        return 1;
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
}