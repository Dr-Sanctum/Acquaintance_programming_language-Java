package com.example;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Пусть дан произвольный список целых чисел. Удалить из него чётные числа.
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
        int i = 0;

        while (i < listInt.size()) {
            if (listInt.get(i)%2 == 0 ){
                listInt.remove(i);
            }
            else{
                i++;
            }
        }
        System.out.println(listInt.toString());
    }
}
