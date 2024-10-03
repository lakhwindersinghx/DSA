public class DuplicateNumber {
    public static void main(String[] args) {
        int[] originalArray = {1, 1, 2, 3, 2, 4, 5};
        int[] newArray = removeDuplicates(originalArray);

        // Print the result array
        System.out.println("Unique elements:");
        for (int x : newArray) {
            System.out.println(x);
        }
    }

    public static int[] removeDuplicates(int[] arr) {
        int uniqueCount = 0;

        // First, find the count of unique elements
        for (int i = 0; i < arr.length; i++) {
            boolean isDuplicate = false;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                uniqueCount++;
            }
        }

        // Create the new array with the count of unique elements
        int[] newArray = new int[uniqueCount];
        int index = 0;

        // Fill the new array with unique elements
        for (int i = 0; i < arr.length; i++) {
            boolean isDuplicate = false;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                newArray[index++] = arr[i];
            }
        }

        return newArray;
    }
}
