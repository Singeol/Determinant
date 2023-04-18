import java.util.Scanner;

public class Main {
    // Функция для нахождения определителя матрицы
    public int determinant(int[][] array, int size) {
        int det = 0;
        if (size == 1){  // Базовый случай: матрица размером 1х1, определитель равен единственному элементу матрицы
            return (array[0][0]);
        }
        else{
            for (int i = 0; i < size; i++){
                int sub_size = size - 1;
                int[][] sub_matrix = new int[sub_size][sub_size];
                // Создание матрицы-подматрицы
                for (int j = 1, k = 0; j < size; j++, k++){
                    for (int m = 0, n = 0; m < i; m++, n++){
                        sub_matrix[k][n] = array[j][m];
                    }
                    for (int m = i + 1, n = i; m < size; m++, n++){
                        sub_matrix[k][n] = array[j][m];
                    }
                }
                // Вычисление знака минора
                int sign = (i % 2 == 0) ? 1 : -1;
                // Вычисление определителя матрицы-подматрицы
                det += array[0][i]*sign * determinant(sub_matrix, (size-1));
            }
            return det;  // Возвращение значения определителя
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main deter = new Main();
        int size = scanner.nextInt();  // Получение размера матрицы от пользователя
        int[][] matrix = new int[size][size];  // Создание двумерного массива для хранения матрицы
        // Заполнение матрицы
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                matrix[i][j] = scanner.nextInt();
            }
        }
        // Вывод определителя матрицы
        System.out.println(deter.determinant(matrix, size));
    }
}
