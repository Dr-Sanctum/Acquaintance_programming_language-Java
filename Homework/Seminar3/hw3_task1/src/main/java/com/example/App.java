package com.example;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Реализовать алгоритм сортировки слиянием.
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        int[] asd = new int[]{3,1,0,45,4,3,62,8,3,6,0,0,5,5,3,465,8};
        System.out.println(Arrays.toString(asd));
        System.out.println(Arrays.toString(sortArray(asd)));
    }

    public static int [] sortArray(int[] arrayA){ // сортировка Массива который передается в функцию
        // проверяем не нулевой ли он?
        if (arrayA == null) {
            return null;
        }
        // проверяем не 1 ли элемент в массиве?
        if (arrayA.length < 2) {
            return arrayA;
        }
        // копируем левую часть от начала до середины
        int [] arrayB = new int[arrayA.length / 2];
        System.arraycopy(arrayA, 0, arrayB, 0, arrayA.length / 2);

        // копируем правую часть от середины до конца массива, вычитаем из длины первую часть
        int [] arrayC = new int[arrayA.length - arrayA.length / 2];
        System.arraycopy(arrayA, arrayA.length / 2, arrayC, 0, arrayA.length - arrayA.length / 2);

        // рекурсией помещаем обе части обратно в метод, он будет работать до тех пор,
        // пока не дойдет до 1 элемента в массиве, после чего вернется в строку и будет искать 
        // правую часть от него и опять вернет его назад
        arrayB = sortArray(arrayB); // левая часть возврат из рекурсии;
        arrayC = sortArray(arrayC); // правая часть возврат из рекурсии;

        // далее опять рекурсия возврата слияния двух отсортированных массивов
        return mergeArray(arrayB, arrayC);
    }

    public static int [] mergeArray(int[] arrayA, int [] arrayB) {

        int [] arrayC = new int[arrayA.length + arrayB.length];
       
        int positionA = 0, positionB = 0;
        
        for (int i = 0; i < arrayC.length; i++) {
            if (positionA == arrayA.length){
                arrayC[i] = arrayB[i - positionA];
                positionB++;
            } else if (positionB == arrayB.length) {
                arrayC[i] = arrayA[i - positionB];
                positionA++;
            } else if (arrayA[i - positionB] < arrayB[i - positionA]) {
                arrayC[i] = arrayA[i - positionB];
                positionA++;
            } else {
                arrayC[i] = arrayB[i - positionA];
                positionB++;
            }
        }
        return arrayC;
    }
}
