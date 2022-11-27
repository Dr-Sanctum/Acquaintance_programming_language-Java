package com.example;

import java.util.Scanner;

/**
 * Реализовать простой калькулятор
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.print( "Введите первое целое число - " );
        Scanner scanner = new Scanner(System.in, "cp866");
        int first_number = Integer.parseInt(scanner.nextLine());
        System.out.print( "Введите второе целое число - " );
        int second_number = Integer.parseInt(scanner.nextLine());
        System.out.print( "Введите введите оператор (+,-,*,/) " );
        String operator = scanner.nextLine();
        scanner.close();
        switch (operator) {
            case "+":
                System.out.println(first_number + second_number); 
                break;
            case "-":
                System.out.println(first_number - second_number); 
                break;
            case "*":
                System.out.println(first_number * second_number); 
                break;
            case "/":
                System.out.println((double)first_number / (double)second_number); 
                break;
            default:
                break;
        }
    }
}
