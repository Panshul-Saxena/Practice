package dataStructuresAndAlgorithms.stack;


public class Main {

//    public static String reverseString(String s){
//        String newString = "";
//        Stack<String> stack = new Stack<>();
//
//        for(int i = 0; i <= s.length(); i++){
//            stack.push(s.substring(i,i+1));
//        }
//
//        for(int i=0;i<=s.length();i++){
//            newString += stack.pop();
//        }
//
//        return newString;
//    }

//    public static String reverseString(String string) {
//        Stack<Character> stack = new Stack<>();
//        String reversedString = "";
//
//        for (char c : string.toCharArray()) {
//            stack.push(c);
//        }
//
//        while (!stack.isEmpty()) {
//            reversedString += stack.pop();
//        }
//
//        return reversedString;
//    }
//
//
//    public static void main(String[] args) {
//        String myString = "hello";
//        String reversedString = reverseString(myString);
//        System.out.println(reversedString);
//
//        /*
//            EXPECTED OUTPUT:
//            ----------------
//            olleh
//        */
//    }

//    static boolean isBalancedParentheses(String s) {
//        Stack<Character> stack = new Stack<>();
//
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
//                stack.push(s.charAt(i));
//            } else if (s.charAt(i) == ')' && stack.peek() == '(') {
//                stack.pop();
//            } else if (s.charAt(i) == '}' && stack.peek() == '{') {
//                stack.pop();
//            } else if (s.charAt(i) == ']' && stack.peek() == '[') {
//                stack.pop();
//            } else {
//                return false;
//            }
//        }
//
//        return stack.isEmpty();
//    }

    public static boolean isBalancedParentheses(String parentheses) {
//        Stack stack = new Stack();
        Stack<Character> stack = new Stack<>();
        for (char p : parentheses.toCharArray()) {
            if (p == '(' || p == '{' || p == '[') {
                stack.push(p);
            } else if (p == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            } else if (p == '}') {
                if (stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
            } else if (p == ']') {
                if (stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        testAndPrint("()", true);
        testAndPrint("()()", true);
        testAndPrint("(())", true);
        testAndPrint("()()()", true);
        testAndPrint("(()())", true);
        testAndPrint(")()(", false);
        testAndPrint(")(", false);
        testAndPrint("(()", false);
        testAndPrint("))", false);
        testAndPrint("(", false);
        testAndPrint(")", false);
    }

    public static void testAndPrint(String testStr, boolean expected) {
        // Run the test and store the result
        boolean result = isBalancedParentheses(testStr);

        // Print the test string, expected result, and actual result
        System.out.println("Test String: " + testStr);
        System.out.println("EXPECTED: " + expected);
        System.out.println("RESULT: " + result);

        // Check if the test passed or failed
        if (result == expected) {
            System.out.println("STATUS: PASS");
        } else {
            System.out.println("STATUS: FAIL");
        }

        // Print a separator for better readability
        System.out.println("--------------");
    }
}
