import java.util.ArrayList;
import java.util.List;

public class Trees {
    public static Node buildTree() {
        Node a = new Node('A');
        Node b = new Node('B');
        Node c = new Node('C');
        Node d = new Node('D');
        Node e = new Node('E');
        Node f = new Node('F');
        Node g = new Node('G');
        Node h = new Node('H');
        a.left = b; a.right = c;
        b.left = d; b.right = e;
        c.left = f; c.right = g;
        d.left = null; d.right = null;
        e.left = null; e.right = h;
        f.left = null; f.right = null;
        g.left = null; g.right = null;
        h.left = null; h.right = null;
        return a;
    }

    public static List<Character> preOrder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Character> list = new ArrayList<>();
        List<Character> leftPreOrder = preOrder(root.left);
        List<Character> rightPreOrder = preOrder(root.right);
        list.add(root.value);
        list.addAll(leftPreOrder);
        list.addAll(rightPreOrder);
        return list;
    }

    public static void preOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        //根 + 左子树 + 右子树
        System.out.println(root.value);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public static void inOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        //左子树 + 根 + 右子树
        inOrderTraversal(root.left);
        System.out.println(root.value);
        inOrderTraversal(root.right);
    }

    public static void postOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        //左子树 + 右子树 + 根
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        postOrderTraversal(root.value);
    }

    private static void postOrderTraversal(char value) {
    }

    public static void main(String[] args) {
        Node root = buildTree();
        preOrderTraversal(root);
        System.out.println("===================");
        inOrderTraversal(root);
        System.out.println("===================");
        postOrderTraversal(root);
        System.out.println("===================");
        System.out.println(preOrder(root));
    }
}


