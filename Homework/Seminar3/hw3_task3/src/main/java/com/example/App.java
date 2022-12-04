package com.example;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее арифметичское этого списка.
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ArrayList<Integer> listInt = new ArrayList<Integer>();

        for (int i = 0; i < 10; i++) {
            listInt.add(ThreadLocalRandom.current().nextInt(-20, 20));
        }
        System.out.println(listInt.toString());
        int min = listInt.get(0);
        int max = listInt.get(0);
        int sum = 0;
        for (Integer integer : listInt) {
            if (min > integer) {
                min = integer;
            }
            if (max < integer) {
                max = integer;
            }
            sum += integer;
        }
        StringBuilder builder = new StringBuilder();
        builder.append("Минимальное число в массиве = ");
        builder.append(min);
        builder.append("\n");
        builder.append("Максимальное число в массиве = ");
        builder.append(max);
        builder.append("\n");
        builder.append("Средне арифметическое в массиве = ");
        builder.append((double)sum/listInt.size());
        System.out.println(builder.toString());
    }
}
