public class TwoDimensional {
    int[][] new2DArray=null;

    public TwoDimensional(int rows, int column){ //constructor
        this.new2DArray=new int[rows][column];
        for(int i=0;i<new2DArray.length;i++){ //for row
            for(int j=0;j<new2DArray[0].length;j++){ //for column
                new2DArray[rows][column]=Integer.MIN_VALUE;
            }
        }
    }

}
