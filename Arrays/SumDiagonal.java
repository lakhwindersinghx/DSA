public class SumDiagonal {
    public static void main(String[] args) {
        int[][] myArray2D = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(sumDiagonalElements(myArray2D));
    }

    public static int sumDiagonalElements(int[][] array) {
        int sum = 0;
        for (int row = 0; row < array.length; row++) {
            for (int column = 0; column < array[0].length; column++) {
                if (row == column) {
                    sum += array[row][column];
                }
            }
        }
        return sum;
    }
}

