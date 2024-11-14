public class TreeMain {
    public static void main(String[] args) {
        TreeNode drinks=new TreeNode("Drinks");
        TreeNode hotDrinks=new TreeNode("Hot");
        TreeNode coldDrinks=new TreeNode("Cold");
        drinks.addChild(hotDrinks);
        drinks.addChild(coldDrinks);
        System.out.println(drinks.printChild(0));
    }
}
