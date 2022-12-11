package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/**
 * Пусть дан список сотрудников: Иван, Пётр, Антон и так далее. Написать
 * программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
 * Отсортировать по убыванию популярности.
 *
 */
public class App {
    public static void main( String[] args )
    {

        List<String> dataName = new ArrayList<String>(Arrays.asList("Иванов", 
        "Петров", "Сидоров", "Михеев", "Иванов", "Иванов", "Сидоров", "Петров"));     

        Map<String, Integer> quantityName = new HashMap<>();

        for (String name : dataName) {
            if (quantityName.containsKey(name)) {
                quantityName.put(name, quantityName.get(name)+ 1);
            }
            else{
                quantityName.put(name,1);
            }
        }
        System.out.println(quantityName);
        
        List<Map.Entry<String, Integer>> lEntries = new LinkedList<>(quantityName.entrySet());
        
        Collections.sort(lEntries, new CompareEntry());
        System.out.println("Отсортированные имена: ");
        System.out.println(lEntries);
    }
}
