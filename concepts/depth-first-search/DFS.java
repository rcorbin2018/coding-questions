import java.util.*;

class DFS {
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
       
        dfsPrint(a);
        System.out.println("");
        dfsPrintRecursion(a);
    }

    public static void dfsPrint(TreeNodeString root) {
        Stack<TreeNodeString> stack = new Stack<TreeNodeString>();
        stack.push(root);
        while(stack.size() > 0) {
            TreeNodeString current = stack.pop();
            if(current.right != null) {
                stack.push(current.right);
            }
            if(current.left != null) {
                stack.push(current.left);
            }
            System.out.print(current.val);
        }
    }

    public static void dfsPrintRecursion(TreeNodeString root) {
        if(root == null) {
            return;
        }
        System.out.print(root.val);
        dfsPrintRecursion(root.left);
        dfsPrintRecursion(root.right);
    }
}