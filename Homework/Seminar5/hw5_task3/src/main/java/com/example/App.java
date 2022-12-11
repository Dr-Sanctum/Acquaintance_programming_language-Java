package com.example;

import java.util.Arrays;

/**
 * Реализовать алгоритм пирамидальной сортировки (HeapSort).
 *
 */
public class App {
    public static void main(String[] args) {
        int arr[] = { 12, 11, 13, 5, 6, 7, 45 };
        System.out.println("Исходный массив: ");
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println("Отсортированный массив: ");
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int arr[]) {

        // Построение кучи (перегруппируем массив)
        for (int i = arr.length / 2 - 1; i >= 0; i--)
            heapify(arr, arr.length, i);

        // Один за другим извлекаем элементы из кучи
        for (int i = arr.length - 1; i >= 0; i--) {
            // Перемещаем текущий корень в конец
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Вызываем процедуру heapify на уменьшенной куче
            heapify(arr, i, 0);
        }
    }

    // Процедура для преобразования в двоичную кучу поддерева с корневым узлом i,
    // что является индексом в arr[]. n - размер кучи
    public static void heapify(int arr[], int n, int i) {
        int largest = i; // Инициализируем наибольший элемент как корень
        int l = 2 * i + 1; // левый = 2*i + 1
        int r = 2 * i + 2; // правый = 2*i + 2

        // Если левый дочерний элемент больше корня
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // Если правый дочерний элемент больше, чем самый большой элемент на данный
        // момент
        if (r < n && arr[r] > arr[largest])
            largest = r;
        // Если самый большой элемент не корень
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Рекурсивно преобразуем в двоичную кучу затронутое поддерево
            heapify(arr, n, largest);
        }
    }
}
