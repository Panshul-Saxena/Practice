package dataStructuresAndAlgorithms.doublylinkedlist;

public class DoublyLinkedList {

    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;
        Node prev;

        Node(int value) {
            this.value = value;
        }
    }

    public DoublyLinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void printList() {
        Node temp = head;
        while (temp!=null) {
            System.out.print(temp.value);
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

    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }

    public Node get(int index) {
        if (index < 0 || index >= length) {
            return null;
        }
        Node temp = head;

        if (index < length/2) {
            for (int i = index; i < length; i++) {
                temp = temp.next;
            }
        } else {
            temp = tail;
            for (int i = length - 1; i > index; i--) {
                temp = temp.prev;
            }
        }

        return temp;
    }

    public boolean set(int index, int value) {
        Node temp = get(index);
        if (temp != null) {
            temp.value = value;
            return true;
        }
        return false;
    }

    public void preprend(int value) {
        Node newNode = new Node(value);

        if (length == 0) {
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
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
            newNode.prev = tail;
        }
        tail = newNode;

        length++;
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > length) {
            return false;
        }
        else if (index == 0) {
            preprend(value);
            return true;
        }
        else if (index == length) {
            append(value);
            return true;
        }
        Node before = get(index - 1);
        Node after = before.next;

        Node newNode = new Node(value);
        newNode.next = before.next;
        newNode.prev = before;
        before.next = newNode;
        after.prev = newNode;

        length++;
        return true;
    }

    public Node removeFirst() {
        if (length == 0) {
            return null;
        }
        Node temp = head;
        if( length == 1) {
            makeEmpty();
            return temp;
        }

        head = head.next;
        head.prev = null;
        temp.next = null;
        length--;
        return temp;
    }

    public Node removeLast() {
        if (length == 0) {
            return null;
        }
        Node temp = tail;
        if (length == 1) {
            makeEmpty();
            return temp;
        }

        tail = tail.prev;
        tail.next = null;
        temp.prev = null;
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
        Node temp = get(index);

        temp.next.prev = temp.prev;
        temp.prev.next = temp.next;
        temp.next = null;
        temp.prev = null;
        length--;
        return temp;

    }

    public void swapFirstLast() {
        if (length == 0 || length == 1) {
            return;
        }
        int temp = head.value;
        head.value = tail.value;
        tail.value = temp;
    }

    public void reverse() {
        Node current = head;
        Node temp = null;

        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;

            current = current.prev;
        }

        temp = head;
        head = tail;
        tail = temp;
    }

    public boolean isPalindrome() {
        if (length <= 1) return true;
        Node left = head;
        Node right = tail;

        for (int i = 0; i < length / 2; i++) {
            if (left.value != right.value) {
                return false;
            }
            left = left.next;
            right = right.prev;
        }
        return true;
    }

    public void swapPairs() {
        Node dummyNode = new Node(0);
        dummyNode.next = head;
        Node previousNode = dummyNode;

        while (head != null && head.next != null) {
            Node firstNode = head;
            Node secondNode = head.next;

            previousNode.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            secondNode.prev = previousNode;
            firstNode.prev = secondNode;

            if (firstNode.next != null) {
                firstNode.next.prev = firstNode;
            }

            head = firstNode.next;
            previousNode = firstNode;
        }

        head = dummyNode.next;
        if (head != null) head.prev = null;
    }


}
