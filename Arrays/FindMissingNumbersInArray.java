public class FindMissingNumbersInArray {
    public static void main(String[] args) {
        int[] myArray = {1, 2, 3, 4, 6};
        System.out.println(findMissingNumberInArray(myArray));
    }

    static int findMissingNumberInArray(int[] arr) {
        int n=arr.length+1;
        int sumNaturalNumbers = (n * (n+1) / 2);//21
        int missingNumber = 0;
        int sumOfArray = 0; //16


        for (int x : arr) {
            sumOfArray += x;
            missingNumber = sumNaturalNumbers - sumOfArray;
        }
        return missingNumber;
    }

}
