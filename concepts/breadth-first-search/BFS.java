import java.util.*;

class BFS {
    public static void main(String[] args) {
        TreeNodeString a = new TreeNodeString("A");
        TreeNodeString b = new TreeNodeString("B");
        TreeNodeString c = new TreeNodeString("C");
        TreeNodeString d = new TreeNodeString("D");
        TreeNodeString e = new TreeNodeString("E");
        TreeNodeString f = new TreeNodeString("F");
        a.left = b;
        b.left = d;
        b.right = e;
        a.right = c;
        c.right = f;

        dbsPrint(a);
    }

    public static void dbsPrint(TreeNodeString root) {
        Deque<TreeNodeString> queue = new ArrayDeque<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            TreeNodeString current = queue.poll();
            System.out.print(current.val);
            if(current.left != null) {
                queue.add(current.left);
            }
            if(current.right != null) {
                queue.add(current.right);
            }
        }
    }
}