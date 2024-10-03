public class FindANumber {
    public static void main(String[] args) {
        int[] intArray = {1,2,3,4,5,6};
        System.out.println(searchInArray(intArray, 6));
    }

        public static int searchInArray(int[] intArray, int valueToSearch) {
            int number = 0;
            for (int i = 0; i < intArray.length; i++) {
                if (valueToSearch == intArray[i]) {
                    number = i;
                }
            }
            return number;
        }
    }

