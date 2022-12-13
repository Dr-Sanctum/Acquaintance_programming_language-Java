package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Подумать над структурой класса Ноутбук для магазина техники - выделить поля и
 * методы. Реализовать в java.
 * 
 * Создать множество ноутбуков.
 * 
 * Написать метод, который будет запрашивать у пользователя критерий (или
 * критерии) фильтрации и выведет ноутбуки,
 * отвечающие фильтру. Критерии фильтрации можно хранить в Map. Например:
 * 
 * “Введите цифру, соответствующую необходимому критерию:
 * 1 - ОЗУ
 * 2 - Объем ЖД
 * 3 - Операционная система
 * 4 - Цвет …
 * 
 * Далее нужно запросить минимальные значения для указанных критериев -
 * сохранить параметры
 * фильтрации можно также в Map.
 * 
 * Отфильтровать ноутбуки их первоначального множества и вывести проходящие по
 * условиям.
 *
 */

 //Часть изначально обьявленных параметров урезал в инициализации чтобы уложиться в 
 //сроки и продемонстрировать сам алгоритм.
public class App {
    public static void main(String[] args) {
        List<Notebook> lNotebooks = new ArrayList<Notebook>();
        lNotebooks.add(new Notebook(1, "Samsung", "s1", "Win", 2));
        lNotebooks.add(new Notebook(2, "Asus", "a1", "Win", 4));
        lNotebooks.add(new Notebook(3, "Lenovo", "l1", "Win", 8));
        lNotebooks.add(new Notebook(4, "Samsung", "s2", "Win", 8));
        lNotebooks.add(new Notebook(5, "Samsung", "s3", "Win", 16));
        lNotebooks.add(new Notebook(6, "Asus", "a2", "Win", 4));
        lNotebooks.add(new Notebook(7, "Dexp", "d1", "Win", 8));
        lNotebooks.add(new Notebook(8, "Dexp", "d2", "Win", 16));

        filter(lNotebooks);
        // System.out.println(lNotebooks);
    }

    public static void filter(List<Notebook> notebooks) {

        Map<Integer, String> mapMenu = new HashMap<>();
        Map<Integer, List<String>> mapFilter = new HashMap<>();
        mapMenu.put(1, "Производитель");
        mapMenu.put(2, "Модель");
        mapMenu.put(3, "ОС");
        mapMenu.put(4, "Обьём оперативной памяти");
        Scanner scanner = new Scanner(System.in, "cp866");

        String tempString;
        int tempInt;
        // Записываем в MapFilter параметры с ограничениями
        System.out.println("Введите цифру, соответствующую необходимому параметру: \n"
                + "1 - Производитель \n"
                + "2 - Модель \n"
                + "3 - ОС \n"
                + "4 - Обьём оперативной памяти \n");
        tempInt = Integer.parseInt(scanner.nextLine());
        if (mapMenu.containsKey(tempInt)) {
            System.out.println("Введите ограничение фильтра");
            List<String> limit = new LinkedList<>();
            limit.add(scanner.nextLine());
            mapFilter.put(tempInt, limit);
        } else {
            System.out.println("Вы ввели несуществующий параметр");
        }
        while (mapFilter.size() < mapMenu.size()) {
            System.out.println("Добавить фильтр? Y/N");
            tempString = scanner.nextLine();
            if (tempString.toUpperCase().equals("N")) {
                break;
            }
            if (tempString.toUpperCase().equals("Y")) {
                tempInt = Integer.parseInt(scanner.nextLine());
                if (mapMenu.containsKey(tempInt)) {
                    System.out.println("Введите ограничение фильтра");
                    List<String> limit = new LinkedList<>();
                    limit.add(scanner.nextLine());
                    mapFilter.put(tempInt, limit);
                } else {
                    System.out.println("Вы ввели несуществующий параметр");
                }
            }
        }
        scanner.close();
        // Проходим по фильтру и по каждому параметру проверяем коллекцию ноутбуков, и
        // удаляем если элемент не подходит по какому либо ограничению
        System.out.println(mapFilter);

        for (Map.Entry<Integer, List<String>> entry : mapFilter.entrySet()) {
            switch (entry.getKey()) {
                case 1:
                    int i = 0;
                    while (i < notebooks.size()) {
                        if (!notebooks.get(i).getManufacturer().equals(entry.getValue().get(0))) {
                            notebooks.remove(i);

                        } else {
                            i++;
                        }

                    }
                    break;

                case 2:
                    int j = 0;
                    while (j < notebooks.size()) {
                        if (!notebooks.get(j).getModel().equals(entry.getValue().get(0))) {
                            notebooks.remove(j);

                        } else {
                            j++;
                        }

                    }
                    break;
                case 3:
                    int k = 0;
                    while (k < notebooks.size()) {
                        if (!notebooks.get(k).getOpSystem().equals(entry.getValue().get(0))) {
                            notebooks.remove(k);

                        } else {
                            k++;
                        }

                    }
                    break;
                case 4:
                    int l = 0;
                    int tempParseInt = Integer.parseInt(entry.getValue().get(0));
                    while (l < notebooks.size()) {
                        if (!(notebooks.get(l).getRam() >= tempParseInt)) {
                            notebooks.remove(l);

                        } else {
                            l++;
                        }

                    }
                    break;
            }
        }
        //Выводим на экран ноутбуки которые соответствуют фильтру, если такие есть
        if (notebooks.size() == 0) {
            System.out.println("По заданным фильтрам не найдено ниодного ноутбука");
        }else{
            System.out.println(notebooks);
        }
        

    }
}
