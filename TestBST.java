

public class TestBST {

    public static void main(String[] args) {

        MyBST<Integer> bst2 = new MyBST<Integer>();
        bst2.insert(20);
        bst2.insert(10);
        bst2.insert(40);
        bst2.insert(16);
        bst2.insert(30);
        bst2.insert(80);
        bst2.insert(27);
        bst2.insert(14);
        bst2.insert(50);

        bst2.delete(20);
        bst2.delete(16);
        bst2.delete(14);

        bst2.print();

        MyBST<String> stringBST = new MyBST<String>();
        stringBST.insert("george");
        stringBST.insert("andrew");
        stringBST.insert("john");
        stringBST.insert("tom");
        stringBST.insert("geoff");
        stringBST.insert("jared");
        stringBST.insert("william");
        stringBST.insert("stephen");
        stringBST.insert("craig");

        stringBST.print();
        stringBST.delete("craig");
        stringBST.print();
    }
}
