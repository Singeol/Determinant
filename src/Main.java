import java.util.Arrays;

public class Main {
    public int determinant(int[][] array, int size) {
        int det = 0;
        if (size == 1){
            return (array[0][0]);
        }
        else{
            for (int i = 0; i < size; i++){
                int sub_size = size - 1;
                int[][] sub_matrix = new int[sub_size][sub_size];
                for (int j = 1, k = 0; j < size; j++, k++){
                    for (int m = 0, n = 0; m < i; m++, n++){
                        sub_matrix[k][n] = array[j][m];
                    }
                    for (int m = i + 1, n = i; m < size; m++, n++){
                        sub_matrix[k][n] = array[j][m];
                    }
                }
                int sign = (i % 2 == 0) ? 1 : -1;
                det += array[0][i]*sign * determinant(sub_matrix, (size-1));
            }
            return det;
        }
    }

    public static void main(String[] args) {
        Main deter = new Main();
        int[][] matrix = new int[][] {{1, 2, 3, 4}, {6, 7, 9, 8}, {5, 0, 7, 3}, {2, 1, 0, 5}};
        int[][] matrix2 = new int[][] {{5, -4}, {3, 2}};
        int size = 4;
        System.out.println(deter.determinant(matrix, size));
    }
}
