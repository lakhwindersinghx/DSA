import java.util.Arrays;

public class recursionPattern {
    public static void main(String[] args) {
        recursionPattern rp = new recursionPattern();
//        rp.triangle2(5, 0);
        int[] array = {1, 2, 4, 5, 3};
        rp.selectionSort(array, array.length - 1, 0, 0);
        System.out.println(Arrays.toString(array));

    }

    public void triangle1(int row, int column) {
        if (row == 0) {
            return;
        }
        if (row != column) {
            System.out.print("*");
            triangle1(row, column + 1);
        } else {
            System.out.println();
            triangle1(row - 1, 0);
        }
    }

    public void triangle2(int row, int column) {
        if (row == 0) {
            return;
        }
        if (row != column) {
            triangle2(row, column + 1);
            System.out.print("*");
        } else {
            triangle2(row - 1, 0);
            System.out.println();
        }
    }

    public void bubbleSort(int[] arr, int row, int column) {
        if (row == 0) {
            return;
        }
        if (column != row) {
            if (arr[column] > arr[column + 1]) {
                int temp = arr[column];
                arr[column] = arr[column + 1];
                arr[column + 1] = temp;
            }
            bubbleSort(arr, row, column + 1);
        } else {
            bubbleSort(arr, row - 1, 0);
        }
    }

    public void selectionSort(int[] arr, int r, int c, int max) {
        if (r == 0) {
            return;
        }
        if (c < r) {
            if (arr[c] > arr[max]) {
                selectionSort(arr, r, c + 1, c);
            } else {
                selectionSort(arr, r, c + 1, max);
            }
        } else {

            int temp = arr[max];
            arr[max] = arr[max];
            arr[r - 1] = temp;
            selectionSort(arr, r - 1, 0, max);
        }
    }
}
