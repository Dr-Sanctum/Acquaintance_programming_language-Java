package com.example;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Даны два ArrayList из целых чисел. Написать функции, которые вычисляют разницу коллекций:
 * 
 * Разность:
 * A - B = все числа из первой коллекции, которые не содержатся во второй коллекции
 * B - A = все числа из второй коллекции, которые не содержатся в первой
 * 
 * Симметрическая разность:
 * A ^ B = числа из первой коллекции, которых нет во второй, А ТАКЖЕ числа из второй, которых нет в первой
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ArrayList<Integer> listIntFirst = new ArrayList<Integer>();
        ArrayList<Integer> listIntSecond = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            listIntFirst.add(ThreadLocalRandom.current().nextInt(0, 20));
            listIntSecond.add(ThreadLocalRandom.current().nextInt(0, 20));
        }
        System.out.println(listIntFirst.toString());
        System.out.println(listIntSecond.toString());
        
        System.out.println(aDiffB(listIntFirst, listIntSecond).toString());
        System.out.println(bDiffA(listIntFirst, listIntSecond).toString());
        System.out.println(bSymmetricDiffA(listIntFirst, listIntSecond).toString());
    }

    public static ArrayList<Integer> aDiffB(ArrayList<Integer> first, ArrayList<Integer> second){
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (Integer integer : first){
            if (!second.contains(integer)) {
                result.add(integer);
            }
        }
        return result;
    }
    
    public static ArrayList<Integer> bDiffA(ArrayList<Integer> first, ArrayList<Integer> second){
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (Integer integer : second){
            if (!first.contains(integer)) {
                result.add(integer);
            }
        }
        return result;
    }
    
    public static ArrayList<Integer> bSymmetricDiffA(ArrayList<Integer> first, ArrayList<Integer> second){
        ArrayList<Integer> result = new ArrayList<Integer>();

        result.addAll(0, aDiffB(first, second));
        result.addAll(result.size(), bDiffA(first, second));
        return result;
    }
}
