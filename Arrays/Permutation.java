public class Permutation {
    public boolean permutation(int[] array1, int[] array2) {
        sort(array1);
        sort(array2);
        for (int i : array1) {
            for (int j : array2) {
                if (array1[i] == array2[j])
                    return true;
            }
        }
        return false;
    }

    public int[] sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }
}