public class MainCDLL {
    public static void main(String[] args) {
        CDLL CDLL=new CDLL();
        CDLL.insertIntoCDLL(1,0);
        CDLL.insertIntoCDLL(2,1);
        CDLL.insertIntoCDLL(3,2);
        CDLL.insertIntoCDLL(4,3);
        System.out.println("Size of list: "+CDLL.size);
        CDLL.traverse();
        CDLL.deleteCDLL();
        System.out.println(CDLL.head.value);
        System.out.println("Size of list: "+CDLL.size);


    }
}
