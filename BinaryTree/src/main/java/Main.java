public class Main {
    public static void main(String[] args) {
        /**Tree firstTryBaby = new Tree();
        firstTryBaby.insert(8);
        firstTryBaby.insert(10);
        firstTryBaby.insert(2);
        firstTryBaby.insert(0);
        firstTryBaby.insert(100);
        firstTryBaby.insert(94);
        firstTryBaby.insert(5);
        firstTryBaby.insert(54);
        System.out.println(firstTryBaby.getRoot());*/

        Tree tree = new Tree();
        tree.insert(8);
        tree.insert(4);
        tree.insert(12);
        tree.insert(2);
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.remove(5);
        Tree changedTree = new Tree();
        changedTree.insert(8);
        changedTree.insert(4);
        changedTree.insert(12);
        changedTree.insert(2);
        changedTree.insert(3);
        changedTree.insert(7);
        System.out.println(changedTree.find(4).getRightChild().getKey());
        System.out.println(tree);
    }
}
