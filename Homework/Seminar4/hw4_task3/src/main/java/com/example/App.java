

import java.util.Deque;
import java.util.LinkedList;


/**
 * Напишите постфиксный калькулятор. Пользователь вводит данные и 
 * операции в обратной польской записи. Калькулятор вычисляет 
 * результат и проверяет, что в стэке получилось единственное число.
 * 
 * Например:
 * 5 4 3 - + => 5 1 + => 6
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String[] a = "5 4 / 5 8 * +".split(" ");
        double result;
        Deque<Double> stek = new LinkedList();

        for (int i = 0; i < a.length; i++) {
            if (Character.isDigit(a[i].charAt(0))) {
                stek.addLast(Double.parseDouble(a[i]));
            }
            else{
                switch (a[i]) {
                    case "+":
                        result = stek.pollLast() + stek.pollLast();
                        stek.addLast(result);
                        break;

                    case "-":
                        result = -stek.pollLast() + stek.pollLast();
                        stek.addLast(result);
                        break;

                    case "*":
                        result = stek.pollLast() * stek.pollLast();
                        stek.addLast(result);
                        break;
                
                    case "/":
                        double temp1 = stek.pollLast();
                        double temp2 = stek.pollLast();
                        result = temp2 / temp1;
                        stek.addLast(result);
                        break;

                    default:
                        break;
                }
            }
        }
        System.out.println(stek);
        
    }
}
