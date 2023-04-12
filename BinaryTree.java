public class BinaryTree <T extends Comparable<T>> {
    Node<T> root;

    BinaryTree () {
        root = null;
    }

    void insert(T data) {
        root = insertRec(root, data);
    }

    Node<T> insertRec(Node<T> root, T data) {
        if (root == null) {
            root = new Node<T>(data);
            return root;
        }

        if (data.compareTo(root.data) < 0)
            root.left = insertRec(root.left, data);
        else if (data.compareTo(root.data) > 0)
            root.right = insertRec(root.right, data);

        return root;
    }

    void inorderTraversal(Node<T> node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.print(node.data + " ");
            inorderTraversal(node.right);
        }
    }

    Node<T> search(Node<T> node, T key) {
        if (node == null || node.data.compareTo(key) == 0)
            return node;

        if (key.compareTo(node.data) < 0)
            return search(node.left, key);

        return search(node.right, key);
    }
}