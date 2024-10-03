public class MainClass {
    public static void main(String[] args) {
        link l = new link();
        l.push(1);
        l.push(2);
        l.push(3);
        l.traverse();
        l.remove(1);
        l.traverse();
    }
}
