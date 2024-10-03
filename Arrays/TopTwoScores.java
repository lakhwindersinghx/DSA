public class TopTwoScores {
    public static void main(String[] args) {
        int[] myArray = {84, 85, 2, 89, 0};
        int[] newArray = findTopTwoScores(myArray);
        for (int x : newArray) {
            System.out.println(x);
        }
    }

    public static int[] findTopTwoScores(int[] array) {
        int biggest = Integer.MIN_VALUE;
        int secondBiggest = Integer.MIN_VALUE;

        for (int x : array) {
            if (x > biggest) {
                secondBiggest = biggest;  // Assign the current biggest to secondBiggest
                biggest = x;  // Update biggest with the new highest value
            } else if (x > secondBiggest && x != biggest) {  // Ensure x is not equal to biggest
                secondBiggest = x;
            }
        }

        return new int[]{biggest, secondBiggest};
    }
}
