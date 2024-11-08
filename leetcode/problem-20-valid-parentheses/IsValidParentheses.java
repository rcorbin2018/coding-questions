import java.util.*;

class IsValidParentheses {
    public static void main(String[] args) {
        String input1 = "()";
        boolean result = isValid(input1);
        System.out.println("input: " + input1 + " result = " + result);
        String input2 = "()[]{}";
        result = isValid(input2);
        System.out.println("input: " + input2 + " result = " + result);
        String input3 = "(]";
        result = isValid(input3);
        System.out.println("input: " + input3 + " result = " + result);
        String input4 = "([])";
        result = isValid(input4);
        System.out.println("input: " + input4 + " result = " + result);
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        HashMap<Character, Character> hm = new HashMap<Character, Character>();
        hm.put(')', '(');
        hm.put(']', '[');
        hm.put('}', '{');
        for(char c : s.toCharArray()) {
            System.out.println("char is: " + c);
            if(hm.containsKey(c)) {
                System.out.println("char: " + c + " is a key in the hashmap of closing parens.");
                if(!stack.isEmpty() && stack.peek() == hm.get(c)) {
                    System.out.println("char: " + hm.get(c) + " value from the hashmap of closing parens is on the stack and must be popped. peek = " + stack.peek());
                    stack.pop();
                    System.out.println("stack = " + stack);
                } else {
                    System.out.println("stack is not empty or char: " + c + " is not on the stack and cant' be popped. peek = " + stack.peek());
                    return false;
                }
            } else {
                System.out.println("char: " + c + " is not in the hashmap of closing parens. pushing to stack");
                stack.push(c);
                System.out.println("stack = " + stack);
            }
        }
        return stack.isEmpty();
    }
}