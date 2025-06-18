package dataStructuresAndAlgorithms.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree {

    private Node root;

    class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

    public BinarySearchTree() {
        root = null;
    }

    public boolean insert(int value) {
        Node newNode = new Node(value);

        if (root == null) {
            root = newNode;
            return true;
        }

        Node temp = root;

        while (true) {
            if (newNode.value == temp.value) return false;

            if (newNode.value < temp.value) {
                if (temp.left == null) {
                    temp.left = newNode;
                    return true;
                } else {
                    temp = temp.left;
                }
            } else if (newNode.value > temp.value) {
                if (temp.right == null) {
                    temp.right = newNode;
                    return true;
                } else {
                    temp = temp.right;
                }
            }
        }
    }

    public boolean contains(int value) {
        Node temp = root;

        while (temp!= null) {
            if (value == temp.value) {
                return true;
            } else if (value < temp.value) {
                temp = temp.left;
            } else if (value > temp.value) {
                temp = temp.right;
            }
        }
        return false;
    }

    private boolean rContains(Node currentNode, int value) {
        if (currentNode == null) return false;

        if (currentNode.value == value) return true;

        if (value < currentNode.value) return rContains(currentNode.left, value);
        else return rContains(currentNode.right, value);
    }

    public boolean rContains(int value) {
        return rContains(root, value);
    }

    private Node rInsert(Node currentNode, int value) {
        if (currentNode == null) return new Node(value);
        if ( value<currentNode.value ) {
            currentNode.left = rInsert(currentNode.left, value);
        } else if (value>currentNode.value) {
            currentNode.right = rInsert(currentNode.right,value);
        }
        return currentNode;
    }

    public void rInsert(int value) {
        rInsert(root, value);
    }

    private int minValue(Node currentNode) {
        while (currentNode.left!=null) {
            currentNode = currentNode.left;
        }
        return currentNode.value;
    }

    private Node deleteNode(Node currentNode, int value) {
        if (currentNode == null) return null;

        if (value < currentNode.value) {
            currentNode.left = deleteNode(currentNode.left, value);
        } else if (value > currentNode.value) {
            currentNode.right = deleteNode(currentNode.right, value);
        } else {
            if (currentNode.left == null && currentNode.right == null) {
                return null;
            } else if (currentNode.left == null) {
                return currentNode.right;
            } else if (currentNode.right == null) {
                return currentNode.left;
            } else {
                int subTreeMin = minValue(currentNode.right);
                currentNode.value = subTreeMin;
                currentNode.right = deleteNode(currentNode.right, subTreeMin);
            }
        }
        return currentNode;
    }

    public void deleteNode(int value) {
        deleteNode(root, value);
    }

    public ArrayList<Integer> BFS(){
        Node currentNode = root;
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> results = new ArrayList<>();
        queue.add(currentNode);

        while(queue.size() > 0) {
            currentNode = queue.remove();
            results.add(currentNode.value);
            if (currentNode.left !=null)
                queue.add(currentNode.left);
            if (currentNode.right!= null)
                queue.add(currentNode.right);
        }

        return results;
    }

//    public ArrayList<Integer> DFSPreOrder() {
//        ArrayList<Integer> results = new ArrayList<>();
//
//        class Traverse{
//            Traverse(Node currentNode) {
//                results.add(currentNode.value);
//                if (currentNode.left!=null) {
//                    new Traverse(currentNode.left);
//                }
//                if (currentNode.right!=null) {
//                    new Traverse(currentNode.right);
//                }
//            }
//        }
//
//        new Traverse(root);
//        return results;
//    }

    public ArrayList<Integer> DFSPreOrder() {
        ArrayList<Integer> results = new ArrayList<>();
        DFSPreOrder(root, results);
        return results;
    }

    private void DFSPreOrder(Node currentNode, ArrayList<Integer> results) {
        if (currentNode == null) {
            return;
        }
        results.add(currentNode.value);                // Visit current node
        DFSPreOrder(currentNode.left, results);   // Traverse left subtree
        DFSPreOrder(currentNode.right, results);  // Traverse right subtree
    }

//    public ArrayList<Integer> DFSInOrder() {
//        ArrayList<Integer> results = new ArrayList<>();
//
//        class Traverse{
//            Traverse(Node currentNode) {
//                if (currentNode.left!=null) {
//                    new Traverse(currentNode.left);
//                }
//                results.add(currentNode.value);
//                if (currentNode.right!=null) {
//                    new Traverse(currentNode.right);
//                }
//            }
//        }
//
//        new Traverse(root);
//        return results;
//    }

    public ArrayList<Integer> DFSInOrder() {
        ArrayList<Integer> results = new ArrayList<>();
        DFSInOrder(root, results);
        return results;
    }

    private void DFSInOrder(Node currentNode, ArrayList<Integer> results) {
        if (currentNode == null) {
            return;
        }
        DFSInOrder(currentNode.left, results);   // Traverse left subtree
        results.add(currentNode.value);                // Visit current node
        DFSInOrder(currentNode.right, results);  // Traverse right subtree
    }


//    public ArrayList<Integer> DFSPostOrder() {
//        ArrayList<Integer> results = new ArrayList<>();
//
//        class Traverse{
//            Traverse(Node currentNode) {
//                if (currentNode.left!=null) {
//                    new Traverse(currentNode.left);
//                }
//                if (currentNode.right!=null) {
//                    new Traverse(currentNode.right);
//                }
//                results.add(currentNode.value);
//            }
//        }
//
//        new Traverse(root);
//        return results;
//    }

    public ArrayList<Integer> DFSPostOrder() {
        ArrayList<Integer> results = new ArrayList<>();
        DFSPostOrder(root, results);
        return results;
    }

    private void DFSPostOrder(Node currentNode, ArrayList<Integer> results) {
        if (currentNode == null) {
            return;
        }
        DFSPostOrder(currentNode.left, results);   // Traverse left subtree
        DFSPostOrder(currentNode.right, results);  // Traverse right subtree
        results.add(currentNode.value);                // Visit current node
    }

    private Node sortedArrayToBST(int[] nums, int left, int right) {
        if (left > right) return null;

        int mid = left + (right-left)/2;
        Node node = new Node(nums[mid]);
        node.left = sortedArrayToBST(nums, left, mid-1);
        node.right = sortedArrayToBST(nums, mid+1, right);

        return node;
    }

    public void sortedArrayToBST(int[] nums) {
        this.root = sortedArrayToBST(nums, 0, nums.length-1);
    }

    private Node invertTree(Node node) {
        if (node == null) return null;

        Node temp = node.left;
        node.left = invertTree(node.right);
        node.right = invertTree(temp);
        return node;
    }

    public void invert() {
        root = invertTree(root);
    }

    public boolean isValidBST() {
        ArrayList<Integer> arr = DFSInOrder();

        for (int i=0; i<arr.size() - 1; i++) {
            if (arr.get(i) >= arr.get(i+1)) return false;
        }
        return true;
    }

    public Integer kthSmallest(int k) {
        Stack<Node> stack = new Stack<>();
        Node node = this.root;

        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            k -= 1;
            if (k == 0) {
                return node.value;
            }
            node = node.right;
        }
        return null;
    }

}
