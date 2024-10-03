public class recursionArray {
    public static void main(String[] args) {
        recursionArray ra = new recursionArray();
        int[] array = {1, 2, 3, 4, 5};
        System.out.println(ra.findIndex(array, 3, 0));
    }

    public boolean findNumber(int array[], int target, int index) {
        if (index == array.length) {
            return false;
        }
        return array[index] == target || findNumber(array, target, index + 1);
    }

    public int findIndex(int array[], int target, int index) {
        if (index == array.length) {
            return -1;
        }
        if (array[index] == target) {
            return index;
        }
        return findIndex(array, target, index+1);
    }



}
