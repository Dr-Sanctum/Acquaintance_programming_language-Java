package com.example;

import java.util.Collections;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        LinkedList<Integer> listInt = new LinkedList<Integer>();
        for (int i = 0; i < 10; i++) {
            listInt.add(ThreadLocalRandom.current().nextInt(-20, 20));
        }
        System.out.println(listInt);

        LinkedList<Integer> resultListInt = (LinkedList)reversList(listInt);
        System.out.println(resultListInt);
    }

    public static LinkedList reversList(LinkedList list){
        LinkedList result = (LinkedList) list.clone();
        Collections.reverse(result);
        return result;
    }  

    
        
    
}
