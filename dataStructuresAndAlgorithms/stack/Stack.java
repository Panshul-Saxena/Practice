package dataStructuresAndAlgorithms.stack;
//
//public class Stack {
//    private Node top;
//    private int height;
//
//    class Node {
//        int value;
//        Node next;
//
//        Node(int value) {
//            this.value = value;
//        }
//    }
//
//    public Stack() {
//        top = null;
//        height = 0;
//    }
//
//    public Stack(int value) {
//        Node newNode = new Node(value);
//        top = newNode;
//        height = 1;
//    }
//
//    public void printStack() {
//        Node temp = top;
//        while (temp != null) {
//            System.out.println(temp.value);
//            temp = temp.next;
//        }
//    }
//
//    public void push(int value) {
//        Node newNode = new Node(value);
//
//        if ( top == null )
//            top = newNode;
//        else {
//            newNode.next = top;
//            top = newNode;
//        }
//        height++;
//    }
//
//    public Node pop() {
//        if ( top == null )
//            return null;
//
//        Node temp = top;
//        top = top.next;
//        temp.next = null;
//
//        height--;
//        return temp;
//    }
//}

import java.util.ArrayList;

public class Stack<T> {

    private ArrayList<T> stackList = new ArrayList<>();

    public ArrayList<T> getStackList() {
        return stackList;
    }

    public void printStack() {
        for (int i = stackList.size()-1; i >= 0; i--) {
            System.out.println(stackList.get(i));
        }
    }

    public boolean isEmpty() {
        return stackList.size() == 0;
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        } else {
            return stackList.get(stackList.size() - 1);
        }
    }

    public int size() {
        return stackList.size();
    }

    public void push(T value) {
        stackList.add(value);
    }

    public T pop() {
        if (isEmpty()) return null;
        return stackList.remove(stackList.size() - 1);
    }

    public static void sortStack(Stack<Integer> stack) {
        Stack<Integer> additionalStack = new Stack<>();

        while (!stack.isEmpty()) {
            int temp = stack.pop();

            while (!additionalStack.isEmpty() && additionalStack.peek() > temp) {
                stack.push(additionalStack.pop());
            }

            additionalStack.push(temp);
        }

        while (!additionalStack.isEmpty()) {
            stack.push(additionalStack.pop());
        }
    }

}
