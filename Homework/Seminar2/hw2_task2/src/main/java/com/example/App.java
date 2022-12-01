package com.example;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.*;

/**
 * Реализуйте алгоритм сортировки пузырьком числового массива, результат после
 * каждой итерации запишите в лог-файл.
 *
 */
public class App {
    public static void main(String[] args) {
        Logger log = Logger.getLogger(App.class.getName());
        FileHandler fh;
        
        try {
            fh = new FileHandler("log.txt");
            log.addHandler(fh);
            SimpleFormatter sFormat = new SimpleFormatter();
            fh.setFormatter(sFormat);
            int[] arrNumber = new int[] { 1, 6, 9, 3, 56, 9, 1 };
            int temp = 0;
            for (int i = 0; i < arrNumber.length - 1; i++) {
                for (int j = 0; j < arrNumber.length - i - 1; j++) {
                    if (arrNumber[j] > arrNumber[j + 1]) {
                        temp = arrNumber[j + 1];
                        arrNumber[j + 1] = arrNumber[j];
                        arrNumber[j] = temp; 
                        log.info(Arrays.toString(arrNumber));
                    }
                }
            }
            System.out.println(Arrays.toString(arrNumber));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
