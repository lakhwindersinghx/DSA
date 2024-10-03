public class recursion {
    public static void main(String[] args) {


        recursion rs = new recursion();
        System.out.println(rs.numberZeroes(2504));

    }

    public int sum(int number) {
        if (number < 0 || number == 0) {
            return 0;
        }
        return sum(number / 10) + number % 10;
    }

    public int power(int base, int exp) {
        if (exp == 0) {
            return 1;
        }
        return base * power(base, exp - 1);
    }

    public int fibonacci(int number) {
        if (number < 2) {
            return number;
        }
        return fibonacci(number - 1) + fibonacci(number - 2);
    }

    public int factorial(int number) {
        if (number == 1 || number <= 0) {
            return 1;
        }
        return number * factorial(number - 1);
    }

    public int sumOfDigits(int number) {
        if (number <= 0) {
            return 0;
        }
        return sumOfDigits(number / 10) + (number % 10); //for eg. number=1234 number/10=123 number%10=4 for first iteration
    }

    public int reverse(int number) {
        //find number of digits.
        int digits = (int) (Math.log10(number) + 1);
        System.out.println("NUMBER OF DIGITS FROM REVERSE: " + digits);
        return helper(number, digits);
    }

    public int helper(int number, int digits) {
        if (number % 10 == number) {
            return number;
        }
        int power = (int) (Math.pow(10, digits - 1));
        System.out.println("Power: " + power);
        int rem = number % 10;
        return rem * power + helper(number / 10, digits - 1);
    }

    public int numberZeroes(int number) {
        int counter = 0;
        return helperZero(number, counter);
    }

    public int helperZero(int number, int counter) {
        if (number == 0) {
            return counter;
        }
        int remainder = number % 10;
        if (remainder == 0) {
            return helperZero(number / 10, counter + 1);
        }
        return helperZero(number / 10, counter);
    }
}
