class ReverseLinkedList {

    public static void main(String[] args) {
        ReverseLinkedList rll = new ReverseLinkedList();
        ListNode head = new ListNode();
        head.val = 1;
        ListNode ln1 = new ListNode();
        ln1.val = 2;
        head.next = ln1;
        ListNode ln2 = new ListNode();
        ln2.val = 3;
        ln1.next = ln2;
        ListNode ln3 = new ListNode();
        ln3.val = 4;
        ln2.next = ln3;
        ListNode ln4 = new ListNode();
        ln4.val = 5;
        ln3.next = ln4;
        System.out.println("head = " + head.toString());
        ListNode returnln = rll.reverseList(head);
        System.out.println("returnln = " + returnln.toString());
        ListNode returnlnrecursed = rll.reverseListRecursive(returnln);
        System.out.println("returnlnrecursed = " + returnlnrecursed.toString());
    }
    //using just pointers
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null) {
            ListNode tempNext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tempNext;
        }
        return prev;
    }
    //using recursion
    public ListNode reverseListRecursive(ListNode head) {
        return reverse(head, null);
    }
    public ListNode reverse(ListNode curr, ListNode prev) {
        if(curr == null) {
            return prev;
        } else {
            ListNode next = curr.next;
            curr.next = prev;
            return reverse(next, curr); 
        }
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        public String toString() {
            String result = val + " ";
            if (next != null) {
                result += next.toString();
            }
            return result;
        }
    }
}