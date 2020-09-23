package array;

import java.util.ArrayList;

/**
 * @Author: zjumic
 * @Date: created at 14:51 2020/9/21
 */

// 顺时针打印矩阵
public class PrintMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[][] {{1,2,3}, {8,9,4}, {7,6,5}};
        PrintMatrix printMatrix = new PrintMatrix();
        System.out.println(printMatrix.printMatrix(matrix));
    }

    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        // beginR, endR
        int bR = 0, bC = 0;
        int eR = matrix.length - 1, eC = matrix[0].length - 1;
        while (bR <= eR && bC <= eC) {
            printMatrix(result, matrix, bR++, bC++, eR--, eC--);
        }
        return result;
    }

    /**
     * 顺时针打印一圈，由于传参传的是
     * @param result
     * @param matrix
     * @param bR
     * @param bC
     * @param eR
     * @param eC
     */
    public void printMatrix(ArrayList<Integer> result, int[][] matrix, int bR, int bC, int eR, int eC) {
        if (bR == eR) {
            for (int i = bC; i <= eC; i++) {
                result.add(matrix[bR][i]);
            }
        } else if (bC == eC){
            for (int i = bR; i <= eR; i++) {
                result.add(matrix[i][bC]);
            }
        } else {
            int curR = bR, curC = bC;
            while (curC != eC) {
                result.add(matrix[curR][curC++]);
            }
            while (curR != eR) {
                result.add(matrix[curR++][curC]);
            }
            while (curC != bC) {
                result.add(matrix[curR][curC--]);
            }
            while (curR != bR) {
                result.add(matrix[curR--][curC]);
            }
        }
    }
}
