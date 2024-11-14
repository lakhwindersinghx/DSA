package TreeWRecursion.ST;

public class STmain {
    public static void main(String[] args) {
        int[] nums = {0, 4, 6,7,5};
        ST st = new ST(nums);
        st.display();
        System.out.println(st.query(2,3));
    }
}
