package com.example;

import java.util.ArrayList;

/**
 * Вывести все простые числа от 1 до 1000
 */
public class App 
{
    public static void main( String[] args )
    {
        //Реализован алгоритм решета Эратосфена для поиска простых чисел в заданном промежутке
        ArrayList<Integer> list_normal_number = new ArrayList<Integer>();
        for (int i = 2; i <= 1000; i++) {
            list_normal_number.add(i);
        }
        ArrayList<Integer> list_cheked = new ArrayList<Integer>();
        list_cheked.addAll(list_normal_number);
        int counter_j = 0;
        boolean first = true;
        for (Integer i : list_cheked) {
            counter_j = 0;
            first = true;
            while (counter_j < list_normal_number.size())
            {
                if (first == true && list_normal_number.get(counter_j) % i == 0)
                {
                    first = false;
                    counter_j++;
                    continue;
                }
                else if (first == false && list_normal_number.get(counter_j) % i == 0)
                {
                    list_normal_number.remove(counter_j);
                }
                counter_j++;
            }
        }

        for (Integer i : list_normal_number) {
            System.out.println(i);
        }

    }
}
