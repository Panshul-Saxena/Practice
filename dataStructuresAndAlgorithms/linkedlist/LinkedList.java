package dataStructuresAndAlgorithms.linkedlist;


import java.util.HashSet;

public class LinkedList {

    private Node head;
    private Node tail;
    private int length;


    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }


    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public Node getHead() {
        if (head == null) {
            return null;
        } else {
            return head;
        }
    }

    public Node getTail() {
        if (head == null) {
            return null;
        } else {
            return tail;
        }
    }

    public int getLength() {
        return length;
    }

    public Node get(int index) {
        if (index < 0 || index >= length) {
            return null;
        }

        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp;
    }

    public boolean set(int index, int value) {
        Node temp = get(index);
        if(temp!=null){
            temp.value = value;
            return true;
        }
        return false;
    }

    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);

        if (length == 0) {
            tail = newNode;
        } else {
            newNode.next = head;
        }
        head = newNode;
        length++;
    }

    public void append(int value) {
        Node newNode = new Node(value);

        if (length == 0) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;

        length++;
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > length) {
            return false;
        }
        else if (index == 0) {
            prepend(value);
            return true;
        }
        else if (index == length) {
            append(value);
            return true;
        }
        Node temp = get(index - 1);
        Node newNode = new Node(value);
        newNode.next = temp.next;
        temp.next = newNode;

        length++;
        return true;
    }

    public Node removeFirst() {
        if (length == 0) {
            return null;
        }
        Node temp = head;
        if (length == 1) {
            makeEmpty();
            return temp;
        }

        head = head.next;
        temp.next = null;
        length--;

        return temp;
    }

    public Node removeLast() {
        if (length == 0) {
            return null;
        }
        Node temp = head;
        if (length == 1) {
            makeEmpty();
            return temp;
        }

        temp = get(length - 2);
        tail = temp;
        temp = temp.next;
        tail.next = null;
        length--;
        return temp;

    }

    public Node remove(int index) {
        if (index < 0 || index >= length) {
            return null;
        }
        else if (index == 0) {
            return removeFirst();
        }
        else if (index == length - 1) {
            return removeLast();
        }
        Node prev = get(index - 1);
        Node temp = prev.next;
        prev.next = temp.next;
        temp.next = null;

        length--;
        return temp;
    }


    public void reverse() {
        Node temp = head;
        head = tail;
        tail = temp;

        Node before = null;
        Node after = temp.next;

        for (int i = 0; i < length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }

    public void reverseBetween(int startIndex, int endIndex) {
        if (head == null) return;

        Node dummyNode = new Node(0);
        dummyNode.next = head;
        Node previousNode = dummyNode;

        for (int i = 0; i < startIndex; i++) {
            previousNode = previousNode.next;
        }

        Node currentNode = previousNode.next;

        for (int i = 0; i < endIndex - startIndex; i++) {
            Node nodeToMove = currentNode.next;
            currentNode.next = nodeToMove.next;
            nodeToMove.next = previousNode.next;
            previousNode.next = nodeToMove;
        }

        head = dummyNode.next;

    }

    //Leetcode 141
    //Floyd's cycle-finding algorithm (also known as the "tortoise and the hare" algorithm)
    public boolean hasLoop() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) return true;

//            Leetcode 142
//            if (slow == fast) break;
        }

//        To return the node where cycle is made.
//        if (!hasLoop()) return true;
//        Node temp = head;
//
//        while (temp != slow) {
//            temp = temp.next;
//            slow = slow.next;
//        }
//
//        return temp;
        return false;
    }

    //Leetcode 19
    //Remove kth node from the end using two pointers
    public Node kthFromEnd(int k) {
        Node slow = head;
        Node fast = head;

        for (int i = 0; i < k; i++) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }


    //Partition List
    public void partitionList(int x) {
        if (head == null) return;

        Node dummy1 = new Node(0);
        Node dummy2 = new Node(0);
        Node prev1 = dummy1;
        Node prev2 = dummy2;
        Node current = head;

        while (current != null) {
            if (current.value < x) {
                prev1.next = current;
                prev1 = current;
            } else {
                prev2.next = current;
                prev2 = current;
            }
            current = current.next;
        }

        prev2.next = null;
        prev1.next = dummy2.next;

        head = dummy1.next;
    }
//    public void partitionList(int x) {
//        if (head == null) return;
//
//        Node left = null;
//        Node right = null;
//        Node temp = head;
//
//        while (temp != null) {
//            if (temp.value < x) {
//                if(left == null) {
//                    left = temp;
//                }
//                else if (left.next == temp) {
//                    left = left.next;
//                }
//                else {
//                    Node ptr = right.next.next;
//                    right.next.next = left.next;
//                    left.next = right.next;
//                    right.next = ptr;
//
//                    left = left.next;
//                }
//            }
//            else {
//                if (right==null) {
//                    right = temp;
//                }
//                else {
//                    right = right.next;
//                }
//            }
//            temp = temp.next;
//        }
//    }

    public void removeDuplicates() {
        HashSet<Integer> set = new HashSet<>();
        Node prev = null;
        Node current = head;

        while (current!=null) {
            if (set.contains(current.value)) {
                prev.next = current.next;
                length--;
            }
            else {
                set.add(current.value);
                prev = current;
            }
                current = current.next;
        }
    }

    public int binaryToDecimal() {
        int num = 0;
        Node temp = head;
        double exp;

        for (int i=length-1 ; i>=0 ; i--) {
            exp = Math.pow(2,i);
            num += temp.value*exp;
            temp = temp.next;
        }

        return num;
    }



}