 public class TreeNodeString {
    String val;
    TreeNodeString left;
    TreeNodeString right;
    TreeNodeString() {}
    TreeNodeString(String val) { this.val = val; }
    
    TreeNodeString(String val, TreeNodeString left, TreeNodeString right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
 }