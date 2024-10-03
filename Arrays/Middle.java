public class Middle {
    public static void main(String[] args) {
        int[] myArray = {5, 6, 7, 8,9,10};
        int [] middleArray=middle(myArray);
        for(int i:middleArray){
            System.out.println(i);
        }
    }
    public static int[] middle(int[] array) {
        int[] newArray=new int[array.length-2];
       for(int i=1;i<array.length-1;i++){
           newArray[i-1]=array[i];
       }
       return newArray;
    }

}

