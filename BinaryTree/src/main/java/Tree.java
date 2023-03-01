public final class Tree {
    static class Node {
        private final int key;
        private Node leftChild, rightChild, parent;

        private Node(int key) {
            this.key = key;
            leftChild = rightChild = parent = null;
        }

        public int getKey() {
            return this.key;
        }

        public Node getParent() {
            return this.parent;
        }

        public Node getLeftChild() {
            return this.leftChild;
        }

        public Node getRightChild() {
            return this.rightChild;
        }

        private void removeLink(Node node) {
            if (this.leftChild != null) {
                if (node.key == this.leftChild.key) {
                    this.leftChild = null;
                }
            }
            if (this.rightChild != null) {
                if (node.key == this.rightChild.key) {
                    this.rightChild = null;
                }
            }
            if (this.parent != null) {
                if (node.key == this.parent.key) {
                    this.parent = null;
                }
            }
        }
    }

    private Node root;

    public Node getRoot() {
        return root;
    }

    public void insert(int key) {
        if (root == null) {
            root = new Node(key);
            return;
        }
        Node expNode = root;
        while (true) {
            if (key < expNode.key) {
                if (expNode.leftChild == null) {
                    expNode.leftChild = new Node(key);
                    expNode.leftChild.parent = expNode;
                    return;
                } else {
                    expNode = expNode.leftChild;
                }
            } else if (key > expNode.key) {
                if (expNode.rightChild == null) {
                    expNode.rightChild = new Node(key);
                    expNode.rightChild.parent = expNode;
                    return;
                } else {
                    expNode = expNode.rightChild;
                }
            } else {
                return;
            }
        }
    }

    public Node find(int key) {
        return toFind(root, key);
    }

    private static Node toFind(Node expNode, int key) {
        if (key == expNode.key) return expNode;
        if (key < expNode.key && expNode.leftChild != null) {
            return toFind(expNode.leftChild, key);
        }
        if (key > expNode.key && expNode.rightChild != null) {
            return toFind(expNode.rightChild, key);
        }
        return null;
    }

    public void remove(int key) {
        Node nodeToRemove = find(key);
        Node parent = nodeToRemove.parent;
        Node left = nodeToRemove.leftChild;
        Node right = nodeToRemove.rightChild;

        if (nodeToRemove != root) {
            parent.removeLink(nodeToRemove);
            if (left != null) {
                left.removeLink(nodeToRemove);
                toJoinNodes(parent, left);
            }
            if (right != null) {
                right.removeLink(nodeToRemove);
                toJoinNodes(parent, right);
            }
        } else toRemoveRoot(nodeToRemove);
    }

    private static void toJoinNodes(Node parent, Node child) {
        if (child.key < parent.key) {
            if (parent.leftChild == null) {
                parent.leftChild = child;
                child.parent = parent;
            } else toJoinNodes(parent.leftChild, child);
        } else {
            if (parent.rightChild == null) {
                parent.rightChild = child;
                child.parent = parent;
            } else {
                toJoinNodes(parent.rightChild, child);
            }
        }
    }

    private void toRemoveRoot(Node node) {
        Node left = node.leftChild;
        Node right = node.rightChild;
        if (left == null && right != null) {
            root = right;
            right.removeLink(node);
        } else if (left != null && right == null) {
            root = left;
            left.removeLink(node);
        } else if (left != null && right != null) {
            root = left;
            toJoinNodes(left, right);
        }
        else root = null;
    }
}