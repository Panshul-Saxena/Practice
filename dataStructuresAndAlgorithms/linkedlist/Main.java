package dataStructuresAndAlgorithms.linkedlist;

public class Main {

    public static void main(String[] args) {

        LinkedList myLinkedList = new LinkedList(3);
//        myLinkedList.append(2);
//        myLinkedList.append(3);
//        myLinkedList.append(4);
//        myLinkedList.append(5);
        myLinkedList.append(8);
        myLinkedList.append(8);
        myLinkedList.append(8);
        myLinkedList.append(5);
        myLinkedList.append(1);

        System.out.println("\nLinked List:");
        myLinkedList.printList();

        myLinkedList.removeDuplicates();

        System.out.println("\nLinked List:");
        myLinkedList.printList();

    }

}