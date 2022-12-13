package com.example;

/**
 * Подумать над структурой класса Ноутбук для магазина техники - выделить поля и
 * методы. Реализовать в java.
 * 
 * Создать множество ноутбуков.
 * 
 * Написать метод, который будет запрашивать у пользователя критерий (или
 * критерии) фильтрации и выведет ноутбуки,
 * отвечающие фильтру. Критерии фильтрации можно хранить в Map. Например:
 * “Введите цифру, соответствующую необходимому критерию:
 * 1 - ОЗУ
 * 2 - Объем ЖД
 * 3 - Операционная система
 * 4 - Цвет …
 * 
 * Далее нужно запросить минимальные значения для указанных критериев -
 * сохранить
 * параметры фильтрации можно также в Map.
 * 
 * Отфильтровать ноутбуки их первоначального множества и вывести проходящие по
 * условиям.
 *
 */
    //Количество атрибутов класса которые изначально задал, уменьшил чтобы уложиться в сроки
public class Notebook {
    private Integer serialNumber;
    private String manufacturer;
    private String model;
    private int ram;
    private int hardDiskCapacity;
    private String opSystem;
    private String color;
    private int price;

    public Notebook(int serialNumber, String manufacturer, String model, String opSystem, int ram) {
        this.serialNumber = serialNumber;
        this.manufacturer = manufacturer;
        this.model = model;
        this. ram = ram;
        // this.hardDiskCapacity = hardDiskCapacity;
        this.opSystem = opSystem;
        // this.color = color;
        // this.price = price;
    }
    

    public int getSerialNumber() {
        return serialNumber;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public int getRam() {
        return ram;
    }

    public int getHardDiskCapacity() {
        return hardDiskCapacity;
    }

    public String getOpSystem() {
        return opSystem;
    }

    public void setOpSystem(String opSystem) {
        this.opSystem = opSystem;
    }

    public String getColor() {
        return color;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("\n \n Серийный номер: %d \n Производитель: %s \n Модель: %s \n"
        + " Оперативная память: %d Gbyte \n Объём диска: %d Gbyte \n OpSystem: %s \n Цвет: %s \n Цена: %d Руб." ,
        serialNumber, manufacturer, model, ram, hardDiskCapacity, opSystem, color, price);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Notebook)) {
            return false;
        }
        Notebook notebook = (Notebook)obj;
        return this.serialNumber.equals(notebook.getSerialNumber());
    }
}
