public class LeetCode48 {
    public static void main(String[] args) {
        int[][] array = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        rotateMatrix(array);

    }

    public static void rotateMatrix(int[][] matrix) {
        //transpose
        for(int i=0;i< matrix.length;i++){
            for(int j=0;j<matrix.length;j++){
//                int temp=matrix[i][j];
//                matrix[i][j]=matrix[j][i];
//                matrix[j][i]=temp;
                System.out.print(matrix[j][i]);
            }
            System.out.println();
        }
    }
}



