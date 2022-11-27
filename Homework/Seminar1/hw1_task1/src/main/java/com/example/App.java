package com.example;

import java.util.Scanner;

/**
 * Вычислить n-ое треугольного число(сумма чисел от 1 до n), n! (произведение
 * чисел от 1 до n)
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Введите число = ");
        Scanner scanner = new Scanner(System.in, "cp866");
        int number = Integer.parseInt(scanner.nextLine());
        scanner.close();
        int temp_addition = 1;
        int temp_mult = 1;
        for (int i = 2; i <= number; i++) {
            temp_addition += i;
            temp_mult = temp_mult * i;
        }
        System.out.println(String.format("Треугольное число %d = %d", number, temp_addition));
        System.out.println(String.format("Факториал числа %d = %d", number, temp_mult));
    }
}
