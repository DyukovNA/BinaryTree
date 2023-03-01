import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeTest {

    @Test
    void getRoot() {
        Tree tree = new Tree();
        tree.insert(8);
        tree.insert(5);
        tree.insert(4);
        tree.insert(6);
        tree.insert(1000);
        tree.insert(0);
        tree.insert(2000);
        assertEquals(8, tree.getRoot().getKey());
    }

    @Test
    void getParent() {
        Tree tree = new Tree();
        tree.insert(8);
        tree.insert(5);
        tree.insert(4);
        tree.insert(6);
        tree.insert(1000);
        tree.insert(0);
        tree.insert(2000);
        assertNull(tree.getRoot().getParent());
        assertEquals(1000, tree.find(2000).getParent().getKey());
        assertEquals(tree.find(4).getParent(), tree.find(6).getParent());
    }

    @Test
    void getLeftChild() {
        Tree tree = new Tree();
        tree.insert(8);
        tree.insert(5);
        tree.insert(4);
        tree.insert(6);
        tree.insert(1000);
        tree.insert(0);
        tree.insert(2000);
        assertNull(tree.find(2000).getLeftChild());
        assertEquals(tree.find(5), tree.getRoot().getLeftChild());
        assertEquals(tree.find(0), tree.find(4).getLeftChild());
    }

    @Test
    void getRightChild() {
        Tree tree = new Tree();
        tree.insert(8);
        tree.insert(5);
        tree.insert(4);
        tree.insert(6);
        tree.insert(1000);
        tree.insert(0);
        tree.insert(2000);
        assertNull(tree.find(2000).getRightChild());
        assertEquals(tree.find(1000), tree.getRoot().getRightChild());
        assertEquals(tree.find(6), tree.find(5).getRightChild());
    }

    @Test
    void insert() {
        Tree tree = new Tree();
        tree.insert(8);
        tree.insert(5);
        tree.insert(4);
        tree.insert(6);
        tree.insert(1000);
        tree.insert(0);
        tree.insert(2000);
        Tree copyOfTree = tree;
        copyOfTree.insert(8);
        copyOfTree.insert(4);
        assertEquals(tree, copyOfTree);
    }

    @Test
    void find() {
        Tree tree = new Tree();
        tree.insert(8);
        tree.insert(5);
        tree.insert(4);
        tree.insert(6);
        tree.insert(1000);
        tree.insert(0);
        tree.insert(2000);
        assertEquals(tree.find(8), tree.getRoot());
    }

    @Test
    void remove() {
        Tree tree = new Tree();
        tree.insert(8);
        tree.insert(4);
        tree.insert(12);
        tree.insert(2);
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.remove(5);
        Tree treeWithRemovedNode = new Tree();
        treeWithRemovedNode.insert(8);
        treeWithRemovedNode.insert(4);
        treeWithRemovedNode.insert(12);
        treeWithRemovedNode.insert(2);
        treeWithRemovedNode.insert(3);
        treeWithRemovedNode.insert(7);
        assertEquals(treeWithRemovedNode.find(4).getRightChild().getKey(),
                tree.find(4).getRightChild().getKey());

        tree.remove(8);
        assertEquals(4, tree.getRoot().getKey());
        assertEquals(12, tree.find(7).getRightChild().getKey());
        tree.remove(7);
        tree.remove(3);
        tree.remove(2);
        tree.remove(12);
        tree.remove(4);
        assertNull(tree.getRoot());
    }
}