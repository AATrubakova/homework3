import java.util.Scanner;

public class HomeWork3 {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Введите номер задания от 1 до 8:");
        System.out.println("1. Метод выводит массив из 0 и 1. Затем заменяет 1 на 0 и 0 на 1");
        System.out.println("2. Метод заполняет пустой массив значениями от 1 до 100");
        System.out.println("3. Метод умножает на 2 значения массива < 6");
        System.out.println("4. Метод создает двумерный массив с единичными диагоналями");
        System.out.println("5. Метод возвращает одномерный массив типа int длиной len, каждая ячейка которого равна initialValue");
        System.out.println("6. Метод возвращает минимальный и максимальный элемент одномерного массива");
        System.out.println("7. Метод определяет равенство суммы левой и правой части одномерного массива ");
        System.out.println("8. Метод выполняет сдвиг массива на n позиций");
        int method = Integer.parseInt(scanner.nextLine());
        switch (method) {
            case 1:
                invertArray();
                break;
            case 2:
                hundredArray();
                break;
            case 3:
                isNumberArrayLessSix();
                break;
            case 4:
                unitDiagonalArray();
                break;
            case 5:
                System.out.println("Введите длину массива len:");
                int len = scanner.nextInt();
                System.out.println("Введите значение initialValue:");
                int initialValue = scanner.nextInt();
                printArray(len, initialValue);
                break;
            case 6:
                maxMinNumbersArray();
                break;
            case 7:
                System.out.println(checkBalance());
                break;
            case 8:
                cyclicShiftArray();
                break;
        }
        scanner.close();
    }
    public static void invertArray() {
        System.out.println("Введите размерность массива:");
        int n = scanner.nextInt();
        int[] arr = new int [n];
        for (int i = 0; i < arr.length; i ++) {
            arr[i] = (int) (Math.random() * 2);
            System.out.print(arr[i] + " ");
        }
        System.out.println("\nОбратный массив:");
        for (int i = 0; i < arr.length; i ++) {
            if (arr[i] == 0) arr[i] = 1;
            else if (arr[i] == 1) arr[i] = 0;
            System.out.print(arr[i] + " ");
        }
    }
    public static void hundredArray() {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
            System.out.print(array[i] + " ");
        }
    }
    public static void isNumberArrayLessSix() {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("1 5 3 2 11 4 5 2 4 8 9 1\n");
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] = array[i] * 2;
            } System.out.print(array[i] + " ");
        }
    }
    public static void unitDiagonalArray() {
        System.out.println("Введите размерность двумерного массива:");
        int n = scanner.nextInt();
        int[][] array = new int[n][n];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = (int) (Math.random() * 10);
                if (i == j || j == n - i - 1) array[i][j] = 1;
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void printArray(int len, int initialValue) {
        int[] array = new int [len];
        for (int i = 0; i < array.length; i++) {
            array[i] = initialValue;
            System.out.print(array[i] + " ");
        }
    }
    public static void maxMinNumbersArray() {
        System.out.println("Введите размерность массива:");
        int n = scanner.nextInt();
        int[] array = new int [n];
        int min = 200000000;
        int max = - 200000000;
        for (int i = 0; i < array.length; i ++) {
            array[i] = (int) (Math.random() * 100);
            System.out.print(array[i] + " ");
            if (array[i] <= min) min = array[i];
            if (array[i] >= max) max = array[i];
        }
        System.out.println("\nmin = " + min);
        System.out.println("max = " + max);
    }
    public static boolean checkBalance() {
        System.out.println("Введите размерность массива:");
        int n = scanner.nextInt();
        int[] array = new int [n];
        int sumarr = 0;
        int sumleft = 0;
        int sumright = 0;
        for (int i = 0; i < array.length; i ++) {
            array[i] = (int) (Math.random() * 2);
            System.out.print(array[i] + " ");
            sumarr += array[i];
        }

        for (int i = 0; i < array.length; i++) {
            sumleft += array[i];
            sumright = sumarr - sumleft;
            System.out.println("\nsumleft = " + sumleft);
            System.out.println("sumright = " + sumright);
            if (sumleft == sumright) {
                System.out.println("true");
            }
        }
        return false;
    }
    public static void cyclicShiftArray() {
        System.out.println("Введите размерность массива:");
        int len = scanner.nextInt();
        System.out.println("Введите величину сдвига n:");
        int n = scanner.nextInt();
        int[] arr = new int [len];
        int temp;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 10);
            System.out.print(arr[i] + " ");
        }
        System.out.println("\nМассив со сдвигом на " + n + " позиции:");
        if (n >= 0) {
            while (n != 0) {
                temp = arr[arr.length-1];
                for (int i = arr.length - 1; i > 0; i--) {
                    arr[i] = arr[i-1];
                }
                arr[0] = temp;
                n = n - 1;
            }
        }
        else if (n < 0) {
            while (n != 0) {
                temp = arr[0];
                for (int i = 1; i < arr.length; i++) {
                    arr[i-1] = arr[i];
                }
                arr[arr.length-1] = temp;
                n = n + 1;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
