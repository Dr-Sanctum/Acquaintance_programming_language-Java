package com.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.regex.Pattern;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * В файле содержится строка с данными:
 * [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"}, 
 * {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"}, 
 * {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
 * 
 * Напишите метод, который разберёт её на составные части и, используя StringBuilder создаст 
 * массив строк такого вида:
 * 
 * Студент Иванов получил 5 по предмету Математика.
 * Студент Петрова получил 4 по предмету Информатика.
 * Студент Краснов получил 5 по предмету Физика.
 *
 */
public class App 
{
    /**
     * Для выполнения задания была применена сторонняя библиотека Gson для разбора строк формата Json, 
     * разбитых в массив с помощью регулярных выражений, а так же StringBuilder для формирования новых строк.
     */
    public static void main( String[] args )
    {
        String pathProject = System.getProperty("user.dir");
        String pathFile = pathProject.concat("/text.txt");
        File f3 = new File(pathFile);
        String[] result = myMethod(f3);
        for (String string : result) {
            System.out.println(string);
        }
        
    }

    private static String[] myMethod(File f){
        Pattern pattern = Pattern.compile(", ");
        try(BufferedReader reader = new BufferedReader(new FileReader(f)))
            {
                String text = reader.readLine();
                String[] strings = pattern.split(text);
                String[] stringResult = new String[3];
                for (int i = 0; i < strings.length; i++) 
                {
                    JsonObject jsonObject = JsonParser.parseString(strings[i]).getAsJsonObject();
                    Map jsonMap = jsonObject.asMap();
                    StringBuilder builder = new StringBuilder();
                    builder.append("Студент ");
                    builder.append(jsonMap.get("фамилия"));
                    builder.append(" получил ");
                    builder.append(jsonObject.get("оценка"));
                    builder.append(" по предмету ");
                    builder.append(jsonObject.get("предмет"));
                    stringResult[i] = builder.toString();
                }
                return stringResult;
            }
            catch(IOException ex){
                System.out.println(ex.getMessage());
            }
        return null;
            
    }
}
