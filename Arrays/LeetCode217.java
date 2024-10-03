public class LeetCode217 { //ISUNIQUE
    public static void main(String[] args) {
       int[] arr={1,2,3,4,5,6};
        System.out.println(isUnique(arr));
    }
        public static boolean isUnique(int[] intArray) {
            boolean status = true;
            for(int i=0;i<intArray.length;i++){
                for(int j=i+1;j<intArray.length;j++){
                    if(intArray[i]==intArray[j]){
                        status=false;
                    }
                }
            }
            return status;
        }
}
