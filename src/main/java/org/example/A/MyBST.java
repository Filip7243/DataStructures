package org.example.A;

public class MyBST {

    private TreeNode root;

    public MyBST() {
        this.root = null;
    }

    public void insert(int elem) {
        TreeNode node = new TreeNode();
        node.value = elem;

        // check if tree empty
        if (isEmpty()) {
            root = node;
        } else {
            // start searching where to place elem starting from root
            TreeNode current = root;
            while (true) {
                TreeNode parent = current;
                if (elem < current.value) { // go to the left tree node
                    current = current.left;
                    if (current == null) {
                        parent.left = node;
                        node.parent = parent;
                        break;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = node;
                        node.parent = parent;
                        break;
                    }
                }
            }
        }
    }

    public boolean find(TreeNode current, int elem) {
        if (current == null) { // stop recursion and return false when value wasnt found
            return false;
        }
        if (current.value == elem) { // stop recursion and return true when find value = elem
            return true;
        }

        if (current.value > elem) { // if elem is less than current search in left node
            return find(current.left, elem);
        } else { // else search in right
            return find(current.right, elem);
        }
    }

    public TreeNode getLowestSuccessor(TreeNode node) { // get the most left node in right tree of node
        TreeNode current = node.right; // get right child of node
        while (current.left != null) {
            current = current.left;
        }

        return current;
    }

    public TreeNode getHighestSuccessor(TreeNode node) {
        TreeNode current = node.left;
        while (current.right != null) {
            current = current.right;
        }

        return current;
    }

    private void deleteWithoutChildren(TreeNode node) {

        // check if node is root, if yes just clear the tree
        if (node == root) {
            root = null;
        } else {
            TreeNode parent = node.parent;
            if (parent.left == node) {
                parent.left = null;
            } else {
                parent.right = null;
            }
            node.parent = null;
        }
    }

    private void deleteWithLeftChild(TreeNode node) {
        if (node == root) {
            root = node.left;
        } else {
            // check if our deleting node is left child of his parent
            if (node.parent.left == node) {
                node.parent.left = node.left;
            } else { // node is right child of his parent
                node.parent.right = node.left;
            }
            node.left.parent = node.parent; // link new parent of orphan child
        }
    }

    private void deleteWithRightChild(TreeNode node) {
        if (node == root) {
            root = node.right;
        } else {
            // check if node is left child of his parent
            if (node.parent.left == node) {
                node.parent.left = node.right;
            } else {
                node.parent.right = node.right;
            }
            node.right.parent = node.parent;
        }
    }

    private void deleteWithTwoChildren(TreeNode node) {
        if (node == root) {
            TreeNode highestSuccessor = getHighestSuccessor(node);
            root = node.left;
            node.left.parent = null;
            highestSuccessor.right = node.right;

        } else {
            TreeNode successor = getLowestSuccessor(node);
            if (successor.left == null && successor.right == null) {
                deleteWithoutChildren(successor);
            } else {
                deleteWithRightChild(successor);
            }

            TreeNode parent = node.parent;
            if (parent.left == node) {
                parent.left = successor;
            } else {
                parent.right = successor;
            }

            successor.left = node.left;
            successor.right = node.right;
            successor.parent = node.parent;

            if (successor.left != null) {
                successor.left.parent = successor;
            }
            if (successor.right != null) {
                successor.right.parent = successor;
            }
        }
    }

    public boolean delete(int elem) {
        if (root == null) {
            return false;
        }
        TreeNode current = root;

        while (current.value != elem) {
            if(elem < current.value) {
                current = current.left;
            } else {
                current = current.right;
            }

            if(current == null) {
                return false;
            }
        }

        if(current.left == null && current.right == null) {
            deleteWithoutChildren(current);
        } else if (current.left == null) {
            deleteWithRightChild(current);
        } else if (current.right == null) {
            deleteWithLeftChild(current);
        } else {
            deleteWithTwoChildren(current);
        }

        return true;
    }

    public void view(TreeNode node, int level) {
        if(node == null) {
            return;
        }
        for (int i = 0; i < level; i++) System.out.print("- ");
        System.out.println(node.value);
        view(node.left, level + 1);
        view(node.right, level + 1);
    }

    public boolean isEmpty() {
        return root == null;
    }

    public TreeNode getRoot() {
        return root;
    }

    public static void main(String[] args) {
        MyBST tree = new MyBST();

        //Wstawianie elementow
        tree.insert(50);
        tree.insert(25);
        tree.insert(75);
        tree.insert(12);
        tree.insert(37);
        tree.insert(43);
        tree.insert(30);
        tree.insert(33);
        tree.insert(87);
        tree.insert(63);
        tree.insert(97);

        tree.delete(50);

        tree.view(tree.getRoot(), 0);

        boolean result1 = tree.find(tree.getRoot(), 33);
        System.out.println("Wynik wyszukania 33:" + result1);

        boolean result2 = tree.find(tree.getRoot(), 40);
        System.out.println("Wynik wyszukania 40:" + result2);

        System.out.println("\n\t<< del(37) >>");
        tree.delete(37);
        tree.view(tree.getRoot(), 0);
        System.out.println("\n");

        System.out.println("\n\t<< del(43) >>");
        tree.delete(43);
        tree.view(tree.getRoot(), 0);
        System.out.println("\n");

        System.out.println("\n\t<< del(25) >>");
        tree.delete(25);
        tree.view(tree.getRoot(), 0);
        System.out.println("\n");
    }
}

class TreeNode {

    protected TreeNode parent;
    protected TreeNode left;
    protected TreeNode right;
    protected int value;

    public TreeNode() {
        this.parent = null;
        this.left = null;
        this.right = null;
        this.value = 0;
    }

    @Override
    public String toString() {
        return value + "";
    }
}
