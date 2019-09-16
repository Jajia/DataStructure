package SparseArray;

import java.io.*;

public class SparseArrayDemo {
    String path = "e:/sparsearray.txt";

    public static void main(String[] args) throws IOException {
        SparseArrayDemo sparseArrayTest = new SparseArrayDemo();
        int[][] originArray = new int[][]{{0, 0, 1, 2}, {0, 0, 0, 4}, {2, 1, 0, 0}, {0, 5, 0, 0}};
        sparseArrayTest.getSparseArray(originArray);
        originArray = sparseArrayTest.getOriginArray(sparseArrayTest.getFileLines());
        sparseArrayTest.printArray(originArray);
    }

    public void getSparseArray(int[][] originArray) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path));
        int count = 0;
        for (int i = 0; i < originArray.length; i++) {
            for (int j = 0; j < originArray[i].length; j++) {
                if (originArray[i][j] != 0) {
                    count++;
                }
            }
        }
        int[][] sparseArray = new int[count + 1][3];
        sparseArray[0][0] = originArray.length;
        sparseArray[0][1] = originArray[0].length;
        sparseArray[0][2] = count;
        int index = 1;
        for (int i = 0; i < originArray.length; i++) {
            for (int j = 0; j < originArray[i].length; j++) {
                if (originArray[i][j] != 0) {
                    sparseArray[index][0] = i;
                    sparseArray[index][1] = j;
                    sparseArray[index++][2] = originArray[i][j];
                }
            }
        }

        for (int i = 0; i < sparseArray.length; i++) {
            for (int j = 0; j < sparseArray[i].length; j++) {
                bufferedWriter.write(String.valueOf(sparseArray[i][j]));
                if (j < sparseArray[i].length - 1) {
                    bufferedWriter.write(',');
                }
            }
            if (i < sparseArray.length - 1) {
                bufferedWriter.write('\n');
            }
        }
        bufferedWriter.close();
    }

    public int[][] getOriginArray(int lineNumber) throws IOException {
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        int[][] sparseArray = new int[lineNumber][3];
        int index = 0;
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            sparseArray[index][0] = new Integer(line.split(",")[0]);
            sparseArray[index][1] = new Integer(line.split(",")[1]);
            sparseArray[index][2] = new Integer(line.split(",")[2]);
            index++;
        }
        bufferedReader.close();
        int[][] originArray = new int[sparseArray[0][0]][sparseArray[0][1]];
        if (sparseArray.length > 1) {
            for (int i = 1; i < sparseArray.length; i++) {
                originArray[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
            }
        }
        return originArray;
    }

    public void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]);
                if (j != array[i].length - 1) {
                    System.out.print(",");
                }
            }
            System.out.println();
        }
    }

    public int getFileLines() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        int lineNumber = 0;
        while (bufferedReader.readLine() != null) {
            lineNumber++;
        }
        bufferedReader.close();
        return lineNumber;
    }
}
