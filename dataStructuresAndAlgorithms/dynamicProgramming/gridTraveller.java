package dataStructuresAndAlgorithms.dynamicProgramming;

public class gridTraveller {

//    private static int waysToTravelGrid(int m, int n) {
//        if (m==0 || n==0) return 0;
//        if (m==1 && n==1) return 1;
//        return waysToTravelGrid(m-1, n) + waysToTravelGrid(m, n-1);
//    }

    private static int waysToTravelGrid(int m, int n, int[][] memo) {
        if (m==0 || n==0) return 0;
        if (m==1 && n==1) return 1;

        if (memo[m-1][n-1]!=0) return memo[m-1][n-1];

        memo[m-1][n-1] = waysToTravelGrid(m-1, n, memo) + waysToTravelGrid(m, n-1, memo);
        return memo[m-1][n-1];
    }

    public static int waysToTravelGrid(int m, int n) {
        int[][] memo = new int[m][n];
        return waysToTravelGrid(m, n, memo);
    }

    public static void main(String[] args) {
        System.out.println(waysToTravelGrid(3, 3));
        System.out.println(waysToTravelGrid(3, 5));
        System.out.println(waysToTravelGrid(3, 1));
        System.out.println(waysToTravelGrid(10, 10));
    }
}
