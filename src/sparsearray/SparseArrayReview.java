package sparsearray;

import java.io.*;

public class SparseArrayReview {
    private String path = "e:/sparsearrayreview.txt";

    public static void main(String[] args) throws IOException {
        SparseArrayReview sparseArrayReview = new SparseArrayReview();
        int[][] originArray = {{0, 1, 0, 0}, {1, 0, 0, 1}, {0, 0, 0, 0}, {0, 0, 1, 0}};
        sparseArrayReview.saveSparseArray(originArray);
        sparseArrayReview.printArray(sparseArrayReview.getOriginArray());
    }

    private void saveSparseArray(int[][] originArray) throws IOException {
        int valueCount = 0;
        for (int[] arr : originArray) {
            for (int val : arr) {
                if (val != 0) {
                    valueCount++;
                }
            }
        }
        int[][] sparseArray = new int[valueCount + 1][3];
        sparseArray[0][0] = originArray.length;
        sparseArray[0][1] = originArray[0].length;
        sparseArray[0][2] = valueCount;

        int index = 1;
        for (int x = 0; x < originArray.length; x++) {
            for (int y = 0; y < originArray[x].length; y++) {
                if (originArray[x][y] != 0) {
                    sparseArray[index][0] = x;
                    sparseArray[index][1] = y;
                    sparseArray[index][2] = originArray[x][y];
                    index++;
                }
            }
        }

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path));
        for (int[] arr : sparseArray) {
            for (int x = 0; x < arr.length; x++) {
                bufferedWriter.write(Integer.toString(arr[x]));
                if (x < arr.length - 1) {
                    bufferedWriter.write(',');
                } else {
                    bufferedWriter.newLine();
                }
            }
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    private int[][] getOriginArray() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        String line;
        int[][] sparseArray = new int[getLineNumber()][3];
        int index = 0;
        while ((line = bufferedReader.readLine()) != null) {
            sparseArray[index][0] = Integer.parseInt(line.split(",")[0]);
            sparseArray[index][1] = Integer.parseInt(line.split(",")[1]);
            sparseArray[index][2] = Integer.parseInt(line.split(",")[2]);
            index++;
        }
        bufferedReader.close();
        int[][] originArray = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int x = 1; x < sparseArray.length; x++) {
            originArray[sparseArray[x][0]][sparseArray[x][1]] = sparseArray[x][2];
        }
        return originArray;
    }

    private int getLineNumber() throws IOException {
        int lineNumber = 0;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            lineNumber++;
        }
        bufferedReader.close();
        return lineNumber;
    }

    private void printArray(int[][] array) {
        for (int[] arr : array) {
            for (int value : arr) {
                System.out.print(value);
                System.out.print(",");
            }
            System.out.println();
        }
    }
}
