import java.util.Random;
import java.util.Scanner;

public class HomeWork3 {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Введите номер задания от 1 до 8:");
        System.out.println("1. Метод выводит массив из 0 и 1. Затем заменяет 1 на 0 и 0 на 1.");
        int method = scanner.nextInt();
        switch (method) {
            case 1:
                invertArray();
            case 2:

        }
        scanner.close();
    }
    public static void invertArray() {
        System.out.println("Введите размерность массива:");
        int n = scanner.nextInt();
        int[] arr = new int [n];
        for (int i = 0; i < arr.length; i ++) {
            arr[i] = ((int) (Math.random() + 0.5));
            System.out.print(arr[i] + " ");
        }
        System.out.println("\nОбратный массив:");
        for (int i = 0; i < arr.length; i ++) {
            if (arr[i] == 0) arr[i] = 1;
            else if (arr[i] == 1) arr[i] = 0;
            System.out.print(arr[i] + " ");
        }
    }
}
