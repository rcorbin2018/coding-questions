class IsPalindrome {
    public static void main(String[] args) {
        IsPalindrome ip = new IsPalindrome();
        System.out.println("string1 result is = " + ip.isPalindrome("Was it a car or a cat I saw?"));
        System.out.println("string2 result is = " + ip.isPalindrome("tab a cat"));
        System.out.println("string3 result is = " + ip.isPalindrome("cat"));
        System.out.println("string3 result is = " + ip.isPalindrome("mom"));
    }
    public boolean isPalindrome(String inString) {
        String validChars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String inStringOnlyValid = inString;
        for(int i = 0; i < inString.length(); i++) {
            String currentChar = inString.substring(i, i + 1);
            if(validChars.indexOf(currentChar) == -1) {
                inStringOnlyValid = inStringOnlyValid.replace(currentChar, "");
            }
        }
        int left = 0;
        int right = inStringOnlyValid.length();
        while(left < right) {
            String currentLeftChar = inStringOnlyValid.substring(left, left + 1);
            String currentRightChar = inStringOnlyValid.substring(right - 1, right);
            if(!currentLeftChar.equalsIgnoreCase(currentRightChar)) {
                return false;
            }
            left = left + 1;
            right = right - 1;
        }
        return true;
    }
}