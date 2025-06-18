package dataStructuresAndAlgorithms.tree;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(47);
        bst.insert(21);
        bst.insert(76);
        bst.insert(18);
        bst.insert(27);
        bst.insert(52);
        bst.insert(82);

        System.out.println("BFS: " +bst.BFS());
        System.out.println("DFS - PreOrder: " +bst.DFSPreOrder());
        System.out.println("DFS - InOrder: " +bst.DFSInOrder());
        System.out.println("DFS - PostOrder: " +bst.DFSPostOrder());
    }
}
