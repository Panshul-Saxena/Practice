package Leetcode;


public class q885 {

    public static int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int [][] arr = new int[rows*cols][2];
        int count = 0;
        int r = rStart;
        int c = cStart;
        int rotation = 0;
        int step = 0;
        int currentStep = 0;

        while (count!= (rows*cols)) {
            if (rotation%5 == 0) {
                if (r<rows && c<cols && r>=0 && c>=0) {
                    arr[count][0] = r;
                    arr[count++][1] = c;
                }
                c++;
                rotation++;
                step+=2;
            } else if (rotation%5 == 1 && currentStep < step-1) {
                if (r<rows && c<cols && r>=0 && c>=0) {
                    arr[count][0] = r;
                    arr[count++][1] = c;
                }
                r++;
                currentStep++;
                if (step-1 == currentStep) {
                    currentStep = 0;
                    rotation++;
                };
            } else if (rotation%5 == 2 && currentStep < step) {
                if (r<rows && c<cols && r>=0 && c>=0 ) {
                    arr[count][0] = r;
                    arr[count++][1] = c;
                }
                c--;
                currentStep++;
                if (step == currentStep) {
                    currentStep = 0;
                    rotation++;
                };
            } else if (rotation%5 == 3 && currentStep < step) {
                if (r<rows && c<cols && r>=0 && c>=0 ) {
                    arr[count][0] = r;
                    arr[count++][1] = c;
                }
                r--;
                currentStep++;
                if (step == currentStep) {
                    currentStep = 0;
                    rotation++;
                };
            } else if (rotation%5 == 4 && currentStep < step) {
                if (r<rows && c<cols && r>=0 && c>=0 ) {
                    arr[count][0] = r;
                    arr[count++][1] = c;
                }
                c++;
                currentStep++;
                if (step == currentStep) {
                    currentStep = 0;
                    rotation++;
                };
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        spiralMatrixIII(5,6,1,4);
    }
}
