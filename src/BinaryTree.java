/**
 * class for the binary Tree, Has the create node,delete and search node method in it
 * @author Michael Maseko
 */
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
   void delete(T key) {
       root = deleteRec(root, key);
   }
   Node<T> deleteRec(Node<T> root, T key){
       if (root == null){
           return root;
       }
       if (key.compareTo(root.data) < 0) {
           root.left = deleteRec(root.left, key);
       }
       else if (key.compareTo(root.data) > 0) {
        root.right = deleteRec(root.right, key);
       }
       else{
           //Node with only one or no child
           if (root.left == null) {
               return root.right;
           }
           else if (root.right == null) {
               return root.left;
           }
           //node with 2 children: get the inorder successor (SMALLEST IN THE RIGHT SUBTREE)
           root.data = minValue(root.right);
           // delete the inorder successor
           root.right = deleteRec(root.right, root.data);
       }
       return root;
   }
   T minValue(Node<T> root){
       T minValue = root.data;
       while (root.left != null) {
           minValue = root.left.data;
           root = root.left;
       }
       return minValue;
   }

    String inorderTraversal(Node<T> node) {
        StringBuilder result = new StringBuilder();
        if (node != null) {
            result.append(inorderTraversal(node.left));
            result.append(node.data).append("\n");
            result.append(inorderTraversal(node.right));
        }
        return result.toString();
    }

    Node<T> search(Node<T> node, T key) {
        if (node == null || node.data.compareTo(key) == 0)
            return node;

        if (key.compareTo(node.data) < 0)
            return search(node.left, key);

        return search(node.right, key);
    }
}