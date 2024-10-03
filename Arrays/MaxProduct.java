public class MaxProduct {
    public String maxProduct(int[] intArray) {
        int a = 0;
        int b = 0;
        int max = Integer.MIN_VALUE;
        for (int i :
                intArray) {
            for (int j :
                    intArray) {
                if (i * j > max) {
                    max = i * j;
                    a = i;
                    b = j;
                }
            }
        }
        return "(" + a + "," + b + ")";
    }

}

