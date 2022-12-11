package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;

/**
 * Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что один человек может иметь несколько телефонов.
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        List<ArrayList<String>> dataPhone = new LinkedList<ArrayList<String>>();
        dataPhone.add(Lists.newArrayList("Васильев", "123413"));
        dataPhone.add(Lists.newArrayList("Васечкин", "324245"));
        dataPhone.add(Lists.newArrayList("Иванов", "4523535"));
        dataPhone.add(Lists.newArrayList("Петров", "14561345"));
        dataPhone.add(Lists.newArrayList("Сидоров", "13414413"));
        dataPhone.add(Lists.newArrayList("Иванов", "123445"));
        dataPhone.add(Lists.newArrayList("Петров", "113441"));
        dataPhone.add(Lists.newArrayList("Сидоров", "6245678"));
        
        Map<String, List<Integer>> phoneBook = new HashMap<>();

        for (ArrayList<String> arrayList : dataPhone) {
            if (phoneBook.containsKey(arrayList.get(0))) {
                phoneBook.get(arrayList.get(0)).add(Integer.parseInt(arrayList.get(1)));
            }
            else{
                phoneBook.put(arrayList.get(0), Lists.newArrayList(Integer.parseInt(arrayList.get(1))));
            }
        }

        System.out.println(phoneBook);

    }
}
