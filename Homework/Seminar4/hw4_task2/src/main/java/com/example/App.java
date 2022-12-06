package com.example;

import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Реализуйте очередь с помощью LinkedList со следующими методами:
 * enqueue() - помещает элемент в конец очереди, dequeue() - возвращает первый 
 * элемент из очереди и удаляет его, first() - возвращает первый элемент из очереди, не удаляя.
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        LinkedList<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < 10; i++) {
            queue.add(ThreadLocalRandom.current().nextInt(-20, 20));
        }
        System.out.print("Исходная очередь - ");
        System.out.println(queue);
        enqueue(queue, 23);
        enqueue(queue, 11);
        System.out.print("Очередь с добавленными элементами - ");
        System.out.println(queue);
        System.out.print("Вывод элемента с удалением - ");
        System.out.println(dequeue(queue));
        System.out.print("Вывод элемента с удалением - ");
        System.out.println(dequeue(queue));
        System.out.print("Очередь с удалёнными элементами -  ");
        System.out.println(queue);
        System.out.print("Вывод элемента - ");
        System.out.println(first(queue));
        System.out.print("Очередь без изменений -  ");
        System.out.println(queue);
    }

    public static void enqueue(LinkedList<Integer> que, int newElement) {
        que.addLast(newElement);
    }

    public static int dequeue(LinkedList<Integer> que) {
        int temp = que.getFirst();
        que.removeFirst();
        return temp;
    }

    public static int first(LinkedList<Integer> que) {

        return que.getFirst();
    }
}
